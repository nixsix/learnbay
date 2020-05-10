package com.learnbay;

public class MinStackProblem {

	public static void main(String[] args) throws Exception {
		int insertSequence []  = {5,4,9,7,3,6,1,8};
		MinStack minStack = new MinStack(insertSequence.length);
		for(int i=0;i<insertSequence.length;i++) {
			minStack.push(insertSequence[i]);
		}
		
		for(int i=0;i<insertSequence.length;i++) {
			System.out.println(minStack.pop());
		}
	}
}

class MinStack{
	Integer OLDMIN = Integer.MIN_VALUE+1;
	Integer NEWMIN = Integer.MIN_VALUE;
	
	int top = -1; 
	int size = 16;
	int []stackElements ;
	
	MinStack(int size){
		this.size = size;
		this.stackElements = new int[size];
	}
	 public void  push(int element) throws Exception{
		 if(top==size-1) {
			 throw new Exception();
		 }
		 if(element >= NEWMIN) {
			 stackElements[++top]=element;
		 }else {
			 OLDMIN = NEWMIN;
			 NEWMIN = element;
			 stackElements[++top]= NEWMIN-OLDMIN;
		 }
	 }
	 
	public  boolean isFull() {
		return top==size-1;
	}
	 
	public int pop() throws Exception {
		if(top == -1) {
			throw new Exception();
		}
		if(peek()> NEWMIN) {
			return stackElements[top--];
		}else {
			OLDMIN = NEWMIN;
			int valToReturn = NEWMIN;
			NEWMIN =  stackElements[top] + OLDMIN;
			return valToReturn;
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

	public int getMin() {
		return NEWMIN;
	}
}
