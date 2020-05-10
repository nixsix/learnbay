package com.recursion;

import java.util.ArrayList;

public class SubsequenceOfString {

	static final ArrayList<String>  result = new ArrayList<>();	
	public static void main(String... args) {
		String input= "abcdef";
		//getSS2(input, input.length()-1);
		//System.out.println(getSS(input));
		printSS("abc","");
	}

	public static ArrayList<String> getSS2(String seq, int pointer){
		if(pointer>=0) {
			addToResult(result, 0, ""+seq.charAt(pointer), result.size());
			getSS2(seq, pointer-1);
			return result;
		}
		return result;
	}
	
	private static ArrayList<String> addToResult(ArrayList<String> result, int index, String character, int initialResultSize){
		if(result !=null && result.isEmpty()) {
			result.add("");
		} 
		if(index==initialResultSize) {
			return result;
		}
		result.add(character + result.get(index));
		addToResult(result, index +1, character,initialResultSize);
		return result;
	}
	
	private static ArrayList<String> getSS(String seq){
		ArrayList<String> currentStackResult = new ArrayList<>();
		if(seq.length()==0) {
			currentStackResult.add("");
			return currentStackResult;
		}
		char c = seq.charAt(0);
		String subseq = seq.substring(1);
		ArrayList<String> recursiveStackResult =  getSS(subseq);
		currentStackResult.addAll(recursiveStackResult);
		for(int i=0,k=recursiveStackResult.size();i<k;i++) {
			currentStackResult.add(c+recursiveStackResult.get(i));
		}
		return currentStackResult;
	}
	
	private static void printSS(String seq, String res) {
		if(seq.length()==0) {
			System.out.println(res);
			return;
		}
		char cc = seq.charAt(0);
		seq  = seq.substring(1);
		printSS(seq, res);
		printSS(seq, res +cc);
	}
}
