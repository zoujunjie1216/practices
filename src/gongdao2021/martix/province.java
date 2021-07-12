package gongdao2021.martix;

/**
 * 根据二维数组 获得省份数量
 * 二维数组代表两个城市是否直接相邻 多个相邻的城市代表一个省
 */
public class province {
    public int findCircleNum(int[][] M) {
        int length = M.length;
        int[] visited = new int[length];
        int fin = 0;
        for (int i = 0; i < length; i++) {
            if (visited[i] == 0) {
                //下面 递归层标记
                fin++;
                dfs(M, visited, i);
            }
        }
        return fin;
    }

    /**
     * 递归层 其实就是把和 当前节点相连的节点置1
     * */
    public void dfs(int[][] M, int[] visited, int y) {
        //如果没有被访问过
        //不能化简从 y 开始 因为如果1 和 4 相邻 ，从4开始就直接会跳过和4 相邻的部分
        for (int i = 0; i < M.length; i++) {
            if (M[y][i]==1 && visited[i] ==0){
                visited[i] = 1;
                //将和第i层相关的城市 标记
                dfs(M,visited,i);
            }
        }
    }
}
