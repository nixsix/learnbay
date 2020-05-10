package com.recursion;

public class FibonacciExample {

	public static int fibonacciRecursion(int n){
		if(n == 0){
			return 0;
		}
		if(n == 1 || n == 2){
			return 1;
		}
		return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
	}
	public static void main(String args[]) {
		int maxNumber = 60;
		System.out.print("Fibonacci Series of "+maxNumber+" numbers: ");
		System.out.print(fibonacciRecursion(maxNumber) +" ");
	}

}