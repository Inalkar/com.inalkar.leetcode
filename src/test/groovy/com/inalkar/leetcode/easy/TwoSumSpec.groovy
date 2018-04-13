package com.inalkar.leetcode.easy

import spock.lang.Specification

class TwoSumSpec extends Specification {

    def "TwoSum"() {
        when:
        def result = TwoSum.twoSum(array, number)

        then:
        assert result[0] == expected[0]
        assert result[1] == expected[1]

        where:
        array                       | number    | expected
        [2, 7, 11, 15] as int[]     | 9         | [0, 1]
        [0, 7, 11, 0] as int[]      | 0         | [0, 3]

    }

}
