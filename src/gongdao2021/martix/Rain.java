package gongdao2021.martix;

/**
 * 雨水- 专题
 * */
public class Rain {
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    public int trap(int[] height) {
        if(height.length<3 )return 0;
        //第一遍 使用数组记录每一个节点右边最高的高度
        int max = 0;
        int[] maxright = new int[height.length];
        int maxleft = height[0];
        int fin =0;
        for(int i=height.length -1;i>0;i--){
            maxright[i] = max;
            max = height[i]>max ? height[i]:max;
        }
        for (int i =1;i<height.length;i++){
            if(height[i]<maxleft&&height[i]<maxright[i]){
                fin += Math.min(maxleft,maxright[i])-height[i];
            }
            maxleft = maxleft>height[i]?maxleft:height[i];
        }
        return fin;
    }

    /**
     * 给定一个数组代表每个位子的高度 计算那两个柱子之间是可以获得最大的储水量
     *  最远的两个 柱子有最大储水量  向里收缩需要更高的柱子 才有可能获得更大储水量
     *  两个柱子矮的那个决定水量 所以移动矮的柱子
     * */
    public int maxContin(int[] height){
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left < right){
            //简化一下 每次移动前判断一下是否更新最大值
            max = Math.max(Math.min(height[left],height[right])*(right-left),max);
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
