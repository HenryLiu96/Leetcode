package com.Leetcode.Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC5 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                    start++;
                    end--;
                    while(start < end && nums[start] == nums[start - 1])
                        start++;
                    while(end > start && nums[end] == nums[end + 1])
                        end--;
                }else if(nums[i] + nums[start] + nums[end] > 0){
                    end--;
                }else
                    start++;
            }
        }
        return res;
    }
}
