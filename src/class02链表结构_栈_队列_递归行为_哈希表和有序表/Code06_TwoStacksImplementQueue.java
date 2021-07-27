package class02链表结构_栈_队列_递归行为_哈希表和有序表;

import java.util.Stack;

//用两个栈实现队列
//只要有机会，就把stackPush里面的内容全都放到stackPop里面
public class Code06_TwoStacksImplementQueue {
    public static class TwoStacksQueue{
        Stack<Integer> stackPush;
        Stack<Integer> stackPop;
        public TwoStacksQueue(){
            stackPush = new Stack();
            stackPop = new Stack();
        }
        public void pushToPop(){
            if(stackPop.isEmpty()){
                while(!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }
        public void add(Integer integer){
            stackPush.push(integer);
            pushToPop();
        }
        public Integer poll(){
            pushToPop();
            return stackPop.pop();
        }
        public Integer peek(){
            pushToPop();
            return stackPop.peek();
        }
    }
}
