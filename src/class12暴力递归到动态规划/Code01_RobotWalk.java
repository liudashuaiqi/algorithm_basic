package class12暴力递归到动态规划;

//已测试，正确
public class Code01_RobotWalk {
    //暴力递归的方式求解
    public static int ways1(int N, int M, int K, int P){
        //无效参数直接返回
        if(N < 0 || K < 1|| M <  1|| M > N || P < 1 || P > N){
            return 0;
        }
        return walk(N,M,K,P);
    }
    public static int walk(int N, int cur,int rest,int P){
        if(rest == 0){
            return cur == P? 1:0;
        }
        if(cur == 1){
            return walk(N,2,rest-1,P);
        }
        if(cur == N){
            return walk(N,N-1,rest-1,P);
        }
        return walk(N,cur-1,rest-1,P) + walk(N,cur+1,rest-1,P);
    }

    //记忆化搜索方式的动态规划
    public static int waysCache(int N,int M,int K,int P){
        if(N < 0 || K < 1|| M <  1|| M > N || P < 1 || P > N){
            return 0;
        }
        int[][] dp = new int[N+1][K+1];
        for(int row = 0;row <= N; row++){
            for(int col = 0;col <= K; col++){
                dp[row][col] = -1;
            }
        }
        return walkCache(N,M,K,P,dp);
    }
    public static int walkCache(int N, int cur,int rest,int P,int[][] dp){
        if(dp[cur][rest] != -1){
            return dp[cur][rest];
        }
        if(rest == 0){
            dp[cur][rest] = cur==P? 1:0;
            return dp[cur][rest];
        }
        if(cur == 1){
            dp[cur][rest] = walkCache(N,2,rest-1,P,dp);
            return dp[cur][rest];
        }
        if(cur == N){
            dp[cur][rest] = walkCache(N,N-1,rest-1,P,dp);
            return dp[cur][rest];
        }
        dp[cur][rest] = walkCache(N,cur-1,rest-1,P,dp)+walkCache(N,cur+1,rest-1,P,dp);
        return dp[cur][rest];
    }


    public static void main(String[] args) {
        System.out.println(ways1(7, 4, 9, 5));
        System.out.println(waysCache(7, 4, 9, 5));
//        System.out.println(ways3(7, 4, 9, 5));
//        System.out.println(ways4(7, 4, 9, 5));
//        System.out.println(ways5(7, 4, 9, 5));
    }
}
