package org.progingo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.progingo.domain.subject.Subject;
import org.progingo.domain.subject.SubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SubjectDao {
    long countByExample(SubjectExample example);

    int deleteByExample(SubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample(SubjectExample example);

    Subject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
}