package com.zhenghao.risk.control.repository.mapper;

import com.zhenghao.risk.control.common.model.CollocationPO;
import com.zhenghao.risk.control.common.model.CollocationPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CollocationPOMapper {
    long countByExample(CollocationPOExample example);

    int deleteByExample(CollocationPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CollocationPO record);

    int insertSelective(CollocationPO record);

    List<CollocationPO> selectByExampleWithRowbounds(CollocationPOExample example, RowBounds rowBounds);

    List<CollocationPO> selectByExample(CollocationPOExample example);

    CollocationPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CollocationPO record, @Param("example") CollocationPOExample example);

    int updateByExample(@Param("record") CollocationPO record, @Param("example") CollocationPOExample example);

    int updateByPrimaryKeySelective(CollocationPO record);

    int updateByPrimaryKey(CollocationPO record);
}