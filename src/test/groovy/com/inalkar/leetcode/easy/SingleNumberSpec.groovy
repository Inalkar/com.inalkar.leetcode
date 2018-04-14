package com.inalkar.leetcode.easy

import spock.lang.Specification

class SingleNumberSpec extends Specification {
    
    def "singleNumber"() {
        setup:
        def util = new SingleNumber()
        
        when:
        def result = util.singleNumber(nums)
        
        then:
        assert result == expected
        
        where:
        nums                    | expected
        [1,2,2] as int[]        | 1
        [13,2,2, 1, 1] as int[] | 13
        [2,2] as int[]          | 0
        [] as int[]             | 0
        [1] as int[]            | 1
    }
    
}
