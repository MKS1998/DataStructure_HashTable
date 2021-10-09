package com.hashtable;

public interface INode<K> {
    K getKey();

    void setKey(K key);

    @SuppressWarnings("rawtypes")
	INode getNext();

    @SuppressWarnings("rawtypes")
	void setNext(INode next);
}