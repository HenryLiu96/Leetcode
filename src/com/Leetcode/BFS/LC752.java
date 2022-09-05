package com.Leetcode.BFS;

import java.util.*;

public class LC752 {
    public int openLock(String[] deadends, String target){
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        start.add("0000");
        end.add(target);
        int level = 0;
        while(!start.isEmpty() && !end.isEmpty()){
            Set<String> temp = new HashSet<>();
            for(String s : start){
                if(end.contains(s))
                    return level;
                if(deads.contains(s))
                    continue;
                deads.add(s);
                StringBuilder sb = new StringBuilder(s);
                for(int i = 0; i < 4; i++){
                    char c = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
                    String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '1') + sb.substring(i + 1);
                    if(!deads.contains(s1))
                        temp.add(s1);
                    if(!deads.contains(s2))
                        temp.add(s2);
                }
            }
            level++;
            start = end;
            end = temp;
        }
        return -1;
    }
}
