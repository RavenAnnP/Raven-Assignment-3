package com.coderscampus.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	public User[] loadUsers(String filePath) {
		User[] users = new User[4];
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
				int count = 0;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 3) {
					users[count] = new User(parts[0], parts[1], parts[2]);
				}
				count++;
			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		return users;
	}

	public User validateLogin(String username, String password, User[] users) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return user; 
			}
		}
		return null; 
	}
}