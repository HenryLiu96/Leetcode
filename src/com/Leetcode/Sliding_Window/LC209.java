package com.Leetcode.Sliding_Window;

public class LC209 {
    public int minSubArrayLen(int target, int[] nums){
        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
