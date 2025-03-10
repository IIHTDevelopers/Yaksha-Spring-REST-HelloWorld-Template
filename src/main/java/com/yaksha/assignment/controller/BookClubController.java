package com.yaksha.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookClubController {

	@GetMapping("/")
	public String home() {
		return "Welcome to the Book Club API!";
	}
}
