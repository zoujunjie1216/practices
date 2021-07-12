package gongdao2021.martix;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 全排列 回溯+剪枝（这一题不用剪枝 第n个排列需要）
 * */
public class AllPermutation {

    public static void main(String[] args) {
        List<List<Integer>> a = permute(new int[]{1, 2, 3});
    }

    //当前这种做法是将nums中的两个数进行交换 非经典递归解法
    public static List<List<Integer>> permute(int[] nums) {
        //回溯部分
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //解法1 需要 解法2 祛除
       /* for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }*/
       //解法1
        //backSum(nums.length, re, temp, 0);
        //解法 2
        backSumTra(nums.length,re,temp,new boolean[nums.length],nums);
        return re;
    }

    //数组长度 输出  nums（list） 开始位子
    public static void backSum(int len, List<List<Integer>> output, List<Integer> temp, int first) {
        //剪枝条件
        if (first == len) {
            output.add(new ArrayList<>(temp));
            //长度已经超过了 进入for循环也是不满足条件
        }
        //从开始的位置 和后面的数值进行交换
        for (int i = first; i < len; i++) {
            //这里就是要和自身进行交换 消耗一次交换 是first +1
            // 所以 123 输出的顺序是 123 132  213  231 321（1 3交换位置 其他不动） 312
            Collections.swap(temp, i, first);
            //first+1
            backSum(len, output, temp, first + 1);
            Collections.swap(temp, i, first);
        }
    }

    //经典解法是 选择一个值加入List 达到长度 就输出到list
    public static void backSumTra(int len, List<List<Integer>> output, List<Integer> temp, boolean[] used, int[] nums) {
        //剪枝条件
        if (temp.size() == len) {
            output.add(new ArrayList<>(temp));
            //长度已经超过了 进入for循环也是不满足条件
        }
        for (int i = 0; i < len; i++) {
            if (used[i] == true) continue;
            temp.add(nums[i]);
            used[i] = true;
            backSumTra(len, output, temp, used, nums);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
