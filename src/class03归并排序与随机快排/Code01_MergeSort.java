package class03归并排序与随机快排;

//归并排序的递归与非递归写法
public class Code01_MergeSort {
    public static void mergeSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr,0,arr.length-1);
    }
    public static void process(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int mid = L + ((R-L) >> 1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    public static void merge(int[] arr,int L, int mid, int R){
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2 = mid+1;
        int index = 0;
        while(p1<=mid && p2<=R){
            help[index++] = arr[p1] < arr[p2]? arr[p1++]:arr[p2++];
        }
        while(p1<=mid){
            help[index++] = arr[p1++];
        }
        while(p2<=R){
            help[index++] = arr[p2++];
        }

        for(int i = 0;i < help.length;i++){
            arr[L+i] = help[i];
        }
        return;
    }
    public static void printArray(int[] arr){
        if(arr == null){
            return;
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //非递归方法实现
    public static void mergeSort2(int[] arr){
        if(arr == null|| arr.length < 2) return;
        int mergeSize = 1;
        int N = arr.length;
        while(mergeSize < N){
            int L = 0;
            while(L < N){
                int mid = L + mergeSize-1;
                if(mid >= N-1) { //左的写法为mid >= N 这里有一点点小问题
                    break;
                }
                int R = Math.min(mid + mergeSize,N-1);
                merge(arr,L,mid,R);
                L = R+1;
            }
            if(mergeSize > N/2){ //防止mergeSize越int_max的边界
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{99,5,4,3,7,1,8,9,0,345,62,1,2};
        mergeSort2(arr);
        printArray(arr);
    }
}
