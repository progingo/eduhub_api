package org.progingo.dao;

import org.progingo.domain.PptGitTree;
import org.progingo.domain.PptGitTreeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PptGitTreeDao {
    long countByExample(PptGitTreeExample example);

    int deleteByExample(PptGitTreeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PptGitTree record);

    int insertSelective(PptGitTree record);

    List<PptGitTree> selectByExample(PptGitTreeExample example);

    PptGitTree selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PptGitTree record, @Param("example") PptGitTreeExample example);

    int updateByExample(@Param("record") PptGitTree record, @Param("example") PptGitTreeExample example);

    int updateByPrimaryKeySelective(PptGitTree record);

    int updateByPrimaryKey(PptGitTree record);
}