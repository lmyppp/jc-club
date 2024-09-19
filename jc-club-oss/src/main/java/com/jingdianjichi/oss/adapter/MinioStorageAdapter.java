package com.jingdianjichi.oss.adapter;

import com.jingdianjichi.oss.entity.FileInfo;
import com.jingdianjichi.oss.util.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

/**
 * 适配器实现类
 */
public class MinioStorageAdapter implements StorageAdapter {

    @Resource
    private MinioUtil minioUtil;

    @Override
    @SneakyThrows   //lombok处理异常注解
    public void createBucket(String bucketName) {
        minioUtil.createBucket(bucketName);
    }

    @Override
    @SneakyThrows
    public void uploadFile(MultipartFile uploadFile, String bucketName, String objectName) {
        minioUtil.createBucket(bucketName);
        if (objectName != null) {
            minioUtil.uploadFile(uploadFile.getInputStream(),bucketName,objectName + "/" + uploadFile.getName());
        }else {
            minioUtil.uploadFile(uploadFile.getInputStream(),bucketName, uploadFile.getName());
        }
    }

    @Override
    @SneakyThrows
    public List<String> getAllBuckets() {
        return minioUtil.getAllBuckets();
    }

    @Override
    @SneakyThrows
    public List<FileInfo> getAllFiles(String bucketName) {
        return minioUtil.getAllFiles(bucketName);
    }

    @Override
    @SneakyThrows
    public InputStream downloadFile(String bucketName, String objectName) {
        return minioUtil.downloadFile(bucketName,objectName);
    }

    @Override
    @SneakyThrows
    public void deleteBucket(String bucketName) {
        minioUtil.deleteBucket(bucketName);
    }

    @Override
    @SneakyThrows
    public void deleteObject(String bucketName, String objectName) {
        minioUtil.deleteObject(bucketName,objectName);
    }
}
