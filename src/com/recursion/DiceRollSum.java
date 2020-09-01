package com.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiceRollSum {

	static HashMap<Integer,Integer> sumComboCount = new HashMap<>();
	static int [] diceRoll = {1,2,3,4,5,6};

	static int n=10;
	static int [] x = new int[n];
	

	
	public static void main(String[] args) {
		Arrays.fill(x, 1);
		calculateDiceSum(1,1,1); 
		System.out.println(sumComboCount);
	}

	private static void calculateDiceSum(int i, int j, int k) {
		if(k>6) {
			calculateDiceSum(i,j+1,1);
			return;
		}
		if(j>6) {
			calculateDiceSum(i+1,1,1);
			return;
		}
		if(i>6) {
			return;
		}
		pushMap(i+j+k);
		calculateDiceSum(i,j,k+1);

	}

	private static void pushMap(int sum) {
		sumComboCount.computeIfPresent(sum, (key,val) -> val+1);
		sumComboCount.computeIfAbsent(sum, val -> 1);
	}
}
