package com.springstudy.AlgorithmOffer.day05;

/**
 * 二维数组中的查找
 * <p>
 * 描述：
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 例子：
 * <p>
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * <p>
 * 技巧
 * 从右上角看，将二维数组视为二叉搜索树，使用二分法
 */
public class FindInTwoDimensionalArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        //matrix[i][j]为左下角标识值flag
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) {  //如果flag > target , 消去行
                i--;
            } else if (matrix[i][j] < target) { //如果flag < target , 消去列
                j++;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        //matrix[i][j]为又上角标识值flag
        int row = 0, column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] > target) {  //如果flag > target , 消去列
                column--;
            } else if (matrix[row][column] < target) { //如果flag < target , 消去列
                row++;
            } else {
                return true;
            }
        }
        return false;
    }

}
