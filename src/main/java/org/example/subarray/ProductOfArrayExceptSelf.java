package org.example.subarray;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        Set<Integer> zeroIndex = new HashSet<>();
        int total = 1;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                zeroIndex.add(i);
            } else {
                total = total * nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {

            if (zeroIndex.size() > 1 || (zeroIndex.size() == 1 && !zeroIndex.contains(i))) {
                result[i] = 0;
            } else if (zeroIndex.contains(i)) {
                result[i] = total;
            } else {
                result[i] = total / nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 1, 0, -3, 3};
        int[] result = productExceptSelf(nums);
        System.out.println(JSON.toJSONString(result));

        //L: 1.4.20.20.160
        //R: 80.16.16.2.1
    }
}
