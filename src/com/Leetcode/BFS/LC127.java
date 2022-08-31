package com.Leetcode.BFS;

import java.util.*;

public class LC127 {
    //word Ladder
    //单向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int step = 1;
        int n = beginWord.length();
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(endWord))
                    return step;
                for(int j = 0; j < n; j++){
                    for(char letter = 'a'; letter <= 'z'; letter++) {
                        StringBuilder next = new StringBuilder(cur);
                        next.setCharAt(j, letter);
                        String nextWord = next.toString();
                        if (set.contains(nextWord)) {
                            if (nextWord.equals(endWord))
                                return step + 1;
                            set.remove(nextWord);
                            q.offer(nextWord);
                        }

                    }
                }
            }
            step++;
        }
        return 0;
    }


    public int ladderLen(String startWord, String endWord, List<String> word){
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<String> wordList = new HashSet<>(word);
        if(!wordList.contains(endWord))
            return 0;
        int step = 1;
        int n = startWord.length();
        begin.add(startWord);
        end.add(endWord);
        while(!begin.isEmpty() && !end.isEmpty()){
            Set<String> nextSet = new HashSet<>();
            for(String w : begin){
                char[] ch = w.toCharArray();
                for(int i = 0; i < n; i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        char pre = ch[i];
                        ch[i] = c;
                        String nextWord = new String(ch);
                        if(end.contains(nextWord))
                            return step + 1;
                        if(visited.contains(nextWord) && wordList.contains(nextWord))
                            nextSet.add(nextWord);
                        ch[i] = pre;
                    }
                }
            }
            if(end.size() < nextSet.size()){
                begin = end;
                end = nextSet;
            }else begin = nextSet;
            step++;
        }
        return 0;
    }
}
