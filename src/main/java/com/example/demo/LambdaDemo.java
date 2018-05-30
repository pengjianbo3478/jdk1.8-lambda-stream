package com.example.demo;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo {

	public static void main(String[] args) {

		base64Demo();

	}

	private static void base64Demo() {
		String orig = "hello world!";
		String desc = Base64.getEncoder().encodeToString(orig.getBytes(StandardCharsets.UTF_8));
		System.out.println("加密后的字符串为:" + desc);
		String unDecodeStr = new String(Base64.getDecoder().decode(desc), StandardCharsets.UTF_8);
		System.out.println("解密后的字符串为" + unDecodeStr);
	}

	private static void n4() {
		// 获取数字的个数、最小值、最大值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}

	private static void n3() {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(i -> i * 10).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
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
