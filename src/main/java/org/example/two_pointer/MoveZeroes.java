package org.example.two_pointer;

import com.alibaba.fastjson.JSON;

public class MoveZeroes {

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void moveZeroes(int[] nums) {

        int l = 0;
        int r = 0;

        while(r < nums.length){
            if(nums[r] != 0){
                swap(nums, l, r);
                l ++;

            }
            r ++;
        }
    }

    public static void moveZeroesVeryLame(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            if (nums[r] == 0) {
                r = r - 1;
            }

            if (nums[l] != 0 ) {
                l = l + 1;
            }

            if (l >= r) {
                break;
            }

            if (nums[l] == 0) {

                int index = l + 1;
                while (nums[index] == 0 && index < r) {
                    index++;
                }

                if (nums[index] != 0) {
                    nums[l] = nums[index];
                    nums[index] = 0;
                    l = l + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

//        int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {0, 0, 0};
//        int[] nums = {1, 0};

        moveZeroes(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
