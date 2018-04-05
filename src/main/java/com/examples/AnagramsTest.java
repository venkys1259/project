package com.examples;

import java.util.*;

public class AnagramsTest {
    private static Map<String,List<String>> anagrams(String[] words){
        Map<String,List<String>> anagramMap = new HashMap<>();
        for(String word:words){
            List<String> list;
            String original = word;
            char[] ch = word.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if(anagramMap.containsKey(sorted)) {
                List<String> existingList = anagramMap.get(sorted);
                existingList.add(original);
                anagramMap.put(sorted,existingList );
            }
            else{
                list = new ArrayList<>();
                list.add(original);
                anagramMap.put(sorted, list);
            }
        }
        return anagramMap;
    }

    public static void main(String[] args) {
        String[] words = {"eat","tae","ate","can","nac","abc","def"};
        Map<String, List<String>> anagramsMasterMap = AnagramsTest.anagrams(words);
       Map<String, List<String>> anagramMap = new HashMap<>();
        for(Map.Entry<String,List<String>> angram : anagramsMasterMap.entrySet()){
            if(angram.getValue().size() > 1){
                anagramMap.put(angram.getKey(),angram.getValue());
            }
        }
        System.out.println(anagramMap);
    }
}
