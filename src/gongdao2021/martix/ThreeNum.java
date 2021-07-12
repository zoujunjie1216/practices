package gongdao2021.martix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 求数组中是否存在三个数之和为0
 *
 * 双指针固定
 * */
public class ThreeNum {
    public List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> fin =new ArrayList();
     if(nums == null||nums.length<3){
         return fin;
     }
        Arrays.sort(nums);
     //左右节点 双边固定在循环里面实现
     /*int left = 0;
     int right = nums.length-1;*/
     //因为是不重复的三个数字 所以左边的指针最多是右边的前两位
     for (int a = 0;a<nums.length-2;a++){
         //a>0 是为了不数组越界 左边等于前一位的时候跳过 没有必要 其实可以不加
         if(a>0 && nums[a] == nums[a-1]){
            continue;
         }
         // 所以是固定单边 a 保证为 0的 这一组数据不重复
         int left = a+1;
         int right = nums.length -1;
         while (left < right ){
             int sum = nums[a] +nums[left]+nums[right];
             if(sum == 0){
                 fin.add(Arrays.asList(nums[a],nums[left],nums[right]));
                 //固定左边的情况下 可能有多种情况 所以需要同时移动 left right
                 // 但是需要注意移动和移动之前值一样的情况 加前面的是为了防止越界
                 while(left< right &&nums[left]==nums[left+1]){
                     left++;
                 }
                 while (right>left && nums[right]==nums[right-1]){
                     right--;
                 }
                 //祛除相同的数后 还有移动
                 right--;
                 left++;

             }else if(sum > 0){
                 right--;
             }else {
                 left++;
             }
         }
     }
     return fin;
    }
}
