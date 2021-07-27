package class01对数器_二分_异或;

// 在arr上，找满足>=value的最左位置
public class Code05_BSNearLeft {
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length-1;
        int index = -1;//记录最左的位置
        while(L <= R){
            int mid = (L+R)/2;
            if(arr[mid] >= value){
                index = mid;
                R = mid-1;
            }else{
                L = mid+1;
            }
        }

        return index;
    }
}
