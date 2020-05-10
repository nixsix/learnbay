package com.recursion;

import java.util.stream.IntStream;

public class Fibo {

	public static void main(String[] args) {
		IntStream.range(0, 44).forEach(k -> System.out.println(fibo(k)));
	}

	private static int fibo(int i) {
		if(i <= 0) {
			return 0;
		}
		if(i<=2) {
			return 1;
		}
		return fibo(i-1) + fibo(i-2);
	}

}
