package com.zhenghao.risk.control.repository.dao;

import com.zhenghao.risk.control.common.convert.RuleConvert;
import com.zhenghao.risk.control.common.model.RulePO;
import com.zhenghao.risk.control.contract.vo.Rule;
import com.zhenghao.risk.control.repository.mapper.RulePOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RuleRepository {

    @Autowired
    private RulePOMapper rulePOMapper;

    public List<Rule> listAll() {
        return rulePOMapper.selectByExample(null).stream()
                .map(RuleConvert::fromPO)
                .collect(Collectors.toList());
    }

    public Rule getById(long id) {
        RulePO rulePO = rulePOMapper.selectByPrimaryKey(id);
        if (rulePO == null) {
            return null;
        }
        return RuleConvert.fromPO(rulePO);
    }

    public long insert(Rule rule) {
        RulePO rulePO = RuleConvert.toPO(rule);
        rulePOMapper.insertSelective(rulePO);
        return rulePO.getId();
    }

    public void update(Rule rule) {
        RulePO rulePO = RuleConvert.toPO(rule);
        rulePOMapper.updateByPrimaryKeySelective(rulePO);
    }

    public void delete(long id) {
        rulePOMapper.deleteByPrimaryKey(id);
    }
}
