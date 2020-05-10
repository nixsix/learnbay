package com.recursion;

import java.util.ArrayList;

public class RecursionGet {

	public static void main(String[] args) {
	//	System.out.println(getPermutations("abcd"));
	//	System.out.println(getPermutations("abcd").size());
		printPermutations("abcd","");
	}

	public static ArrayList<String> getPermutations(String str){

		if(str.length()==0) {
			ArrayList<String> br  = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);		

		ArrayList<String> recursionList = getPermutations(ros);
		ArrayList<String> stackList = new ArrayList<>(); 
		for(String rrs : recursionList) {
			for(int i = 0, k=rrs.length() ; i<=k ; i++) {
				String permutedResult = rrs.substring(0,i)+ ch + rrs.substring(i);
				stackList.add(permutedResult) ;
			}
		}

		return stackList;
	}
	
	public static void printPermutations(String ques, String answer) {
		//base case
		
		if(ques.length()==0) {
			System.out.println(answer);
			return;
		}
		
		for(int i = 0, k=ques.length() ; i<k ; i++) {
			char cc = ques.charAt(i);
			String ros = ques.substring(0,i)+ques.substring(i+1);
			printPermutations(	ros, answer+cc  );
		}
	}
}
