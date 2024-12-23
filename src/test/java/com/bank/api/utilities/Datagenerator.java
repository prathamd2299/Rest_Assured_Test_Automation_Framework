package com.bank.api.utilities;

import java.util.Random;

import com.github.javafaker.Faker;

public class Datagenerator {
	private static final Faker faker = new Faker();
	private static final Random random = new Random();

	public static String getRandomFirstName() {
		return faker.name().firstName();
	}

	public static String getRandomLastName() {
		return faker.name().lastName();
	}

	public static String getRandomEmail() {
		return faker.internet().emailAddress();
	}

	public static String getRandomUserName() {
		return faker.name().username();
	}

	public static String getRandomPassword() {
		return faker.internet().password();
	}

	public static String getRandomMobileNumber() {
		// Ensure the first digit is non-zero
		int firstDigit = random.nextInt(9) + 1;

		// Generate the remaining 9 digits
		long remainingDigits = (long) (random.nextDouble() * 1_000_000_000L);

		return firstDigit + String.format("%09d", remainingDigits);
	}
}
