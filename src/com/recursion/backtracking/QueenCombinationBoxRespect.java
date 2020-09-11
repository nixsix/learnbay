package com.recursion.backtracking;

public class QueenCombinationBoxRespect {

	public static void main(String... args) {
		int qCounter = 0;
		int bCounter = 0;
		int totalQueens = 2;
		boolean [] box= {false,false,false,false};
		String ans = "";
		queenCombinationBoxRespect(box, bCounter,  qCounter, totalQueens, ans);
	}

	private static void queenCombinationBoxRespect(boolean[] box, int bCounter, int qCounter, int totalQueens,String ans) {
		//BC
		
		if(qCounter==totalQueens) {
			System.out.println(ans);
			return;
		}
		
		if(bCounter ==box.length) {
			return;
		}
		
		box[bCounter] = true;
		queenCombinationBoxRespect(box, bCounter+1, qCounter+1, totalQueens, ans + "b" + bCounter);
		box[bCounter] = false;
		queenCombinationBoxRespect(box, bCounter+1, qCounter, totalQueens, ans );
	}
	
}
