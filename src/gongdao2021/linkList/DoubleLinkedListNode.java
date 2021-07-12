package gongdao2021.linkList;

/**
 * 双向链表节点
 * */
public class DoubleLinkedListNode {
   // lru 专用
   int key;
   int value;
   DoubleLinkedListNode pre;
   DoubleLinkedListNode next;

   public DoubleLinkedListNode(int key, int value) {
      this.key = key;
      this.value = value;
   }
}
