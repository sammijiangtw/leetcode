package org.example.subarray;

import com.alibaba.fastjson.JSON;

public class RotateArray {

    public static void rotate(int[] nums, int k) {

        int len = nums.length;
        int[] newArray = new int[len];

        for (int i = 0; i < len; i++) {

            newArray[(i+k)%len] =nums[i];
        }

        System.arraycopy(newArray, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {

//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;

        int[] nums = {1, 2};
        int k = 3;
        rotate(nums, k);
        System.out.println(JSON.toJSONString(nums));
    }
}
