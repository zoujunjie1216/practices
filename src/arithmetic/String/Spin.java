package arithmetic.String;

public class Spin {
    public static void main(String[] args) {
        if(spin("abcdef","bcdfea")==-1){
            System.out.println("no");
        }else{
            System.out.println("yes");
        }
    }
    public static int spin(String a,String b){
        String c=b+b;
        return c.indexOf(a);
    }
}
