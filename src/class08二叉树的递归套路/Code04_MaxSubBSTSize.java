package class08二叉树的递归套路;

//已经测试 代码正确
public class Code04_MaxSubBSTSize {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            value = data;
        }
    }
    public static class Info{
        public boolean isAllBST;
        public int maxSubBSTSize;
        public int min;
        public int max;
        public Info(boolean is,int size, int mi,int ma){
            isAllBST = is;
            maxSubBSTSize = size;
            min = mi;
            max = ma;
        }
    }
    public static int maxSubBSTSize2(Node head){
        if(head == null){
            return 0;
        }
        return process(head).maxSubBSTSize;
    }
    public static Info process(Node X){
        if(X == null){
            return null;
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        int min = X.value;
        int max = X.value;
        if(leftInfo!=null){
            min = Math.min(leftInfo.min,min);
            max = Math.max(leftInfo.max,max);
        }
        if(rightInfo!=null){
            min = Math.min(rightInfo.min,min);
            max = Math.max(rightInfo.max,max);
        }


        int maxSubBSTSize = 0;
        if(leftInfo!=null){
            maxSubBSTSize = leftInfo.maxSubBSTSize;
        }
        if(rightInfo!=null){
            maxSubBSTSize = Math.max(maxSubBSTSize,rightInfo.maxSubBSTSize);
        }

        boolean isAllBST = false;
        if(
                (leftInfo==null?true:leftInfo.isAllBST)
                &&
                        (rightInfo==null?true:rightInfo.isAllBST)
                &&
                        (leftInfo==null?true:leftInfo.max < X.value)
                &&
                        (rightInfo==null?true:X.value<rightInfo.min)
                ){
            isAllBST = true;
            maxSubBSTSize = (leftInfo==null?0:leftInfo.maxSubBSTSize)
                    +
                    (rightInfo==null?0:rightInfo.maxSubBSTSize)
                    +1;
        }
        return new Info(isAllBST,maxSubBSTSize,min,max);
    }
}
