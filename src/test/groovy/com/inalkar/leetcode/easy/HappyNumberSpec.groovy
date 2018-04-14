package com.inalkar.leetcode.easy

import spock.lang.Specification

class HappyNumberSpec extends Specification {
    
    def "isHappy"() {
        setup:
        def util = new HappyNumber()
        
        when:
        def result = util.isHappy(number)
        
        then:
        assert result == expected
        
        where:
        number  | expected
        2       | false
        0       | false
        1       | true
        19      | true
        31      | true
    }
    
}
