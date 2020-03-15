package com.data.serializer;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.data.domain.GrantedPermission;

public class GrantedPermissionDeserializer implements JsonDeserializer<GrantedPermission> {

    @Override
    public GrantedPermission deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2)
            throws JsonParseException {
        Gson gson = new Gson();
        return gson.fromJson(arg0, GrantedPermission.class);
    }

}
