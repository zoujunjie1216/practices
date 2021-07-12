package arithmetic.acstack;

import java.util.Stack;

public class StackReverse {
    //只用一个栈实现栈的反转，不使用其他任何数据结构
    //使用动态递归方法实现，不使用的方法还在思考，
    //动态递归的作用是将节点卡在某一步之后就进行下一个节点的操作
    public int getAndRemoveLast(Stack<Integer> stack){
        int a=stack.pop();
        if(stack.isEmpty()){
            return a;
        }else {
            int i=getAndRemoveLast(stack);
            stack.push(a);
            return i;
        }
    }
    public void reveser(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }else {
            int i=getAndRemoveLast(stack);
            reveser(stack);
            stack.push(i);
        }
        System.out.println();
    }


}
