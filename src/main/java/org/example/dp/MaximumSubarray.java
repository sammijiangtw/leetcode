package org.example.dp;

import java.sql.Array;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int result = nums[0];
        int[] temp = new int [nums.length];
        temp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if(temp[i -1] > 0 ){
                temp[i] = temp[i -1] + nums[i];
            } else {
                temp[i] = nums[i];
            }

            result = Math.max(result, temp[i]);
        }

        return result;
    }

    public static void main(String[] args) {

//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1};
        int[] nums = {5,4,-1,7,8};
        int result = maxSubArray(nums);
        System.out.println(result);
    }
}
