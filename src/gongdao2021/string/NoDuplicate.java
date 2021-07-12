package gongdao2021.string;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复最长字符串
 * */
public class NoDuplicate {

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> ch = new HashMap<>();
        int length = s.length();
        int start = 0;
        int maxlength = 0;
        String max = "";
        for (int i=0;i<length;i++){
            if(ch.containsKey(s.charAt(i))){
                //判断一下和当前字符重复的字符是否在start 位置之后
                // 有可能中间字符串是重复的 start 会大于 对应的字符的位置
                start = Math.max(start,ch.get(s.charAt(i))+1);
            }
            ch.put(s.charAt(i),i);
            //这里判断的是 长度 也可以返回串
            maxlength = Math.max(maxlength,i-start+1);
            //max = max.length()>(i-start+1)?max: s.substring(start,i);
        }
        return maxlength;
    }
}
