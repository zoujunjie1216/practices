package gongdao2021.linkList;

/**
 * 判断两个链表是否有公共节点
 * 这一题需要判断的点有好几个
 * 1.分别判断两个链表是否有环  两个链表都有环  可能相交 --相交的单链尾巴成环
 * 2.两个链表都没有环  换 head 法
 * 3 两个链表有一个有环 一个没环 不相交
 * */
public class CommonNode {

    //判断是否有环的操作  快慢指针
    public LinkedListNode commandNode(LinkedListNode node1,LinkedListNode node2){
        //只有两个都无环 或者两个都有环的情况下 存在common node
        LinkedListNode circle1 = hasCircle(node1);
        LinkedListNode circle2 = hasCircle(node2);
        //两个都无环 到尾部直接交换节点就行(需要返回交点 不需要直接返回尾巴看是否相等)
        if(circle1 == null && circle2 == null){
            return noLoop(node1,node2);
        }
        //两个都有环
        if(circle1 !=null && circle2 != null){
            return hasLoop(node1,node2,circle1,circle2);
        }
        //其他情况
        return null;
    }

    //两个无环链表判断是否相交 并返回node
    public LinkedListNode noLoop(LinkedListNode node1,LinkedListNode node2){
        LinkedListNode cur1 = node1;
        LinkedListNode cur2 = node2;
        while(cur1 != cur2){
            //如果没有 两个节点肯定会同时 （a的长度 + b的长度）为null
            cur1 = cur1.next == null ? cur1.next : node2;
            cur2 = cur2.next == null ? cur2.next : node1;
        }
        return cur1;
    }

    //同理上面的 将common node 当成最后一个节点就行
    public LinkedListNode hascommonLoop(LinkedListNode node1,LinkedListNode node2,LinkedListNode last){
        LinkedListNode cur1 = node1;
        LinkedListNode cur2 = node2;
        while(cur1 != cur2){
            //如果没有 两个节点肯定会同时 （a的长度 + b的长度）为null
            cur1 = cur1.next == last ? cur1.next : node2;
            cur2 = cur2.next == last ? cur2.next : node1;
        }
        return cur1;
    }

    public  LinkedListNode hasLoop(LinkedListNode node1,LinkedListNode node2,LinkedListNode circle1,LinkedListNode circle2){
        //如果环的入点 在链表的交点及之后 且有交点
        if(circle1 == circle2){
           return hascommonLoop(node1,node2,circle1);
        }else {
            //判断circle1 回到 该节点能否遇到circle2 不能就没有 交点
            LinkedListNode cur =circle1.next;
            while (cur != circle1){
                if(cur == circle2){
                    //这种情况下 两个链表下面会形成一个环 返回其中一个就可以
                    return circle1;
                }
                cur = cur.next;
            }
            //没有交点
            return null;
        }
        //如果环的入点 在链表的交点之前
    }

    //判断链表是否有环 如果有 返回入环的节点
    public LinkedListNode hasCircle(LinkedListNode node){
        LinkedListNode fast = node;
        LinkedListNode slow = node;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
            if(fast == slow){
                //相等的话 fast指针放置在头部
                fast = node;
                while (fast != slow){
                    fast = fast.next;
                    slow =slow.next;
                }
                return fast;
            }
        }
        return null;
    }

}
