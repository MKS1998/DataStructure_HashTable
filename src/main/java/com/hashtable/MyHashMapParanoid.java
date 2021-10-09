package com.hashtable;

import java.util.ArrayList;

public class MyHashMapParanoid<K, V> {
    private final int numBuckets;
    ArrayList<MyLinkedList<K>> myBucketArray;
	private ArrayList<Object> myBucketArray1;
	public MyHashMapParanoid() {
        this.numBuckets = 10;
        this.myBucketArray1 = new ArrayList<>(numBuckets);

        for (int i = 0; i < numBuckets; i++)
            this.myBucketArray1.add(null);
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        System.out.println("Key " + key + " hashcode " + hashCode + " index " + index);
        return index;
    }

    public V get(K key) {
        int index = this.getBucketIndex(key);
        Object myLinkedList = this.myBucketArray1.get(index);
        if (myLinkedList == null)
            return null;
        @SuppressWarnings("unchecked")
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) ((MyLinkedList<K>) myLinkedList).search(key);
        return (myMapNode == null) ? null : myMapNode.getValue();
    }

    public void add(K key, V value) {
        int index = this.getBucketIndex(key);
        Object myLinkedList = this.myBucketArray1.get(index);
        if (myLinkedList == null)
            myLinkedList = new MyLinkedList<>();
        this.myBucketArray1.set(index, myLinkedList);
        @SuppressWarnings("unchecked")
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) ((MyLinkedList<Object>) myLinkedList).search(key);
        if (myMapNode == null) {
            myMapNode = new MyMapNode<>(key, value);
            ((MyLinkedList<K>) myLinkedList).append(myMapNode);
        } else {
            myMapNode.setValue(value);
        }
    }


    @Override
    public String toString() {
        return "MyLinkedHashMap List {" + myBucketArray1 + "}";
    }
}