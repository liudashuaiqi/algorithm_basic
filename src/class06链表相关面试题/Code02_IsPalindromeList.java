package class06链表相关面试题;

import java.util.Stack;

//判断链表是否为回文结构
//三个代码都已经提交正确
public class Code02_IsPalindromeList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int v){
            value =v;
        }
    }
    //extra space o(n)
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while(!stack.empty()){
            if(stack.pop().value!=cur.value){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
    //extra space o(n/2)
    public static boolean isPalindrome2(Node head){
        Stack<Node> stack = new Stack<>();
        if(head == null){
            return true;
        }
        Node s = head;
        Node f = head;
        while(f.next!=null&&f.next.next!=null){
            s = s.next;
            f = f.next.next;
        }
        for(Node cur = s.next;cur!=null;cur = cur.next){
            stack.push(cur);
        }
        Node cur = head;
        while(!stack.empty()){
            if(stack.pop().value!=cur.value){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
    //extra space o(1)
    public static boolean isPalindrome3(Node head){
        if(head == null){
            return true;
        }
        //找到链表的中点位置以及最后节点的位置
        Node mid = head;
        Node last = head;
        while(last.next!=null&&last.next.next!=null){
            mid = mid.next;
            last = last.next.next;
        }
        while(last.next!=null){
            last = last.next;
        }
        //反转链表
        Node pre = mid;
        Node cur = mid.next;
        Node next = null;

        mid.next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //进行对比
        boolean flag = true;
        Node p1 = head;
        Node p2 = last;
        while(p1!=null&&p2!=null){
            if(p1.value!=p2.value){
                flag = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        //将链表还原
        pre = null;
        cur = last;
        next = null;
        while(cur!=mid){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        for(cur = head;cur!=null;cur=cur.next){
            System.out.println(cur.value);
        }
        return flag;
    }
}
