package com.learnbay;

public class CountSetBits {

	public static void main(String[] args) {
		System.out.println(countSetBitsByRightShift(33));
	}

	@SuppressWarnings("unused")
	private static int countSetBits(int n) {
		int count = 0;
		while(n>0) {
			n = n&(n-1);
			System.out.println(n + "  ");
			count++;
		}
		return count;
	}
	
	static int countSetBitsByRightShift(int n) 
    { 
        int count = 0; 
        while (n > 0) { 
            count = count + n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
}
