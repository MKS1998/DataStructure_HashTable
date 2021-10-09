package com.hashtable;

public class MyHashMap<K, V> {
	private static final MyLinkedList<K, V> myLinkedList = null;
	private static final String myLinkedList1 = null;
	 MyHashMap<K,V> myLinkedList11;

	public MyHashMap() {
		MyHashMap.myLinkedList1 = new MyLinkedList<>();
	}

	public V get(K key) {
		@SuppressWarnings("unchecked")
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) MyHashMap.myLinkedList1.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	@SuppressWarnings("unchecked")
	public void add(K key, V value) {
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) MyHashMap.myLinkedList1.search(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			MyHashMap.myLinkedList1.append((INode<Object>) myMapNode);
		} else {
			myMapNode.setValue(value);
		}
	}

	public String toString() {
		return "MyHashMapNodes {" + myLinkedList1 + "}";1
	}
}