package class08二叉树的递归套路;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//已经测试，代码正确
public class Code07_lowestAncestor {
    public static class Node{
        public int value;
        public Node left;
        public Node right;
    }
//    方法1此代码有问题,有bug,以后再找吧
//    public static Node lowestAncestor1(Node head, Node o1,Node o2){
//        if(head == null){
//            return null;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(head);
//        HashMap<Node,Node> map = new HashMap<>();
//        map.put(head,null);
//        while(!queue.isEmpty()){
//            Node cur = queue.poll();
//            if(cur.left!=null){
//                queue.add(cur.left);
//                map.put(cur.left,cur);
//            }
//            if(cur.right!=null){
//                queue.add(cur.right);
//                map.put(cur.right,cur);
//            }
//        }
//        HashSet<Node> set = new HashSet<>();
//        Node cur = o1;
//        while(cur!=null){
//            set.add(cur);
//            cur = map.get(cur);
//        }
//
//        Node cur1 = o2;
//        while(cur!=null){
//            if(set.contains(cur1)){
//                return cur1;
//            }
//            cur1 = map.get(cur1);
//        }
//        return null;
//    }

    public static class Info{
        public Node ans;
        public boolean findO1;
        public boolean findO2;
        public Info(Node a,boolean fo1,boolean fo2){
            ans = a;
            findO1 = fo1;
            findO2 = fo2;
        }
    }
    public static Node lowestAncestor2(Node head, Node o1,Node o2){
        if(head == null){
            return null;
        }
        return process(head,o1,o2).ans;
    }
    public static Info process(Node X, Node o1,Node o2){
        if(X == null){
            return new Info(null,false,false);
        }
        Info leftInfo = process(X.left,o1,o2);
        Info rightInfo = process(X.right,o1,o2);

        boolean findO1 = X == o1||leftInfo.findO1||rightInfo.findO1;
        boolean findO2 = X == o2||leftInfo.findO2||rightInfo.findO2;

        Node ans = null;
        if(leftInfo.ans!=null){
            ans = leftInfo.ans;
        }
        if(rightInfo.ans!=null){
            ans = rightInfo.ans;
        }

        if(ans==null){
            if(findO1&&findO2){
                ans = X;
            }
        }

        return new Info(ans,findO1,findO2);
    }
}
