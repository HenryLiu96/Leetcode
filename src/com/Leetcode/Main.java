package com.Leetcode;

import com.Leetcode.Binary_Search.LC4;
import com.Leetcode.Two_Pointers.LC680;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String he = "hello";
        char[] c = he.toCharArray();
        Arrays.sort(c);
        String cur = new String(c);
        System.out.println(cur);
        Set<Character> set = new HashSet<>();

    }
}
