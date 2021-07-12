package arithmetic.acstack;

import java.util.Stack;

public class acstack {
    //设计一个队列，用两个栈实现,实现队列的操作，
    Stack<Integer> stackpush = new Stack<Integer>();
    Stack<Integer> stackpop = new Stack<Integer>();

    public void push(Integer a) {
        //压入操作
        stackpush.push(a);
    }

    public Integer poll() {
        if (stackpop.isEmpty()) {
            if (stackpush.isEmpty()) {
                System.out.println("队列中没有可取整数！");
                return -1;
            } else {
                for (Integer a : stackpush) {
                    stackpop.push(a);
                }
            }
        }
        return stackpop.pop();
    }

    public Integer peek() {
        if (stackpop.isEmpty()) {
            if (stackpush.isEmpty()) {
                System.out.println("队列中没有可取整数！");
                return -1;
            } else {
                for (Integer a : stackpush) {
                    stackpop.push(a);
                }
            }
        }
        return stackpop.peek();

    }
}