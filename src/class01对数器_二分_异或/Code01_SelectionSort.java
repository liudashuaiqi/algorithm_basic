package class01对数器_二分_异或;
//对数器
//Math.random() [0,1) 返回0到1左闭右开这个范围上所有小数中等概率返回一个
//Math.random() * N 返回0到N这个范围上左闭右开任何一个小数,等概率返回一个
//(int)(Math.random() * N) [0,N-1] 返回0到N-1左闭右闭这个范围上等概率返回一个整数
//第三种情况两个做一个减法。[-?,+?]负的某一个值到正的某一个值上面都有

import java.util.Arrays;

//选择排序
//使用了对数器
public class Code01_SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //0~N-1  1~N-1  2~N-1 ... N-2~N-1
        //i~N-1
        for(int i = 0;i < arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j < arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr,minIndex,i);
        }
    }
    public static void swap(int[] arr,int i,int j){
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

    //对数器
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }
    public static int[] copyArray(int[] arr){
        if(arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            res[i] = arr[i];
        }
        return res;
    }
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] res = new int[(int)(Math.random()*(1+maxSize))];
        for(int i = 0;i < res.length;i++){
            res[i] = (int)(Math.random()*(maxValue+1)) - (int)(Math.random()*(maxValue+1));
        }
        return res;
    }
    public static boolean isEqual(int[] arr, int[] res){
        if((arr == null && res != null) || (arr !=null && res == null)){
            return false;
        }
        if(arr == null && res == null){
            return true;
        }
        if(arr.length != res.length){
            return false;
        }
        for(int i = 0;i < arr.length;i++){
            if(arr[i] != res[i]){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0;i < testTime;i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if(!isEqual(arr1,arr2)){
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!":"Fucked fucking");

        int[] arr = generateRandomArray(maxSize,maxValue);
        selectionSort(arr);
        printArray(arr);
    }
}
