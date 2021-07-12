package ac;

public class ArrayTest {
    //数组旋转。外圈打印，之字型打印
    public static void main(String[] args) {
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        ziprint(a);

    }
    public static void round(int[][] a ){//转圈打印
        int b=a.length;//保存尾行地址
        int c=a[0].length;//保存尾列地址
        int d=0;//保存首行地址
        int e=0;//保存首列地址
        int[][] f=new int[a.length][a[0].length];
        while(e<=c){
            for(int k=e;k<c;k++){
            System.out.println(a[d][k]);
        }
            for(int l=d+1;l<b;l++){
            System.out.println(a[l][c-1]);
        }
            for(int m=c-2;m>e;m--){
            System.out.println(a[b-1][m]);
        }
            for(int n=b-2;n>d;n--){
            System.out.println(a[n][e]);
        }
            d++;e++;b--;c--;
        }
    }
    public static void round2(int[][] a ){
        int b=a.length-1;//保存尾行地址
        int c=a[0].length-1;//保存尾列地址
        int d=0;//保存首行地址
        int e=0;//保存首列地址
        while(e<=c){
            int rc1=e;
            int rc2=c;
            int rr1=d;
            int rr2=b;
            while(rc1!=c){
                System.out.print(a[d][rc1]+" ");
                rc1++;
            }
            while(rr1!=b){
                System.out.print(a[rr1][c]+" ");
                rr1++;
            }
            while(rc2!=e){
                System.out.print(a[b][rc2]+" ");
                rc2--;
            }
            while(rr2!=d){
                System.out.print(a[rr2][e]+" ");
                rr2--;
            }
          b--;c--;d++;e++;
        }
    }
    public static void ziprint(int[][] a){
        //之字形打印
        int mr=0;
        int mc=0;//横向移动的点位的横纵坐标
        int nr=0;
        int nc=0;//纵向移动的点位的横纵坐标
        int endr=a.length-1;
        int endc=a[0].length-1;
        boolean dire=false;
        while(nc!=endc +1){
            ziprintchild(a,mr,mc,nr,nc,dire);
            mr=mc==endc?mr+1:0;
            mc=mc==endc?endc:mc+1;
            nc=nr==endr?nc+1:0;
            nr=nr==endr?endr:nr+1;

            dire=!dire;

        }
    }
    public static void ziprintchild(int[][]a ,int mr,int mc,int nr,int nc,boolean dire){
        if(dire==true){
            while(mr!=nr+1){
                System.out.print(a[mr++][mc--]+" ");
            }
        }else {
            while(nc!=mc+1){
                System.out.print(a[nr--][nc++]+" ");
            }
        }

    }


}
