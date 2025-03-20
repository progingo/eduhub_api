package org.progingo.dao;

import org.progingo.domain.ResourceShowData;
import org.progingo.domain.ResourceShowDataExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ResourceShowDataDao {
    long countByExample(ResourceShowDataExample example);

    int deleteByExample(ResourceShowDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ResourceShowData record);

    int insertSelective(ResourceShowData record);

    List<ResourceShowData> selectByExample(ResourceShowDataExample example);

    ResourceShowData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ResourceShowData record, @Param("example") ResourceShowDataExample example);

    int updateByExample(@Param("record") ResourceShowData record, @Param("example") ResourceShowDataExample example);

    int updateByPrimaryKeySelective(ResourceShowData record);

    int updateByPrimaryKey(ResourceShowData record);
}