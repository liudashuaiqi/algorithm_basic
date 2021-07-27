package class01对数器_二分_异或;

public class Code07_EvenTimesOddTimes {
    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for(int i = 0;i < arr.length;i++){
            eor ^= arr[i];
        }
        System.out.println(eor);
    }
    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for(int i = 0;i < arr.length;i++){
            eor ^= arr[i];//eor = a^b
        }
        int rightOne = eor & ((~eor) + 1);//把eor最右侧的1取出来
        int onlyOne = 0;
        for(int i = 0;i <arr.length;i++){
            if((arr[i] & rightOne) == 1){//全都是1的异或
                onlyOne = onlyOne ^ arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor^onlyOne));
    }
    //统计一个数N对应的二进制数1出现的次数
    public static int bit1counts(int N) {
        int count = 0;
        while(N != 0){
            int rightOne = N & ((~N)+1);
            N = N ^ rightOne;
            count++;
        }
        return count;
    }
}
