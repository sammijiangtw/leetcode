package org.example.sliding_window;

import java.util.Arrays;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        return result;
    }

    public static int[] maxSlidingWindowLame(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k ; i++) {

            int[] temp = Arrays.copyOfRange(nums, i, i + k);
            Arrays.sort(temp);

            result[i] = temp[temp.length - 1];
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
//        int[] nums = {1};
//        int k = 1;
//        int[};
        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
