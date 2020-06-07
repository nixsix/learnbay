package com.recursion;

import java.util.Scanner;

public class CharacterRepeatIndicator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String  input = sc.next();
		System.out.println(duplicateFinder(input,""));
	}

	public static String duplicateFinder(String x, String res){
		if(x.length()==0){
			return res;
		}

		char cc = x.charAt(x.length()-1);
		String passedOn = x.substring(0, x.length()-1);
		if(res.length()>0&& cc == res.charAt(0)){
			res = cc + "*" +res;
		}else {
			res = cc + res;
		}
		return duplicateFinder(passedOn, res);
	}
}
