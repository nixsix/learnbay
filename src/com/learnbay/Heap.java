package com.learnbay;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	List<Integer> data = new ArrayList<>();
	
	public void add(Integer item) {
		data.add(item);
		upHeapify(data.size()-1);
	}

	private void upHeapify(int ci) {
		//BaseCase actually not required as we use < comparison and not <=
		if(ci==0) {
			return;
		}
		int pi = (ci -1)/2;
		if(data.get(ci) < data.get(pi)) {
			swap(ci,pi);
			upHeapify(pi);
		}
	}
	
	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j); 
		data.set(i, jth);data.set(j, ith);
	}
	
	public int remove() {
		int rv= data.get(0);
		swap(0,this.data.size()-1);
		data.remove(data.size()-1);
		downHeapify(0);
		return rv;
	}
	
	private void downHeapify(int pi) {
		
		int ci1 =pi*2+1;
		int ci2 =pi*2+2;
		int mini = pi;
		//check minimum of among the child
		mini = checkIndexAndFindMinimum(ci1, ci2, mini);
		
		if(mini != pi) {
			swap(mini,pi);
			downHeapify(mini);
		}
	}

	private int checkIndexAndFindMinimum(int ci1, int ci2, int mini) {
		if(ci1< data.size() && data.get(ci1)<data.get(mini)) {
			mini = ci1;
		}
		if(ci2 < data.size() && data.get(ci2)<data.get(mini)) {
			mini = ci2;
		}
		return mini;
	}

	public void display() {System.out.println(data);}
	public int size() {	return data.size();}
	public boolean isEmpty() {	return data.size()<1;}
}
