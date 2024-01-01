package com.meghabassi;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LetterCounter {

    public Map<Character,Integer> countLettersString(String word){
        Map<Character,Integer> charCountMap= new HashMap<>();
        if(word==null)
            return  charCountMap;
        char[] charArray=word.toLowerCase(Locale.ENGLISH).toCharArray();

        for(int i=0;i<word.length();i++){
            if(charArray[i]>=97 && charArray[i]<=122)
                charCountMap.put(charArray[i],charCountMap.getOrDefault(charArray[i],0)+1);

        }
        return charCountMap;
    }

}