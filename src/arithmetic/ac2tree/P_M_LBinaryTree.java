package arithmetic.ac2tree;

import java.util.Stack;

class NodeTree{
    public int val;
    public NodeTree left;
    public NodeTree right;

    public NodeTree(int data){
        this.val=data;
    }
}
public class P_M_LBinaryTree {
    public static void main(String[] args) {
        NodeTree a=new NodeTree(1);
        NodeTree b=new NodeTree(2);
        NodeTree c=new NodeTree(3);
        NodeTree d=new NodeTree(4);
        NodeTree e=new NodeTree(5);
        NodeTree f=new NodeTree(6);
        NodeTree g=new NodeTree(7);
        NodeTree h=new NodeTree(8);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=g;
        d.right=h;

        /*//先序遍历，
        PbinaryTree(a);
        System.out.println();
        NPbinaryTree(a);
        System.out.println();
        preErgodic(a);*/

        /* //中序遍历
        MbinaryTree(a);
        System.out.println();
        NMbinaryTree(a);
        System.out.println();
        midErgodic(a);*/

        //后序遍历
        LbinaryTree(a);
        System.out.println();
        lastRegodic(a);
        System.out.println();
        lastRegodic2(a);



    }
    public static void PbinaryTree(NodeTree node){
        //先序遍历，递归方法
        System.out.print(node.val+" ");
        if(node.left!=null) {
            PbinaryTree(node.left);
        }
        if(node.right!=null) {
            PbinaryTree(node.right);
        }
    }
    public static void MbinaryTree(NodeTree node){
        //中序遍历，递归方法
        if(node.left!=null) {
            MbinaryTree(node.left);
        }
        System.out.print(node.val+" ");
        if(node.right!=null) {
            MbinaryTree(node.right);
        }
    }
    public static void LbinaryTree(NodeTree node){
        //后序遍历，递归方法
        if(node.left!=null) {
            LbinaryTree(node.left);
        }
        if(node.right!=null) {
            LbinaryTree(node.right);
        }
        System.out.print(node.val+" ");
    }
    public static void NPbinaryTree(NodeTree node) {
        //非递归先序遍历
        Stack<NodeTree> stack = new Stack<NodeTree>();
        NodeTree tmp = node;
        if (tmp != null) {//节点非空
            dealP(tmp,stack);
            while (!stack.isEmpty()) {
                NodeTree rightNode = stack.pop();//然后将弹出的节点再进行轮流遍历
                dealP(rightNode,stack);
            }
        }
    }
    public static void dealP(NodeTree tmp,Stack<NodeTree> stack){//前序遍历方法
        while (tmp.left != null) {
            System.out.print(tmp.val + " ");
            //左节点不为空时，先将左节点输出，然后判断是否将右节点加入

            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            tmp = tmp.left;
        }
        System.out.print(tmp.val + " ");
        if(tmp.right!=null){
            stack.push(tmp.right);
        }
    }

    public static void NMbinaryTree(NodeTree node){
        Stack<NodeTree> stack=new Stack<NodeTree>();
        NodeTree tmp=node;
        if (tmp!=null){
            dealM(tmp,stack);
            while(!stack.isEmpty()){
                NodeTree next=stack.pop();
                System.out.print(next.val+" ");
                if(next.right!=null) {
                    dealM(next.right, stack);//轮流处理后返回
                }
            }
        }

    }
    public static void dealM(NodeTree tmp,Stack<NodeTree> stack){
        while(tmp.left!=null){
            stack.push(tmp);
            tmp=tmp.left;
        }
        stack.push(tmp);

    }

    public static void preErgodic(NodeTree nodeTree){
        //非递归先序遍历，最优算法
        Stack<NodeTree> stack=new Stack<NodeTree>();
        stack.push(nodeTree);
        while(!stack.isEmpty()){
            NodeTree head=stack.pop();
            System.out.print(head.val+" ");
            if(head.right!=null){
                stack.push(head.right);
            }
            if(head.left!=null){
                stack.push(head.left);
            }
        }
    }

    public static void midErgodic(NodeTree nodeTree) {
        //非遍历中序遍历最优解
        if (nodeTree != null) {
            Stack<NodeTree> stack = new Stack<NodeTree>();
            NodeTree head = nodeTree;
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head=head.right;
                }
            }
        }
    }

    public static void lastRegodic(NodeTree nodeTree){
        //非递归后续遍历最优解，双栈  核心思想是将第一个栈弹出的元素放进第二个栈中
        Stack<NodeTree> stack1=new Stack<NodeTree>();
        Stack<NodeTree> stack2=new Stack<NodeTree>();
        stack1.push(nodeTree);
        while (!stack1.isEmpty()){
            NodeTree head=stack1.pop();
            stack2.push(head);
            if(head.left!=null){
                stack1.push(head.left);
            }
            if(head.right!=null){
                stack1.push(head.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().val+" ");
        }
    }

    public static void lastRegodic2(NodeTree nodeTree) {
        //非递归后续遍历最优解，单栈  核心思想是判断当前栈顶元素和上一个弹出的元素是否相等，相等说明弹出过
        Stack<NodeTree> stack = new Stack<NodeTree>();
        stack.push(nodeTree);
        NodeTree pre = null;
        while (!stack.isEmpty()){
            NodeTree now = stack.peek();
            if(now.left!=null&&now.left!=pre&&now.right!=pre){
                stack.push(now.left);
            }else if(now.right!=null&&now.right!=pre){
                stack.push(now.right);
            }else {
                pre=stack.pop();
                System.out.print(pre.val+" ");
            }
        }
    }

}
