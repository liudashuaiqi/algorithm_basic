package class05_桶排序_排序总结;

//value only for 0~200
//对数器测过，已经成功
public class Code03_CountSort {
    public static void countSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int[] bucket = new int[max+1];
        for(int i = 0;i < arr.length;i++){
            bucket[arr[i]]++;
        }
        int index = 0;
        for(int i = 0;i < max+1;i++){
            while(bucket[i]>0){
                arr[index++] = i;
                bucket[i]--;
            }
        }
    }
}
