# 概述

`winsin`是一款web脚手架，致力于简化`spring-boot`为基础的web应用开发。
# 引入依赖
Gradle
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
Maven
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


# 模块
## 
## JPA
选用JPA作为ORM框架
```groovy
implementation(
        "com.github.lugew.winsin:jpa-spring-boot-starter:${winsinVersion}"
)
```
## MyBatis
集成[MyBatis-plus](https://baomidou.com/)
#### 使用方式
```groovy
implementation(
        "com.github.lugew.winsin:mybatis-spring-boot-starter:${winsinVersion}"
)
```
`@MapperScan`注解指定扫描Mapper扫描位置
```java
@MapperScan("com.lugew.*.*.repository")//你的mapper包
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
### 特性
#### 分页
添加`@EnableMyBatisPlusPaging`注解开启分页，默认分页仅支持MySQL
```java
@EnableMyBatisPlusPaging
@MapperScan("com.lugew.*.*.repository")//你的mapper包
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
## Web
默认开启`spring-boot-starter-web`，且只作为API服务。
### 统一响应（返回值）
#### 使用方式
```groovy
implementation(
        "com.github.lugew.winsin:web-spring-boot-starter:${winsinVersion}"
)
```
添加`@EnableStandardResponse`注解，开启标准响应。
```java
@EnableStandardResponse
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```


开启后，消息格式如下：
```json
{
  "code":"ok",//响应代码，不建议使用数字（但仍可选）
  "data":{//数据
    "name":"winsin",
    "version:1
  },
  "message":"success"//消息提示
}
```
### 自定义异常解析

- 抛出的异常需继承`com.lugew.winsin.core.exception.Exception`，或直接使用。
```java
public class Exception extends RuntimeException implements KeyValue<String> {
    private String key;//键
    private Object[] arguments;//参数

    public Exception() {
    }

    public Exception(String key, Object... arguments) {
        super(key);
        setKey(key);
        setValue(arguments);
    }

    public Exception(String message) {
        super(message);
        key = message;
    }

    public Exception(String message, Throwable cause) {
        super(message, cause);
        key = message;
    }

    public Exception(Throwable cause) {
        super(cause);
    }

    public Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        key = message;
    }

    @Override
    public Object[] getValue() {
        return this.arguments;
    }

    @Override
    public void setValue(Object... value) {
        this.arguments = value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;
    }


    @Override
    public String getKeyValue() {
        return key;
    }
}
```
```java
/**
 * @author 夏露桂
 * @date 2020/12/31 17:39
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BasicController<User, UserService, Long> {
    @PostMapping("/userNotFound")
    public void userNotFound() {
        throw new Exception(Error.USER_NOT_FOUND.getCode());
    }
}

```

- 自定义配置类，且实现ExceptionConfigurationSupporter接口，并重写`getMessage`方法。以国际化消息为例：
```java
/**
 * @author 夏露桂
 * @since 2021/1/21 11:22
 */
@Configuration
@RequiredArgsConstructor
public class ExceptionConfiguration implements ExceptionConfigurationSupporter {
    private final MessageSource messageSource;//构造器注入消息源

    @Override
    public String getMessage(Exception exception) {
        return messageSource.getMessage(exception.getKey(), exception.getValue(), LocaleContextHolder.getLocale());
    }
}
```
配置完成之后，异常信息返回如下：
```json
{
  "code":"user.not.found",//错误代码
  "data":null,
  "message":"用户不存在"//消息提示
}
```


