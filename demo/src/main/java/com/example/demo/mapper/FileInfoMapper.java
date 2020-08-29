package com.example.demo.mapper;

import com.example.demo.entity.Dataset;
import com.example.demo.entity.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileInfoMapper {

    FileInfo getById(@Param("fileId") String fileId);

    void insertOne(FileInfo fileInfo);

    void deleteOne(@Param("fileId") String fileId);

    void deleteAll(@Param("fileId") String fileId);

    void updateOne(FileInfo fileInfo);

    List<FileInfo> getByDatasetId(@Param("datasetId") String datasetId);

    void batchInsert(@Param("fileInfoList") List<FileInfo> fileInfoList);

}
