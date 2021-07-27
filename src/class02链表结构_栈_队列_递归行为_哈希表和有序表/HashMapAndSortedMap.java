package class02链表结构_栈_队列_递归行为_哈希表和有序表;

import java.util.HashMap;
import java.util.TreeMap;

public class HashMapAndSortedMap {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            value = data;
        }
    }
    public static void main(String[] args){
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"我是1");
        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.get(1));

        TreeMap<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"w1");
        treeMap.put(2,"w2");
        treeMap.put(4,"w4");
        treeMap.put(5,"w5");
        //最小的值以及最大的值
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        // <=3
        System.out.println(treeMap.floorKey(3));
        //>=3
        System.out.println(treeMap.ceilingKey(3));
        Integer a = 123;

        Integer b = Integer.reverse(a);
        System.out.println(b);
    }
}
