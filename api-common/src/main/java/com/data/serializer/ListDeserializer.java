package com.data.serializer;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class ListDeserializer<T> implements JsonDeserializer<List<T>> {

    Class<T[]> tClass;

    public ListDeserializer(Class<T[]> tClass) {
        this.tClass = tClass;
    }

    @Override
    public List<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        T[] objects = context.deserialize(json, tClass);
        return Arrays.asList(objects);
    }
}
