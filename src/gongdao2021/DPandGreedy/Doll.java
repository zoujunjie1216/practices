package gongdao2021.DPandGreedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃问题
 * 当一个信封的长度和宽度 都大于（等于不算）
 * */
public class Doll {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                //n*2 根据宽度正序 高度逆序
                return a[0] == b[0]? b[1] - a[1]:a[0] - b[0];
            }
        });
        int[] temp = new int[envelopes.length];
        for(int i = 0;i<envelopes.length;i++){
            //长度  这样子之后就变成了一个根据长度求最长递增子序列的问题
            temp[i] = envelopes[i][1];
        }
        return lengthOfLIS(temp);
    }

    /**
     * 求数组的最长递增子序列问题
     *
     * dp 数组的每一格的最长子序列都是改位置之前的比他小的数加 1
     * */
    public int lengthOfLIS(int[] nums) {
        //本题的最长
        int[] temp =new int[nums.length];
        Arrays.fill(temp,1);
        for(int i=0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    //比较当前值和递归值
                    temp[j] = Math.max(temp[j],temp[i]+1);
                }
            }
        }
        //遍历一遍temp 数组，最大的值就是 最大的长度
        int max = 0;
        for(int i=0;i<nums.length;i++){
            max = Math.max(temp[i],max);
        }
        return max;
    }
}
