package org.example.matrix;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Matrix
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {

        Set<Integer> columnIndex = new HashSet<>();
        Set<Integer> rowIndex = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {

            int[] row = matrix[i];

            for (int j = 0; j < row.length; j++) {

                if (0 == row[j]) {
                    rowIndex.add(i);
                    columnIndex.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {

            if(rowIndex.contains(i)){
                matrix[i] = new int[matrix[i].length];
                continue;
            }

            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {

                rowList.add(columnIndex.contains(j)? 0 : matrix[i][j]);
            }

            matrix[i] = rowList.stream().mapToInt(Integer::intValue).toArray();
        }

    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);

        System.out.println(JSON.toJSONString(matrix));
    }
}
