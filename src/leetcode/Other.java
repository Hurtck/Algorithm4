package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Other {
    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<>();
        String[] dic = new String[]{"cat", "cats", "and", "sand", "dog"};
        for(String sb:dic){
            dict.add(sb);
        }
        System.out.println(wordBreak(s,dict).toString());
    }
    //word-break-ii
    public static ArrayList<String> wordBreak(String s, Set<String> dict){
        ArrayList<String> sentence = new ArrayList<>();
        int endIndex =0;
        while (endIndex<s.length()){
            for(String word:dict){
                int tempIndex = endIndex;
                boolean tag = true;
                for(int i=0;i<word.length();i++){
                    if(word.charAt(i)!=s.charAt(endIndex)){
                        tag = false;
                        break;
                    }
                    tempIndex++;
                }
                if(tag){
                    sentence.add(s.substring(endIndex,tempIndex));
                    endIndex = tempIndex;
                }
            }
        }
        return sentence;
    }
}
