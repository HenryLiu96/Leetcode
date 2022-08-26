package com.Leetcode.Binary_Search;

public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int left = 0;
        int right = nums1.length;
        while(left <= right){
            int midUp = left + (right - left) / 2;
            int midDown = (nums1.length + nums2.length + 1) / 2 - midUp;
            int upLeft = midUp == 0 ? Integer.MIN_VALUE : nums1[midUp - 1];
            int upRight = midUp == nums1.length ? Integer.MAX_VALUE : nums1[midUp];
            int downLeft = midDown == 0 ? Integer.MIN_VALUE : nums2[midDown - 1];
            int downRight = midDown == nums2.length ? Integer.MAX_VALUE : nums2[midDown];
            if(upLeft <= downRight && upRight >= downLeft)
                if((nums1.length + nums2.length) % 2 == 0)
                    return (double)(Math.max(upLeft, downLeft) + Math.min(upRight, downRight)) / (double) 2;
                else return (double)Math.max(upLeft, downLeft);
            else if(upRight < downLeft){
                left = midUp + 1;
            }else{
                right = midUp - 1;
            }
        }
        return -1;
    }
}
