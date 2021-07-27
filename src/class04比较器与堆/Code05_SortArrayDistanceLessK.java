package class04比较器与堆;

import java.util.PriorityQueue;
//对数器测过，非常正确
//一个几乎有序的数组，每个元素移动的距离不超过K
//选择一个合适的排序策略，对数组进行排序
public class Code05_SortArrayDistanceLessK {
     public static void sortedArrDistanceLessK(int[] arr,int k){
         if(k==0){
             return;
         }
         //默认小根堆
         PriorityQueue<Integer> heap = new PriorityQueue<>();
         int i = 0;
         for(;i<arr.length&&i <= k;i++){
             heap.add(arr[i]);
         }
         int index = 0;
         for(;i < arr.length;i++){
             arr[index++] = heap.poll();
             heap.add(arr[i]);
         }
         while(!heap.isEmpty()){
             arr[index++] = heap.poll();
         }
     }
}
