package class05_桶排序_排序总结;

//对数器测过 正确
public class Code04_RadixSort {
    //only for no-negative value
    public static void radixSort(int[] arr){
        if(arr == null|| arr.length < 2){
            return;
        }

        radixSort(arr,0,arr.length-1,maxbits(arr));
    }
    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        int res = 0;
        while(max!=0){
            max/=10;
            res++;
        }
        return res;
    }
    public static void radixSort(int[] arr, int L, int R,int digit){
        final int radix = 10;
        int[] help = new int[R-L+1];
        for(int d = 1;d<=digit;d++){


            int[] count = new int[radix];
            for(int i = L;i <= R;i++){
                int j = getDigit(arr[i],d);
                count[j]++;
            }
            for(int i = 1;i < radix;i++){
                count[i] += count[i-1];
            }
            for(int i = R;i >= L;i--){
                int j = getDigit(arr[i],d);
                help[count[j]-1] = arr[i];
                count[j]--;
            }

            for(int i = L,j = 0;i <= R;i++,j++){
                arr[i] = help[j];
            }
        }
    }
    //把x十进制中d位置上的数字 取出来
    public static int getDigit(int x,int d){
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

}
