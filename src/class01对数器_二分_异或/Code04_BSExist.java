package class01对数器_二分_异或;

//二分查找
public class Code04_BSExist {
    public static boolean exist(int[] sortedArr,int num){
        if(sortedArr == null || sortedArr.length == 0){
            return false;
        }
        int L = 0;
        int R = sortedArr.length -1;
        while (L <= R){
            //int mid = (L + R)/2; // L+R可能会越界
            //int mid = L + (R - L)/2;
            // N/2  N >> 1
            int mid = L + ((R - L) >> 1);
            if(sortedArr[mid] == num){
                return true;
            }else if(sortedArr[mid] > num){
                R = mid-1;
            }else if(sortedArr[mid] < num){
                L = mid+1;
            }

        }

        return sortedArr[L] == num;
    }
}
