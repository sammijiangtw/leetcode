package org.example.two_pointer;

import com.alibaba.fastjson.JSON;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int l = 0;
        int r = height.length - 1;

        int areaMax = 0;
        while (l < r) {

            int area = (r - l) * Math.min(height[l], height[r]);
            areaMax = Math.max(areaMax, area);

            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return areaMax;
    }

    public static void main(String[] args) {

//        int[] nums = {1,1};
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] nums = {1, 0};
        System.out.println("start");
        int result = maxArea(nums);
        System.out.println(JSON.toJSONString(result));
    }
}
