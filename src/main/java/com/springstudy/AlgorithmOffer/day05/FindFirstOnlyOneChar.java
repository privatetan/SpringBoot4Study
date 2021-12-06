package com.springstudy.AlgorithmOffer.day05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 第一个只出现一次的字符
 *
 * 描述
 * 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 例子
 * 输入：s = "abaccdeff"
 * 输出：'b'
 *
 * 使用LinkedHashMap
 */
public class FindFirstOnlyOneChar {

    public char firstUniqChar(String s) {
       if("".equals(s)||s==null){
           return ' ';
       }
       Map<Character,Boolean> charmap = new LinkedHashMap();
        for (char a: s.toCharArray()) {
            if(charmap.containsKey(a)){
                charmap.put(a,false);
            }else {
                charmap.put(a,true);
            }
        }
        for (Character key: charmap.keySet()) {
            if(charmap.get(key)){
                return key;
            }
        }
        return ' ';
    }
}
