package com.example.translater;
import java.lang.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {
    static Map<String, Integer> english = new HashMap<String, Integer>();
    static Map<Integer, String> french = new HashMap<Integer, String>();
    static void MakeDictionary() {
        File file = new File("input.txt");
        File file2 = new File("input2.txt");
        Scanner in,in2;
        Map<String, Integer> english = new HashMap<String, Integer>();
       Map<Integer, String> french = new HashMap<Integer, String>();

        {
            try {
                in = new Scanner(file);
                in2 = new Scanner(file2);
                while (in.hasNextLine()) {
                    String line = in.nextLine();
                    StringBuilder builder = new StringBuilder();
                    StringTokenizer stringTokenizer = new StringTokenizer(line," ");
                    int id = Integer.parseInt(stringTokenizer.nextToken());
                    while(stringTokenizer.hasMoreTokens()){
                        String token = stringTokenizer.nextToken();
                        builder.append(token+ " ");
                    }
                    english.put(String.valueOf(builder), id);
                }
                while (in2.hasNextLine()) {
                    String line = in2.nextLine();
                    StringBuilder builder = new StringBuilder();
                    StringTokenizer stringTokenizer = new StringTokenizer(line," ");
                    int id = Integer.parseInt(stringTokenizer.nextToken());
                    while(stringTokenizer.hasMoreTokens()){
                        String token = stringTokenizer.nextToken();
                        builder.append(token+ " ");
                    }
                    french.put(id, String.valueOf(builder));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
   }
    static Map<String, Integer> getEnglish(){
        return english;
   }
   static Map<Integer, String> getFrench(){
        return  french;
   }
}
