package class06链表相关面试题;

import java.util.HashMap;

//链表的复制
//哈希表
//技巧，最优方法   方法已经测试 正确
public class Code04_CopyListWithRandom {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int v){
            value = v;
        }
    }

    public static Node copyListWithRand1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
    //
    public static Node copyListWithRand2(Node head){
        if(head == null){
            return null;
        }
        //把新建的复制结点放到链表当中去
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //设置rand指针
        cur = head;
        Node copyNode = null;
        while(cur!=null){
            Node next = cur.next.next;
            copyNode = cur.next;
            copyNode.rand = cur.rand ==null? null:cur.rand.next;
            cur = next;
        }
        //链表的拆分
        Node res = head.next;
        cur = head;
        while(cur != null){
            Node next = cur.next.next;
            copyNode = cur.next;
            cur.next = next;
            copyNode.next = next ==null? null:next.next;
            cur = next;
        }
        return res;
    }

}
