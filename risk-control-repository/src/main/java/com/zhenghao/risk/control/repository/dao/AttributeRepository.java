package com.zhenghao.risk.control.repository.dao;

import com.zhenghao.risk.control.common.model.AttributePO;
import com.zhenghao.risk.control.common.util.ModelHelper;
import com.zhenghao.risk.control.contract.vo.Attribute;
import com.zhenghao.risk.control.repository.mapper.AttributePOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AttributeRepository {

    @Autowired
    private AttributePOMapper attributePOMapper;

    public List<Attribute> listAll() {
        return attributePOMapper.selectByExample(null).stream()
                .map(x -> ModelHelper.map(x, Attribute.class))
                .collect(Collectors.toList());
    }

    public long insert(Attribute attribute) {
        AttributePO attributePO = ModelHelper.map(attribute, AttributePO.class);
        attributePOMapper.insertSelective(attributePO);
        return attributePO.getId();
    }

    public void delete(long id) {
        attributePOMapper.deleteByPrimaryKey(id);
    }
}
