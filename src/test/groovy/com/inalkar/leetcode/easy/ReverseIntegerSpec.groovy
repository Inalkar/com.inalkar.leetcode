package com.inalkar.leetcode.easy

import spock.lang.Specification

class ReverseIntegerSpec extends Specification {

    def "reverseInteger"() {
        when:
        def result = ReverseInteger.reverse(number)

        then:
        assert result == expected

        where:
        number    | expected
        123       | 321
        -321      | -123
    }

}
