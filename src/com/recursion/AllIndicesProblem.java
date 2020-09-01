package com.recursion;

import java.util.Scanner;

public class AllIndicesProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int  arrLen = sc.nextInt();
		int input [] = new int[arrLen];
		int index =0;
		while(arrLen!=0) {
			input[index++]= sc.nextInt();
			arrLen--;
		}
		int  numberToLook = sc.nextInt();
		index = 0;
		String result ="";
		result = checkAllIndex(input, index, result, numberToLook); 
		System.out.println(result);
	}

	private static String checkAllIndex(int[] input, int index, String result, int numberToLook) {
		if(index == input.length) {
			return result;
		}
		
		if(input[index]==numberToLook) {
			if(result.equals("")) {
				result = result + index;
			}else {
				result = result + " " + index;
			}
		}
		result = checkAllIndex(input, index+1, result, numberToLook);
		return result;
	}

}
