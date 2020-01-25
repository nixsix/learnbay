package com.learnbay;

import java.util.Stack;

public class PostFixEvaluationStack {

	static public String operators = "+-*/";

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		String expression = "2 3 1 * + 9 -";
		System.out.println(evaluateExpression(expression));
	}

	private static int evaluateExpression(String expression) throws NumberFormatException{
		Stack<Integer> stack  = new Stack<>();
		String [] expressionArray =  expression.split("\\s+");
		for(String s : expressionArray) {
			if(Character.isDigit(s.charAt(0))) {
				stack.push(Integer.parseInt(s));
			}
			if(operators.contains(s)) {
				stack.push(evalOp(s, stack));
			}
		}
		return stack.pop();
	}

	private static int  evalOp(String s, Stack<Integer> stack) {
		int oprndB = stack.pop();
		int oprndA = stack.pop();
		int result = 0;
		switch(s) {
			case "+" : result =oprndA+oprndB;
			break;
			case "-" : 
				result =oprndA-oprndB;
			break;
			case "*" : result =oprndA*oprndB;
			break;
			case "/" : result =oprndA/oprndB;
			break;
		}
		return result;	
	}

}
