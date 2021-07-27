package class03归并排序与随机快排;
//在一个数组中，一个数左边比它小的数的总和，叫数的小和，
// 所有数的小和累加起来，叫数组小和。求数组小和。
public class Code02_SmallSum {
    public static int smallSum(int[] arr){
        if(arr == null || arr.length < 2){
            return 0;
        }
        return process(arr,0,arr.length-1);
    }

    public static int process(int[] arr, int L, int R){
        if(L >= R){
            return 0;
        }
        int mid = L + ((R-L) >> 1);
        return  process(arr,L,mid) +
                process(arr,mid+1,R) +
                merge(arr,L,mid,R);
    }
    public static int merge(int[] arr,int L, int mid, int R){
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2 = mid+1;
        int index = 0;
        int ans = 0;
        while(p1<=mid && p2<=R){
            ans += arr[p1] < arr[p2] ? arr[p1]*(R-p2+1) : 0;
            help[index++] = arr[p1] < arr[p2]? arr[p1++]:arr[p2++] ;
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
        return ans;
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
    public static void main(String[] args){
        int[] arr = new int[]{1,3,4,2,5}; //输出16
        System.out.println(smallSum(arr));
    }
}
