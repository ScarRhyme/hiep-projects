package com.data.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.data.common.CommonUtil;
import com.data.domain.GrantedPermission;;

public class GrantedPermissionSerializer implements JsonSerializer<GrantedPermission> {

    @Override
    public JsonElement serialize(GrantedPermission permission, Type arg1, JsonSerializationContext arg2) {
        JsonObject result = new JsonObject();
        result.add("grantedDomain", new JsonPrimitive(CommonUtil.NVL(permission.getGrantedDomain())));
        result.add("operationCode", new JsonPrimitive(CommonUtil.NVL(permission.getOperationCode())));
        result.add("resourceCode", new JsonPrimitive(CommonUtil.NVL(permission.getResourceCode())));
        result.add("defaultDomain", new JsonPrimitive(CommonUtil.NVL(permission.getDefaultDomain())));
        return result;
    }

}
