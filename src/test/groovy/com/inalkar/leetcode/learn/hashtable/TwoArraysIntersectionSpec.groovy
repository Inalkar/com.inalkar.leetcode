package com.inalkar.leetcode.learn.hashtable

import spock.lang.Specification

class TwoArraysIntersectionSpec extends Specification {
    
    def "intersection"() {
        setup:
        def util = new TwoArraysIntersection()
        
        when:
        def result = util.intersection(nums1, nums2)
        
        then:
        assert Arrays.equals(result, expected)
        
        where:
        nums1                   | nums2                     | expected
        [1,2,2,1] as int[]      | [2,2] as int[]            | [2] as int[]
        [] as int[]             | [2,2] as int[]            | [] as int[]
        [1,2,2,1] as int[]      | [] as int[]               | [] as int[]
    }
    
}
