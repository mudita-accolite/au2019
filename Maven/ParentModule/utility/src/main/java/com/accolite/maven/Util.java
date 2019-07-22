package com.accolite.maven;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
	 public static String convertToJsonString(Object obj) {
	    	ObjectMapper obj1=new ObjectMapper();
	    	 String jsonStr="";
			try { 
	            jsonStr = obj1.writeValueAsString(obj);
	            return jsonStr; 
	        } 
	        catch (IOException e) { 
	            e.printStackTrace(); 
	        }
			return jsonStr; 
	    }

	 
}
