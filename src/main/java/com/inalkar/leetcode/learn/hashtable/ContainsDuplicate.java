package com.inalkar.leetcode.learn.hashtable;

import java.util.HashSet;

/**
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
