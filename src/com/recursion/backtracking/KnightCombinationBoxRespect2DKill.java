package com.recursion.backtracking;

public class KnightCombinationBoxRespect2DKill {



	public static void main(String... args) {
		int qCounter = 0;
		int row = 0;int col= 0;
		int totalknights = 3;
		boolean [][] box= new boolean[3][3];
		String ans = "";
		knightCombinationBoxRespect2DKill(box, row, col, qCounter, totalknights, ans);
	}

	private static void knightCombinationBoxRespect2DKill(boolean[] [] box, int row, int col, int qCounter, int totalknights,String ans) {
		//BC

		if(qCounter==totalknights) {
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
		if(isItSafeToPlaceknight(box,row,col)) {
			box[row][col]= true;
			knightCombinationBoxRespect2DKill(box, row, col+1, qCounter+1, totalknights, ans + "{" + row + ", " + col + "}");
			box[row][col] = false;
		}
		knightCombinationBoxRespect2DKill(box, row, col+1, qCounter, totalknights, ans );
	}

	private static boolean isItSafeToPlaceknight(boolean[][] box, int row, int col) {
		int rowArr[] = {-1,-2,-2,-1};
		int colArr[] = {2,1,-1,-2};
		for(int i=0;i<4;i++) {
			int r = row + rowArr[i];
			int c = col  + colArr[i];
			
			if(r >=0 && r< box.length && c>=0 && c< box[0].length) {
				if(box[r][c]) {
					return false;
				}
			}
		}
		return true;
	}




}
