package arithmetic.linkedlist;

public class reverse {
    public static Node rever(Node head) {
        if (head.next == null) return head;
        Node last = rever(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
         Node a=rever(node1);
       while(a!=null){
           System.out.println(a.getVal());
            a=a.next;
        }
    }
}
