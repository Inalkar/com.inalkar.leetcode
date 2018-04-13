package com.inalkar.leetcode.learn.hashtable

import spock.lang.Specification

class MyHashSetSpec extends Specification {
    
    def "Add"() {
        setup: 
        def set = new MyHashSet()
        
        when:
        set.add(1)
        set.add(1000000)
        set.add(999999)
        
        then:
        assert set.contains(1)
        assert set.contains(1000000)
        assert set.contains(999999)
    }

    def "Remove"() {
        setup: 
        def set = new MyHashSet()
        
        when:
        set.add(1)
        set.add(1001)
        set.add(2001)
        set.add(2)
        set.remove(1)
        set.remove(1001)
        
        then:
        assert !set.contains(1)
        assert set.contains(2)
        assert set.contains(2001)
    }

    def "Remove#2"() {
        setup: 
        def set = new MyHashSet()
        
        when:
        set.add(1)
        set.add(1001)
        set.add(2001)
        set.add(2)
        set.remove(1001)
        
        then:
        assert set.contains(1)
        assert set.contains(2)
        assert set.contains(2001)
        assert !set.contains(1001)
    }
    
}
