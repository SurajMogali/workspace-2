package com.demo.lambda;

import java.net.ResponseCache;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyNameHandler implements RequestHandler<NameRequest, NameResponse> {

	public NameResponse handleRequest(NameRequest input, Context context) {
		String fullName = input.getFirstname() + " " + input.getLastName();

		NameResponse response = new NameResponse();
		response.setFullName(fullName);

		return response;
	}

}
