package com.learnbay.ds;

public class Queue  {

	public static void main(String[] args) {
	}
	int q [] = null;

	public Queue(int size){
		q = new int[size];
	}

	public void enqueue(int value) throws Exception {
		if(size==q.length) {
			throw new Exception("Queue is full");
		}
		rearIndex = (rearIndex + 1 )%q.length;
		q[rearIndex] = value;
		size++;
		if(frontIndex==-1) {
			frontIndex++;
		}
	}
	
	public int dequeue() throws Exception {
		if(size==0) {
			throw new Exception("Queue is full");
		}
		int elementToReturn = q[frontIndex];
		size--;
		frontIndex = (frontIndex+ 1)%q.length;
		return elementToReturn;
	}

	public int getFrontIndex() {
		return frontIndex;
	}

	public void setFrontIndex(int frontIndex) {
		this.frontIndex = frontIndex;
	}

	public int getRearIndex() {
		return rearIndex;
	}

	public void setRearIndex(int rearIndex) {
		this.rearIndex = rearIndex;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	int frontIndex = -1;
	int rearIndex = -1;
	int size = 0;
}
