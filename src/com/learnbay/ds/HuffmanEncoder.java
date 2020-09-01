package com.learnbay.ds;

import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
	
	Map<Character, String> encoder ;
	Map<String, Character> decoder ;
	public static void main(String[] args) {

	}

	public HuffmanEncoder(String feeder) {
		//Create a freq map of this feeders string
		Map<Character, Integer> freqMap = new HashMap<>();
		for(int i=0, k= feeder.length();i<k;i++) {
			Character cc = feeder.charAt(i);
			if(freqMap.containsKey(cc)) {
				freqMap.put(cc, freqMap.get(cc)+1);
			}else {
				freqMap.put(cc, 1);
			}
		}
		
		//Create a min heap of trees
		//Heap<Node> minHeap = new Heap<>(true);
	}
	
	
	private class Node implements Comparable<Node>{
		Character data;
		int cost;
		Node left;
		Node right;
		
		Node(Character data, int cost){
			this.data = data;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost ;
		}
	}
}
