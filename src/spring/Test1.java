package spring;

public class Test1 {
    public static Node squence(Node node,Node node2){
         Node head=null;
         Node pre=null;
        while(node!=null&node2!=null) {
            Node temp = new Node();
            if (node.val <= node2.val) {
                temp.val = node.val;
                if (head == null) head = temp;
                if (pre != null) pre.next = temp;
                pre = temp;
                node=node.next;
            } else {
                temp.val = node2.val;
                if (head == null) head = temp;
                if (pre != null) pre.next = temp;
                pre = temp;
                node2=node2.next;
            }
        }
            while(node!=null){
                Node temp=new Node();
                temp.val=node.val;
                pre.next=temp;
                node=node.next;
            }
            while(node2!=null){
                Node temp=new Node();
                temp.val=node2.val;
                pre.next=temp;
                node2=node2.next;
            }
            return head;
        }


    public static void main(String[] args) {
        Node node1=new Node();
        Node node2=new Node();
        Node node3=new Node();
        Node node4=new Node();
        Node node5=new Node();
        Node node6=new Node();
       node1.setVal(1);
       node1.next=node3;
        node2.setVal(2);
        node2.next=node4;
        node3.setVal(3);
        node3.next=node5;
        node4.setVal(4);
        node4.next=node6;
        node5.setVal(5);
        node6.setVal(6);
        Node fin=squence(node2,node1);

        System.out.println("1");
    }
}
