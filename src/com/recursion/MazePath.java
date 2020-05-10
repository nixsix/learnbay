package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePath {

	public static void main(String[] args) {
		//List<String> mazeResult = getMazePath(0,0,2,2);
		//System.out.println(mazeResult);
		printMazePath(0,0,5,5,"");
	}

	private static List<String> getMazePath(int cr, int cc, int er, int ec) {
		List<String> mr = new ArrayList<>();
		
		if(cr ==er && cc==ec) {
			mr.add(""); return mr;
		}
		if(cr >er || cc>ec) {
			return mr;
		}
		
		List<String> rrh = getMazePath(cr,cc+1,er,ec);
		List<String> rrv = getMazePath(cr+1,cc,er,ec);
		
		for(String rr:rrh) {
			mr.add("H"+rr);
		}
		for(String rr:rrv) {
			mr.add("V"+rr);
		}		
		return mr;
	}
	
	private static void printMazePath(int i, int j, int k, int l, String ans) {
		if(i==k && j ==l) {
			System.out.println(ans);
			return;
		}
		if(i >  k) {
			return;
		}
		if(j >  l) {
			return;
		}
		printMazePath(i,j+1,k,l, ans + "H");
		printMazePath(i+1,j,k,l, ans + "V");
	}

}
