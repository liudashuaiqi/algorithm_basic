package class01对数器_二分_异或;

//不一定数组非要有序才可以二分,二分的过程中有一种排它性的情况可以出现，就可以二分
//arr无序，任意两个相邻的数都不相等，返回一个局部最小的位置即可（任意）
public class Code06_BSAwesome {
    public static int getLessIndex(int[] arr) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length == 1){
            return 0;
        }
        if(arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length-1] < arr[arr.length-2]){
            return arr.length-1;
        }
        int left = 1;
        int right = arr.length-2;
        while(left < right){
            int mid = (left+right)/2;
            if(arr[mid] > arr[mid-1]){
                right = mid-1;
            }else if(arr[mid] > arr[mid+1]){
                left = mid+1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
