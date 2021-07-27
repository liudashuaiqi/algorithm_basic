package class09贪心算法;


import java.util.PriorityQueue;
//已经测试，正确
public class Code03_LessMoneySplitGold {
    public static int lessMoney2(int[] arr){
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for(int i = 0;i < arr.length;i++){
            pQ.add(arr[i]);
        }
        int sum = 0;
        while(pQ.size() > 1){
            int a = pQ.poll();
            int b = pQ.poll();
            sum += a+b;
            pQ.add(a+b);
        }
        return sum;
    }
}
