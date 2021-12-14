package com.wenner.it.springweb.config;

import com.wenner.it.springweb.SpringwebApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

// 提供MVC功能
@EnableWebMvc
// 申明该类为配置类
@Configuration
// 扫描指定类所在的包及子包中的spring组件
@ComponentScan(basePackageClasses = SpringwebApplication.class)
public class MySpringWebConfig implements WebMvcConfigurer {

    //设置响应信息编码集
    @Override
    public void extendMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringHttpMessageConverter =
                (StringHttpMessageConverter) converters.get(1);
        stringHttpMessageConverter.setDefaultCharset(
                Charset.forName("utf-8"));
    }




}
