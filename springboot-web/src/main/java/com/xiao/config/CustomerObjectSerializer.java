package com.xiao.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.xiao.entity.User;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.jackson.JsonObjectSerializer;

import java.io.IOException;

/**
 * 自定义Object序列化
 */
@JsonComponent
public class CustomerObjectSerializer {

    public static class Serializer extends JsonObjectSerializer {
        @Override
        protected void serializeObject(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException {

        }
    }

    public static class Deserializer extends JsonObjectDeserializer {
        @Override
        protected User deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) throws IOException {
            return null;
        }
    }
}
