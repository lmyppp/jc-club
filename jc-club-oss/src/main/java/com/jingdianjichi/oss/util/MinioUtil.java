package com.jingdianjichi.oss.util;

import com.jingdianjichi.oss.entity.FileInfo;
import io.minio.*;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * minio文件操作工具
 */
@Component
public class MinioUtil {

    @Resource
    private MinioClient minioClient;

    /**
     * 创建bucket桶
     */
    public void createBucket(String bucketName) throws Exception {
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!exists) {
            //创建桶
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    /**
     * 上传文件
     */
    public void uploadFile(InputStream inputStream, String bucketName, String objectName) throws Exception {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName)
                .stream(inputStream, -1, Integer.MAX_VALUE).build());
    }

    /**
     * 列出所有桶
     */
    public List<String> getAllBuckets() throws Exception {
        List<Bucket> buckets = minioClient.listBuckets();
        return buckets.stream()
                .map(bucket -> bucket.name()).collect(Collectors.toList());
    }

    /**
     * 列出桶中文件
     */
    public List<FileInfo> getAllFiles(String bucketName) throws Exception {
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket(bucketName).build());
        List<FileInfo> fileInfoList = new LinkedList<>();
        for (Result<Item> result : results) {
            FileInfo fileInfo = new FileInfo();
            Item item = result.get();
            fileInfo.setFileName(item.objectName());
            fileInfo.setEtag(item.etag());
            fileInfo.setDirectoryFlag(item.isDir());
            fileInfoList.add(fileInfo);
        }
        return fileInfoList;
    }

    /**
     * 下载文件
     */
    public InputStream downloadFile(String bucketName, String objectName) throws Exception {
        GetObjectResponse object = minioClient.getObject(GetObjectArgs.builder()
                .bucket(bucketName).object(objectName).build());
        return object;
    }

    /**
     * 删除桶
     */
    public void deleteBucket(String bucketName) throws Exception {
        minioClient.removeBucket(
                RemoveBucketArgs.builder().bucket(bucketName).build()
        );
    }

    /**
     * 删除文件
     */
    public void deleteObject(String bucketName, String objectName) throws Exception {
        minioClient.removeObject(
                RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build()
        );
    }

}
