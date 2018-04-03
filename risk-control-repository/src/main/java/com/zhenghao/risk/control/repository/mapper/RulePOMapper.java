package com.zhenghao.risk.control.repository.mapper;

import com.zhenghao.risk.control.common.model.RulePO;
import com.zhenghao.risk.control.common.model.RulePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RulePOMapper {
    long countByExample(RulePOExample example);

    int deleteByExample(RulePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RulePO record);

    int insertSelective(RulePO record);

    List<RulePO> selectByExampleWithRowbounds(RulePOExample example, RowBounds rowBounds);

    List<RulePO> selectByExample(RulePOExample example);

    RulePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RulePO record, @Param("example") RulePOExample example);

    int updateByExample(@Param("record") RulePO record, @Param("example") RulePOExample example);

    int updateByPrimaryKeySelective(RulePO record);

    int updateByPrimaryKey(RulePO record);
}