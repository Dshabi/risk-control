package com.zhenghao.risk.control.repository.dao;

import com.zhenghao.risk.control.common.convert.ConditionConvert;
import com.zhenghao.risk.control.common.model.ConditionPO;
import com.zhenghao.risk.control.common.model.ConditionPOExample;
import com.zhenghao.risk.control.contract.vo.Condition;
import com.zhenghao.risk.control.repository.mapper.ConditionPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ConditionRepository {

    @Autowired
    private ConditionPOMapper conditionPOMapper;

    public List<Condition> listAll() {
        return conditionPOMapper.selectByExample(null).stream()
                .map(ConditionConvert::fromPO)
                .collect(Collectors.toList());
    }

    public List<Condition> listByIds(List<Long> ids) {
        ConditionPOExample example = new ConditionPOExample();
        example.createCriteria().andIdIn(ids);

        return conditionPOMapper.selectByExample(example).stream()
                .map(ConditionConvert::fromPO)
                .collect(Collectors.toList());
    }

    public long insert(Condition condition) {
        ConditionPO conditionPO = ConditionConvert.toPO(condition);
        conditionPOMapper.insertSelective(conditionPO);
        return conditionPO.getId();
    }

    public void delete(long id) {
        conditionPOMapper.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByIds(List<Long> ids) {
        ConditionPOExample example = new ConditionPOExample();
        example.createCriteria().andIdIn(ids);

        conditionPOMapper.deleteByExample(example);
    }
}
