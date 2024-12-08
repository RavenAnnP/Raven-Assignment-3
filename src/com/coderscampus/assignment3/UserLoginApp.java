package com.coderscampus.assignment3;

import java.util.Scanner;

public class UserLoginApp {
	public static void main(String[] args) {
		UserService userService = new UserService();
		User[] users = userService.loadUsers("data.txt");

		Scanner scanner = new Scanner(System.in);
		int attempts = 0;
		final int MAX_ATTEMPTS = 5;

		while (attempts < MAX_ATTEMPTS) {
			System.out.print("Enter your email: ");
			String username = scanner.nextLine();
			System.out.print("Enter your password: ");
			String password = scanner.nextLine();

			User loggedInUser = userService.validateLogin(username, password, users);
			if (loggedInUser != null) {
				System.out.println("Welcome: " + loggedInUser.getName());
				return; 
			} else {
				System.out.println("Invalid login, please try again.");
				attempts++;
			}
		}
		System.out.println("Too many failed login attempts, you are now locked out.");

		scanner.close();
	}
}