package arithmetic.linkedlist;

public class getSqueue {
    /**
     * 讲一个链表变成左边小，中间相等，右边大的顺序结构
     *
     * */
    public static void main(String[] args) {
        Node node1=new Node(2);
        Node node2=new Node(2);
        Node node3=new Node(6);
        Node node4=new Node(1);
        Node node5=new Node(5);
        Node node6=new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        Node node7=squeue(node1,3);
        System.out.println(1);
    }

    public static Node squeue(Node head,int value){
         Node heads=null;
         Node heade=null;
         Node middles=null;
         Node middlee=null;
         Node laste=null;
         Node lasts=null;
         Node cur=head;
         while (cur.next!=null){
           if(cur.getVal()<value){
               if(heads==null&&heade==null){
                 heads=heade=cur;
               }else {
                   heade.next=cur;
                   heade=cur;
               }
           }else if (cur.getVal()==value){
               if(middlee==null&&middles==null){
                   middlee=middles=cur;
               }else {
                   middlee.next=cur;
                   middlee=cur;
               }
           }else {
               if(laste==null&&lasts==null){
                   laste=lasts=cur;
               }else {
                   laste.next=cur;
                   laste=cur;
               }
           }
           cur=cur.next;
         }
         if (heade!=null){
             if (middlee!=null){
              heade.next=middles;
              middlee.next=lasts;
             }else {
                 heade.next=lasts;
             }
         }
         return heads;

    }
}
