package com.example.demo.service.impl;

import com.example.demo.service.GenerateIdService;
import com.example.demo.service.UploadService;
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
import java.util.List;

@Service
public class UplaodServiceImpl implements UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UplaodServiceImpl.class);

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private GenerateIdService generateIdService;

    @Override
    public String uploadFile(MultipartFile file) {

        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }

        String fileName = file.getOriginalFilename();

        String fileId = generateIdService.generateId("file");

        String targetDir = StringUtil.joinString(uploadPath,  fileId, "/");
        File targetDirFile = new File(targetDir);
        targetDirFile.mkdir();
        File targetFile = new File(StringUtil.joinString(targetDir, fileName));
        try {
            file.transferTo(targetFile);
            logger.info("上传成功");
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
        String fileId = generateIdService.generateId("file");
        for (MultipartFile mf : files) {
            if (!mf.isEmpty()) {
                String originalFilename = mf.getOriginalFilename();
                String fileName = originalFilename.substring(originalFilename.lastIndexOf("/") + 1);
                String filePath = StringUtil.joinString(uploadPath,  fileId, "/", originalFilename.replaceAll(fileName, ""));
                File filePathDir = new File(filePath);
                if (!filePathDir.exists()) {
                    filePathDir.mkdirs();
                }
                try {
                    mf.transferTo(new File(filePathDir + "/"+ fileName));
                    logger.info("上传成功");
                } catch (IOException e) {
                    logger.error(e.toString(), e);
                    logger.info("上传失败");
                    return "上传失败";
                }

            } else {
                return "未选择文件";
            }
        }
        return "上传成功";
    }

    public static void main(String[] args) {

    }
}

