package com.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Tiling {

	
	static int memoized [] = null;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int  arrLen = sc.nextInt();
		int input [] = new int[arrLen];
		
		int index =0;
		List<Integer> tileResult = new LinkedList<>();
		while(arrLen!=0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			memoized  = new int[n];
			Arrays.fill(memoized, -1);
			int res = tilingSolve(n,m);
			tileResult.add(res);
			arrLen--;
		}
	
		tileResult.forEach(System.out::println);
	}

	private static int tilingSolve(int n, int m) {
		if(n<1) {
			return 0;
		}
		if (memoized[n-1]!=-1) {
			return memoized[n-1];
		}
		if(n<m) {
			return 1;
		}
		if(n==m) {
			return 2;
		}
		int res = tilingSolve(n-1, m) + tilingSolve(n-m,m);
		memoized[n-1] = res;
		return res;
	}

}
