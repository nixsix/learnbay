package com.recursion.backtracking;

import static java.lang.System.out;

public class CoinChange {

	static int[] coins = {2,3,5,6};
	static int total = 10;
	public static void main(String[] args) {
		coinChangeCombination( 10,"",0);
		out.println("	Combination then Permutation	");
		coinChangePermutation( 10,"");
	}

	private static void coinChangePermutation(int currentTotal, String currentPattern) {

		if( currentTotal<0) {
			return;
		}
		if(currentTotal==0) {
			out.println(currentPattern);
			return;
		}
		for(int i =0; i< coins.length;i++) {
			coinChangePermutation(currentTotal-coins[i], currentPattern+coins[i]);
		}
			
	}

	private static void coinChangeCombination( int currentTotal, String currentPattern, int lastUsed) {
		if( currentTotal<0) {
			return;
		}
		if(currentTotal==0) {
			out.println(currentPattern);
			return;
		}
		for(int i =lastUsed; i< coins.length;i++) {
			coinChangeCombination(currentTotal-coins[i], currentPattern+coins[i], i);
		}
	}

}
