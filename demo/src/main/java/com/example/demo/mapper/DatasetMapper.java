package com.example.demo.mapper;

import com.example.demo.entity.Dataset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DatasetMapper {

    Dataset getById(@Param("datasetId") String datasetId);

    void insertOne(Dataset dataset);

    void deleteOne(@Param("datasetId") String datasetId);

    void updateOne(Dataset dataset);
}
