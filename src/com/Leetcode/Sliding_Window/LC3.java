package com.Leetcode.Sliding_Window;

import java.util.Map;
import java.util.HashMap;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while(map.get(cur) > 1){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
