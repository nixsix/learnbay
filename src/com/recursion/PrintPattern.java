package com.recursion;

public class PrintPattern {

	public static void main(String[] args) {
		pattern(5,1,1);
		System.out.println("\n");
		patternReverse(5,1,1);
	}

	private static void patternReverse(int n, int row, int col) {
		if(n == 0) {
			return;
		}
		if(col>n) {
			System.out.println();
			patternReverse(n-1,row+1,1);
			return;
		}
		System.out.print("*\t");
		patternReverse(n,row,col+1);
	}

	public static void pattern(int n, int row, int col) {
		if(row>n) {
			return;
		}
		if(col>row) {
			System.out.println();
			pattern(n,row+1,1);
			return;
		}
		System.out.print("*\t");
		if(col>=n) {
			return;
		}
		pattern(n,row,col+1);
	}
}
