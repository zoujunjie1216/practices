package gongdao2021.binaryTree;

/**
 * 二叉树的最近公共祖先（这种应该是两个节点一定在树中的解法）
 *
 * */
public class leastParent {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当 root 等于其中一个值 如果另外半边递归找到 那该节点为父节点
        //如果另外半边没有找到 那么 两个节点都在这一边 当前节点为父节点
        if(root == null||p == root && q == root){
            return root;
        }
        if(root != null){
            TreeNode left =lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            //两个节点在左右子树
            if(left != null&&right!=null){
                return root;
                //两个节点都在左子树
            }else if(left != null){
                return left;
            }else {
                return right;
            }
        }
        //到了尾部为null 节点 返回null
        return null;
    }

    /**
     * 如果题目是二叉搜索树 那么
     * */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //那么只有两种情况
        //当root 节点值大于q p 那么 递归到左子树
        if(root.val>p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        //当root 节点值小于q p 那么 递归到右子树
        if(root.val < p.val && root.val <q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //这是root 等于其中一个节点的val 的情况
        return root;
    }
}
