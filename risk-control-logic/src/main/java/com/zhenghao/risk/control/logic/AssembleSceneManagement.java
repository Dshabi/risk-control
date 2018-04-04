package com.zhenghao.risk.control.logic;

import com.zhenghao.risk.control.common.util.ModelHelper;
import com.zhenghao.risk.control.contract.vo.Collocation;
import com.zhenghao.risk.control.contract.vo.Rule;
import com.zhenghao.risk.control.contract.vo.Scene;
import com.zhenghao.risk.control.repository.dao.CollocationRepository;
import com.zhenghao.risk.control.repository.dao.ConditionRepository;
import com.zhenghao.risk.control.repository.dao.RuleRepository;
import com.zhenghao.risk.control.repository.dao.SceneRepository;
import javafx.util.Pair;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * zhenghao
 * 2018/4/4
 */
@Component
public class AssembleSceneManagement {

    private static final String CONDITION_IDS_DELIMITER = "_";

    @Autowired
    private CollocationRepository collocationRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private SceneRepository sceneRepository;

    public List<Scene> assembleAllScenes() {
        Map<Long, Scene> idToScene = sceneRepository.listAll().stream()
                .collect(Collectors.toMap(Scene::getId, x -> x));

        Map<Pair<Long, Long>, Collocation> collocationMap = getAllCollocationMap();

        Map<Long, Rule> idToRule = getAllIdToRule();

        List<Scene> scenes = Lists.newArrayList();
        collocationMap.forEach((pair, collocation) -> {
            pair.getKey();
            Scene scene = idToScene.get(pair.getKey());
            Rule rule = fitCollocation(idToRule.get(pair.getValue()), collocation);
            if (scene.getRules() == null) {
                scene.setRules(Lists.newArrayList(rule));
            }
            else {
                scene.getRules().add(rule);
            }
            if (!scenes.contains(scene)) {
                scenes.add(scene);
            }
        });

        return scenes;
    }

    private Map<Pair<Long, Long>, Collocation> getAllCollocationMap() {
        return collocationRepository.listAll().stream()
                .collect(Collectors.toMap(x -> new Pair<>(x.getSceneId(), x.getRuleId()), x -> x));
    }

    private Map<Long, Rule> getAllIdToRule() {
        return ruleRepository.listAll().stream()
                .map(this::fitConditions)
                .collect(Collectors.toMap(Rule::getId, x -> x));
    }

    private Rule fitConditions(Rule rule) {
        List<Long> conditionIds = listFromExpression(rule.getRelConditionIds());

        rule.setConditions(conditionRepository.listByIds(conditionIds));
        return rule;
    }

    private List<Long> listFromExpression(String expression) {
        return Arrays.stream(expression.split(CONDITION_IDS_DELIMITER))
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    private Rule fitCollocation(Rule rule, Collocation collocation) {
        Rule replica = new Rule();
        ModelHelper.setIfFieldEquals(replica, rule);
        replica.setReturnCode(collocation.getReturnCode());
        replica.setPriority(collocation.getPriority());
        replica.setStatus(collocation.getStatus());

        return replica;
    }

}
