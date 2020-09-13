package com.learnbay.ds;

public class SegmentTree {
	private class Node{
		int data;
		int startInternval;
		int endInternval;
		Node left;
		Node right;
	}
	Node root;
	public SegmentTree(int arr[]) {
		this.root = constructTree(arr,0,arr.length-1);
	}
	private Node constructTree(int[] arr, int si , int ei) {
		if(si == ei) {
			Node leafNode = new Node();
			leafNode.data = arr[si];
			leafNode.startInternval = si;
			leafNode.endInternval = ei;
			return leafNode;
		}
		Node node = new Node();
		node.startInternval =si;
		node.endInternval =ei;
		
		int mid = (si+ei)/2;
		node.left = this.constructTree(arr, si, mid);
		node.right = this.constructTree(arr, mid+1, ei);
		
		node.data = node.left.data + node.right.data;
		
		return node;
	}
	
	public void display() {
		this.display(this.root);
	}
	private void display(Node node) {
		String str = "";
		if(node.left!= null) {
			str += "Interval=["+node.left.startInternval + "-" + node.left.endInternval+"] and Data= "+node.left.data;
		}else {
			str += "No left child =>";
		}
		str += "Interval=["+node.startInternval + "-" + node.endInternval+"] and Data= "+node.data;
		if(node.right!=null) {
			str += "<= data is ="+ node.right.data + "and Interval=[ "+node.right.startInternval + "-" + node.right.endInternval+"]";
		}else {
			str += "No right child =>";
		}
		System.out.println(str);
		if(node.left != null) {
			display(node.left);
		}
		if(node.right != null) {
			display(node.right);
		}
		
	}
	
	public int query(int qsi, int qei) {
		return this.query(this.root,qsi, qei);
	}
	
	private int query(Node node, int qsi, int qei) {
		//Node is completely inside
		if(node.startInternval>= qsi && node.endInternval <=qei) {
			return node.data;
		}else if(node.startInternval> qei || node.endInternval<qsi) {
			return 0;
		}else {
			int leftAns = query(node.left, qsi, qei);
			int rightAns = query(node.right, qsi, qei);
			return leftAns + rightAns;
		}
	}
	
	public void update(int index, int newValue) {
		this.root.data = update(this.root, index, newValue);
	}
	
	private int update(Node node, int index, int newValue) {

		if(index>=node.startInternval && index <=node.endInternval) {
			if(index==node.startInternval && index==node.endInternval) {
				node.data = newValue;
			}else {
				int leftValue = update(node.left,index, newValue);
				int rightValue = update(node.right,index, newValue);
				node.data = leftValue + rightValue;
			}
		}
		return node.data ;
	}
	public static void main(String... args) {
		int[] arr ={3,8,7,6,-2,-8,4,9};
		SegmentTree sg = new SegmentTree(arr);
		//sg.display();
		
		System.out.println("Sum is " +sg.query(2, 6));
		System.out.println("Sum is " +sg.query(1, 5));
		sg.update(3, 14);
		System.out.println("Sum is " +sg.query(2, 6));
		
	}
}

