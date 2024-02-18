package org.example.subarray;

import com.alibaba.fastjson.JSON;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        int result = 0;
        for (int i = 0; i < nums.length; i++) {

            int amount = nums[i];
            if (amount == k) {
                result++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                amount = amount + nums[j];
                if (amount == k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, -1, 0};
//        int[] nums = {1, 1, 1};
//        int[] nums = {1, 2, 3};
//        int[] nums = {1, 2, 1, 2, 1};
//        int[] nums = {-27, 125, 209, -84, -222, -137, 112, -76, 200, -139, 200, 61, -215, 121, 318, -128, 121, 216,
//            -132, 165, -19, 89, 193, -59, 203, 8, 140, -128, -201, 199, -5, 36, -167, -140, -194, -166, 182, -50, 729,
//            -167, -114, -71, 108, -40, -189, 188, -109, 69, -134, 682, 173, -89, -114, -177, 194, -1, 168, -42, -55,
//            -32, 198, 171, 45, 25, -18, 154, -22, -192, 213, 86, -16};
        int k = 2;
        System.out.println("start");
        int result = subarraySum(nums, k);
        System.out.println(JSON.toJSONString(result));
    }
}
