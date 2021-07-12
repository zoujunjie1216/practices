package gongdao2021.DPandGreedy;

import java.util.List;

/**
 * 三角形最小路径和
 *
 * 从下往上遍历 最下面一层 其实就是打印的list
 * */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
      int[][] fin = new int[triangle.size()+1][triangle.size()+1];
      for(int i=triangle.size()-1;i>=0;i--){
          List<Integer> temp = triangle.get(i);
         for(int j = 0;j<temp.size();j++){
             fin[i][j]=Math.min(fin[i+1][j],fin[i+1][j+1]);
         }
      }
      return fin[0][0];
    }
}
