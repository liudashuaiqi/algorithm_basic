package class02链表结构_栈_队列_递归行为_哈希表和有序表;

//用双向链表实现双端队列，再用双端队列实现属于自己的栈和队列
public class Code03_DoubleEndsQueueToStackAndQueue {
    public static class Node<T>{
        public T value;
        public Node<T> next;
        public Node<T> last;
        public Node(T data){
            value = data;
        }
    }
    public static class DoubleEndsQueue<T>{
        public Node<T> head;
        public Node<T> tail;
//      addFromHead addFromBottom popFromHead popFromBottom

        public void addFromHead(T value){
            Node<T> q = new Node(value);
            if(head == null){
                head = q;
                tail = q;
                return;
            }
            q.next = head;
            head.last = q;
            head = q;
        }
        public void addFromBottom(T value){
            Node<T> q = new Node(value);
            if(head == null){
                head = q;
                tail = q;
                return;
            }
            tail.next = q;
            q.last = tail;
            tail = q;
        }
        public T popFromHead(){
            if(head == null){
                return null;
            }
            Node<T> q = head;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                head = head.next;
                head.last = null;
                q.next = null;
            }
            return q.value;
        }
        public T popFromBottom(){
            if(head == null){
                return null;
            }
            Node<T> q = tail;
            if(head == tail){
                head = null;
                tail = null;
            }else {
                tail = tail.last;
                tail.next = null;
                q.last = null;
            }
            return q.value;
        }
        public boolean isEmpty(){
            return head == null;
        }
    }

    public static class MyQueue<T>{
        public DoubleEndsQueue<T> queue;
        public MyQueue(){
            queue = new DoubleEndsQueue<>();
        }
        public void push(T value){
            queue.addFromHead(value);
        }
        public T poll(){
            return queue.popFromBottom();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }
    public static class MyStack<T>{
        public DoubleEndsQueue<T> queue;
        public MyStack(){
            queue = new DoubleEndsQueue<>();
        }
        public void push(T value){
            queue.addFromHead(value);
        }
        public T poll(){
            return queue.popFromHead();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }
}
