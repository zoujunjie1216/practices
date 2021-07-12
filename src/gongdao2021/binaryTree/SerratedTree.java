package gongdao2021.binaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 * 广度优先遍历
 * */
public class SerratedTree {

    public static void main(String[] args) {
        TreeNode node1 =new TreeNode(1);
        TreeNode node2 =new TreeNode(2);
        TreeNode node3 =new TreeNode(3);
        TreeNode node4 =new TreeNode(4);
        TreeNode node5 =new TreeNode(5);
        TreeNode node6 =new TreeNode(6);
        TreeNode node7 =new TreeNode(7);
        TreeNode node8 =new TreeNode(8);
        node1.left=node2;
        node1.right=node3;
        node2.left = node4;
        node2.right=node5;
        node3.left=node6;
        node3.right = node7;
        node4.left = node8;
        serratedTree(node1);
    }

    //二叉树层级打印（广度优先遍历）
    public static void printTree(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val+",");
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return ;
    }
    /**
     * 层级打印--需要打印出每一层
     * */
    public static void printTree2(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Integer level = 1;
        //两个指针 一个指向当前行最后一个 一个指向下一行最后一个
        TreeNode last = root;
        TreeNode nlast = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val+",");
            if(node.left != null){
                queue.offer(node.left);
                nlast =node.left;
            }
            if(node.right != null){
                queue.offer(node.right);
                nlast = node.right;
            }
            //触及的条件 poll的节点为当前行的最后一个节点 那么nlast 一定变成了下一行的最后一个节点
            // （queue为空时代表这是树的最后一个节点）
            if(node == last && !queue.isEmpty()){
                System.out.println("level" +(++level)+" : ");
                last = nlast;
            }
        }
        return ;
    }

    //返回一个list 锯齿形遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

     return null;
    }

    //返回一个String
    public  static String serratedTree(TreeNode root){
        if(root == null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int level = 1;
        TreeNode last =root;
        TreeNode nlast = null;
        //是否向右遍历
        boolean lr = true;
        while(!queue.isEmpty()){
            if(lr){
                root = queue.pollFirst();
                if(root.left != null){
                    queue.offerLast(root.left);
                    //不管从左到右还是从右到左 实际上都是加进去第一个值 为nlast
                    nlast = nlast == null ? root.left : nlast;
                }
                if(root.right != null){
                    queue.offerLast(root.right);
                    nlast = nlast == null ? root.right : nlast;
                }
            }else {
                root = queue.pollLast();
                if(root.right != null){
                    queue.offerFirst(root.right);
                    nlast = nlast == null ? root.right : nlast;
                }
                if(root.left != null){
                    queue.offerFirst(root.left);
                    nlast = nlast == null ? root.left : nlast;
                }
            }
            System.out.println(root.val);
            //触及的条件 poll的节点为当前行的最后一个节点 那么nlast 一定变成了下一行的最后一个节点
            // （queue为空时代表这是树的最后一个节点）
            if(root == last && !queue.isEmpty()){
                System.out.println("level" +(++level)+" : ");
                last = nlast;
                //因为上面的判断 这里需要清空 nlast
                nlast = null;
                lr = !lr;
            }
        }
       return null;
    }
}
