package class08二叉树的递归套路;

//代码已经测试，正确
public class Code08_MaxDistance {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static int maxDistance2(Node head){
        return process(head).maxDistance;
    }
    public static class Info{
        public int maxDistance;
        public int height;
        public Info(int d,int h){
            maxDistance = d;
            height = h;
        }
    }
    public static Info process(Node X){
        if(X==null){
            return new Info(0,0);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);
        int height = Math.max(leftInfo.height,rightInfo.height)+1;

        int d = Math.max(leftInfo.maxDistance,rightInfo.maxDistance);
        d = Math.max(d,leftInfo.height+1+rightInfo.height);

        return new Info(d, height);
    }
}
