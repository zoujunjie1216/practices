package arithmetic.acstack;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        StackReverse a=new StackReverse();
        a.reveser(stack);


    }
}
