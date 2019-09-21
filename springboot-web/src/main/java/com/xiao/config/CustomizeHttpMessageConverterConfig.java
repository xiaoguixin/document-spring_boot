package com.xiao.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.xiao.serialize.CustomizeJsonSerialize;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import java.nio.charset.Charset;
import java.util.Date;

/**
 * Spring MVC使用HttpMessageConverter接口转换HTTP请求和响应(Request和ReposeBody)
 * 如对象自动转换为JSON或者XML
 *
 */
@Configuration
public class CustomizeHttpMessageConverterConfig {

    /**
     * 自定义ResponseBody对象输出
     * @return
     */
    @Bean
    public HttpMessageConverters customConverters() {
        System.out.println("－－－－－－－init－－－－－－");

        HttpMessageConverter<String> str = new StringHttpMessageConverter();
        FastJsonHttpMessageConverter fastConverter = fastConverter();
        MappingJackson2HttpMessageConverter jacksonConverter = jacksonConverter();
        MappingJackson2XmlHttpMessageConverter jacksonXMlConverter = null;

        int type = 0;
        if(type == 1){// fast json格式化
            return new HttpMessageConverters(str, fastConverter);
        } else if(type == 2){// jackson格式化
            return new HttpMessageConverters(str, jacksonConverter);
        } else if(type == 3){// jackson转化xml格式化
            return new HttpMessageConverters(str, jacksonXMlConverter);
        } else {
            return new HttpMessageConverters(str);
        }
    }

    /**
     * FastJson格式化输出
     * @return
     */
    public FastJsonHttpMessageConverter fastConverter() {
        // 定义格式
        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                //输出key是包含双引号
                SerializerFeature.QuoteFieldNames,
                // 是否输出为null的字段,若为null 则显示该字段
                SerializerFeature.WriteMapNullValue,
                // 数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                // List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                // 字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                // Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                // Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                // 循环引用
                SerializerFeature.DisableCircularReferenceDetect
        };

        // 添加FastJson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));

        // 定义一个convert转换消息的对象,在convert中添加配置信息
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        fastConverter.setFastJsonConfig(fastJsonConfig);

        return fastConverter;
    }

    /**
     * jackson格式化输出
     * @return
     */
    public MappingJackson2HttpMessageConverter jacksonConverter(){
        SimpleModule simpleModule = new SimpleModule();
        // 输出
        //simpleModule.addSerializer(Double.class, new DoubleSerialize());//保留两位小数
        simpleModule.addSerializer(Date.class, new CustomizeJsonSerialize.BirthdaySerializer());//保留两位小数

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
        return converter;
    }
}
