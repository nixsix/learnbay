package com.recursion;

public class EqualSumPartition {
	
	public static void main(String... args) {
			int input [] = {1,5,1,11};
			canPartition(input);
	}
	
	 public static boolean canPartition(int[] nums) {
	        int sum = 0;
	        for(int i=0;i<nums.length;i++){
	            sum += nums[i];
	        }
	        if(sum%2==1){
	            return false;
	        }
	        sum = sum/2;
	        
	       return subsetsum(nums, sum);
	    }
	    
	   public static boolean subsetsum(int[] nums, int sum){
	       boolean t[][] = new boolean[nums.length+1][sum+1];
	        for(int i=0;i< nums.length+1; i++){
	            for(int j=0;j<sum+1; j++){
	                if(i==0){t[i][j]=false;}
	                if(j==0){t[i][j]=true;}
	            }
	        }
	        for(int i=1;i< nums.length+1; i++){
	            for(int j=1;j<sum+1; j++){
	                if(nums[i-1]<=j){
	                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
	                } 
	                else {
	                    t[i][j] = t[i-1][j];
	                }    
	            }
	        }
	        return t[nums.length][sum];
	    }
	
}
