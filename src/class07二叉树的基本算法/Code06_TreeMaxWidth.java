package class07二叉树的基本算法;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//此题已测试 正确
public class Code06_TreeMaxWidth {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static int maxWidthUseMap(Node head){
        if(head == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        HashMap<Node,Integer> map = new HashMap<>();
        map.put(head,1);

        int curLevel = 1;
        int curLevelNodes = 0;
        int max = 0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            int curNodeLevel = map.get(temp);
            if(temp.left!=null){
                queue.add(temp.left);
                map.put(temp.left,curNodeLevel+1);
            }
            if(temp.right!=null){
                queue.add(temp.right);
                map.put(temp.right,curNodeLevel+1);
            }
            if(curLevel == curNodeLevel){
                curLevelNodes++;
            }else{
                max = Math.max(max,curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }
        }
        max = Math.max(max,curLevelNodes);
        return max;
    }
    public static int maxWidthNoMap(Node head){
        if(head == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node curEnd = head;
        Node nextEnd = null;
        int max = 0;
        int curLevelNodes = 0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.left!=null){
                queue.add(temp.left);
                nextEnd = temp.left;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                nextEnd = temp.right;
            }
            curLevelNodes++;
            if(temp == curEnd){
                max = Math.max(max,curLevelNodes);
                curLevelNodes = 0;
                curEnd = nextEnd;
            }
        }
        return max;
    }
    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxWidthUseMap(head) != maxWidthNoMap(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");

    }
}
