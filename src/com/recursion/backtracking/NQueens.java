package com.recursion.backtracking;

public class NQueens {



	public static void main(String... args) {
		int qCounter = 0;
		int row = 0;int col= 0;
		int totalQueens = 3;
		boolean [][] box= new boolean[4][4];
		String ans = "";
		//nQueens2(box, row,   qCounter, totalQueens, ans);
		kQueens(box, row,   qCounter, totalQueens, ans);
	}

	private static void nQueens2(boolean[] [] box, int row,   int qCounter, int totalQueens, String ans) { 
		//BC
		if(totalQueens == qCounter) {
			System.out.println(ans); 
			return;
		}
		
		if(row == box.length) {
			return;
		}
		
		//Every col
		for(int col=0;col<box[0].length;col++) {
			if (isItSafeToPlaceQueen(box, row, col)) {
				box[row][col] = true;
				nQueens2(box, row + 1, qCounter + 1, totalQueens, ans + "{" + row + ", " + col + "}");
				box[row][col] = false;
			}
		}
	}
	
	private static void kQueens(boolean[] [] box, int row,   int qCounter, int totalQueens, String ans) { 
		//BC
		if(totalQueens == qCounter) {
			System.out.println(ans); 
			return;
		}
		
		if(row == box.length) {
			return;
		}
		
		//Every col
		for(int col=0;col<box[0].length;col++) {
			if (isItSafeToPlaceQueen(box, row, col)) {
				box[row][col] = true;
				kQueens(box, row + 1, qCounter + 1, totalQueens, ans + "{" + row + ", " + col + "}");
				box[row][col] = false;
			}
		}
		//Not placed
		kQueens(box, row + 1, qCounter, totalQueens, ans);
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
