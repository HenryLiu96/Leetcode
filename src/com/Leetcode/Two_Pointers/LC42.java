package com.Leetcode.Two_Pointers;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC42 {
    public int trap(int[] height){
        Deque<Integer> s = new ArrayDeque<>();
        int res = 0;
        for(int i = 0; i < height.length; i++){
            while(!s.isEmpty() && height[s.peek()] < height[i]){
                int pre = s.pop();
                if(s.isEmpty())
                    break;
                int minHeight = Math.min(s.peek(), height[i]);
                res += (minHeight - height[pre]) * (i - s.peek() - 1);
            }
            s.push(i);
        }
        return res;
    }
}
