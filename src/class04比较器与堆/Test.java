package class04比较器与堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static class MyComp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }

    }
    public static void main(String[] args){
        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyComp());

        heap.add(5);
        heap.add(7);
        heap.add(3);
        heap.add(0);
        heap.add(2);
        heap.add(5);

        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

}