package gongdao2021.string;

/**
 * 字符串排列
 * 给定两个字符串 判断一个字符串是否含有另一个字符串的子串的排列
 * s1 是 s2 的子串
 */
public class Inclusion {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        int[] value = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            //s2 取 开头和 s1 相等的部分 判断 是否重合 之后每次向右 一定一个单位
            value[s2.charAt(i) - 'a']++;
            value[s1.charAt(i) - 'a']--;
        }
        int diff = 0;
        for(int a : value){
            if(a!=0){
                diff++;
            }
        }
        if(diff == 0) return true;
        for(int j = s1.length();j< s2.length();j++){
            //s2 向右移动的过程中 遇到和弹出的字符相等的直接pass  但是for循环哪里是移动了的
            if(s2.charAt(j) == s2.charAt(j-s1.length())) continue;
            //当前为0 新加入的就会造成差异
            if(value[s2.charAt(j)-'a'] ==0){
                diff++;
            }
            value[s2.charAt(j)-'a']++;
            //如果是加入值后为0 则差异减少 diff --
            if(value[s2.charAt(j)-'a'] ==0){
                diff--;
            }
            //先处理新增的 后处理 退出的
            if(value[s2.charAt(j-s1.length())-'a'] ==0){
                diff++;
            }
            value[s2.charAt(j-s1.length())-'a']--;
            if(value[s2.charAt(j-s1.length())-'a'] ==0){
                diff--;
            }
            if(diff ==0 ) return true;
        }

        return false;
    }
}
