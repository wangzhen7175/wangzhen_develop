package com.example.demo.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Dataset {

    private String datasetId;

    private Date createTime;

    private String userId;

    private String datasetName;

    private int fileCount;

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public String getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(String datasetId) {
        this.datasetId = datasetId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "datasetId='" + datasetId + '\'' +
                ", createTime=" + createTime +
                ", userId='" + userId + '\'' +
                ", datasetName='" + datasetName + '\'' +
                ", fileCount='" + fileCount + '\'' +
                '}';
    }
}
