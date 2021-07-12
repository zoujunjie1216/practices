package gongdao2021.DPandGreedy;

/**
 * 最大的正方形
 * 其实就是判断改位置上面 左边 和 左上角 三个位置 的最小值+1
 * */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
         int row = matrix.length;
         if(row<1) return 0;
         int cloumn = matrix[0].length;
         if(cloumn < 1) return 0;
         //多加一行 从第二行开始
         int[][] fin =new int[row+1][cloumn+1];
         int max=0;
         //边界条件  需要=length时仍可以处理 因为下面的条件是 matrix[i-1][j-1] == '1'
         for (int i=1;i<=row;i++){
             for(int j=1;j<=cloumn;j++){
                 //字符比较
                 if(matrix[i-1][j-1] == '1'){
                     //上面 左边 和 左上角 三个位置 的最小值+1
                   fin[i][j] = Math.min(Math.min(fin[i-1][j],fin[i][j-1]),fin[i-1][j-1])+1;
                   max = Math.max(fin[i][j],max);
                 }
             }
         }
         //返回的是面积
         return max*max;
    }
}
