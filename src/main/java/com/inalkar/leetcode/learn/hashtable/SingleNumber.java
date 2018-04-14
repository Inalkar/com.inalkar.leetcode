package com.inalkar.leetcode.learn.hashtable;

public class SingleNumber {
    
    public int singleNumber(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
    
}
