package com.hashtable;


import junit.framework.TestCase;
import org.junit.Test;

public class MyHashMapTest {
    //testCase to Find the Frequency of given words are true
    @Test
    public void givenASentence_WhenWordsAreAddedToList_ShouldReturnWordFrequency() {
        String sentence = "To Be or not To be";
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value += 1;
            myHashMap.add(word, value);
        }
        int frequency = myHashMap.get("to");
        System.out.println(myHashMap);
        TestCase.assertEquals(2, frequency);
    }
}