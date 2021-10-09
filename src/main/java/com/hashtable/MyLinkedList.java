package com.hashtable;

public class MyLinkedList<K> {
	public INode<K> head;
	public INode<K> tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void append(INode<K> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			INode<K> tempNode = this.tail;
			this.tail = newNode;
			tempNode.setNext(newNode);
		}

	}

	@SuppressWarnings("unchecked")
	public INode<K> pop(INode<K> deleteNode) {
		INode<K> tempNode = this.head;
		this.head = head.getNext();
		return tempNode;
	}

	@SuppressWarnings("unchecked")
	public INode<K> search(K key) {
		INode<K> tempNode = head;
		while (tempNode != null && tempNode.getNext() != null) {
			if (tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}

	public String toString() {
		return "MyLinkedListNodes{" + head + '}';
	}
}