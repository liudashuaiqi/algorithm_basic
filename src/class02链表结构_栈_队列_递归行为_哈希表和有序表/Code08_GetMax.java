package class02链表结构_栈_队列_递归行为_哈希表和有序表;

//使用二分法 求一个数组中的最大值，时间复杂度为O(n)
public class Code08_GetMax {
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }
    public static int process(int[] arr,int L, int R){
        if(L == R){
            return arr[L];
        }
        int mid = L + ((R-L) >> 1);
        int leftMax = process(arr,L,mid);
        int rightMax = process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }
}
