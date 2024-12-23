package com.bank.api.services;

import static io.restassured.RestAssured.*;

import com.bank.api.utilities.ConfigManager;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	private RequestSpecification requestSpecification;

	public BaseService() {
		requestSpecification = given().baseUri(ConfigManager.getProperty("baseUri"));
	}

	public void attachToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}

	public Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).when().post(endpoint);
	}
}
