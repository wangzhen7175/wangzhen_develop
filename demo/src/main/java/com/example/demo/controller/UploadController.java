package com.example.demo.controller;

import com.example.demo.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

//@RestController
@Controller//默认返回视图
@CrossOrigin
@RequestMapping(value = "/upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String upload() {
        return "upload";
    }

    /**
     * 上传普通文件
     * @param file
     * @return
     */
    @RequestMapping("/toUpload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {

        return uploadService.uploadFile(file);
    }

    /**
     * 上传文件夹
     * @param request
     * @return
     */
    @RequestMapping("/toUploadDir")
    @ResponseBody
    public String uploadDir(HttpServletRequest request) {

        return uploadService.uploadDir(request);
    }
}
