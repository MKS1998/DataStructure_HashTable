package com.hashtable;
import junit.framework.TestCase;
import org.junit.Test;


public class MyHashMapTest {
    private TestCase Assertions;

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

    @Test
    public void givenASentence_whenWordsAreAddedToList_shouldReturnParanoidWordFrequency() {
        String sentence = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately " +
                "into paranoid avoidable situations";
        MyHashMapParanoid<String, Integer> myLinkedHashMap = new MyHashMapParanoid<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value += 1;
            myLinkedHashMap.add(word, value);
        }
        System.out.println(myLinkedHashMap);
        int frequency = myLinkedHashMap.get("paranoid");
        TestCase.assertEquals(3, frequency);
    }
    @Test
    public void givenASentence_whenRemovedAvoidableWord_shouldRemoveAvoidableWord(){
        String sentence = "Paranoids are not paranoid because they are paranoid but " +
                "because they keep putting themselves deliberately " +
                "into paranoid avoidable situations";
        MyHashMapParanoid<String, Integer> myLinkedHashMap = new MyHashMapParanoid<>();
        String[] words = sentence.toLowerCase().split(" ");
        for(String word : words) {
            Integer value = myLinkedHashMap.get(word);
            if (value == null)
                value = 1;
            else
                value += 1;
            myLinkedHashMap.add(word, value);
        }
        System.out.println("before:" + myLinkedHashMap);
        myLinkedHashMap.remove("avoidable");
        System.out.println("after: " + myLinkedHashMap);
        Integer removedWordFrequency = myLinkedHashMap.get("avoidable");
        TestCase.assertEquals(null,removedWordFrequency);
    }
}