package org.progingo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.progingo.domain.FileUploadRecord;
import org.progingo.domain.FileUploadRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileUploadRecordDao {
    long countByExample(FileUploadRecordExample example);

    int deleteByExample(FileUploadRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileUploadRecord record);

    int insertSelective(FileUploadRecord record);

    List<FileUploadRecord> selectByExample(FileUploadRecordExample example);

    FileUploadRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileUploadRecord record, @Param("example") FileUploadRecordExample example);

    int updateByExample(@Param("record") FileUploadRecord record, @Param("example") FileUploadRecordExample example);

    int updateByPrimaryKeySelective(FileUploadRecord record);

    int updateByPrimaryKey(FileUploadRecord record);
}