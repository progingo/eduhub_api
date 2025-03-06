package org.progingo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.progingo.domain.project.Project;
import org.progingo.domain.project.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectDao {
    long countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}