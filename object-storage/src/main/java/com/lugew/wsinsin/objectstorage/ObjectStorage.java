package com.lugew.wsinsin.objectstorage;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * 对象存储器接口，
 * 包含常用增删改
 *
 * @author 夏露桂
 * @since 2021/1/29 18:16
 */
public interface ObjectStorage {

    Object put(String key, File file);

    Object put(String key, InputStream inputStream);

    void delete(String key);

    Object delete(List<String> keys);

    String getUrlPrefix();

    String getId();

    String getKey();

    String getBucket();

    String getRegion();

    Type getType();
}
