package org.example.subarray;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {

                return interval1[0] - interval2[0];
            }
        });

        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];

        int resultIndex = 0;
        for (int i = 1; i <= intervals.length - 1; i++) {

            int[] current = intervals[i];
            int[] pre = result[resultIndex];

            if (pre[0] < current[0] && pre[1] < current[0] && pre[1] < current[1]) {
                resultIndex++;
                result[resultIndex] = current;

            } else {
                result[resultIndex] = new int[]{Math.min(pre[0],current[0]), Math.max(pre[1], current[1])};
            }

        }

        if(resultIndex != intervals.length -1) {
            int[][] newResult = new int[resultIndex+1][2];
            System.arraycopy(result, 0, newResult, 0, resultIndex + 1);
            return newResult;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 3}};
//        int[][] intervals = {{1,4},{0,1}};
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = {{1,4},{0,0}};
        int[][] result = merge(intervals);
        System.out.println(JSON.toJSONString(result));
    }
}
