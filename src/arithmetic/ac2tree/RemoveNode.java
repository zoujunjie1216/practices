package arithmetic.ac2tree;

class Node{
    public int value;
    public Node next;
    public Node(int data){
        this.value=data;
    }
}
public class RemoveNode {
    public static void main(String[] args) {
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        System.out.println((int)Math.ceil(6.5));
        System.out.println((int)Math.floor(6.5));
        //removeab(a,5,6);//System.out.println(removemid(a));
        //removeLastKNode(a,2);
    }
    public static Node removeLastKNode(Node head,int k){
        if(head==null||k<1){//单链表移除倒数某个节点,双链表与单链表删除倒数第k个节点的方法一致，需要注意链表的重连
            return head;
        }else {
            Node node=head;
            while(node!=null){
                node=node.next;
                k--;
            }
            if(k>0){
                System.out.println("没有倒数第k个节点");
            }
            if(k==0){
                System.out.println(head.value);
            }
            if(k<0){
                while (k!=0){
                    head=head.next;
                    k++;
                }
                System.out.println(head.value);
            }
        }
         return head;
    }
    public static Node resverNode(Node head){//单链表反转
        Node pre=null;
        Node next;
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
    public static Node  removemid(Node a){
        //移除链表中间的节点0,1-不移除，2移除-1，3移除1，四移除二
        //链表操作的基本思想是用指针移动来确定位置
        if(a==null||a.next==null) {
            return a;
        }
        if(a.next.next==null) {
            Node next = a.next;
            a.next = null;
            return next;
        }
        Node pre=a;
        Node next=a.next.next;
        while (next.next!=null&&next.next.next!=null) {
            pre = pre.next;
            next = next.next.next;
        }
           pre.next=pre.next.next;
        return a;
       /* int k=0;
        int b=0;
        if(a==null||a.next==null){
            System.out.println("不会移除结点");
        }
        while(a!=null){
            k++;
            a=a.next;
            if(k==2){
                b=1;
            }else {
                b=(k+1)/2;
            }*/
    }
    public static Node removeab(Node e,int a,int b){
        //移除链表中间的b/a出的结点
        if(a<=0||a>b){
            return e;
        }
        int n=0;
        Node head=e;
        while(head!=null){
            head=head.next;
            n++;
        }
        int m=(int)Math.ceil((double)(n*a)/(double)b);
        if(m==1){
            e=e.next;
            return e;
        }else {
            int k=2;
            Node l=e;
            while (k!=m){
                l=l.next;
                k++;
            }
            l.next=l.next.next;
            return e;
        }

    }
}
