package com.jingdianjichi.oss.adapter;

import com.jingdianjichi.oss.entity.FileInfo;
import io.minio.*;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 原本是中间层service接口
 * 现改成适配器接口
 */
public interface StorageAdapter {
    /**
     * 创建bucket桶
     */
    void createBucket(String bucketName);

    /**
     * 上传文件
     */
    void uploadFile(MultipartFile uploadFile, String bucketName, String objectName);

    /**
     * 列出所有桶
     */
    List<String> getAllBuckets();

    /**
     * 列出桶中文件
     */
    List<FileInfo> getAllFiles(String bucketName);

    /**
     * 下载文件
     */
    InputStream downloadFile(String bucketName, String objectName);

    /**
     * 删除桶
     */
    void deleteBucket(String bucketName);

    /**
     * 删除文件
     */
    void deleteObject(String bucketName, String objectName);
}
