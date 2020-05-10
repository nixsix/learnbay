package com.recursion.backtracking;

public class QueenBoxesPermutationCombination {
	static int qpsf = 0;
	static int tq =2;
	static String ans = "";
	static int count = 0;
	static boolean []  boxesStatus = new boolean[4];
	public static void main(String[] args) {

		queenCombinationCall(boxesStatus, qpsf, tq, ans, -1);
		System.out.println("\n\n");
		queenPermutationCall(boxesStatus, qpsf, tq, ans);
	}

	private static void queenPermutationCall(boolean[] boxesStatus, int queenPointer, int totalQueens, String ans) {
		if(queenPointer == totalQueens) {
			count++;
			System.out.println(ans);
			return;
		}

		for(int i =0,k=boxesStatus.length;i<k;i++) {
			if(boxesStatus[i]==false) {
				boxesStatus[i] = true;
				queenPermutationCall(boxesStatus, queenPointer+1, totalQueens,ans + "q"+queenPointer+ "b" + i + " ");
				boxesStatus[i] = false;
			}
		}
	}
	private static void queenCombinationCall(boolean[] boxesStatus, int queenPointer, int totalQueens, String ans, int lastBoxUsed) {
		if(queenPointer == totalQueens) {
			count++;
			System.out.println(ans);
			return;
		}

		for(int i=lastBoxUsed +1, k=boxesStatus.length; i<k; i++) {
				boxesStatus[i] = true;
				queenCombinationCall(boxesStatus, queenPointer+1, totalQueens,ans + "q" + queenPointer+ "b" + i + " ",i);
				boxesStatus[i] = false;
		}
	}


}