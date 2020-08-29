package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//默认返回视图
@CrossOrigin
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(FileController.class);
    //进入列表页面
    @RequestMapping(value = "/viewlist", method = RequestMethod.GET)
    public String viewFilePage() {
        return "Viewfile";

    }

    //加载文件内容
    @RequestMapping(value = "/viewFile", method = RequestMethod.GET)
    @ResponseBody
    public String viewFile() {
        return "ViewFile";

    }

}
