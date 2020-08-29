package com.example.demo.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FileInfo {

    private String fileId;

    private String fileName;

    private String filePath;

    private double fileSize;

    private String datasetId;

    private Date createTime;

    public String getFileId() {
        return fileId;
    }

    public void setFile_id(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
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

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileId='" + fileId + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", datasetId='" + datasetId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
