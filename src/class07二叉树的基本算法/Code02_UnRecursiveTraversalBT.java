package class07二叉树的基本算法;

import java.util.Stack;
//已测试正确
public class Code02_UnRecursiveTraversalBT {
    public static class Node{
        int value;
        Node left;
        Node right;
        Node(int v){
            value = v;
        }
    }
    //先序遍历
    public static void pre(Node head){
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.empty()){
            Node temp = stack.pop();
            System.out.println(temp.value);
            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }
    //中序遍历
    public static void in(Node head){
        if(head == null) return;
        Stack<Node> stack = new Stack<>();
        Node p = head;
        while(!stack.empty()||p!=null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                Node temp = stack.pop();
                System.out.println(temp.value);
                p = temp.right;
            }
        }
    }
    //后序遍历 两个栈
    public static void pos1(Node head){
        Stack<Node> stack = new Stack<>();
        Stack<Integer> p = new Stack<>();
        stack.push(head);
        while(!stack.empty()){
            Node temp = stack.pop();
            p.push(temp.value);
            if(temp.left!=null){
                stack.push(temp.left);
            }
            if(temp.right!=null){
                stack.push(temp.right);
            }
        }
        while(!p.empty()){
            System.out.println(p.pop());
        }
    }
    public static void pos2(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node c = head;
        stack.push(c);
        Node h = null;
        while(!stack.empty()){
            c = stack.peek();
            if(c.left!=null&&h!=c.left&&h!=c.right){
                stack.push(c.left);
            }else if(c.right!=null&&h!=c.right){
                stack.push(c.right);
            }else{
                Node temp = stack.pop();
                System.out.println(temp.value);
                h = c;
            }
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }
}
