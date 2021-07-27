package class08二叉树的递归套路;

//已经测试正确
public class Code02_IsFull {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            value = v;
        }
    }
    public static class Info{
        public int height;//树高
        public int n;//节点数
        public Info(int h,int a){
            height = h;
            n = a;
        }
    }
    public static boolean isFull2(Node head){
        if(head == null) return true;
        Info all = process1(head);
        return (1<<all.height)-1 == all.n;
    }
    public static Info process1(Node X){
        if(X == null){
            return new Info(0,0);
        }
        Info leftInfo = process1(X.left);
        Info rightInfo = process1(X.right);
        int height = Math.max(leftInfo.height,rightInfo.height)+1;
        int n = leftInfo.n+rightInfo.n+1;
        return new Info(height,n);
    }
}
