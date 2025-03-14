package org.progingo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.progingo.domain.ppt.PptInfo;
import org.progingo.domain.ppt.PptInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PptInfoDao {
    long countByExample(PptInfoExample example);

    int deleteByExample(PptInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PptInfo record);

    int insertSelective(PptInfo record);

    List<PptInfo> selectByExample(PptInfoExample example);

    PptInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PptInfo record, @Param("example") PptInfoExample example);

    int updateByExample(@Param("record") PptInfo record, @Param("example") PptInfoExample example);

    int updateByPrimaryKeySelective(PptInfo record);

    int updateByPrimaryKey(PptInfo record);
}