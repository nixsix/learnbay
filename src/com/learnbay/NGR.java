package com.learnbay;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NGR {

	public static void main(String[] args) {
		int input []= {1,3,2,4}; 
		NGL(input);

	}

	private static void NGL(int[] a) {
		List<Integer> l = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		for(int i =a.length-1;i>=0;i--) {
			if(s.size() == 0) {
				l.add(-1);
			}else if(s.size() > 0 && s.firstElement() > a[i]) {
				l.add(s.firstElement());
			}else if(s.size()>0 && s.firstElement() <= a[i]) {
				while(s.size()> 0 && s.firstElement() <= a[i]) {
					s.pop();
				}
				if(s.size()==0) {
					l.add(-1);
				}else {
					l.add(s.firstElement());
				}
			}
			s.push(a[i]);
		}
		System.out.println(l);
	}

}
