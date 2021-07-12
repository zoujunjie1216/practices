package spring;


import java.util.*;

public class Test {
    private void test(){
        System.out.println("test");
    }

    private  void test1(){
        System.out.println("test1");
        List<Integer> a=new ArrayList<>();
        Collections.reverse(a);
    }
    public int[][] merge(int[][] intervals) {
        //先排序。然后遍历找到具有重合空间的两个数组
        List<int[]>fin=new ArrayList<int[]>();
        if(intervals==null) return fin.toArray(new int[0][]);;
        if(intervals.length==1) return intervals;
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        int[] temp;
        for(int i=0;i<intervals.length;i++){
            temp=new int[2];
            temp[0]=intervals[i][0];
            temp[1]=intervals[i][1];
            while(i+1<intervals.length&&temp[1]>=intervals[i+1][0]){
                //具有重合的部分就将这两个数组合并
                temp[1]=Math.max(intervals[i+1][1],temp[1]);
                i++;
            }
            fin.add(temp);
        }
        return fin.toArray(new int[0][]);
    }
}
