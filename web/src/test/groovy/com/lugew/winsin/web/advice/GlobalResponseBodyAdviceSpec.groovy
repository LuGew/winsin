package com.lugew.winsin.web.advice

import com.lugew.winsin.web.response.R
import org.springframework.core.MethodParameter
import org.springframework.http.ResponseEntity
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

/**
 *
 * 全局返回值拦截器
 * @author 夏露桂* @since 2021/1/20 10:19
 */
@Subject(GlobalResponseBodyAdvice)
@Narrative("对返回值统一处理")
class GlobalResponseBodyAdviceSpec extends Specification {
    @Shared
    GlobalResponseBodyAdvice globalResponseBodyAdvice

    def setupSpec() {
        globalResponseBodyAdvice = new GlobalResponseBodyAdvice()
    }

    def "返回的R的data部分是body"() {
        given: "方法返回值是void"
        MethodParameter methodParameter = Stub()
        methodParameter.getParameterType() >> Void.class
        Object body = new Object()

        expect: "返回的R的data部分是body"
        with((R) globalResponseBodyAdvice.beforeBodyWrite(body, methodParameter, null, null, null, null)) {
            getData() == body
        }
    }

    def "指定类型返回值不做处理"() {
        given: "指定类型"
        MethodParameter methodParameter = Stub()
        methodParameter.getParameterType() >> type
        expect: "过滤指定类型"
        supported == globalResponseBodyAdvice.supports(methodParameter, null)
        where: "类型"
        type                 || supported
        R.class              || false
        ResponseEntity.class || false
        Object.class         || true
    }
}
