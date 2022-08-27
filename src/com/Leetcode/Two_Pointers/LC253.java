package com.Leetcode.Two_Pointers;


import java.util.*;

public class LC253 {
    public int meetingRoom1(int[][] intervals){
         List<int[]> list = new ArrayList<>();
         for(int[] interval : intervals){
             list.add(new int[]{interval[0], 1});//起飞
             list.add(new int[]{interval[1], -1});//降落
         }
         Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
         int res = 0;
         int count = 0;
         for(int[] pointer : list){
             count += pointer[1];
             res = Math.max(res, count);
         }
         return res;
    }

    public int meetingRoom2(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(pq.peek()[1] <= intervals[i][0])
                pq.poll();
            pq.offer(intervals[i]);
        }
        return pq.size();
    }
}
