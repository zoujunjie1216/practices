package gongdao2021.linkList;
/**
 * 链表排序 应该和数组排序的方法是一致的
 * */
public class SquenceNode {
  public LinkedListNode squence(LinkedListNode node1){
     if (node1 == null){
         return node1;
     }
     return cut(node1);
  }

  public LinkedListNode cut(LinkedListNode node){
      if(node.next == null ){
          return node;
      }

      //快慢指针 找到中点拆分
      LinkedListNode fast = node;
      LinkedListNode slow =node;
      //这里有两种情况 分别判断。next.next (这种情况slow会在偶数时的左中间节点)
      //next（这种情况快指针会在null上 slow会在偶数时的右中间节点）
      while (fast.next!=null && fast.next.next!=null){
          fast = fast.next.next;
          slow = slow.next;
      }
      //断链
      LinkedListNode current = slow.next;
      slow.next=null;
      LinkedListNode node1 = cut(node);
      LinkedListNode node2 = cut(current);
      return merge(node1,node2);
  }

//合并两个有序的单向链表 因为拆分成最小的单个节点 所以肯定是有序的
  public LinkedListNode merge(LinkedListNode node1,LinkedListNode node2){
      LinkedListNode head = new LinkedListNode(-1);
      LinkedListNode currentNode = head;
     while(node1 !=null && node2 != null){
          if(node1.val<node2.val){
              currentNode.next =node1;
              node1 = node1.next;
          }else {
              currentNode.next =node2;
              node2=node2.next;
          }
         currentNode=currentNode.next;
     }
     //不用再循环判断 只需要将剩余的尾巴连过去
      if(node1!=null){
          currentNode.next=node1;
      }

      if(node2!=null){
          currentNode.next=node2;
      }
    /* while (node1!=null){
         currentNode.next = node1;
         node1=node1.next;
         currentNode=currentNode.next;
     }
     while (node2 != null){
         currentNode.next = node2;
         node2 = node2.next;
         currentNode = currentNode.next;
     }*/
     return head.next;
  }

}
