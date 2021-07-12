package arithmetic.linkedlist;

public class YuesefuQuestion {
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
        node6.setNext(node1);
        System.out.println(josephusKill2(node1,2).getVal());
    }

    public static Node josephusKill2(Node head,int m){
        if(head==null||head.next==head||m<1){
            return head;
        }
        Node cur=head.next;
        int tmp=1;//tmp->list size
        while (cur!=head){
            tmp++;
            cur=cur.next;
        }
        int position=getPosition(tmp,m);//得到位置
        //找到位置，修改并返回
        cur=head;
        while (position--> 1) {
            cur=cur.next;
        }
        cur.next=cur;
        return cur;
    }

    public static int getPosition(int i,int m){
        //核心思想是算出删除某个位置后下一个删除的位置在原始位置里对应的位置，单只剩一个位置时为幸存位置
        if(i==1){
            return 1;
        }
        return (getPosition(i-1,m)+m-1)%i+1;
    }
}
