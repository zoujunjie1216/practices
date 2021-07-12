package gongdao2021.martix;

import java.util.Arrays;

/**
 * 获取数组的排列列表
 * 排列序列
 *
 * 经典回溯（全排列才是）
 * */
public class NextPermutation {
    //hard 难度 先写下面的 next 排列 medinum
    public String getPermutation(int n, int k) {
        return null;
    }

    //下一个排列 获取跟定数列的下一个更大的数列
    // 核心思想是 一个数从后往前 找到第一个前一个数<后一个数的值
    // 类似12543 需要找到2 然后 交换 2 3 的值 剩下的排序 就可以了
    //
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length <= 1) return;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                int min = 0;
                //上面是i-1 位选出
                for(int j = nums.length-1;j>=i;j--){
                    //这里可能是 12543 或者 13542 所以不是选后面最小的 而是 选
                    // 比第二位大的里面最小的  因为后面又是倒序的 所以 直接比较
                    // 找第一个比他大的就跳出循环
                    if(nums[i-1]<nums[j]){
                        min = j;
                        break;
                    }
                }
                //交换 这两个值 i 和 i后面的最小值 min
                int temp =nums[i-1];
                nums[i-1] =nums[min];
                nums[min]=temp;
                //左臂右开
                Arrays.sort(nums,i,nums.length);
                return;
            }
        }
        //遍历完成没有返回 说明是一个desc 数组 根据题目 返回 排序数组
        Arrays.sort(nums);
    }
}
