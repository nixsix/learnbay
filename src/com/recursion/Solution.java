package com.recursion;

class Solution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        
        if((pushed == null || popped == null)|| (pushed.length != popped.length)){
            return false;
        }
        
        boolean evenElements = pushed.length%2==0;
        for(int i =0,k=pushed.length-1;i<k;i++){
            if(!(pushed[i] == popped[k-i])){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String []  args) {
    	int [] pushed = {1,2,3,4,5};
    	int [] popped = {4,5,3,2,1};
    	validateStackSequences(pushed, popped);
    }
}
