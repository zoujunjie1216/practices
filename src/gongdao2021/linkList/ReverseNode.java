package gongdao2021.linkList;

/**
 * 1.反转链表
 * 2.从倒数第n个节点开始反转
 * */
public class ReverseNode {
    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(1);
        LinkedListNode node1 = new LinkedListNode(2);
        LinkedListNode node2 = new LinkedListNode(3);
        LinkedListNode node3 = new LinkedListNode(4);
        LinkedListNode node4 = new LinkedListNode(5);
        LinkedListNode node5 = new LinkedListNode(6);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        reverse(node);
    }

    //递归解法
    public static LinkedListNode reverse(LinkedListNode node){
        if(node.next == null){
            return node;
        }
        LinkedListNode nextNode = reverse(node.next);
        //最经典的一步 返回的都是最底层的节点 当前节点的next 就是下一个节点
        node.next.next = node ;
        return nextNode;
    }

    //非递归解法
}
