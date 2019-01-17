package com.jin.railway.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class JsonUtil {	
	
	public static String toJson(Object object){
		 Gson gson = new Gson(); 
		 String ret = gson.toJson(object);
		 //log.info(ret);
		 return ret;
	}
	
	public static <T> T fromJson(String json, Class<T> t){
		Gson gson = new Gson();
		T obj = gson.fromJson(json, t);
		//log.info(obj.toString());
		return obj;
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sss", "aaa");
		map.put("yyy", "111");
		String jsonStr = toJson(map);
		System.out.println(jsonStr);
		
		System.out.println(fromJson(jsonStr, HashMap.class));
	}
}
