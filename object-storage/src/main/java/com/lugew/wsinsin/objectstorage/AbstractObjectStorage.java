package com.lugew.wsinsin.objectstorage;


/**
 * @author 夏露桂
 * @since 2021/1/29 18:16
 */
public abstract class AbstractObjectStorage implements ObjectStorage {
    protected final String urlPrefix;
    protected final String id;
    protected final String key;
    protected final String bucket;
    protected final String region;
    protected Type type;

    public AbstractObjectStorage(String urlPrefix, String id, String key, String bucket, String region) {
        this.urlPrefix = urlPrefix;
        this.id = id;
        this.key = key;
        this.bucket = bucket;
        this.region = region;
        this.type = null;
    }

    @Override
    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getUrlPrefix() {
        return urlPrefix;
    }

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public String getBucket() {
        return bucket;
    }
}
