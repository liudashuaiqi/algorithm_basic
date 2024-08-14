package class03归并排序与随机快排;


public class Code03_PartitionAndQuickSort {
    
    //partiiton过程,把<num的数放在数组左边，>num的数放在数组的右边，=num的数放在数组的中间
    //此过程的时间复杂度为O(n)，额外空间复杂度为O(1)
    public static int[] partition_(int[] arr, int L, int R, int number){
        int less = L-1;
        int more = R+1;
        while(L < more){ 
            if(arr[L] < number){
                swap(arr,++less,L++);
            }else if(arr[L] > number){
                swap(arr,--more,L);
            }else {
                L++;
            }
        }
        return new int[] { less+1, more-1};
    }
    
    //partiiton过程,把<=num的数放在数组左边，>num的数放在数组的右边
    //此过程的时间复杂度为O(n)，额外空间复杂度为O(1)
    public static int partition(int[] arr, int L, int R){
        if(L >R) {
            return -1;
        }
        if(L==R){
            return L;
        }
        int lessEqual = L-1; //<=区的右边界
        int index = L;
        while(index < R){ //以arr[R]作为划分数
            if(arr[index] <= arr[R]){
                swap(arr,++lessEqual,index++);
            }else {
                index++;
            }
        }
        swap(arr,++lessEqual,R);//把arr[R]放到lessEqual的地方
        return lessEqual;
    }

    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    //  <arr[R]  ==arr[R]  > arr[R]
    public static int[] netherlandsFlag(int[] arr,int L, int R){
        if(L > R){
            return new int[]{-1,-1};
        }
        if(L == R){
            return new int[]{L,L};
        }
        int less = L-1; //<arr[R]的左边界
        int more = R; //对于R位置上的数，我们先不动它. more 为 >arr[R]的右边界
        int index = L;
        while(index < more){
            if(arr[index] > arr[R]){
                swap(arr,index,--more);
            }else if(arr[index] == arr[R]){
                index++;
            }else if(arr[index] < arr[R]){
                swap(arr,index++,++less);
            }
        }
        swap(arr,more++,R);
        return new int[]{less+1,more-1};
    }

    //快速排序1.0版本
    public static void quickSort1(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process1(arr,0,arr.length-1);
    }
    public static void process1(int[] arr,int L, int R){
        if(L >= R){
            return;
        }
        int mid = partition(arr,L,R);
        process1(arr,L,mid-1);
        process1(arr,mid+1,R);
    }

    //快排2.0
    public static void quickSort2(int[] arr){
        if(arr == null|| arr.length<2){
            return;
        }
        process2(arr,0,arr.length-1);
    }
    public static void process2(int[] arr, int L, int R){
        if(L>=R){
            return;
        }
        int[] equalArea = netherlandsFlag(arr,L,R);
        process2(arr,L,equalArea[0]-1);
        process2(arr,equalArea[1]+1,R);

    }

    //快排3.0
    public static void quickSort3(int[] arr){
        if(arr == null|| arr.length<2){
            return;
        }
        process3(arr,0,arr.length-1);
    }
    public static void process3(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        //L..R上找一个数字跟R做交换
        swap(arr,L+(int)(Math.random()*(R-L+1)),R);
        int[] equalArea = netherlandsFlag(arr,L,R);
        process2(arr,L,equalArea[0]-1);
        process2(arr,equalArea[1]+1,R);
    }

    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        int[] arr = new int[]{99,5,4,3,7,1,8,9,0,345,62,1,2};
        quickSort3(arr);
        printArray(arr);
    }
}
