package com.inalkar.leetcode.learn.hashtable

import spock.lang.Specification

class ContainsDuplicateSpec extends Specification {
    
    def "containsDuplicate"() {
        setup:
        def util = new ContainsDuplicate()
        
        when:
        def result = util.containsDuplicate(nums)
        
        then:
        assert result == expected
        
        where:
        nums                | expected
        [1,2,3,4] as int[]  | false
        [] as int[]         | false
        [4,2,3,4] as int[]  | true
    }
    
}
