package com.learnbay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class NGR {

	public static void main(String[] args) {
		int input []= {1,3,2,4}; 
		NGL(input);

	}

	private static void NGL(int[] a) {
		List<Integer> vector = new Vector<>();
		Stack<Integer> s = new Stack<>();
		for(int i =a.length-1;i>=0;i--) {
			if(s.isEmpty() ) {
				vector.add(-1);
			}else if(isNotEmpty(s) && s.lastElement() > a[i]) {
				vector.add(s.lastElement());
			}else if(isNotEmpty(s) && s.lastElement() <= a[i]) {
				while(isNotEmpty(s) && s.lastElement() <= a[i]) {
					s.pop();
				}
				if(s.size()==0) {
					vector.add(-1);
				}else {
					vector.add(s.lastElement());
				}
			}
			s.push(a[i]);
		}
		Collections.reverse(vector);
		System.out.println(vector);
	}

	private static boolean isNotEmpty(Stack<Integer> s) {
		return s.size() > 0;
	}

}
