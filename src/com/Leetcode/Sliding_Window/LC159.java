package com.Leetcode.Sliding_Window;

import java.util.Map;
import java.util.HashMap;

public class LC159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > 2){
                char cur = s.charAt(left);
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) == 0)
                    map.remove(cur);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;



    }
}
