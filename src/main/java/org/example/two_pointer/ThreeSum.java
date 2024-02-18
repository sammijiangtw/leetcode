package org.example.two_pointer;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r && l <= nums.length - 2) {

                int amount = nums[i] + nums[l] + nums[r];

                if(amount < 0){
                    l++;
                }

                if(amount > 0){
                    r--;
                }

                if (amount == 0) {
                    List<Integer> part = Arrays.asList(nums[i], nums[l], nums[r]).stream().sorted().collect(Collectors.toList());
                    result.add(part);
                    r--;
                    l++;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {

//        int[] nums = {0,0,0,0};
//        int[] nums = {-1,0,1,0};
//        int[] nums = {3,0,-2,-1,1,2};
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSum(nums);
        System.out.println(JSON.toJSONString(result));
    }
}
