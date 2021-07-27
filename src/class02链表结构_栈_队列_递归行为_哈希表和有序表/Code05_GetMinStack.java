package class02链表结构_栈_队列_递归行为_哈希表和有序表;

import java.util.Stack;

//实现一个特殊的栈，在基本功能的基础上，再实现返回栈中最小元素的功能
//1）pop、push、getMin操作的时间复杂度都是 O(1)。
//2）设计的栈类型可以使用现成的栈结构。


public class Code05_GetMinStack {
    //第一种方法 对于每一个数据，都要放到stackMin和stackData栈里面
    public static class MyStack{
        Stack<Integer> stackData;
        Stack<Integer> stackMin;
        public MyStack(){
            stackData = new Stack<Integer>();
            stackMin = new Stack<Integer>();
        }
        public void push(Integer value){
            if(stackData.isEmpty()){
                stackData.push(value);
                stackMin.push(value);
                return;
            }
            stackData.push(value);
            if(value >= stackMin.peek()){
                stackMin.push(stackMin.peek());
            }else {
                stackMin.push(value);
            }
        }
        public Integer pop(){
            if(stackData.isEmpty()){
                throw new RuntimeException();
            }
            stackMin.pop();
            return stackData.pop();
        }
        public Integer getMin(){
            if(stackMin.isEmpty()){
                throw new RuntimeException("栈为空");
            }
            return stackMin.peek();
        }
    }
    public static void main(String[] args){
        MyStack sta = new MyStack();
        sta.push(1);

        System.out.println(sta.getMin());
        System.out.println(sta.pop());

    }
    //第二种方法,只有当前值<=min栈顶元素的值的时候，才同时入栈，否则不变
    //出栈的时候，判断一下如果data栈顶元素大于min栈顶元素，则只有data栈顶元素出站
}
