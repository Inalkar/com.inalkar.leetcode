package com.inalkar.leetcode.easy;

import java.util.HashSet;

/**
 * 217. Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/description/
 * 
 * @author Svyatoslav Voloshin
 */
public class ContainsDuplicate {
    
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
    
}
