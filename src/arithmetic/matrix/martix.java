package arithmetic.matrix;

public class martix {//牛生小牛问题，新生小牛三年后才能生牛，问n年后有多少小牛
    public static void main(String[] args) {
        System.out.println(total(9));
    }
    public static int total(int a){
        if(a<1){
            return 0;
        }
        if(a==1||a==2||a==3){
            return a;
        }
        if(a>3){
            int[][] tmp={{1,1,0},{0,0,1},{1,0,0}};
            int[][] res=martixride(tmp,a-3);
            return 3*res[0][0]+2*res[1][0]+res[2][0];
        }return 1;
    }

    public static int[][] martixpower(int[][] x, int[][] y) {
        if (x[0].length != y.length) {
            System.out.println("矩阵无法相乘！");
            return null;
        }
        int[][] tmp = new int[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < x[0].length; k++) {
                    tmp[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        return tmp;
    }

    public static int[][] martixride(int[][] tmp, int n) {
        int[][] res = new int[tmp.length][tmp.length];
        for (int i = 0; i < res.length; i++)
            res[i][i] = 1;//先将矩阵设为单位矩阵

        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = martixpower(res, tmp);
            }
            tmp = martixpower(tmp, tmp);
        }
       /* while (n >> 1 != 0) {
            if ((n & 1) != 0) {
                res = martixpower(res, tmp);
            }
            tmp = martixpower(tmp, tmp);
        }*/
       return res;
    }
}
