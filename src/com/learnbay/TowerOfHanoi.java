package com.learnbay;

import com.learnbay.ds.Stack;

public class TowerOfHanoi {

	public static void main(String[] args)throws Exception {
		Stack originalStack = new Stack(4);
		originalStack.push(4);originalStack.push(7);originalStack.push(9);originalStack.push(12);
		
		Stack intermediateStack = new Stack(4);
		Stack finalStack = new Stack(4);
		
		towerOfHanoi(originalStack, intermediateStack, finalStack);
		addAllElementsToFinalStack(intermediateStack,finalStack);
		
		while(finalStack.currentSize()!=0){
			System.out.println(finalStack.pop());
		}
	}

	private static void towerOfHanoi(Stack originalStack, Stack intermediateStack, Stack finalStack) throws Exception {
		if(originalStack.hasStackJustOneElement()) {
			int num = originalStack.pop();
			finalStack.push(num);
			return;
		}
		int element = originalStack.pop();
		towerOfHanoi(originalStack, intermediateStack, finalStack);
		intermediateStack.push(element);
	}
	
	private static void addAllElementsToFinalStack(Stack intermediateStack, Stack finalStack) throws Exception {
		if(intermediateStack.isEmpty()) {
			return;
		}
		int num = intermediateStack.pop();
		addAllElementsToFinalStack(intermediateStack, finalStack);
		finalStack.push(num);
	}

}
