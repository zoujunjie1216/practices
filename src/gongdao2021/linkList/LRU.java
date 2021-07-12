package gongdao2021.linkList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU 算法
 * 本题的解法就是双链表+hashmap 然后根据长度移除最近未訪問的
 * */
public class LRU {
    //缓存
    private Map<Integer,DoubleLinkedListNode> cache =
            new HashMap<Integer, DoubleLinkedListNode>();
    private int size;
    private int capacity;
    private DoubleLinkedListNode head,tail;

    public LRU(int capacity) {
         this.capacity =capacity;
    }

    public int get(int key) {
        DoubleLinkedListNode cacheNode =cache.get(key);
         if(cacheNode==null){
          return -1;
         }
         moveToHead(cacheNode);
         return cacheNode.value;
    }

    public void put(int key, int value) {
        DoubleLinkedListNode cacheNode =cache.get(key);
        if(cacheNode == null){
            DoubleLinkedListNode newNode = new DoubleLinkedListNode(key,value);
            cache.put(key,newNode);
            addHead(newNode);
            ++size;
            if(size>capacity){
                //remove hashmap cache
                cache.remove(tail.pre.value);
                removeTail();
                --size;
            }
        }else {
            moveToHead(cacheNode);
        }
    }

    public void addHead(DoubleLinkedListNode node){
        //1-3  2-3
        node.next=head.next;
        //3-1 3-2
        head.next.pre =node;
        //1-2
        head.next=node;
        //2-1
        node.pre=head;
    }

    public void moveToHead(DoubleLinkedListNode node){
        removeNode(node);
        node.next=head.next;
        head.next=node;
        node.pre=head;
    }

    public void removeNode(DoubleLinkedListNode node){
        node.pre.next =node.next;
        node.next.pre = node.pre;
        //may not add
        node.pre =null;
        node.next=null;
    }
    public void removeTail(){
        removeNode(tail.pre);
    }
}
