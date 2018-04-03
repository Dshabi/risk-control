package com.zhenghao.risk.control.repository.mapper;

import com.zhenghao.risk.control.common.model.ScenePO;
import com.zhenghao.risk.control.common.model.ScenePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ScenePOMapper {
    long countByExample(ScenePOExample example);

    int deleteByExample(ScenePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ScenePO record);

    int insertSelective(ScenePO record);

    List<ScenePO> selectByExampleWithRowbounds(ScenePOExample example, RowBounds rowBounds);

    List<ScenePO> selectByExample(ScenePOExample example);

    ScenePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ScenePO record, @Param("example") ScenePOExample example);

    int updateByExample(@Param("record") ScenePO record, @Param("example") ScenePOExample example);

    int updateByPrimaryKeySelective(ScenePO record);

    int updateByPrimaryKey(ScenePO record);
}