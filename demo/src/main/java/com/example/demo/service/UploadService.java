package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface UploadService {

    String uploadFile(MultipartFile file);

    String uploadDir(HttpServletRequest request);
}
