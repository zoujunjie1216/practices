package arithmetic.array;

import java.util.Arrays;
import java.util.Comparator;

public class Enevlops {
    public int maxEnvelopes(int[][] envelopes) {
        //宽度从小到大排序，如果宽度相等则将长度从大到小排序
        //这样子之后就变成了一个根据长度求最长递增子序列的问题
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]==b[0]?b[1]-a[1]:b[0]-a[0];
            }
        });
        //创建长度数组
        int[] temp=new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            temp[i]=envelopes[i][1];
        }
        return lengthOfLIS(temp);
    }

    public int lengthOfLIS(int[] nums) {
        //本题核心思想是从后往前遍历
        int[] dp=new int[nums.length];
        //每一个单元的最小值都至少为1
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                //当前值小于dp目标值，则判断dp值的最大值
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        //遍历一遍dp 拿到最大值
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
