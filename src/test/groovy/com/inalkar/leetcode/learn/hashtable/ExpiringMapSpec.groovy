package com.inalkar.leetcode.learn.hashtable

import spock.lang.Specification

class ExpiringMapSpec extends Specification {
    
    def "Put"() {
        setup:
        def map = new ExpiringMap()

        when:
        map.put(1, 1, 1000)
        map.put(2, 2, 1000)
        map.put(2, 1, 1000)
        map.put(1001, 12, 1000)

        then:
        map.get(1) == 1
        map.get(1001) == 12
        map.get(3) == null
        map.get(2) == 1
    } 
    
    def "expired"() {
        setup:
        def map = new ExpiringMap()

        when:
        map.put(2, 2, 0)
        sleep(10)

        then:
        map.get(2) == null
    }

    def "Remove"() {
        setup:
        def map = new ExpiringMap()

        when:
        map.put(1, 1, 1000)
        map.put(1001, 12, 1000)
        map.put(2001, 21, 1000)
        map.remove(1001)

        then:
        map.get(1) == 1
        map.get(1001) == null
        map.get(2001) == 21
    }
    
}
