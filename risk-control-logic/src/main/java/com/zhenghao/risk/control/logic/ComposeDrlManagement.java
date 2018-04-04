package com.zhenghao.risk.control.logic;

import com.zhenghao.risk.control.contract.enums.CategoryEnum;
import com.zhenghao.risk.control.contract.vo.Condition;
import com.zhenghao.risk.control.contract.vo.Rule;
import com.zhenghao.risk.control.contract.vo.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * zhenghao
 * 2018/4/4
 */
@Component
public class ComposeDrlManagement {

    private static final Logger logger = LoggerFactory.getLogger(ComposeDrlManagement.class);

    @Autowired
    private AssembleSceneManagement assembleSceneManagement;

    public Map<String, String> composeAllDrls() {
        return assembleSceneManagement.assembleAllScenes().stream()
                .collect(Collectors.toMap(Scene::getName, this::composeDrl));
    }

    private String composeDrl(Scene scene) {
        StringBuilder drlStr = new StringBuilder();
        drlStr.append("package com.zhenghao.").append(scene.getName()).append(";\n\n");
        appendImportPart(drlStr);

        scene.getRules().forEach(rule -> composeRule(drlStr, rule));

        return drlStr.toString();
    }

    private void appendImportPart(StringBuilder sb) {
        sb.append("import java.util.Map;\n");
        sb.append("import java.util.List;\n");
        sb.append("import com.zhenghao.risk.control.contract.vo.Event;\n");
        sb.append("import com.zhenghao.risk.control.contract.vo.FireResult;\n");
    }

    private void composeRule(StringBuilder sb, Rule rule) {
        appendRuleHead(sb, rule);
        composeRuleWhen(sb, rule);
        composeRuleThen(sb, rule);
    }

    private void appendRuleHead(StringBuilder sb, Rule rule) {
        sb.append("\nrule \"").append(rule.getName()).append("\"\n");
        sb.append("salience ").append(rule.getPriority()).append("\n");
    }

    private void composeRuleWhen(StringBuilder sb, Rule rule) {
        sb.append("when\n");
        sb.append("$fireResult : FireResult(isProcessed == false)\n");
        sb.append("$event : Event(").append(parseConditions(rule.getConditions(), rule.getLogicMode())).append(")\n");
    }

    private void composeRuleThen(StringBuilder sb, Rule rule) {
        sb.append("then\n");
        sb.append("modify( $fireResult ) {\n");
        sb.append("setIsProcessed(true),\n");
        sb.append("setReturnCode(\"").append(rule.getReturnCode()).append("\")\n");
        sb.append("};\nend\n");
    }

    private String parseConditions(List<Condition> conditions, String logicMode) {
        String result = logicMode;

        for (int i = 0; i < conditions.size(); i++) {
            String condition = parseCondition(conditions.get(i));
            result = result.replace(String.valueOf(i + 1), condition);
        }

        return result;
    }

    private String parseCondition(Condition condition) {
        return parseFactor(condition.getLeftCategory(), condition.getLeftValue()) +
                " " + condition.getComparator() + " " +
                parseFactor(condition.getRightCategory(), condition.getRightValue());
    }

    private String parseFactor(String category, String value) {
        if (CategoryEnum.MANU_NUM.name().equals(category)) {
            return value;
        }
        else if (CategoryEnum.MANU_STR.name().equals(category)) {
            return "\"" + value + "\"";
        }
        else if (CategoryEnum.NORMAL.name().equals(category)) {
            return "parameters[\"" + value + "\"]";
        }
        else {
            logger.error("Illegal category: " + category);
            throw new IllegalArgumentException("Illegal category: " + category);
        }
    }

}
