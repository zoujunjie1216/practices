package arithmetic.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllSquence {
    public static void main(String[] args) {
        List<List<Integer>>fin=permute(new int[]{1,2,3});
        System.out.println("nihao");
    }
    public  static List<List<Integer>> permute(int[] nums) {
        //回溯算法解题,
        List<List<Integer>> output=new ArrayList<List<Integer>>();
        List<Integer> temp=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            temp.add(nums[i]);//将数组的值顺序加入到初始数组中
        }
        backsum(nums.length,output,temp,0);
        return output;
    }

    public  static void backsum(int len, List<List<Integer>> output, List<Integer> temp, int first){
        //确定开始位，数组长度
        if(first==len){
            output.add(new ArrayList<>(temp));//如果递归到数组长度为值，则是一个值，加入output
        }
        for(int i=first;i<len;i++){
            Collections.swap(temp,i,first);//交换需要交换的两位
            backsum(len,output,temp,first+1);//交换完递归进入下一位
            Collections.swap(temp,i,first);//递归完之后将两个值交换回给一个交换使用
        }
    }
}
