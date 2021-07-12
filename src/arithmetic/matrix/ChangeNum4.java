package arithmetic.matrix;

public class ChangeNum4 {
    public static void main(String[] args) {
        System.out.println(changeWay(new int[]{5,2,3},20));
    }
    public  static int changeWay(int[] arr,int aims){
        if(arr==null||arr.length==0||aims<=0){
            return 0;
        }
        int[] a=new int[aims+1];//将第一个地址设为1
        a[0]=1;
        for(int i=1;arr[0]*i<=aims;i++){
            a[i*arr[0]]=1;//将第一排的为数组倍数的值设为1
        }
        for(int i=1;i<arr.length;i++) {
            for (int j = 1; j < aims + 1; j++) {
                //从第二排开始循环
                if(j>=arr[i]) {
                    a[j] = a[j - arr[i]] + a[j];
                }
            }
        }
    return a[aims];
    }
}
