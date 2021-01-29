package com.lugew.wsinsin.objectstorage;


import com.lugew.winsin.core.Error;
import com.lugew.winsin.core.exception.Exception;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;

/**
 * 简单腾讯对象存储
 *
 * @author LuGew
 * @since 2020/10/22
 */
@Component
@Slf4j
public class SimpleTencentCOS extends AbstractTencentCOS {
    public SimpleTencentCOS(
            @Value("${object-storage.tencent.secret-id}") String secretId,
            @Value("${object-storage.tencent.secret-key}") String secretKey,
            @Value("${object-storage.tencent.bucket-name}") String bucketName,
            @Value("${object-storage.tencent.region}") String region,
            @Value("${object-storage.tencent.url-prefix}") String urlPrefix
    ) {
        super(urlPrefix, secretId, secretKey, bucketName, region);
    }

    @Override
    public Object put(String key, File file) {
        try {
            return client.putObject(new PutObjectRequest(getBucket(), key, file));
        } catch (java.lang.Exception e) {
            throw new Exception(Error.UPLOAD_FAILED.getCode(), e);
        }
    }

    @Override
    public Object put(String key, InputStream inputStream) {
        try {
            return client.putObject(new PutObjectRequest(getBucket(), key, inputStream, new ObjectMetadata()));
        } catch (java.lang.Exception e) {
            throw new Exception(Error.UPLOAD_FAILED.getCode(), e);
        }
    }
}
