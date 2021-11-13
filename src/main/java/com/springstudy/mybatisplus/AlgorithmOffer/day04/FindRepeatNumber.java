package com.springstudy.mybatisplus.AlgorithmOffer.day04;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中重复的数字
 *
 * 描述：
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 例子
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 */
public class FindRepeatNumber {
        public int findRepeatNumber(int[] nums) {
            //使用map或者set记录数组元素
            Map<Integer,Integer> tempMap = new HashMap<>();
            //遍历原数组
           for(int i =0;i<nums.length;i++){
               //如果不存在，存入，存在返回
               if(!tempMap.containsKey(nums[i])){
                   tempMap.put(nums[i],i);
               }else {
                   return nums[i];
               }
           }
         return -1;
        }

}
