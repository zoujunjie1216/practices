package arithmetic.matrix;

public class MatrixPower {
    public static void main(String[] args) {
        int[][]a={{1,2},{2,1}};
        int[][]b={{1,2},{2,1}};
        int[][]e={{1,2},{1,1},{1,2}};
        int[][]c=muliMatrix(a,b);
        int[][]d=matrixpower(e,2);
        for(int i=0;i<c.length;i++){
            for(int j=0;j<c[0].length;j++){
                System.out.println(c[i][j]);
            }
        }
        for(int i=0;i<d.length;i++){
            for(int j=0;j<d[0].length;j++){
                System.out.println(c[i][j]);
            }
        }

    }
    public  static int[][] matrixpower(int[][]m,int p){
        //求矩阵的n次方
        int[][] res=new int[m.length][m[0].length];
        for(int i=0;i<res.length;i++){
            res[i][i]=1;
        }
        int[][] tmp=m;
        for(;p!=0;p>>=1){
            if((p&1)!=0){
               res=muliMatrix(res,tmp);
            }
            tmp=muliMatrix(tmp,tmp);
        }
        return res;
    }
    public static int[][] muliMatrix(int[][]m1,int[][] m2){
        int res[][]=new int[m1.length][m2[0].length];
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m2[0].length;j++){
                for(int k=0;k<m2.length;k++){
                    res[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
}
