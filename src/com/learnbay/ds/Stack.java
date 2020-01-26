package com.learnbay.ds;

public class Stack {
	
	int top = -1; 
	int size = 16;
	int []stackElements ;
	
	public Stack(int size){
		this.size = size;
		this.stackElements = new int[size];
	}
	 public void  push(int element) throws Exception{
		 if(isFull()) {
			 throw new Exception("Stack Full");
		 }else {
			 stackElements[++top]=element;
		 }
	 }
	 
	public  boolean isFull() {
		return top==size-1;
	}
	 
	public int pop() throws Exception {
		 if(isEmpty()) {
			 throw new  Exception("Nothing can be returned from empty stack");
		 }else {
			 int elementToReturn = stackElements[top];
			 stackElements[top--] = 0;
			 return elementToReturn;
		 }
	 }
	public boolean isEmpty() {
		return top==-1;
	}
	
	public boolean hasStackJustOneElement() {
		return top==0;
	}
	 
	public int peek() {
		 if(isEmpty()) {
			 return 0;
		 }else {
			 return stackElements[top];
		 }
	 }
	
	public int currentSize() {
		return top + 1;
	}

}
