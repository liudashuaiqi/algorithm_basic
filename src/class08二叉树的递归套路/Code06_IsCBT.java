package class08二叉树的递归套路;

import java.util.LinkedList;
import java.util.Queue;

//代码已经测试 正确
public class Code06_IsCBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int v){
            value = v;
        }
    }
    public static boolean isCBT1(Node head){
        if(head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        boolean leaf = false;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if((leaf&&(cur.left!=null||cur.right!=null))||(cur.left == null&&cur.right!=null)){
                return false;
            }
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
            if(cur.left==null||cur.right==null){
                leaf = true;
            }
        }
        return true;
    }

    public static class Info{
        public boolean isFull;
        public boolean isCBT;
        public int height;
        public Info(boolean f,boolean c, int h){
            isFull = f;
            isCBT = c;
            height = h;
        }
    }
    public static boolean isCBT2(Node head){
        if(head == null){
            return true;
        }
        return process(head).isCBT;
    }
    public static Info process(Node X){
        if(X == null){
            return new Info(true,true,0);
        }
        Info leftInfo = process(X.left);
        Info rightInfo = process(X.right);

        int height = Math.max(leftInfo.height,rightInfo.height)+1;

        boolean isFull = leftInfo.isFull
                &&
                rightInfo.isFull
                &&
                leftInfo.height==rightInfo.height;

        boolean isCBT = false;
        if(isFull){
            isCBT = true;
        }else{
            if(leftInfo.isCBT&&rightInfo.isCBT){
                if(leftInfo.isCBT&&rightInfo.isFull&&leftInfo.height==rightInfo.height+1){
                    isCBT = true;
                }
                if(leftInfo.isFull&&rightInfo.isFull&&leftInfo.height==rightInfo.height+1){
                    isCBT = true;
                }
                if(leftInfo.isFull&&rightInfo.isCBT&&leftInfo.height==rightInfo.height){
                    isCBT = true;
                }
            }
        }
        return new Info(isFull,isCBT,height);
    }
}
