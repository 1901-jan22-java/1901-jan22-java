package com.question23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class StringToDate {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a date int this format: Month day, year");
		String sDate = buffer.readLine(); // Reads user input as a string.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH); // Java object used to convert a date into the format pattern entered in he first parameter, followed by the language that will be entered. 
		LocalDate date = LocalDate.parse(sDate, formatter); // Takes in a char sequence as the first parameter, and the datetimeformatter as the second argument. Parses the pattern into a date from a string.
		System.out.println(date);
	}

}
