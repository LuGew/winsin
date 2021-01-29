package com.lugew.wsinsin.objectstorage;

import com.lugew.winsin.core.Error;
import com.lugew.winsin.core.exception.Exception;
import io.minio.*;
import io.minio.messages.DeleteError;
import io.minio.messages.DeleteObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 夏露桂
 * @date 2020/12/24 17:53
 */
@Slf4j
@Component
public class Minio extends AbstractObjectStorage {
    protected final MinioClient client;
    protected final int port;
    protected final String url;

    public Minio(
            @Value("${object-storage.minio.url-prefix}") String urlPrefix,
            @Value("${object-storage.minio.url}") String url,
            @Value("${object-storage.minio.port}") int port,
            @Value("${object-storage.minio.id}") String id,
            @Value("${object-storage.minio.key}") String key,
            @Value("${object-storage.minio.bucket}") String bucket
    ) {
        super(urlPrefix, id, key, bucket, null);
        this.port = port;
        this.url = url;
        this.setType(Type.MINIO);
        client = MinioClient.builder()
                .endpoint(url, port, false)
                .credentials(id, key)
                .build();
    }

    @Override
    public Object put(String key, File file) {
        try {
            return client.uploadObject(UploadObjectArgs.builder()
                    .bucket(getBucket())
                    .object(key)
                    .filename(file.getAbsolutePath())
                    .contentType(ContentType.IMAGE_PNG.getMimeType())
                    .build());
        } catch (java.lang.Exception e) {
            throw new Exception(Error.UPLOAD_FAILED.getCode(), e);
        }

    }

    @Override
    public Object put(String key, InputStream inputStream) {
        try {
            return client.putObject(PutObjectArgs.builder()
                    .bucket(getBucket())
                    .object(key)
                    .stream(inputStream, -1, 10485760)
                    .build());
        } catch (java.lang.Exception e) {
            throw new Exception(Error.UPLOAD_FAILED.getCode(), e);
        }
    }

    @Override
    public void delete(String key) {
        try {
            client.removeObject(RemoveObjectArgs.builder()
                    .bucket(getBucket())
                    .object(key)
                    .build()
            );
        } catch (java.lang.Exception e) {
            throw new Exception(Error.DELETE_FAILED.getCode(), e);
        }
    }

    @Override
    public Object delete(List<String> keys) {
        if (null != keys && !keys.isEmpty()) {
            List<DeleteObject> objects = new LinkedList<>();
            for (String key : keys) {
                objects.add(new DeleteObject(key));
            }
            Iterable<Result<DeleteError>> results = client.removeObjects(RemoveObjectsArgs.builder()
                    .bucket(getBucket())
                    .objects(objects)
                    .build()
            );
            try {
                for (Result<DeleteError> result : results) {
                    DeleteError error = result.get();
                    log.warn("删除单个文件：{} 错误，消息：{}", error.objectName(), error.message());
                }
            } catch (java.lang.Exception e) {
                throw new Exception(Error.DELETE_FAILED.getCode(), e);
            }

        }
        return null;
    }

    public MinioClient getClient() {
        return client;
    }
}
