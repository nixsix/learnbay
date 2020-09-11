package com.recursion.backtracking;

public class CoinChangeCoinRespect {

	public static void main(String[] args) {
		int[] coins = {2,3,5,6};
		int total = 10;
		String ans = "";
		int coinIndex = 0;
		int changeCounter = total;
		coinChangeCoinRespect(coins,coinIndex, changeCounter,ans);
	}

	private static void coinChangeCoinRespect(int[] coins, int coinIndex,  int changeCounter,   String ans) {
		
		if(changeCounter == 0) {
			System.out.println(ans);
			return;
		}
		
		if(changeCounter < 0 || coinIndex == coins.length ) {
			return;
		}
		coinChangeCoinRespect(coins, coinIndex, changeCounter-coins[coinIndex],  ans+coins[coinIndex]);
		coinChangeCoinRespect(coins, coinIndex+1, changeCounter,  ans);
	}
}
