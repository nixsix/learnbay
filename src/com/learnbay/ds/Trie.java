package com.learnbay.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
	private class Node {

		char data;
		HashMap<Character,Node> children ;
		boolean isTerminal;
		
		Node(char data, boolean isTerminal){
			this.data=data;
			this.children = new HashMap<>();
			this.isTerminal =isTerminal;
		}
	}
	
	private int numWords;
	private Node root;
	
	public Trie() {
		this.root= new Node('\0', false);
		this.numWords = 0;
	}
	
	public int numWords() {
		return this.numWords;
	}
	
	public void addWord(String word) {
		this.addWord(this.root, word);
	}
	
	public void addWord(Node parent, String word) {
		if(word.length()==0) {
			if(parent.isTerminal) {
				// Word already exists
			} else {
				parent.isTerminal = true;
				this.numWords++;
			}
			return;
		}
		char cc = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(cc);
		if(child==null) {
			child = new Node(cc, false);
			parent.children.put(cc, child);
		}
		this.addWord(child, ros);
	}
	
	public void display() {
		this.display(this.root,"");
	}
	
	private void display(Node node, String osf) {
		if(node.isTerminal) {
				String toDisplay = osf.substring(1)+node.data;
				System.out.println(toDisplay);
				
		}
		Set<Map.Entry<Character, Node>> entries = node.children.entrySet();
		for(Map.Entry<Character, Node> entry :entries) {
			this.display(entry.getValue(), osf + node.data);
		}
	}
}
