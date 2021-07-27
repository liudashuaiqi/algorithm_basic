package class01对数器_二分_异或;


//冒泡排序
// 0 ~ N-1
// 0 ~ N-2
// 0 ~ N-3
// .....  0~1    0~i(i = N-1~1)
public class Code02_BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = arr.length-1; i > 0;i--){
            for(int j = 0 ;j < i;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    //i和j如果指向了同一块地址空间则会出错
    public static void swap(int[] arr,int i, int j){
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
    }
}
