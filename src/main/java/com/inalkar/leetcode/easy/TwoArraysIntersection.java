package com.inalkar.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 
 * @author Svyatoslav Voloshin
 */
public class TwoArraysIntersection {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];

        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                set.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                index1++;
            }
        }
        
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer value : set) {
            result[index] = value;
            index++;
        }
        return result;
    }
    
}
