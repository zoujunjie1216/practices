package arithmetic.ac2tree;

public class LookupTree {
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
        printlook(a);
    }
    public static void printlook(NodeTree nodeTree){
        printInorder(nodeTree,0,"H",17);
    }
    public static void printInorder(NodeTree nodeTree,int height,String to,int len){
        if(nodeTree==null){
            return;
        }
        printInorder(nodeTree.right,height+1,"↓",len);//先遍历右子树
        //输出逻辑，每个数的长度为17
        String val=to+nodeTree.val+to;
        int pre=(len-val.length())/2;
        int last=len-pre-val.length();
        String use=getspace(pre)+val+getspace(last);//拼凑出长度为17的输出值
        System.out.println(getspace(height*len)+use);
        printInorder(nodeTree.left, height+1, "↑", len);//后遍历左子树
    }
    public static String getspace(int len){
        StringBuffer stringBuffer=new StringBuffer();
        for(int a=0;a<len;a++){
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}
