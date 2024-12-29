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

	public Response getRequest(String endpoint) {
		return requestSpecification.when().get(endpoint);
	}

	public Response getRequestWithPathParameter(String pathParameter, String endpoint) {
		return requestSpecification.when().get(endpoint + pathParameter);
	}

	public Response putRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).when().put(endpoint);
	}

	public Response patchRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).when().patch(endpoint);
	}

	public Response deleteRequestWithOneQueryParameter(String key, int value, String endpoint) {
		return requestSpecification.queryParam(key, value).when().delete(endpoint);
	}
}
