package org.example.hash;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {

            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            }

            hashMap.putIfAbsent(nums[i], i);
        }

        return null;
    }

    public int[] twoSumLame(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > target) {
                continue;
            }

            int remain = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (remain == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {

        int[] nums = {3,3,3};
        int target = 6;
        int[] result = twoSum(nums, target);
        System.out.println(JSON.toJSONString(result));
    }
}
