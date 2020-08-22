package com.example.demo.mapper;

import com.example.demo.entity.GenerateId;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface GenerateIdMapper {

    Integer getMaxCode(@Param("idType") String idType, @Param("date") Date date);

    GenerateId getOneByIdType(@Param("idType") String idType);

    void updateMaxCode(@Param("idType") String idType,@Param("maxCode") Integer newMaxCode);

    void insertOne(GenerateId generateId);

    void updateOne(GenerateId generateId);
}
