package com.inalkar.leetcode.learn.hashtable

import spock.lang.Specification

class MyHashMapSpec extends Specification {

    def "Put"() {
        setup:
        def map = new MyHashMap()

        when:
        map.put(1, 1)
        map.put(2, 2)
        map.put(2, 1)
        map.put(1001, 12)

        then:
        map.get(1) == 1
        map.get(1001) == 12
        map.get(3) == -1
        map.get(2) == 1
    }

    def "Remove"() {
        setup:
        def map = new MyHashMap()

        when:
        map.put(1, 1)
        map.put(1001, 12)
        map.put(2001, 21)
        map.remove(1001)

        then:
        map.get(1) == 1
        map.get(1001) == -1
        map.get(2001) == 21
    }
}
