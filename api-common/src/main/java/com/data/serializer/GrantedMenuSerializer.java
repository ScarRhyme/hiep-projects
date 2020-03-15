
package com.data.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.data.common.CommonUtil;
import com.data.domain.GrantedMenu;

public class GrantedMenuSerializer implements JsonSerializer<GrantedMenu> {

    @Override
    public JsonElement serialize(GrantedMenu menu, Type arg1, JsonSerializationContext arg2) {
        JsonObject result = new JsonObject();
        result.add("name", new JsonPrimitive(CommonUtil.NVL(menu.getName())));
        result.add("code", new JsonPrimitive(CommonUtil.NVL(menu.getCode())));
        result.add("url", new JsonPrimitive(CommonUtil.NVL(menu.getUrl())));
        result.add("reourceKey", new JsonPrimitive(CommonUtil.NVL(menu.getResourceKey())));
        result.add("sortOrder", new JsonPrimitive(CommonUtil.NVL(menu.getSortOrder())));
        result.add("sysMenuId", new JsonPrimitive(CommonUtil.NVL(menu.getSysMenuId())));
        return result;
    }

}
