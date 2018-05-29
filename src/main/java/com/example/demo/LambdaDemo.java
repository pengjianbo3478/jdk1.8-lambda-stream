package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {

	public static void main(String[] args) {

		a1();
		a2();

		c1();
	}

	private static void c1() {
		new Thread(() -> System.out.println("hello")).start();
	}

	private static void a1() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		long count = languages.stream().filter(str -> str.startsWith("J")).count();
		System.out.println(count);
	}

	private static void a2() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		languages.stream().filter(str -> str.length() > 5).forEach(System.out::println);
	}

	private static void m2() {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		features.forEach(System.out::println);
	}

	private static void m1() {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}
	}

}
