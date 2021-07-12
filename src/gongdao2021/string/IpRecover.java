package gongdao2021.string;

import java.util.ArrayList;
import java.util.List;
/**
 * 给定一个字符串 还原成 ip
 * 回溯算法 经典例题
 * */
public class IpRecover {
    public List<String> restoreIpAddresses(String s) {
        //基础判断
        List<String> fin = new ArrayList<>();
        if(s.length()>12||s.length()<4){
            return fin;
        }
        backSum(fin,new ArrayList<String>(),s,0);
        return fin;
    }

    /**
     * 通过回溯 剪枝 祛除不满足的情况
     * @param child 因为需要记录当前这一种情况 暂时使用
     *
     * 这里的核心是 s 递归的条件
     * */
    public void backSum(List<String> fin,List<String> child,String s,int i){
        //一般都会有剪枝 筛选条件 递归也有
        if(child.size() == 4){
            if(i==s.length()){
                fin.add(String.join(".",child));
            }
            return;
        }
        //经典for循环 判断每一种情况 这里一个String 最大255 三位
        for(int m=1;m<4;m++){
            //因为边界判断的关系 时间实际上处理的就是长度对应的单位 substring长度左闭有开
            if(i+m >s.length()) break;
            String temp = s.substring(i,i+m);
            //以0 开头的数只能为 0 其他数 不存在   >255 也不成立
            if((temp.startsWith("0")&&temp.length()!=1)||Integer.valueOf(temp)>255) continue;
            child.add(temp);
            backSum(fin,child,s,i+m);
            child.remove(child.size()-1);
        }
    }
}
