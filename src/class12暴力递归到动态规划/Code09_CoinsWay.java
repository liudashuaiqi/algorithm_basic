package class12暴力递归到动态规划;

//已测试，正确
public class Code09_CoinsWay {
    //从左往右的尝试模型
    public static int ways1(int[] arr,int aim){
        if(arr == null || arr.length==0|| aim < 0){
            return 0;
        }
        return process1(arr,0,aim);
    }
    public static int process1(int[] arr,int index, int rest){
        //rest >= 0
        if(index == arr.length){
            return rest == 0? 1 : 0;
        }
        int ways = 0;
        for(int i = 0;rest - arr[index]*i >=0;i++){
            ways += process1(arr, index+1,rest-arr[index]*i);
        }
        return ways;
    }

    //记忆化搜索
    public static int ways2(int[] arr,int aim){
        if(arr == null || arr.length == 0|| aim < 0){
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];
        for(int i = 0;i <= N;i++){
            for(int j = 0;j <= aim;j++){
                dp[i][j] = -1;
            }
        }
        return process2(arr,0,aim,dp);
    }
    public static int process2(int[] arr,int index,int rest,int[][] dp){
        if(dp[index][rest]!=-1){
            return dp[index][rest];
        }
        if(index == arr.length){
            dp[index][rest] = rest == 0? 1 : 0;
            return dp[index][rest];
        }
        int ways = 0;
        for(int i = 0;rest - arr[index]*i >=0;i++){
            ways += process1(arr, index+1,rest-arr[index]*i);
        }
        dp[index][rest] = ways;
        return dp[index][rest];
    }

    //经典dp
    public static int ways3(int[] arr,int aim){
        if(arr == null || arr.length==0|| aim < 0){
            return 0;
        }
        int N = arr.length;
        int[][] dp =new int[N+1][aim+1];
        dp[N][0] = 1;

        for(int index = N-1; index >=0;index--){
            for(int rest = 0; rest <= aim;rest++){
                int ways = 0;
                for(int i = 0;rest - arr[index]*i >=0;i++){
                    ways += dp[index+1][rest-arr[index]*i];
                }
                dp[index][rest] = ways;
            }
        }

        return dp[0][aim];
    }

    //优化枚举后的dp
    public static int ways4(int[] arr,int aim){
        if(arr == null || arr.length==0|| aim < 0){
            return 0;
        }
        int N = arr.length;
        int[][] dp =new int[N+1][aim+1];
        dp[N][0] = 1;

        for(int index = N-1; index >=0;index--){
            for(int rest = 0; rest <= aim;rest++){
                dp[index][rest] = dp[index+1][rest];
                if(rest-arr[index] >=0){
                    dp[index][rest] += dp[index][rest-arr[index]];
                }
            }
        }

        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10,50,100 };
        int sum = 1000;
        System.out.println(ways1(arr, sum));
        System.out.println(ways2(arr, sum));
        System.out.println(ways3(arr, sum));
        System.out.println(ways4(arr, sum));
    }
}
