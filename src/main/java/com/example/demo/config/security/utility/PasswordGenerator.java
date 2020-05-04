package com.example.demo.config.security.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PasswordGenerator {

	private final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String DIGITS = "0123456789";
	private final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";

	public String generate(int length) {
		// Argument Validation.
		if (length <= 0) {
			return "";
		}

		// Variables.
		StringBuilder password = new StringBuilder(length);
		Random random = new Random(System.nanoTime());

		// Collect the categories to use.
		List<String> charCategories = new ArrayList<>(4);
		charCategories.add(LOWER);
		charCategories.add(UPPER);
		charCategories.add(DIGITS);
		charCategories.add(PUNCTUATION);

		// Build the password.
		for (int i = 0; i < length; i++) {
			String charCategory = charCategories.get(random.nextInt(charCategories.size()));
			int position = random.nextInt(charCategory.length());
			password.append(charCategory.charAt(position));
		}
		return new String(password);
	}
}
