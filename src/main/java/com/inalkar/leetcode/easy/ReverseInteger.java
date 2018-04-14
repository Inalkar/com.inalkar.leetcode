package com.inalkar.leetcode.easy;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/description/
 * 
 * @author Svyatoslav Voloshin
 */
public class ReverseInteger {

    public static int reverse(int x) {
        int reverse = 0;
        boolean isNegative;
        if (isNegative = x < 0) x = Math.abs(x);
        while(x != 0) {
            if(reverse > (Integer.MAX_VALUE - (x % 10)) / 10) return 0;

            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return isNegative ? -reverse : reverse;
    }

}
