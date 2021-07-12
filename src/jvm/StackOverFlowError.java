package jvm;


import javax.tools.JavaCompiler;

public class StackOverFlowError {
    /**
     * vm args: -Xss128k
     * */
    private int stackLength=1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        StackOverFlowError oom=new StackOverFlowError();
        try{
            oom.stackLeak();
        }catch(Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }
}
