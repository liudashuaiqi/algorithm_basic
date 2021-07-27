package class06链表相关面试题;

//链表问题的两个噩梦之一:求两个可能有环的单链表的第一个相交节点
//已经测试正确
public class Code05_FindFirstIntersectNode {
    public static class Node{
        public int value;
        public Node next;
        public Node(int v){
            value = v;
        }
    }
    public static Node getIntersectNode(Node head1, Node head2){
        if(head1 == null||head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }
        if(loop1 !=null && loop2 != null){
            return bothLoop(head1,head2,loop1,loop2);
        }
        return null;
    }

    public static Node getLoopNode(Node head){
        if(head == null || head .next == null|| head.next.next == null){
            return null;
        }
        Node s = head.next;
        Node f = head.next.next;
        while(s != f){
            if(f.next==null||f.next.next==null){
                return null;
            }
            s = s.next;
            f = f.next.next;
        }
        s = head;
        while(s != f){
            s = s.next;
            f = f.next;
        }
        return s;
    }
    //无环单链表的
    public static Node noLoop(Node head1,Node head2){
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while(cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1 != cur2){
            return null;
        }
        cur1 = n > 0? head1:head2; //指向较长的链表的头
        cur2 = cur1 == head1? head2:head1;
        n = Math.abs(n);
        while(n != 0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    public static Node bothLoop(Node head1,Node head2,Node loop1,Node loop2){
        if(loop1 == loop2){
            Node cur1 = head1;
            Node cur2 = head2;
            int n = 0;
            while(cur1.next != loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2.next != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0? head1:head2;
            cur2 = cur1 == head1? head2:head1;
            n = Math.abs(n);
            while(n!=0){
                n--;
                cur1 = cur1.next;
            }
            while(cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            Node cur = loop1.next;
            while(cur!=loop1){
                if(cur == loop2){
                    return loop1;//返回loop1和loop2都可以
                }
                cur = cur.next;
            }
            return null;
        }
    }
    public static void main(String[] args){
// 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
