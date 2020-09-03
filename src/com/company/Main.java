package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstWord = scanner.nextLine();
        String secondWord = scanner.nextLine();

        if (firstWord.length() == secondWord.length()){
            checkAnagram(firstWord, secondWord);
        }else {
            System.out.println("no");
        }
    }

    static void checkAnagram(String firstWord, String secondWord){
        char c1[] = firstWord.toUpperCase().toLowerCase().toCharArray();
        char c2[] = secondWord.toUpperCase().toLowerCase().toCharArray();

        int count;
        boolean flag = true;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < c1.length; ++i) {
            count = 0;
            if (map.containsKey(c1[i])){
                count = map.get(c1[i]);
            }
            map.put(c1[i], ++count);
            count = 0;

            if(map.containsKey(c2[i])){
                count = map.get(c2[i]);
            }

            map.put(c2[i], --count);
        }
        for(int i : map.values()){
            if(i != 0){
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println("yes");
        }
        else{
            System.out.println("no");

        }


    }

}