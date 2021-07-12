package gongdao2021.binaryTree;


/**
 * 面试题 -leetcode 450
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * 当时给出的解是找到比他大的那个值去替换他  然后删掉替换值  -麻烦
 * 简单的做法是，返回右子节点，然后左子树变成右子节点最左边节点的左子树，因为右子树的所有节点都会比左子树大
 * */
public class DeleteTreeNode {
    public TreeNode deleteNode(TreeNode root, int key) {
       //当已经找到null 代表当前子树不存在目标值
        if(root == null) return null;

        if(root.val == key){
           //找到该值后处理
            if(root.left == null){
                //左子树为空的时候，直接返回右子树
                return root.right;
            }else if(root.right == null){
                //右子树为空的时候，直接返回左子树
                return root.left;
            }else{
                //左右子树都不为空 左子树连到右子树最左边 先找到右子树最小值
                TreeNode right = root.right;
                while(right.left != null){
                    right = right.left;
                }
                //将root 的左子树 放到 root右子树的最小节点
                right.left=root.left;
                //返回右子节点
                return root.right;
            }
       }else if(key > root.val){
          //如果该值小于 目标key 那么只有可能该值在右子树  那么该节点的右子树可能为新树
           root.right = deleteNode(root.right,key);
       }else {
           root.left = deleteNode(root.left,key);
       }
       //处理完成  返回root
       return root;
    }
}
