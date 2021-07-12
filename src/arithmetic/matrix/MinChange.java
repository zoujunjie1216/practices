package arithmetic.matrix;

public class MinChange {
    public static void main(String[] args) {
        System.out.println(change(new int[]{5,2,3},4));
    }
    public static int change(int[]a,int aim){
       //取最大值，看是否能除完//error 需修改
        sort(a);
        int m=0,n=0;
        while(aim%a[m]!=0){
            n+=aim/a[m];
            aim=aim%a[m];
            m++;
            if(m==a.length){
                System.out.println("得不到的");
                return -1;
            }
            }

        n+=aim/a[m];
        return n;
    }
    public static void sort(int[]a){
        //将数组内的值排序
        for(int i=0;i<a.length;i++){
            int b=a[i];
            for(int j=i;j<a.length;j++){
                if(a[j]>b){
                    a[i]=a[j];
                    a[j]=b;
                    b=a[i];
                }
            }
        }
    }
}
