package com.learnbay;

import java.util.LinkedList;

public class Solution {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length;
        long[] sums = new long[N+1];
        for (int i = 0; i < N; ++i)
            sums[i+1] = sums[i] + (long) A[i];
        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N+1; // N+1 is impossible
        LinkedList<Integer> list = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < sums.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!list.isEmpty() && sums[y] <= sums[list.getLast()])
                list.removeLast();
            while (!list.isEmpty() && sums[y] >= sums[list.getFirst()] + K)
                ans = Math.min(ans, y - list.removeFirst());

            list.addLast(y);
        }

        return ans < N+1 ? ans : -1;
    }
    
    public static void main(String... args) {
    	int [] A = {17,85,93,-45,-21};
		int K=150;
    	Solution s = new Solution();
    	int result = s.shortestSubarray(A, K);
    	System.out.println(result);
    }
}