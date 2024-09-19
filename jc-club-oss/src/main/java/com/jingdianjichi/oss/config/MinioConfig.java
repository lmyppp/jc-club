package com.jingdianjichi.oss.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * minio配置类
 */
@Configuration
public class MinioConfig {
    /**
     * minioUrl
     */
    @Value("${minio.url}")  //对接配置文件，取值
    private String url;
    /**
     * minio账户
     */
    @Value("${minio.accessKey}")
    private String accessKey;
    /**
     * minio秘密
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    /**
     * 构造MinioClient
     */
    @Bean
    public MinioClient getMinioClient() {
        return MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
    }
}
