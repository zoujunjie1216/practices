package gongdao2021.martix;

/**
 * 面积最大的岛屿
 * 核心思想是递归 然后将遍历过的位置值置0
 * */
public class MaxLand {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int cloumn = grid[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cloumn; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max,dfs(i,j,grid));
                }
            }
        }
        return max;
    }

    public int dfs(int i,int j,int[][] grid){
        //边界判断
        if(i<0||j<0||i>grid.length-1||j>grid[0].length-1||grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        int left =dfs(i,j-1,grid);
        int right =dfs(i,j+1,grid);
        int top =dfs(i-1,j,grid);
        int low =dfs(i+1,j,grid);
        return 1+left+right+top+low;
    }
}