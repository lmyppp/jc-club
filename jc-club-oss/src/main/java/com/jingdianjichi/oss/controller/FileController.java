package com.jingdianjichi.oss.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.jingdianjichi.oss.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FileController {
    @Resource
    private FileService fileService;

    @RequestMapping("/testGetAllBuckets")
    public String testGetAllBuckets() {
        List<String> allBuckets = fileService.getAllBuckets();
        return allBuckets.get(0);
    }


}
