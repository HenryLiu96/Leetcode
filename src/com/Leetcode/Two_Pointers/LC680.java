package com.Leetcode.Two_Pointers;

public class LC680 {
    public boolean isPalindrome(String s){
        int n = s.length();
        int start = 0;
        int end = n - 1;
        while(s.charAt(start) == s.charAt(end) && start < end){
            start++;
            end--;
        }
        if(start == end)
            return true;
        else
            return isPalin(s, start + 1, end) || isPalin(s, start, end - 1);
    }

    public boolean isPalin(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else
                return false;
        }
        return true;
    }
}
