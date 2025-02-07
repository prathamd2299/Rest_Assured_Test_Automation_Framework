package com.bank.api.filters;

import org.apache.logging.log4j.*;

import io.restassured.filter.*;
import io.restassured.response.Response;
import io.restassured.specification.*;

public class LoggingFilter implements Filter {
	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec);// Request is going to executed
		logResponse(response);

		return response;// test for assertion
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI with endpoint:" + requestSpec.getURI());
		logger.info("Request Header:" + requestSpec.getHeaders());
		logger.info("Request PayLoad:" + requestSpec.getBody());

		if (requestSpec.getQueryParams() != null) {
			logger.info("Request query parameters: " + requestSpec.getQueryParams());
		}

		if (requestSpec.getPathParams() != null) {
			logger.info("Request path parameters: " + requestSpec.getPathParams());
		}
	}

	public void logResponse(Response response) {
		logger.info("STATUS CODE:" + response.getStatusCode());
		logger.info("Response Header :" + response.headers());
		logger.info("Request Body:" + response.getBody().prettyPrint() + "\n");
	}
}
