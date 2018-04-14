package com.inalkar.leetcode.learn.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    
    public boolean isHappy(int n) {
        if (n == 1) return true;
        
        Set<Integer> set = new HashSet<>();
        
        return isHappy(n, set);
    }
    
    private boolean isHappy(int n, Set<Integer> set) {
        if (set.contains(n)) return false;
        set.add(n);
        
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        if (sum == 1) return true;
        
        return isHappy(sum, set);
    }
    
}
