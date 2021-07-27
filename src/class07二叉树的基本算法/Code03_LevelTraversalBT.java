package class07二叉树的基本算法;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

//已经测试 正确
public class Code03_LevelTraversalBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void level(Node head) {
        if(head == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            System.out.println(temp.value);
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }

    //层序遍历求二叉树深度
    public static class TreeNode{
        public int v;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int value){
            v = value;
        }
    }
    public static int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode nextLast = null;
        TreeNode last = root;
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if(cur.left != null){
                queue.offer(cur.left);
                nextLast = cur.left;
            }

            if(cur.right != null){
                queue.offer(cur.right);
                nextLast = cur.right;
            }

            if(cur == last){
                level++;
                last = nextLast;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println(TreeDepth(head));
        System.out.println("========");
    }
}
