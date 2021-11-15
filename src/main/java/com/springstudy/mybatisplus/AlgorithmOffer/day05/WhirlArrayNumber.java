package com.springstudy.mybatisplus.AlgorithmOffer.day05;

/**
 * 旋转数组的最小数字
 * <p>
 * 描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 例子：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 技巧使用二分法，注意临界条件
 */
public class WhirlArrayNumber {
    /**
     * 二分法
     */
    public int minArray(int[] numbers) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int temp = (start + end) / 2;
            if(numbers[temp]>numbers[end]){
                start = temp + 1;
            }else if(numbers[temp]<numbers[end]){
                end = temp;
            }else {
                end--;
            }
        }
        return numbers[start];
    }
}
