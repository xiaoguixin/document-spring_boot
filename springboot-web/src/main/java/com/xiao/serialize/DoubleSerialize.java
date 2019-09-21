package com.xiao.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * 定义单个序列化类
 * 需要结合jackson框架使用
 */
public class DoubleSerialize extends JsonSerializer<Double> {

    private DecimalFormat df = new DecimalFormat("#0.00");

    /**
     * 用户将double类型的数据格式化成小数点后两位的字符串数据：
     * 如输出为“900.00”.
     * 实体类属性增加@JsonSerialize，详见User类
     * @param aDouble
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(this.df.format(aDouble));
    }
}
