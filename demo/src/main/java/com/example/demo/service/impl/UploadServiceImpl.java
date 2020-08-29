package com.example.demo.service.impl;

import com.example.demo.entity.Dataset;
import com.example.demo.entity.FileInfo;
import com.example.demo.mapper.DatasetMapper;
import com.example.demo.mapper.FileInfoMapper;
import com.example.demo.service.GenerateIdService;
import com.example.demo.service.UploadService;
import com.example.demo.utils.FileUtil;
import com.example.demo.utils.SessionUtil;
import com.example.demo.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class UploadServiceImpl implements UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private GenerateIdService generateIdService;

    @Autowired
    private DatasetMapper datasetMapper;

    @Autowired
    private FileInfoMapper fileInfoMapper;

    @Override
    public String uploadFile(MultipartFile file) {

        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();

        String datasetId = generateIdService.generateId("dataset");

        String targetDir = StringUtil.joinString(uploadPath,  datasetId, "/");
        File targetDirFile = new File(targetDir);
        targetDirFile.mkdir();
        File targetFile = new File(StringUtil.joinString(targetDir, fileName));
        try {
            file.transferTo(targetFile);
            logger.info("上传成功");
            saveFileInfo(datasetId);
            return "上传成功";
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        return "上传失败！";
    }

    @Override
    public String uploadDir(HttpServletRequest request) {

        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        List<MultipartFile> files = params.getFiles("file");
        String datasetId = generateIdService.generateId("dataset");
        for (MultipartFile mf : files) {
            if (!mf.isEmpty()) {
                String originalFilename = mf.getOriginalFilename();
                String fileName = originalFilename.substring(originalFilename.lastIndexOf("/") + 1);
                String filePath = StringUtil.joinString(uploadPath,  datasetId, "/", originalFilename.replaceAll(fileName, ""));
                File filePathDir = new File(filePath);
                if (!filePathDir.exists()) {
                    filePathDir.mkdirs();
                }
                try {
                    mf.transferTo(new File(filePathDir + "/"+ fileName));
                    logger.info("上传成功" + fileName);
                } catch (IOException e) {
                    logger.error(e.toString(), e);
                    logger.info("上传失败");
                    return "上传失败";
                }

            } else {
                return "未选择文件";
            }
        }
        saveFileInfo(datasetId);
        return "上传成功";
    }

    //将文件信息存表
    public boolean saveFileInfo(String datasetId){
        Dataset dataset = new Dataset();
        dataset.setDatasetId(datasetId);
        dataset.setCreateTime(new Date());
        dataset.setDatasetName(datasetId);
        dataset.setUserId(SessionUtil.getUserId());
        List<FileInfo> fileInfoList = new LinkedList<>();
        fileInfoList =  FileUtil.getFileInfo(StringUtil.joinString(uploadPath,  datasetId),fileInfoList);
        dataset.setFileCount(fileInfoList.size());
        fileInfoList.stream().forEach(fileInfo -> {
                    fileInfo.setFile_id(generateIdService.generateId("file"));
                    fileInfo.setDatasetId(datasetId);
                    fileInfo.setCreateTime(new Date());
                }

        );
        datasetMapper.insertOne(dataset);
        fileInfoMapper.batchInsert(fileInfoList);
        return true;
    }
    public static void main(String[] args) {

    }
}

