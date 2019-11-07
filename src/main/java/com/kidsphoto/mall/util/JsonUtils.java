package com.kidsphoto.mall.util;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 自定义响应结构
 */
public class JsonUtils {

	// 定义jackson对象
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.configure(Feature.ALLOW_SINGLE_QUOTES, true)
			.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	
	/**
	 * <p>
	 * Title: pojoToJson
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 *
	 * @param data
	 * @return
	 */
	public static String objectToJson(Object data) {
		try {
			return OBJECT_MAPPER.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String simpleMap2JsonStr(Map<String, Object> params) {
		try {
			Iterator<String> iterator = params.keySet().iterator();
			JSONObject jsonObject = new JSONObject();
			while (iterator.hasNext()) {
				String key = iterator.next();
				jsonObject.put(key, params.get(key));
			}
			return jsonObject.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * @param jsonData
	 *            json数据
	 * @param clazz
	 *            对象中的object类型
	 * @return
	 */
	public static <T> T jsonToPojo(String jsonData, Class<T> clazz) {
		try {
			T t = OBJECT_MAPPER.readValue(jsonData, clazz);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = OBJECT_MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @param jsonData
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> Map<K, V> jsonToMap(String jsonData) {
		JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(HashMap.class, String.class,
				Object.class);
		try {
			Map<K, V> map = OBJECT_MAPPER.readValue(jsonData, javaType);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
