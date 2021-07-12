package arithmetic.ac2tree;



import java.util.LinkedList;
import java.util.Queue;

public class SerailizeTree {
    public static void main(String[] args) {
        NodeTree a = new NodeTree(1);
        NodeTree b = new NodeTree(2);
        NodeTree c = new NodeTree(3);
        NodeTree d = new NodeTree(4);
        NodeTree e = new NodeTree(5);
        NodeTree f = new NodeTree(6);
        NodeTree g = new NodeTree(7);
        NodeTree h = new NodeTree(8);
        NodeTree i = new NodeTree(9);
        NodeTree j = new NodeTree(10);
        NodeTree k = new NodeTree(11);
        NodeTree l = new NodeTree(12);
        NodeTree m = new NodeTree(13);
        NodeTree n = new NodeTree(14);
        NodeTree o = new NodeTree(15);
        NodeTree p = new NodeTree(16);
        a.left = b;
        a.right = c;
        b.right = d;
        c.left = e;
        c.right = f;
        d.right = h;
        d.left = g;
        e.left = i;
        e.right = j;
        h.right = k;
        i.left = l;
        k.left = m;
        k.right = n;
        l.left = o;
        l.right = p;
        String sbreturn = "1!2!#!4!7!#!#!8!#!11!13!#!#!14!#!#!3!5!9!12!15!#!#!16!#!#!#!10!#!#!6!#!#!";
        returnserailizetree(sbreturn);
        System.out.println(serailizetree(a));
        System.out.println(way2serailizetree(a));
        way2returnserailizetree("1!2!3!#!4!5!6!7!8!9!10!#!#!#!#!#!11!12!#!#!#!13!14!15!16!#!#!#!#!#!#!#!#!");
        System.out.println();
    }

    public static String serailizetree(NodeTree nodeTree) {
        StringBuffer sb = new StringBuffer();
        if (nodeTree == null) {
            sb.append("#!");
        } else {
            sb.append(nodeTree.val + "!");
            sb.append(serailizetree(nodeTree.left));
            sb.append(serailizetree(nodeTree.right));
        }
        return sb.toString();
    }

    public static void returnserailizetree(String sbreturn) {
        String[] tmp = sbreturn.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < tmp.length; i++) {
            queue.offer(tmp[i]);
        }
        NodeTree nodeTree = ergodicqueue(queue);
    }

    public static NodeTree ergodicqueue(Queue<String> queue) {
        String tmp = queue.poll();
        if (tmp.equals("#")) {
            return null;
        } else {
            NodeTree nodeTree = new NodeTree(Integer.parseInt(tmp));
            nodeTree.left = ergodicqueue(queue);
            nodeTree.right = ergodicqueue(queue);
            return nodeTree;
        }
    }

    public static String way2serailizetree(NodeTree nodeTree) {
        Queue<NodeTree> queue = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer(nodeTree.val + "!");
        queue.offer(nodeTree);
        while (!queue.isEmpty()) {
            NodeTree tmp = queue.poll();
            if (tmp.left != null) {
                stringBuffer.append(tmp.left.val + "!");
                queue.offer(tmp.left);
            } else {
                stringBuffer.append("#!");
            }
            if (tmp.right != null) {
                stringBuffer.append(tmp.right.val + "!");
                queue.offer(tmp.right);
            } else {
                stringBuffer.append("#!");
            }
        }
        return stringBuffer.toString();
    }

    public static NodeTree way2returnserailizetree(String s) {
        String[] tmp = s.split("!");
        Queue<NodeTree> queue = new LinkedList<NodeTree>();
        int now=0;
        NodeTree nodeTree=generatetoint(tmp[now++]);
        queue.offer(nodeTree);
        while(!queue.isEmpty()){
            NodeTree tmpnode=queue.poll();
            tmpnode.left=generatetoint(tmp[now++]);
            tmpnode.right=generatetoint(tmp[now++]);
            if(tmpnode.left!=null){
                queue.offer(tmpnode.left);
            }
            if(tmpnode.right!=null){
                queue.offer(tmpnode.right);
            }
        }
        return nodeTree;
    }


    public static NodeTree generatetoint(String val) {
        if (val.equals("#")) {
            return null;
        } else {
            return new NodeTree(Integer.parseInt(val));
        }
    }
}
