package com.springstudy.mybatisplus.AlgorithmOffer.day04;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 例子：
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class FindTimeNumber {
    /**
     * 二分法：强烈推荐
     */
    public int search(int[] nums, int target) {
        //右边界-左边界
      return  binarySearch(nums, target) - binarySearch(nums, target - 1);
    }


     public  int binarySearch(int[] nums, int tar) {
            int i = 0, j = nums.length - 1;
            while(i <= j) {
                int m = (i + j) / 2;
                if(nums[m] <= tar) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            return i;
    }



}
