package class04比较器与堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

//此堆结构中增加了新的功能，resign方法,
//对于某一个已经放到里面的对象改了它的值，需要进行向上或者是向下调整
//时间复杂度o(logN)
//大根堆？？？
//此代码对数器有问题  一行一行代码比较的 且比较器的写法没看明白
public class Code03_Heap02 {
    public static class Node{
        public int value;
        public Node left;
        public Node(int v){
            value = v;
        }
    }
    public static class MyCom implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2) {
            return o2.value-o1.value;
        }
    }
    public static class MyHeap<T>{
        private int heapSize;
        private ArrayList<T> heap;
        private HashMap<T,Integer> indexMap;
        private Comparator<? super T> comparator; //这是个啥意思？

        public MyHeap(Comparator<? super T> com){
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            comparator = com;
        }
        public boolean isEmpty(){
            return heapSize == 0;
        }
        public int size(){
            return heapSize;
        }
        public boolean contains(T value){
            return indexMap.containsKey(value);
        }
        public void push(T value){
            heap.add(value);
            indexMap.put(value,heapSize);
            heapInsert(heapSize++);
        }
        public T pop(){
            T ans = heap.get(0);
            swap(0,heapSize-1);
            heap.remove(heapSize-1);
            indexMap.remove(ans);
            heapify(0,--heapSize);
            return ans;
        }
        public void resign(T value){
            int valueIndex = indexMap.get(value);
            heapify(valueIndex,heapSize);
            heapInsert(valueIndex);
        }
        public void heapify(int index,int heapSize){
            int left = index*2+1;
            while(left < heapSize){
                int largest = left + 1 < heapSize && (comparator.compare(heap.get(left+1),heap.get(left)) < 0)? left+1:left;
                largest = comparator.compare(heap.get(index),heap.get(largest)) < 0? index : largest;
                if(index == largest){
                    break;
                }
                swap(index,largest);
                index = largest;
                left = index*2+1;
            }
        }
        public void heapInsert(int index){
            while(comparator.compare(heap.get(index),heap.get((index-1)/2)) < 0){ //如何定义比较方法的？
                swap(index,(index-1)/2);
                index = (index-1)/2;
            }
        }
        public void swap(int i, int j){
            T a = heap.get(i);
            T b = heap.get(j);
            heap.set(i,b);
            heap.set(j,a);
            indexMap.put(a,j);
            indexMap.put(b,i);
        }
    }
    public static void main(String[] args){
        MyHeap<Node> myheap = new MyHeap<>(new MyCom());
        Node n1 = new Node(5);
        Node n2 = new Node(4);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
        myheap.push(n1);
        myheap.push(n2);
        myheap.push(n3);
        myheap.push(n4);
        myheap.push(n5);

        System.out.println(myheap.pop().value);
    }
}
