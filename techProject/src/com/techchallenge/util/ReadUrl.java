package com.techchallenge.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ReadUrl {
	
	public String getJson(HttpURLConnection signedUrl){
		
		InputStreamReader inputStreamReader = null;
		BufferedReader bf = null;
		StringBuilder sb = new StringBuilder();
		String line = "";
		
		try{
			inputStreamReader = new InputStreamReader(signedUrl.getInputStream());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		bf = new BufferedReader(inputStreamReader);
  
        try{
        	while((line=bf.readLine()) != null){
        		//System.out.println(line);
            	sb.append(line);
        	}
        	bf.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        return sb.toString();
	}

}
