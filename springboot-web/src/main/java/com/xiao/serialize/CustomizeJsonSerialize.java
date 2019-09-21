package com.xiao.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用@JsonComponent注解定义多个序列化／反序列化规则
 * 需要结合jackson框架使用
 */
@JsonComponent
public class CustomizeJsonSerialize {

    //定义时间格式
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    //数值格式
    private static DecimalFormat df = new DecimalFormat("#0.00");

    /**
     * 生日输出规则
     * 需配合@JsonSerialize，详见User类
     */
    public static class BirthdaySerializer extends JsonSerializer<Date> {
        @Override
        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(sdf.format(date));
        }
    }

    /**
     * 保留两位小数规则
     * 需配合@JsonSerialize，详见User类
     */
    public static class DoubleSerialize extends JsonSerializer<Double> {
        @Override
        public void serialize (Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(df.format(aDouble));
        }
    }

    /**
     * 格式化输入日期
     */
    public static class BirthdayDeserializer extends JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            return null;
        }
    }


}
