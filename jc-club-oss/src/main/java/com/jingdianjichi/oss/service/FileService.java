package com.jingdianjichi.oss.service;

import com.jingdianjichi.oss.adapter.StorageAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * 解决的问题：
 *      FileController要是调用不同的oos服务，需要注入不同的service实现类，需要修改代码，
 *      通过此service，可以通过读取配置解决 。StorageConfig
 * FileService接收到StorageService的bean对象
 * 就可以调用业务接口实现功能
 * controller层和此service对接
 */
@Service
public class FileService {

    private final StorageAdapter storageAdapter;

    public FileService(StorageAdapter storageAdapter){
        this.storageAdapter = storageAdapter;
    }

    public List<String> getAllBuckets() {
        return storageAdapter.getAllBuckets();
    }
}
