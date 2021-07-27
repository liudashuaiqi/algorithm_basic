package class04比较器与堆;

//堆排序 先建立大根堆  对数器跑过 已经正确

public class Code04_HeapSort {
    public static void heapSort(int[] arr){
        if(arr == null|| arr.length < 2){
            return;
        }
//        for(int i = 0;i < arr.length;i++){
//            heapInsert(arr,i);
//        }
        for(int i = arr.length-1;i >= 0;i--){
            heapify(arr,i,arr.length);
        }
        int index = arr.length; //跟左的写法不太一样
        while(index > 0){
            swap(arr,0,--index);
            heapify(arr,0,index);
        }
    }
    public static void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    public static void heapify(int[]arr, int index,int heapSize){
        int left = index*2+1;
        while(left < heapSize){
            int largest = left + 1 < heapSize && arr[left+1] > arr[left]? left+1 : left;
            largest = arr[index] > arr[largest]? index:largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index*2+1;
        }
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
        heapSort(arr);
        printArray(arr);
    }
}
