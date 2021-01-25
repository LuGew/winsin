# Winsin

# 使用

## 引入依赖

gradle

```groovy
repositories {
    //依赖库
    maven {
        name 'jitpack'
        url "https://jitpack.io"
    }
}

ext {
    //版本
    winsinVersion = "1.0.0-RELEASE"
}

implementation(
        "com.github.lugew.winsin:winsin-spring-boot-starter:${winsinVersion}"
)
```

maven

```xml

<repositories>
    <repository>
        <id>jitpack</id>
        <name>jitpack</name>
        <url>
            https://jitpack.io
        </url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.lugew.winsin</groupId>
        <artifactId>winsin-spring-boot-starter</artifactId>
        <version>1.0.0-RELEASE</version>
    </dependency>
</dependencies>

```

## 开启功能
