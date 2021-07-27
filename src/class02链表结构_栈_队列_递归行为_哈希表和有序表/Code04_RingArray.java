package class02链表结构_栈_队列_递归行为_哈希表和有序表;

//使用环型数组实现栈和队列
//前置指针指向了为空的一个空间
public class Code04_RingArray {
    public static class MyQueue{
        public int[] arr;
        public int pushi;
        public int polli;
        public int size;
        public final int limit;

        public MyQueue(int limit){
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }
        public void push(int value){
            if(size == limit){
                throw new RuntimeException("满了！！！不能加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }
        public int pop(){
            if(size == 0){
                throw new RuntimeException("栈为空不能返回");
            }
            size--;
            int data = arr[polli];
            polli = nextIndex(polli);
            return data;
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public int nextIndex(int i){
            return i < limit-1? i+1 : 0;
        }
    }

}
