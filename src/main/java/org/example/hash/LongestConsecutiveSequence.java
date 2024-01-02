package org.example.hash;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int[] sortedArray = Arrays.stream(nums).sorted().distinct().toArray();
        for (int i = 0; i < sortedArray.length; i++) {
            if (map.isEmpty()) {

                map.put(sortedArray[i], 1);
            } else {
                if (map.containsKey(sortedArray[i] - 1)) {
                    map.put(sortedArray[i], map.get(sortedArray[i] - 1) + 1);
                    map.remove(sortedArray[i] - 1);
                } else {
                    map.put(sortedArray[i], 1);
                }
            }
        }

        return map.values().stream().max(Comparator.comparing(Integer::intValue)).orElse(0);
    }

    public static void main(String[] args) {

        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] nums2 = {0,0,-1};
        int[] nums3 = {};
        int[] nums4 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

        int result = longestConsecutive(nums2);
        System.out.println(JSON.toJSONString(result));
    }
}
