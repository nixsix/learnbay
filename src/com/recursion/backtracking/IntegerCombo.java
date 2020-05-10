package com.recursion.backtracking;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.Scanner;

public class IntegerCombo {

	static String [] combo = {"a","b"};
	static int count =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		String res = "";
		Integer [] total = new Integer[n];
		Arrays.fill(total , 0);
		for (int i = 0; i < n; i++) {
			int x= total[i];
			int a=integerComboBackTrack(arr[i], "a",0);
			count = 0;
			int b= integerComboBackTrack(arr[i], "b", 0);
			total[i]= a+b; 
			System.out.println("#"+(i+1)+" : "+total[i]);
			count = 0;
		}
	}

	private static int integerComboBackTrack(int lengthToAchieve , String res, int total) {
		if(res.length()==lengthToAchieve) {
		//	out.println(res);
			return ++count;
		}	
		integerComboBackTrack(lengthToAchieve, res+"a",++total);
		if((res.length()==0 || (res.charAt(res.length()-1)!='b'))&& res.length()!=lengthToAchieve) {
			integerComboBackTrack(lengthToAchieve, res+ "b",++ total);
		}  
		return count;
	}

}
