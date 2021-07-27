package class06链表相关面试题;

//跑过代码 已经正确
public class Code01_LinkedListMid {
    public static class Node{
        public int value;
        public Node next;
        public Node(int v){
            value = v;
        }
    }
    //奇数返回中点，偶数返回上中点
    public static Node midOrUpMidNode(Node head){
        if(head == null|| head.next==null||head.next.next==null){
            return head;
        }
        Node s = head.next;
        Node f = head.next.next;
        while(f.next!=null&&f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }//奇数返回中点，偶数返回下中点
    public static Node midOrDownMidNode(Node head){
        if(head == null || head.next==null){
            return head;
        }
        Node s = head.next;
        Node f = head.next;
        while(f.next!=null&&f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    //奇数长度返回中点前一个，偶数返回上中点前一个
    public static Node midOrUpMidPreNode(Node head){
        if(head == null|| head.next == null||head.next.next==null){
            return null;
        }
        Node s = head;
        Node f = head.next.next;
        while(f.next!=null&&f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    //奇数长度返回中点前一个，偶数长度返回下中点前一个
    public static Node midOrDownMidPreNode(Node head){
        if(head == null && head.next == null){
            return null;
        }
        Node s = head;
        Node f = head.next;
        while(f.next!=null&&f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}
