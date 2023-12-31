package org.example;

import java.util.HashMap;
import java.util.Map;

public class DuplicateFinder {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,2,5,6,3};

        Map<Integer,Integer> countMap = new HashMap<>();

        for(int num : array){
            //count occorances of each number
            countMap.put(num, countMap.getOrDefault(num,0)+1);
        }
        System.out.println("Duplicates in the array:");

        for (Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue() > 1){
                System.out.println(entry.getKey());
            }
        }
    }
}
