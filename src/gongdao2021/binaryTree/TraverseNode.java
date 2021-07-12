package gongdao2021.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 遍历二叉树 - 非递归的方式
 */
public class TraverseNode {
    /**
     * 递归方式
     * */
    public void travel(TreeNode node) {
        if (node == null) return;
        travel(node.left);
        System.out.println("中序遍历");
        travel(node.right);
    }

    /**
     * 二叉树转成链表  不能直接递归（链表会被打断 获取不到完整的结构） 需要先转成list
     * */
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }


    /**
     * 非递归方式  前中后 遍历
     * */
    public void preTravel(TreeNode node){

    }

    public void minTravel(TreeNode node){

    }

    public void lastTravel(TreeNode node){

    }

}
