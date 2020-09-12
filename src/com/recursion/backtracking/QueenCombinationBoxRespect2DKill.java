package com.recursion.backtracking;

public class QueenCombinationBoxRespect2DKill {


	public static void main(String... args) {
		int qCounter = 0;
		int row = 0;int col= 0;
		int totalQueens = 4;
		boolean [][] box= new boolean[5][5];
		String ans = "";
		queenCombinationBoxRespect2DKill(box, row, col, qCounter, totalQueens, ans);
	}

	private static void queenCombinationBoxRespect2DKill(boolean[] [] box, int row, int col, int qCounter, int totalQueens,String ans) {
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
		//place only if safe
		if(isItSafeToPlaceQueen(box,row,col)) {
			box[row][col]= true;
			queenCombinationBoxRespect2DKill(box, row+1, 0, qCounter+1, totalQueens, ans + "{" + row + ", " + col + "}");
			box[row][col] = false;
		}
		queenCombinationBoxRespect2DKill(box, row, col+1, qCounter, totalQueens, ans );
	}

	private static boolean isItSafeToPlaceQueen(boolean[][] box, int row, int col) {

		//vertically upward
		int r = row-1; int c = col;
		while(r>=0) {
			if(box[r][c]) {
				return false;
			}
			r--;
		}

		//horizonatlly left
		r = row; c = col-1;
		while(c>=0) {
			if(box[r][c]) {
				return false;
			}
			c--;
		}

		//diagonally left
		r = row-1;
		c = col-1;

		while(r >=0 && c >=0) {
			if(box[r][c]) {
				return false;
			}
			r--;c--;
		}


		//diagonally right
		r = row-1;
		c = col+1;

		while(r >=0 && c < box[0].length) {
			if(box[r][c]) {
				return false;
			}
			r--;
			c++;
		}

		return true;
	}



}
