package com.jingdianjichi.oss.config;

import com.jingdianjichi.oss.adapter.StorageAdapter;
import com.jingdianjichi.oss.adapter.AliStorageAdapter;
import com.jingdianjichi.oss.adapter.MinioStorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 存储服务器配置类
 * 通过配置文件读取存储服务器类型
 * 注入对接各个存储服务器的实现类，根据配置读取的结果返回不同的存储服务器实现类对象。
 * FileService接收
 */
@Configuration
@RefreshScope
public class StorageConfig {

    @Value("${storage.service.type}")
    private String storageType;

    @Bean
    @RefreshScope
    public StorageAdapter storageService(){
        if ("minio".equals(storageType)) {
            return new MinioStorageAdapter();
        }else if ("aliyun".equals(storageType)){
            return new AliStorageAdapter();
        }else {
            throw new IllegalArgumentException("未找到对应的文件存储处理器");
        }
    }

}
