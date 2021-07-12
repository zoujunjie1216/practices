package arithmetic.acstack;

import java.util.Stack;

public class StackMin {
    //设计一个栈，拥有得到栈中最小元素的功能
    private Stack<Integer> stackData;
    private Stack<Integer> stackOp;
    public  StackMin(){
        this.stackOp=new Stack<Integer>();
        this.stackData=new Stack<Integer>();
    }
    public void push(Integer a){
        stackData.push(a);
        if(stackOp.isEmpty()){
            stackOp.push(a);
        }else if(stackOp.peek()>=a){
            stackOp.push(a);
        }
    }
    public int  pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int a=stackData.pop();
        if(a==stackOp.peek()){
            stackOp.pop();
        }
        return a;
    }
    public int getMin(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int a=stackOp.peek();
      return a;
    }

}
