package com.recursion.backtracking;

public class QueenCombinationBoxRespect2D {


	public static void main(String... args) {
		int qCounter = 0;
		int row = 0;int col= 0;
		int totalQueens = 3;
		boolean [][] box= new boolean[3][4];
		String ans = "";
		queenCombinationBoxRespect2D(box, row, col, qCounter, totalQueens, ans);
	}

	private static void queenCombinationBoxRespect2D(boolean[] [] box, int row, int col, int qCounter, int totalQueens,String ans) {
		//BC
		
		if(qCounter==totalQueens) {
			System.out.println(ans);
			return;
		}
		
		if(col == box[0].length) {
			row++;
			col=0;
		}
		
		if(row ==box.length) {
			return;
		}
		
		box[row][col]= true;
		queenCombinationBoxRespect2D(box, row, col+1, qCounter+1, totalQueens, ans + "{" + row + ", " + col + "}");
		box[row][col] = false;
		queenCombinationBoxRespect2D(box, row, col+1, qCounter, totalQueens, ans );
	}
	


}
