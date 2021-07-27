package class02链表结构_栈_队列_递归行为_哈希表和有序表;

import java.util.LinkedList;
import java.util.Queue;

//用两个队列实现一个栈
public class Code07_TwoQueueImplementStack {
    public static class TwoQueueStack<T>{
        Queue<T> queue;
        Queue<T> help;
        public TwoQueueStack(){
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }
        public void push(T value){
            queue.offer(value); //多态编译看左，运行看右
        }
        public T poll(){
            while(queue.size()>1){
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return ans;
        }
        public T peek(){
            while(queue.size()>1){
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            help.offer(ans);
            Queue<T> temp = queue;
            queue = help;
            help = temp;
            return ans;
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }
}
