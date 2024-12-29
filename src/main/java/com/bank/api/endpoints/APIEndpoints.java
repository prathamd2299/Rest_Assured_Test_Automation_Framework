package com.bank.api.endpoints;

public class APIEndpoints {
//	Auth controller endpoints
	public static final String signUpAPI = "/api/auth/signup";
	public static final String loginAPI = "/api/auth/login";
	public static final String forgotPasswordAPI = "/api/auth/forgot-password";

//	User Management contoller endpoints
	public static final String getUserProfileEndpoint = "/api/users/profile";
	public static final String updateUserProfileEndpoint = "/api/users/profile";
	public static final String deleteUserProfileEndpoint = "/api/users/profile";
	public static final String chnagePasswordUserProfileEndpoint = "/api/users/change-password";

//	Account contoller endpoints
	public static final String getUserAccountsEndpoint = "/api/accounts/user";
	public static final String createUserAccountEndpoint = "/api/accounts";
	public static final String getUserAccountByAccountNumberEndpoint = "/api/accounts/";
}
