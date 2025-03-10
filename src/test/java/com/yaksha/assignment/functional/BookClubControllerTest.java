package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.yaksha.assignment.BookClubApplication;
import com.yaksha.assignment.utils.JavaParserUtils;

@WebMvcTest(BookClubApplication.class)
@AutoConfigureMockMvc
public class BookClubControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	private static final String CLASS_PATH = "src/main/java/com/yaksha/assignment/controller/BookClubController.java"; // Path
																														// to
	// BookClubController.java

	// Test 1: Check if the class has @RestController annotation
	@Test
	void testClassHasRestControllerAnnotation() throws IOException {
		boolean hasAnnotation = JavaParserUtils.checkClassAnnotation(CLASS_PATH, "RestController");
		yakshaAssert(currentTest(), hasAnnotation, businessTestFile);
	}

	// Test 2: Check if the 'home' method has @GetMapping annotation
	@Test
	void testMethodHasGetMappingAnnotation() throws IOException {
		boolean hasAnnotation = JavaParserUtils.checkMethodAnnotation(CLASS_PATH, "home", "GetMapping");
		yakshaAssert(currentTest(), hasAnnotation, businessTestFile);
	}

	// Test 3: Check if the 'home' method returns a String
	@Test
	void testMethodReturnType() throws IOException {
		boolean isReturnTypeCorrect = JavaParserUtils.checkMethodReturnType(CLASS_PATH, "home", "String");
		yakshaAssert(currentTest(), isReturnTypeCorrect, businessTestFile);
	}
}
