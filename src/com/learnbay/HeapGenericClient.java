package com.learnbay;

public class HeapGenericClient {

	public static void main(String[] args) {
		HeapGeneric<Integer> h = new HeapGeneric<>();
		h.add(10);
		h.add(20);
		h.add(30);
		
		System.out.println(h.remove());
		System.out.println(h.remove());
		System.out.println(h.remove());
	}

}
