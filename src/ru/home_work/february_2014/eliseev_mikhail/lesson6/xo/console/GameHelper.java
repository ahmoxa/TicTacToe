package ru.home_work.february_2014.eliseev_mikhail.lesson6.xo.console;

// класс для пользовательского ввода целиком взят из русского издания книги Head First Java (5 глава, стр. 142)

// fix: генерит исключение, если ввести не цифры

import java.io.*;

class GameHelper {
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) {
				return null;
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		return inputLine;
	}
}