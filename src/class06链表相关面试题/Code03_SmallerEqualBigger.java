package class06链表相关面试题;

//可以用数组去做（笔试这么做，省略）
//可以用六个引用去做,已经测试，正确
public class Code03_SmallerEqualBigger {
    public static class Node{
        public int value;
        public Node next;
        public Node(int v){
            value = v;
        }
    }
    public static Node listPartition2(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next =null;
        while(head!=null){
            next = head.next;
            head.next = null;
            if(head.value < pivot){
                if(sH==null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = sT.next;
                }
            }else if(head.value == pivot){
                if(eH==null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = eT.next;
                }
            }else if(head.value > pivot){
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = bT.next;
                }
            }
            head = next;
        }
        //下面的代码很经典,难写
        //引用中,可能有空可能不是空，都需要判断
        if(sT!=null){
            sT.next = eH;
            eT = eT==null? sT:eT;
        }
        if(eT!=null){
            eT.next = bH;
        }
        return sH!=null? sH:(eH!=null?eH:bH);
    }
}
