package arithmetic.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class sumNumbers {
    public static void main(String[] args) {
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        a.left=b;
        a.right=c;
        int d=sumNumbers(a);
    }
    public static int sumNumbers(TreeNode root) {
        int sum=0;
        //bfs
        LinkedList <TreeNode> bfs=new LinkedList<TreeNode>();
        bfs.add(root);
        while(!bfs.isEmpty()){
           //计算节点值
            int level=0;
            int length=bfs.size();
            for(int i=0;i<length;i++){
                TreeNode node=bfs.pop();
                if(node!=null){
                    level+=node.val;
                    bfs.add(node.left);
                    bfs.add(node.right);
                }
            }
           if(level!=0){
               sum=sum*10*length+level;
           }
        }
        return sum;
    }
}
