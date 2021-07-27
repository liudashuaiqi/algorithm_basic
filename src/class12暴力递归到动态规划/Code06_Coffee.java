package class12暴力递归到动态规划;

//一行一行对过，答案正确
public class Code06_Coffee {
    //return process(drinks, a, b, 0, 0);
    public static int process(int[] drinks,int a,int b,int index, int washLine){
        if(index == drinks.length-1){
            return Math.min(drinks[index]+b,Math.max(washLine,drinks[index])+a);
        }
        int wash = Math.max(washLine , drinks[index]) + a;
        int next1 = process(drinks,a,b,index+1,wash);
        int p1 = Math.max(wash,next1);

        int dry = drinks[index] + b;
        int next2 = process(drinks,a,b,index+1,washLine);
        int p2 = Math.max(dry,next2);

        return Math.min(p1,p2);
    }
    public static int dp(int[] drinks,int a,int b){
        if(a >= b){
            return drinks[drinks.length-1] + b;
        }
        //a < b
        int n = drinks.length;
        int limit = 0;
        for(int i = 0;i < n;i++){
            limit = Math.max(limit,drinks[i]) + a;
        }
        int[][] dp = new int[n][limit+1];

        for(int i = 0;i <= limit;i++){
            dp[n-1][i] = Math.min(drinks[n-1]+b,Math.max(i,drinks[n-1])+a);
        }
        for(int index = n-2; index >= 0; index--){
            for(int washLine =0;washLine <= limit;washLine++){

                int wash = Math.max(washLine , drinks[index]) + a;
                int p1 = Integer.MAX_VALUE;
                if(wash <= limit){
                    p1 = Math.max(wash,dp[index+1][wash]);
                }

                int dry = drinks[index] + b;
                int p2 = Math.max(dry,dp[index+1][washLine]);

                dp[index][washLine]= Math.min(p1,p2);
            }
        }
        return dp[0][0];
    }
}
