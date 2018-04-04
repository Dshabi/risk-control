package com.zhenghao.risk.control.repository.dao;

import com.zhenghao.risk.control.common.model.CollocationPO;
import com.zhenghao.risk.control.common.model.CollocationPOExample;
import com.zhenghao.risk.control.common.util.ListHelper;
import com.zhenghao.risk.control.common.util.ModelHelper;
import com.zhenghao.risk.control.contract.vo.Collocation;
import com.zhenghao.risk.control.repository.mapper.CollocationPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CollocationRepository {

    @Autowired
    private CollocationPOMapper collocationPOMapper;

    public List<Collocation> listAll() {
        return collocationPOMapper.selectByExample(null).stream()
                .map(x -> ModelHelper.map(x, Collocation.class))
                .collect(Collectors.toList());
    }

    public List<Collocation> listBySceneId(long sceneId) {
        CollocationPOExample example = new CollocationPOExample();
        example.createCriteria().andSceneIdEqualTo(sceneId);

        return collocationPOMapper.selectByExample(example).stream()
                .map(x -> ModelHelper.map(x, Collocation.class))
                .collect(Collectors.toList());
    }

    public Collocation getBySceneIdAndRuleId(long sceneId, long ruleId) {
        CollocationPOExample example = new CollocationPOExample();
        example.createCriteria().andSceneIdEqualTo(sceneId).andRuleIdEqualTo(ruleId);

        CollocationPO collocationPO = ListHelper.getFirstOrNull(collocationPOMapper.selectByExample(example));
        return ModelHelper.map(collocationPO, Collocation.class);
    }

    public long insert(Collocation collocation) {
        CollocationPO collocationPO = ModelHelper.map(collocation, CollocationPO.class);
        collocationPOMapper.insertSelective(collocationPO);
        return collocationPO.getId();
    }

    public void update(Collocation collocation) {
        CollocationPO collocationPO = ModelHelper.map(collocation, CollocationPO.class);
        collocationPOMapper.updateByPrimaryKeySelective(collocationPO);
    }

    public void delete(long id) {
        collocationPOMapper.deleteByPrimaryKey(id);
    }
}
