package com.recursion;

import java.util.Scanner;

public class StringToInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String  input = sc.next();
		System.out.println(convertString(input,input.length()-1,0));
	}

	public static int 	convertString(String str, int charIndex, int power){
		if(charIndex == -1){
			return 0;
		}
		int sum = 0;
		sum = Integer.parseInt(str.charAt(charIndex)+"") * new Double(Math.pow(10.0d, new Double (power))).intValue();
		sum = sum + convertString(str, charIndex -1, power+1 );
		return sum;
	}

	
}
