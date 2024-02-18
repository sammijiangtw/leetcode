package org.example.subarray;

import com.alibaba.fastjson.JSON;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {

        Set<Integer> all = new HashSet<>();
        for(int i : nums){
            all.add(i);
        }

        for(int i = 1; true; i++){

            if(!all.contains(i)){
                return i;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {-1, 1, 0, -3, 3};
        int result = firstMissingPositive(nums);
        System.out.println(JSON.toJSONString(result));
    }
}
