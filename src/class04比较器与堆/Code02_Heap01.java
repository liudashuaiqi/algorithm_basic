package class04比较器与堆;

//自己实现一个大根堆 已用对数器测试 success
public class Code02_Heap01 {
    public static class MyMaxHeap{
        private int[] heap;
        private int heapSize;
        private final int limit;
        public MyMaxHeap(int limit){
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }
        public boolean isEmpty(){
            return heapSize == 0;
        }
        public boolean isFull(){
            return heapSize == limit;
        }
        public void push(int value){
            heap[heapSize] = value;
            heapInsert(heap,heapSize++);
        }
        public int pop(){
            int ans = heap[0];
            heap[0] = heap[--heapSize]; //左写法，都一样:swap(heap, 0, --heapSize);
            heapify(heap,0,heapSize);
            return ans;
        }
        public void heapInsert(int[] arr,int index){
            while(arr[index] > arr[(index-1)/2]){
                swap(arr,index,(index-1)/2);
                index = (index-1)/2;
            }
        }
        public void heapify(int[] arr, int index,int heapSize){
            int left = index*2+1;
            while(left < heapSize){
                int largest = left+1 < heapSize && arr[left+1] > arr[left]? left+1:left;
                largest = arr[index] > arr[largest]? index :largest;
                if(largest == index){
                    break;
                }
                swap(arr,index,largest);
                index = largest;
                left = index*2+1;
            }
        }
        public void swap(int[] arr,int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
