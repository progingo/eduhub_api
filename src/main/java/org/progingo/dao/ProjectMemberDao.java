package org.progingo.dao;

import org.progingo.domain.project.ProjectMember;
import org.progingo.domain.project.ProjectMemberExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectMemberDao {
    long countByExample(ProjectMemberExample example);

    int deleteByExample(ProjectMemberExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectMember record);

    int insertSelective(ProjectMember record);

    List<ProjectMember> selectByExample(ProjectMemberExample example);

    ProjectMember selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectMember record, @Param("example") ProjectMemberExample example);

    int updateByExample(@Param("record") ProjectMember record, @Param("example") ProjectMemberExample example);

    int updateByPrimaryKeySelective(ProjectMember record);

    int updateByPrimaryKey(ProjectMember record);
}