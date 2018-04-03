package com.zhenghao.risk.control.repository.mapper;

import com.zhenghao.risk.control.common.model.NormalParameterPO;
import com.zhenghao.risk.control.common.model.NormalParameterPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NormalParameterPOMapper {
    long countByExample(NormalParameterPOExample example);

    int deleteByExample(NormalParameterPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NormalParameterPO record);

    int insertSelective(NormalParameterPO record);

    List<NormalParameterPO> selectByExampleWithRowbounds(NormalParameterPOExample example, RowBounds rowBounds);

    List<NormalParameterPO> selectByExample(NormalParameterPOExample example);

    NormalParameterPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NormalParameterPO record, @Param("example") NormalParameterPOExample example);

    int updateByExample(@Param("record") NormalParameterPO record, @Param("example") NormalParameterPOExample example);

    int updateByPrimaryKeySelective(NormalParameterPO record);

    int updateByPrimaryKey(NormalParameterPO record);
}