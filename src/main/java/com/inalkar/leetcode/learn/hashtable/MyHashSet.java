package com.inalkar.leetcode.learn.hashtable;

public class MyHashSet {
    
    private int bucketsCount = 1000;
    
    private ValueWrapper[] buckets;
    
    private class ValueWrapper {
        ValueWrapper next;
        int value;
    }
    
    public MyHashSet() {
        buckets = new ValueWrapper[bucketsCount];
    }
    
    public void add(int key) {
        if (contains(key)) return;
        
        int bucket = findBucket(key);
        ValueWrapper valueWrapper = buckets[bucket];
        if (valueWrapper == null) {
            ValueWrapper value = new ValueWrapper();
            value.value = key;
            buckets[bucket] = value;
        } else {
            while (valueWrapper.next != null) {
                valueWrapper = valueWrapper.next;
            }
            ValueWrapper value = new ValueWrapper();
            value.value = key;
            valueWrapper.next = value;
        }
    }
    
    public void remove(int key) {
        int bucket = findBucket(key);
        ValueWrapper valueWrapper = buckets[bucket];
        if (valueWrapper == null) return;
            
        if (valueWrapper.value == key) {
            buckets[bucket] = valueWrapper.next;
        } else {
            while (valueWrapper.next != null && valueWrapper.next.value != key) {
                valueWrapper = valueWrapper.next;
            }
            valueWrapper.next = valueWrapper.next != null ? valueWrapper.next.next : null;
        }
    }
    
    public boolean contains(int key) {
        return findValue(key) != null;
    }
    
    private ValueWrapper findValue(int key) {
        int bucket = findBucket(key);
        ValueWrapper value = buckets[bucket];
        if (value == null) return null;
        
        return findValueInCollision(value, key);
    }
    
    private ValueWrapper findValueInCollision(ValueWrapper value, int  key) {
        if (value == null) return null;
        if (value.value == key) return value;
        return findValueInCollision(value.next, key);
    }
    
    private int findBucket(int key) {
        return key % bucketsCount;
    }
    
}
