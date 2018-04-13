package com.inalkar.leetcode.learn.hashtable;

public class MyHashMap {

    private int bucketsCount = 1000;

    private EntryNode[] buckets;

    private class EntryNode {
        EntryNode next;
        Entry entry;
    }

    private class Entry {
        int key;
        int value;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new EntryNode[bucketsCount];
    }

    /** value will always be positive. */
    public void put(int key, int value) {
        int bucket = toBucketIndex(key);
        EntryNode entryNode = buckets[bucket];
        if (entryNode == null) {
            entryNode = new EntryNode();

            Entry entry = new Entry();
            entry.key = key;
            entry.value = value;

            entryNode.entry = entry;

            buckets[bucket] = entryNode;
        } else {
            while (entryNode.next != null && entryNode.entry.key != key) {
                entryNode = entryNode.next;
            }

            if (entryNode.entry.key == key) {
                entryNode.entry.value = value;
            } else {
                EntryNode nextEntry = new EntryNode();

                Entry entry = new Entry();
                entry.key = key;
                entry.value = value;
                nextEntry.entry = entry;

                entryNode.next = nextEntry;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Entry entry = findEntry(key);
        if (entry == null) return -1;

        return entry.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = toBucketIndex(key);
        EntryNode entryNode = buckets[bucket];
        if (entryNode == null) return;

        if (entryNode.entry.key == key) {
            buckets[bucket] = entryNode.next;
        } else {
            while (entryNode.next != null && entryNode.next.entry.key != key) {
                entryNode = entryNode.next;
            }
            entryNode.next = entryNode.next != null ? entryNode.next.next : null;
        }
    }

    private Entry findEntry(int key) {
        int bucket = toBucketIndex(key);
        EntryNode entryNode = buckets[bucket];
        if (entryNode == null) return null;

        entryNode = findValueInCollision(entryNode, key);
        return entryNode != null ? entryNode.entry : null;
    }

    private EntryNode findValueInCollision(EntryNode node, int  key) {
        if (node == null) return null;
        if (node.entry.key == key) return node;
        return findValueInCollision(node.next, key);
    }

    private int toBucketIndex(int key) {
        return key % bucketsCount;
    }

}
