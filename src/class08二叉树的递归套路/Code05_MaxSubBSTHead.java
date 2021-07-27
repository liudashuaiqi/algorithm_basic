package class08二叉树的递归套路;

//已经测试 正确
public class Code05_MaxSubBSTHead {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
    }
    public static class Info{
        public Node head;
        public int size;
        public int min;
        public int max;
        public Info(Node a, int b, int c, int d){
            head = a;
            size = b;
            min = c;
            max = d;
        }
    }
    public static Node maxSubBSTHead2(Node head){
        if(head == null){
            return null;
        }
        return process(head).head;
    }
    public static Info process(Node X){
        if(X == null){
            return null;
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        int min = X.value;
        int max = X.value;
        int size = 0;
        Node head = null;
        if(leftInfo!=null){
            min = Math.min(min,leftInfo.min);
            max = Math.max(max,leftInfo.max);
            size = leftInfo.size;
            head = leftInfo.head;
        }
        if(rightInfo!=null){
            min = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
            if(rightInfo.size > size){
                size = rightInfo.size;
                head = rightInfo.head;
            }
        }
        if(
                (leftInfo == null? true:leftInfo.head == X.left)
                &&(rightInfo == null? true:rightInfo.head == X.right)
                &&(leftInfo ==null? true:leftInfo.max < X.value)
                &&(rightInfo == null? true:X.value < rightInfo.min)
                ){
                 head = X;
                 size = (leftInfo == null? 0: leftInfo.size)
                         +(rightInfo == null? 0: rightInfo.size)
                         +1;
        }
        return new Info(head,size,min,max);
    }
}
