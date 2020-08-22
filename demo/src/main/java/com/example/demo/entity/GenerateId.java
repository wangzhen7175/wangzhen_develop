package com.example.demo.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenerateId {

    private String idType;

    private Date date;

    private Integer maxCode;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMaxCode() {
        return maxCode;
    }

    public void setMaxCode(Integer maxCode) {
        this.maxCode = maxCode;
    }

    @Override
    public String toString() {
        return "GenerateId{" +
                "idType='" + idType + '\'' +
                ", date=" + date +
                ", maxCode='" + maxCode + '\'' +
                '}';
    }
}
