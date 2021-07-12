package gongdao2021.martix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 核心思想是 将数组内集合排序 然后 根据a[i][1]和a[i+1][0] 比较进行合并
 * int[] temp =new int[2];
 * if(i+1<arr.length&&arr[i][1]>=arr[i+1][0])
 * */
public class mergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list =new ArrayList<>();
        if (intervals == null) return list.toArray(new int[0][]);
        if(intervals.length == 1) return intervals;
        //排序 从小到大排序 a-b
        Arrays.sort(intervals,((o1, o2) -> o1[0]-o2[0]));
        for(int i=0;i<intervals.length;i++){
            //二维数组就是一维数组的的数组集合
            int[] temp =new int[2];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            while (i+1<intervals.length&&temp[1]>=intervals[i+1][0]){
                temp[1] = Math.max(temp[1],intervals[i+1][1]);
                i++;
            }
            list.add(temp);
        }
        return list.toArray(new int[0][]);
    }
}
