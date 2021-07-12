package ac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
 *将那个棋子放在无限大的棋盘上，将i个棋子叠到一起所需要的步数
 * 输入三行 2
 * 4
 * 1249
 * 1111
 * 输出0 1 3 10
 */
public class chess {
    public static void main(String[] args) throws Exception {
       /* BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));//输入
        int n=Integer.parseInt(bf.readLine());
        String[] x=bf.readLine().split(" ");
        String[] y=bf.readLine().split(" ");
        int[] x_arr=trans(x);\

        int[] y_arr=trans(y);
        int[] distanse=new int[n];*/
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextInt()){
            int a=scanner.nextInt();
            int[] x=new int[a];
            int[] y=new int[a];
            for(int i=0;i<a;i++){
                x[i]=scanner.nextInt();
            }
            for(int i=0;i<a;i++){
                y[i]=scanner.nextInt();
            }
            int[] res=new int[a];
            for(int i=0;i<a;i++){
                res[i]=Integer.MAX_VALUE;
            }
            int[] distance=new int[a];


                for(int j=0;j<a;j++){
                    for(int k=0;k<a;k++){
                        distance[k]=Math.abs(x[k]-x[j])+Math.abs(y[k]-y[j]);
                    }
                    Arrays.sort(distance);
                    int temp=0;
                    for(int r=0;r<a;r++){
                        temp+=distance[r];
                        res[r]=Math.min(temp,res[r]);
                    }
                }

            for(int i=0;i<a-1;i++){
                System.out.println(res[i]+" ");
            }
                System.out.println(res[a-1]);
        }



    }
    /*public static int point(int[] arr){
      *//*  if(arr.length>0) {
            int min = arr[0], max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                min = arr[i] < min ? arr[i] : min;
                max = arr[i] > max ? arr[i] : max;
            }
        }*//*
      int sum;
      int minDistance;
      int [] count=new int[arr.length];
      for(int i=0;i<arr.length;i++){
          for(int j=0;j<arr.length;j++){

          }
      }
        return
    }*/

    public static int[] trans(String[] a){
        int[] b=new int[a.length];//数组转化，string--int
        for(int i=0;i<a.length;i++){
            b[i]=Integer.parseInt(a[i]);
        }
        return b;
    }

}
