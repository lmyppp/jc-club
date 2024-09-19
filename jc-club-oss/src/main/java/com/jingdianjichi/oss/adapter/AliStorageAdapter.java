package com.jingdianjichi.oss.adapter;

import com.jingdianjichi.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class AliStorageAdapter implements StorageAdapter {
    @Override
    public void createBucket(String bucketName) {

    }

    @Override
    public void uploadFile(MultipartFile uploadFile, String bucketName, String objectName) {

    }

    @Override
    public List<String> getAllBuckets() {
        List<String> list = new LinkedList<>();
        list.add("aliyun");
        return list;
    }

    @Override
    public List<FileInfo> getAllFiles(String bucketName) {
        return null;
    }

    @Override
    public InputStream downloadFile(String bucketName, String objectName) {
        return null;
    }

    @Override
    public void deleteBucket(String bucketName) {

    }

    @Override
    public void deleteObject(String bucketName, String objectName) {

    }
}
