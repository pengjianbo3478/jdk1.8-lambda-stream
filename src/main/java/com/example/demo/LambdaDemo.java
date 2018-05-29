package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo {

	public static void main(String[] args) {

		d1();
	}

	private static void d1() {
		List<String> strList = Arrays.asList("cccc", "erwrwer", "qwewqe", "erwer", "1");
		List<String> filtered = strList.stream().filter(x -> x.length() > 4).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
	}

	private static void n2() {
		// 不使用lambda表达式为每个订单加上12%的税
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			System.out.println(price);
		}

		// 使用lambda表达式
		List<Integer> list = Arrays.asList(100, 200, 300, 400, 500);
		list.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
	}

	private static void n1() {

		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			total = total + price;
		}
		System.out.println("Total : " + total);

		List<Integer> abc = Arrays.asList(100, 200, 300, 400, 500);
		double bill = abc.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
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
