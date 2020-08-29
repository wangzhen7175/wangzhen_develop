package com.example.demo.utils;

import com.example.demo.entity.FileInfo;

import java.io.File;
import java.util.List;

public class FileUtil {


    public static List<FileInfo> getFileInfo(String filePath, List<FileInfo> fileInfoList) {
        File file = new File(filePath);
        File[] listfile = file.listFiles();
        for (int i = 0; i < listfile.length; i++) {
            if (!listfile[i].isDirectory()) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setFileName(listfile[i].getName());
                fileInfo.setFilePath(listfile[i].getAbsolutePath());
                fileInfo.setFileSize(listfile[i].length());
                fileInfoList.add(fileInfo);
            } else {
                getFileInfo(listfile[i].toString(),fileInfoList);
            }
        }
        return fileInfoList;
    }
}
