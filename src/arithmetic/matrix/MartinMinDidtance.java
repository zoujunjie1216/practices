package arithmetic.matrix;

import java.util.Stack;

public class MartinMinDidtance {
    //取矩阵最小路径和，并输出最小路径
    //动态规划问题
    public static void main(String[] args) {
        int a[][] = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int b[][] = new int[a.length][a[0].length];
        getMinArr(a,b);
        getminway(a,b);
    }

    public static void getMinArr(int[][] a, int[][] b) {
        //将矩阵变为路径值
        //需要先将第一排和第一列的值算出来，否则数组越界
        initArr(a,b);
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a[0].length; j++) {
                    b[i][j] = b[i - 1][j] < b[i][j - 1] ? (a[i][j] + b[i - 1][j]) : (b[i][j - 1] + a[i][j]);
            }
        }
        return;
    }
    public static void initArr(int[][]a,int[][]b){
        b[0][0]=a[0][0];
        for(int i=1;i<a.length;i++){
            b[i][0]=b[i-1][0]+a[i][0];
            b[0][i]=b[0][i-1]+a[0][i];
        }
    }
    public static void getminway(int[][]a,int[][]b){
        //从终点向上遍历找到最短路径
       /* Stack<Integer> stack=new Stack<>();
        Integer m=b.length;
        int n=b[0].length;
        int k=b[m][n];
        stack.push(m);*/
        //从起点向终点找
        int m=0;
        int n=0;
        int k=b.length;
        int l=b[0].length;
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(a[0][0]);//头
        while(m<b.length-1&&n<b[0].length-1){
            //当数组两边都小于边界是可以循环查找，一遍到头后继续会数组越界异常
            if(b[m+1][n]<b[m][n+1]){
                stack.push(a[m+1][n]);
                m++;
            }else {
                stack.push(a[m][n+1]);
                n++;
            }
        }
        //一边到头后可以直接取完最后一列或一行的数值
        for(;m<b.length-1;m++){
          stack.push(a[m+1][n]);
        }
        for(;n<b[0].length-1;n++){
            stack.push(a[m][n+1]);
        }
        System.out.println("ok");
    }

}
