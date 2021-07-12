package arithmetic.String;

public class replaceStr {
    /**
     * 用字符串替换指定字符串
     * */
    public static void main(String[] args) {
        System.out.println(replace("a123123123bcd123","123","X"));
    }
    public static String replace(String str1,String str2,String str3){
        char[] a=str1.toCharArray();
        char[] b=str2.toCharArray();
        boolean flag=true;
        for(int i=0;i<a.length;i++){
            if(a[i]==b[0]){
                 for(int j=0;j<b.length;j++){
                     if(a[i+j]!=b[j]){
                         flag=false;
                         break;
                     }
                 }
                 //找到了指定字符串之后，将改区域内全部置为0
                 if (flag==true){
                    for (int k=0;k<b.length;k++){
                        a[i+k]=0;
                    }
                 }
            }
        }
        boolean open=true;
        StringBuilder str=new StringBuilder();
        //找到之后将000全部替换成指定字符串
        for (int i=0;i<a.length;i++){
            if(a[i]==0){
                if(open==true) {
                    str.append(str3);
                    open = false;
                }
            }else {
                str.append(a[i]);
                open=true;
            }
        }
        return str.toString();
    }
}
