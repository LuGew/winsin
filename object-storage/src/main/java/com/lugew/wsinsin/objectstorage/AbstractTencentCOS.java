package com.lugew.wsinsin.objectstorage;


import com.lugew.winsin.core.Error;
import com.lugew.winsin.core.exception.Exception;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.MultiObjectDeleteException;
import com.qcloud.cos.model.DeleteObjectsRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 腾讯对象存储
 *
 * @author LuGew
 * @since 2020/10/22
 */
@Slf4j
public abstract class AbstractTencentCOS extends AbstractObjectStorage {
    protected final COSClient client;

    public AbstractTencentCOS(
            String urlPrefix,
            String secretId,
            String secretKey,
            String bucketName,
            String region
    ) {
        super(urlPrefix, secretId, secretKey, bucketName, region);
        this.setType(Type.TENCENT_COS);
        COSCredentials credentials = new BasicCOSCredentials(getId(), getKey());
        ClientConfig config = new ClientConfig(new Region(getRegion()));
        client = new COSClient(credentials, config);
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

    @Override
    public void delete(String key) {
        try {
            client.deleteObject(getBucket(), key);
        } catch (java.lang.Exception e) {
            throw new Exception(Error.DELETE_FAILED.getCode(), e);
        }
    }

    @Override
    public Object delete(List<String> keys) {
        try {
            DeleteObjectsRequest deleteObjectsRequest = new DeleteObjectsRequest(getBucket());
            List<DeleteObjectsRequest.KeyVersion> keyList = new ArrayList<>(keys.size());
            for (String key : keys) {
                keyList.add(new DeleteObjectsRequest.KeyVersion(key));
            }
            deleteObjectsRequest.setKeys(keyList);
            return client.deleteObjects(deleteObjectsRequest);
        } catch (MultiObjectDeleteException e) {
            throw new Exception(Error.DELETE_FAILED.getCode(), e);
        }
    }
}
