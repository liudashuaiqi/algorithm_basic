package class12暴力递归到动态规划;

//已经对过，代码正确
public class Code03_Knapsack {
    public static int dpWay(int[] w,int[] v,int bag){
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];

        for(int index = N-1;index >= 0; index--){
            for(int rest = 0;rest <= bag; rest++){
                int p1 = dp[index + 1][rest];
                int p2 = -1;
                if( rest - w[index] >= 0){
                    p2 = dp[index + 1][ rest - w[index]] + v[index];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }

        return dp[0][bag];
    }
}
