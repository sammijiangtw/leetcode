package org.example.two_pointer;

import com.alibaba.fastjson.JSON;

public class TrappingRainWater {

    public static int trap(int[] height) {

//        int[] leftmax
//        for()
        return 0;


    }

    public static void main(String[] args) {
//        int[] nums = {9,6,8,8,5,6,3};
//        int[] nums = {1,1,0};
//        int[] nums = {5,4,1,2};
//        int[] nums = {1,1};
//        int[] nums = {1, 1, 1, 1, 1};
//        int[] nums = {0};
//        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};//6
        int[] nums = {4, 2, 0, 3, 2, 5};//9
        System.out.println("start");
        int result = trap(nums);
        System.out.println(JSON.toJSONString(result));
    }
}
