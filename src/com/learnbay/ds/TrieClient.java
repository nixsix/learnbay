package com.learnbay.ds;

public class TrieClient {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.addWord("art");
		trie.addWord("arts");
		trie.addWord("bug");
		trie.addWord("boy");
		trie.addWord("sea");
		trie.addWord("see");
		trie.addWord("seen");
		trie.addWord("nikhil");
		trie.display();
		System.out.println(trie.search("seem"));
	}

}
