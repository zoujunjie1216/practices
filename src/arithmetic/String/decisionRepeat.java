package arithmetic.String;

public class decisionRepeat {
    /**
     * 判断是否出现重复的值
     * 1.时间复杂度为O(n)
     * 2.空间复杂度为O(1)，时间复杂度要做到尽量低
     * */
    public static void main(String[] args) {
        System.out.println("是否重复:"+isunique("wqerr".toCharArray()));
    }

    public static String isunique(char[] chars){
        if(chars==null){
            return "不重复";
        }
        boolean[] booleans=new boolean[256];
        int i=0;
        while (i<chars.length){
           if(booleans[chars[i]]){
               return "重复";
           }else {
               booleans[chars[i]]=true;
               i++;
           }
        }
        return "不重复";
    }

    public static String isunique2(char[] chars){
         return "aaaaaa";
    }
}
