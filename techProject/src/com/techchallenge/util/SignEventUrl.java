package com.techchallenge.util;

import java.net.HttpURLConnection;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;

public class SignEventUrl {
	public HttpURLConnection signUrl(HttpURLConnection url){
		//Marketplace techtest
		//String consumerKey = "techtest-152698";
		//String consumerSecret = "Q6P7p2tbjfqFqWNr";
		
		//testMarketplace techtest2
		String consumerKey = "techtest2-183982";
		String consumerSecret = "aXmrcw1GLIfE3lNO";
		
		
		OAuthConsumer consumer = new DefaultOAuthConsumer(consumerKey,consumerSecret);
		try{
        	consumer.sign(url);
        }catch(Exception e){
        	e.printStackTrace();
        }
		
		return url;
	}

}
