package com.springstudy.mybatisplus.AlgorithmOffer.day03;

import java.util.Vector;

/**
 * 替换字符串
 *
 * 描述：
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 例子：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceStr{
    public String replaceSpace(String s) {
        char[] chars = new char[s.length()*3]; //注意这里初始长度为字符串长度的3倍，以容纳所有替换后的字符串
        int arrLen = 0;  //记录新数组索引位置
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){  //如果为''则往新数组插入三个字符
                chars[arrLen++] = '%';
                chars[arrLen++] = '2';
                chars[arrLen++] = '0';
            }else{
                chars[arrLen++] = s.charAt(i);  //如果为其他字符则往新数组插入该字符
            }
        }
     return new String(chars,0, arrLen);  //灵活运用String类的构造方法
    }

}
