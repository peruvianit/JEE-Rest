package it.peruvianit.commons.util;

import com.google.gson.GsonBuilder;

public class GsonUtils {
	public GsonUtils(){};
	
	public static String objToJson (final Object object){
		return new GsonBuilder().setPrettyPrinting().create().toJson(object);
	}
}
