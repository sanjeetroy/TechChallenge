package com.techchallenge.web;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techchallenge.util.RequestToResponse;


/**
 * Servlet implementation class InteractWithMarketPlace
 */
@WebServlet("/techchallenge")
public class InteractWithMarketPlace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String eventUrl = (String) request.getParameter("eventUrl");
		
		URL url = new URL(eventUrl);
        HttpURLConnection requestUrl = (HttpURLConnection) url.openConnection();
		requestUrl.setRequestProperty("Accept", "application/json");
        
		RequestToResponse requestToResponse = new RequestToResponse();
		requestToResponse.requestToResponse(requestUrl);
        
        
        
		//Response
		
		
        response.setContentType("application/json");
		
        PrintWriter out = response.getWriter();
        String jsonResponse = requestToResponse.getJsonResponse();
        out.println(jsonResponse);

	}

}
