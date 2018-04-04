package com.zhenghao.risk.control.repository.dao;

import com.zhenghao.risk.control.common.convert.NormalParameterConvert;
import com.zhenghao.risk.control.common.model.NormalParameterPO;
import com.zhenghao.risk.control.common.util.ModelHelper;
import com.zhenghao.risk.control.contract.vo.NormalParameter;
import com.zhenghao.risk.control.repository.mapper.NormalParameterPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NormalParameterRepository {

    @Autowired
    private NormalParameterPOMapper normalParameterPOMapper;

    public List<NormalParameter> listAll() {
        return normalParameterPOMapper.selectByExample(null).stream()
                .map(NormalParameterConvert::fromPO)
                .collect(Collectors.toList());
    }

    public NormalParameter getById(long id) {
        NormalParameterPO normalParameterPO = normalParameterPOMapper.selectByPrimaryKey(id);
        return ModelHelper.map(normalParameterPO, NormalParameter.class);
    }

    public long insert(NormalParameter normalParameter) {
        NormalParameterPO normalParameterPO = NormalParameterConvert.toPO(normalParameter);
        normalParameterPOMapper.insertSelective(normalParameterPO);
        return normalParameterPO.getId();
    }

    public void delete(long id) {
        normalParameterPOMapper.deleteByPrimaryKey(id);
    }

}
