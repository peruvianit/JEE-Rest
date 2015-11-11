package it.peruvianit.util;

import com.google.gson.GsonBuilder;

public class GsonUtil {
	public GsonUtil(){};
	
	public static String objToJson (final Object object){
		return new GsonBuilder().create().toJson(object);
	}
}
