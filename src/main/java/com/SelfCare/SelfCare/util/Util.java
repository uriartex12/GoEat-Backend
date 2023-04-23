package com.SelfCare.SelfCare.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Util {
	
	 public static String signSha512Base64(String message) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		 	MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
		 	byte[] messageBytes = message.getBytes("UTF-8");
		 	byte[] hashBytes = messageDigest.digest(messageBytes);
		 	StringBuilder hashBuilder = new StringBuilder();
		 	for (byte b : hashBytes) {
		 	  hashBuilder.append(String.format("%02x", b));
		 	}
		 	String hashString = hashBuilder.toString();
		 	return hashString;

	 }
	 
	 public static void responsePaginated(Map response,int total, Map params) {
			
			response.put("total", total);
			response.put("xpagina", Integer.parseInt(params.get("xpagina").toString()));
			response.put("pagina", Integer.parseInt(params.get("pagina").toString()));
			//return response;

	 }
		
     public static int resolveLimit(Map map) {
			return (Integer.parseInt(map.get("pagina").toString())-1)*Integer.parseInt(map.get("xpagina").toString());

     }
}
