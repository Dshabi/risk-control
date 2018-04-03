package com.zhenghao.risk.control.repository.mapper;

import com.zhenghao.risk.control.common.model.ConditionPO;
import com.zhenghao.risk.control.common.model.ConditionPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ConditionPOMapper {
    long countByExample(ConditionPOExample example);

    int deleteByExample(ConditionPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ConditionPO record);

    int insertSelective(ConditionPO record);

    List<ConditionPO> selectByExampleWithRowbounds(ConditionPOExample example, RowBounds rowBounds);

    List<ConditionPO> selectByExample(ConditionPOExample example);

    ConditionPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ConditionPO record, @Param("example") ConditionPOExample example);

    int updateByExample(@Param("record") ConditionPO record, @Param("example") ConditionPOExample example);

    int updateByPrimaryKeySelective(ConditionPO record);

    int updateByPrimaryKey(ConditionPO record);
}