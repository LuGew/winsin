package com.lugew.wsinsin.objectstorage;


import com.lugew.winsin.core.Error;
import com.lugew.winsin.core.exception.Exception;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 腾讯复杂对象存储
 *
 * @author LuGew
 * @since 2020/10/22
 */
@Component
public class AdvancedTencentCOS extends AbstractTencentCOS {
    private final int threadsCount = 32;
    private final TransferManager transferManager;

    public AdvancedTencentCOS(
            @Value("${object-storage.tencent.url-prefix}") String urlPrefix,
            @Value("${object-storage.tencent.secret-id}") String secretId,
            @Value("${object-storage.tencent.secret-key}") String secretKey,
            @Value("${object-storage.tencent.bucket-name}") String bucketName,
            @Value("${object-storage.tencent.region}") String region

    ) {
        super(urlPrefix, secretId, secretKey, bucketName, region);
        ExecutorService executorService = Executors.newFixedThreadPool(this.threadsCount);
        transferManager = new TransferManager(this.client, executorService);

    }

    @Override
    public Object put(String key, File file) {
        try {
            Upload upload = transferManager.upload(new PutObjectRequest(getBucket(), key, file));
            return upload.waitForUploadResult();
        } catch (java.lang.Exception e) {
            throw new Exception(Error.UPLOAD_FAILED.getCode(), e);
        }
    }

    @Override
    public Object put(String key, InputStream inputStream) {
        try {
            Upload upload = transferManager.upload(new PutObjectRequest(getBucket(), key, inputStream, new ObjectMetadata()));
            return upload.waitForUploadResult();
        } catch (java.lang.Exception e) {
            throw new Exception(Error.UPLOAD_FAILED.getCode(), e);

        }
    }
}
