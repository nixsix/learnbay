package com.recursion;

import java.util.*;
public class Main {
    public static void main(String args[]) {
    	int [] input = {1,2,3,4,5};
    	System.out.println(recursiveSortCheck(5, input));
    }

		public static boolean recursiveSortCheck(int size, int []array){
			if(size-2==0){
				return true;
			}
			if(array[size-1]< array[size-2]){
				return false;
			}
			
			return recursiveSortCheck(size-1, array);
			
		}
	
}
