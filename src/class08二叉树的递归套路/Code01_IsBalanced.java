package class08二叉树的递归套路;

//已经测试，正确
public class Code01_IsBalanced {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static class Info{
        public boolean isBalanced;
        public int height;
        public Info(boolean b,int h){
            isBalanced = b;
            height = h;
        }
    }
    public static boolean isBalanced1(Node head){
        return process2(head).isBalanced;
    }
    public static Info process2(Node X){
        if(X == null){
            return new Info(true,0);
        }
        Info leftInfo = process2(X.left);
        Info rightInfo = process2(X.right);
        int height = Math.max(leftInfo.height,rightInfo.height)+1;
        boolean isBalanced = false;
        if(leftInfo.isBalanced&&rightInfo.isBalanced&&Math.abs(leftInfo.height-rightInfo.height)<2){
            isBalanced = true;
        }
        return new Info(isBalanced,height);
    }

}
