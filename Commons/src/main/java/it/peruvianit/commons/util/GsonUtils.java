package it.peruvianit.commons.util;

import com.google.gson.GsonBuilder;

public final class GsonUtils {
	public GsonUtils(){};
	
	public static String objToJsonPrettyPrinting (final Object object){
		return new GsonBuilder().setPrettyPrinting().create().toJson(object);
	}
	
	public static String objToJson (final Object object){
		return new GsonBuilder().create().toJson(object);
	}
}
