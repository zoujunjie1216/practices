package arithmetic.ac2tree;

public class Anti_clockwise {
    public static void main(String[] args) {
        NodeTree a=new NodeTree(1);
        NodeTree b=new NodeTree(2);
        NodeTree c=new NodeTree(3);
        NodeTree d=new NodeTree(4);
        NodeTree e=new NodeTree(5);
        NodeTree f=new NodeTree(6);
        NodeTree g=new NodeTree(7);
        NodeTree h=new NodeTree(8);
        NodeTree i=new NodeTree(9);
        NodeTree j=new NodeTree(10);
        NodeTree k=new NodeTree(11);
        NodeTree l=new NodeTree(12);
        NodeTree m=new NodeTree(13);
        NodeTree n=new NodeTree(14);
        NodeTree o=new NodeTree(15);
        NodeTree p=new NodeTree(16);
        a.left=b;
        a.right=c;
        b.right=d;
        c.left=e;
        c.right=f;
        d.right=h;
        d.left=g;
        e.left=i;
        e.right=j;
        h.right=k;
        i.left=l;
        k.left=m;
        k.right=n;
        l.left=o;
        l.right=p;
        //1.求树的高度，求完之后建立树高的数组依次将数组最左和最右边的节点翻入数组
        //2.求出每一层最左最右
        sout(a);
        System.out.println();
        soutway2(a);
        //第二种需要判断该节点的父节点是否为最左或者最有节点，是才可以将其打印出来，但是无法选中后对其父节点进行判断所以需要在ergodic是判断
    }

    public static int getHeight(NodeTree node,int m) {//求树高，递归做法
       if(node==null){
           return m;
       }else {
           return Math.max(getHeight(node.left,m+1),getHeight(node.right,m+1));
       }
    }
    public static void setArr(NodeTree node,int m,NodeTree[][] arr){
       if(node==null){
           return;
       }else{
           arr[m][0]=arr[m][0]==null?node:arr[m][0];//第一次处理的节点为最左边的节点，之后每次进行判断即可
           arr[m][1]=node;//当前节点一定是最右边的节点
           //ergodic所有层
           setArr(node.left,m+1,arr);
           setArr(node.right,m+1,arr);
       }
    }
    public static void sout(NodeTree node) {
        if(node==null){
            return;
        }
        int height=getHeight(node,0);
        NodeTree arr[][]=new NodeTree[height][2];
        setArr(node,0,arr);
        //输出最左边的节点
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i][0].val+" ");
        }
        //输出最后一层的不属于最左最右的叶子节点
        soutLastLeaf(node,0,arr);
        //输出最右边的节点，且不属于最左边的节点
        for(int i=arr.length-1;i>=0;i--){
            if (arr[i][1]!=arr[i][0]){
                System.out.print(arr[i][1].val+" ");
            }
        }
    }
    public static void soutLastLeaf(NodeTree node,int l,NodeTree[][] a) {
        if(node==null){
            return;
        }else if (node.left==null&&node.right==null&&node!=a[l][0]&&node!=a[l][1]){
            System.out.println(node.val);
        }
        soutLastLeaf(node.left,l+1,a);
        soutLastLeaf(node.right,l+1,a);
    }

   /* public static int getHeight(NodeTree node){//求树高，非递归做法
        Stack<NodeTree> stack1=new Stack<NodeTree>();
        Stack<NodeTree> stack2=new Stack<NodeTree>();
        stack1.push(node);
        int a=0;
         while(!stack1.isEmpty()||!stack2.isEmpty()){
             if(!stack1.isEmpty()) {
                 while (!stack1.isEmpty()) {
                     NodeTree nodeTree1=stack1.pop();
                     if(nodeTree1.left!=null){
                         stack2.push(nodeTree1.left);
                     }
                     if(nodeTree1.right!=null){
                         stack2.push(nodeTree1.right);
                     }
                 }
             a++;
             }
             if(!stack2.isEmpty()){
                 while(!stack2.isEmpty()){
                     NodeTree nodeTree1=stack2.pop();
                     if(nodeTree1.left!=null){
                         stack1.push(nodeTree1.left);
                     }
                     if(nodeTree1.right!=null){
                         stack1.push(nodeTree1.right);
                     }
                 }
                 a++;
             }
         }
         return a;
    }*/
   /*public static void way2print(NodeTree nodeTree){
       if(nodeTree==null){
           return;
       }else {
           System.out.print(nodeTree.val+" ");
           if(nodeTree.left!=null&&nodeTree.right!=null){
              printleft(nodeTree.left,true);
              printRight(nodeTree.right,true);
           }else {
               way2print(nodeTree=nodeTree.left==null?nodeTree.right:nodeTree.right);//放回当前单个字节点的左或者右节点
           }
       }
   }
   public static void printleft(NodeTree nodeTree,boolean bool){
     if(nodeTree==null){
         return;
     }else {
         if((nodeTree.left==null&&nodeTree.right==null)||bool){
             System.out.print(nodeTree.val+" ");
         }
         printleft(nodeTree.left,bool);
         printleft(nodeTree.right,bool&&(nodeTree.left==null?true:false));
     }
   }
   public static void printRight(NodeTree nodeTree,boolean bool){
      if(nodeTree==null){
          return;
      }else {
          printRight(nodeTree.left,bool&&nodeTree.left==null?true:false);
          printRight(nodeTree.right,bool);
          if(bool||(nodeTree.left==null?true:false)){
              System.out.print(nodeTree.val+" ");
          }
      }
    }*/

   public static  void soutway2(NodeTree nodeTree){
       if(nodeTree==null){
           return;
       }else {
           System.out.print(nodeTree.val+" ");
           if(nodeTree.left!=null&&nodeTree.right!=null){
               printleft(nodeTree.left,true);
               printright(nodeTree.right,true);
           }else {
               soutway2( nodeTree.left==null?nodeTree.right:nodeTree.left);
           }
       }
   }
   public static  void printleft(NodeTree nodeTree,boolean bool){
       if(nodeTree==null){
           return;
       }else {
           if(bool||(nodeTree.left==null&&nodeTree.right==null)){
               System.out.print(nodeTree.val+" ");
           }
           printleft(nodeTree.left,true);
           printleft(nodeTree.right,bool&&(nodeTree.left==null?true:false));
       }
   }
   public static void printright(NodeTree nodeTree,boolean bool){
       if(nodeTree==null){
           return;
       }else {
           printright(nodeTree.left,bool&&(nodeTree.right==null?true:false));
           printright(nodeTree.right,bool);
           if(bool||(nodeTree.left==null&&nodeTree.right==null)) {
               System.out.print(nodeTree.val + " ");
           }
       }
   }


}
