package com.inalkar.leetcode.easy;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return null;

        HashMap<Integer, Integer> numbersToFind = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (numbersToFind.containsKey(value)) {
                int[] result = new int[2];
                result[1] = i;
                result[0] = numbersToFind.get(value);
                return result;
            } else {
                numbersToFind.put(nums[i], i);
            }
        }
        return null;
    }

}
