package com.inalkar.leetcode.learn.hashtable;

public class ExpiringMap {
    
    private int bucketsCount = 1000;

    private Entry[] buckets;
    
    private class Entry {
        Entry next;
        int key;
        int value;
        long expirationTime;
    }
    
    public ExpiringMap() {
        buckets = new Entry[bucketsCount];
    }
    
    public void put(int key, int value, long durationMs) {
        long entryExpirationTime = System.currentTimeMillis() + durationMs;
        
        int bucket = toBucketIndex(key);
        Entry entry = buckets[bucket];
        if (entry == null) {
            entry = new Entry();
            entry.key = key;
            entry.value = value;
            entry.expirationTime = entryExpirationTime;
            buckets[bucket] = entry;
        } else {
            while (entry.next != null && entry.next.key != key) {
                entry = entry.next;
            }

            if (entry.key == key) {
                entry.value = value;
                entry.expirationTime = entryExpirationTime;
            } else {
                Entry nextEntry = new Entry();
                nextEntry.key = key;
                nextEntry.value = value;
                nextEntry.expirationTime = entryExpirationTime;
                entry.next = nextEntry;
            }
        }
    }

    public Integer get(int key) {
        long currentTime = System.currentTimeMillis();
        
        Entry entry = findEntry(key);
        if (entry == null) return null;
        
        if (entry.expirationTime < currentTime) {
            remove(key);
            return null;
        } 
        
        return entry.value;
    }

    public void remove(int key) {
        int bucket = toBucketIndex(key);
        Entry entry = buckets[bucket];
        if (entry == null) return;

        if (entry.key == key) {
            buckets[bucket] = entry.next;
        } else {
            while (entry.next != null && entry.next.key != key) {
                entry = entry.next;
            }
            entry.next = entry.next != null ? entry.next.next : null;
        }
    }

    private Entry findEntry(int key) {
        int bucket = toBucketIndex(key);
        Entry entryNode = buckets[bucket];
        if (entryNode == null) return null;
        
        return findValueInCollision(entryNode, key);
    }

    private Entry findValueInCollision(Entry entry, int  key) {
        if (entry == null) return null;
        if (entry.key == key) return entry;
        return findValueInCollision(entry.next, key);
    }

    private int toBucketIndex(int key) {
        return key % bucketsCount;
    }
    
}
