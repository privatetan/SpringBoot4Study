package com.springstudy.mybatisplus.AlgorithmOffer.day04;

/**
 * 0～n-1中缺失的数字
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 例子：
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 */
public class FindMissNumber {
    /**
     *  套路：递增排序数组使用二分法
     */
    public int missingNumber(int[] nums) {
        int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid]==mid){
                start = mid+1;
            }else {
                end = mid -1 ;
            }
        }
        return start;
    }
}
