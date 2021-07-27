package class02链表结构_栈_队列_递归行为_哈希表和有序表;

//翻转单链表以及双向链表
public class Code01_ReverseList {
    //定义节点
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            value = data;
        }
    }
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;
        public DoubleNode(int data){
            value = data;
        }
    }
    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }
}
