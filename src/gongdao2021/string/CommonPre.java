package gongdao2021.string;

/**
 * 多个字符串最大公共前缀
 * */
public class CommonPre {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1 ) return strs[0];

        String re = strs[0];
        for(int i=1;i<strs.length;i++){
            String com = strs[i];
            //定义遍历的长度 其实就是数组中的string 两两比较 每次将common 部分放进re
            int j =0;
            for (;j<re.length()&&j<com.length();j++){
                if(re.charAt(j) != com.charAt(j)){
                    //跳出本次循环
                    break;
                }
            }
            //获取公共的String
            re = re.substring(0,j);
        }
        return re;
    }
}
