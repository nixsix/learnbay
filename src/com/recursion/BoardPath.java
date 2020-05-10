package com.recursion;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BoardPath {

	private static Map<Integer, Character> hm = new LinkedHashMap<>();
	
	public static void main(String[] args) {
		fillHM();
		//List<String> al = getBoardPath(0,10);
		//System.out.println(al);
//		printPath(0,"");
		decodeMessage("1411", 0, "");
		
	}

	private static void fillHM( ) {
		hm.put(1, 'a');hm.put(2, 'b');hm.put(3, 'c');hm.put(4, 'd');hm.put(5, 'e');hm.put(6, 'f');
		hm.put(7, 'g');hm.put(8, 'h');hm.put(9, 'i');hm.put(10, 'j');hm.put(11, 'k');hm.put(12, 'l');
		hm.put(13, 'm');hm.put(14, 'n');hm.put(15, 'o');hm.put(16, 'p');hm.put(17, 'q');hm.put(18, 'r');
		hm.put(19, 's');hm.put(20, 't');hm.put(21, 'u');hm.put(22, 'v');hm.put(23, 'w');hm.put(24, 'x');
		hm.put(25, 'y');hm.put(26, 'z');		
	}

	public static List<String> getBoardPath(int curr, int end) {
		List<String> myResult = new ArrayList<>();
		
		if(curr == end) {
			myResult.add("");
			return myResult;
		}
		
		if(curr> end) {
			return myResult;
		}
		
		for(int dice =1; dice <=6; dice++) {
			List<String> rr = getBoardPath(curr+dice,end);
			for(String rrs: rr) {
				myResult.add(dice + rrs);
			}
		}
		return myResult;
	}

	public static void printPath(int curr, String res) {
		if(curr == 10) {
			out.println(res);
			return;
		}
		if(curr > 10) {
			return;
		}
		for(int dice =1; dice <=6; dice++) {
			printPath(curr+dice, dice +res);
		}
	}
	
	public static void decodeMessage(String x, int curr, String res) {
		if(curr == x.length()) {
			out.println(res);
			return ;
		}
		
		if(curr>x.length()) { 
			return; 
		}
		
		for(int move =1; move<=2; move++) {
				if(curr+move > x.length() ) {
					return ;
				}
				Character character = hm.get(Integer.parseInt(x.substring(curr,curr+move)));
				if(character != null) {
					decodeMessage(x, curr+move, res+character);
				}
		}
	}
}
