package class12暴力递归到动态规划;

public class test {
    //leetcode 474 一和零
    //记忆化搜索式的dp
    public static int findMaxForm(String[] strs, int m, int n) {
        if(strs == null || strs.length ==0 || (m<0&&n<0)){
            return 0;
        }

        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i = 0;i < strs.length+1;i++){
            for(int j = 0;j < m+1;j++){
                for(int k = 0;k < n+1;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        //提前记录strs中的0 1 数量
        int[][] map = new int[strs.length][2];
        for(int i = 0;i < strs.length;i++){
            char[] s = strs[i].toCharArray();
            int cnt0 = 0;
            int cnt1 = 0;
            for(int j = 0;j < s.length;j++){
                if(s[j]=='1'){
                    cnt1++;
                }else if(s[j] == '0'){
                    cnt0++;
                }
            }
            map[i][0] = cnt0;
            map[i][1] = cnt1;
        }

        return process(strs,0,m,n,dp,map);
    }
    public static int process(String[] strs,int index,int m, int n,int[][][] dp,int[][] map){
        if(dp[index][m][n]!=-1){
            return dp[index][m][n];
        }
        if(index == strs.length){
            dp[index][m][n] = 0;
            return dp[index][m][n];
        }
        int cnt0 = map[index][0];
        int cnt1 = map[index][1];;

        int count1 = -1;
        if(m >= cnt0 && n >= cnt1){
            count1 = 1+process(strs,index+1,m-cnt0,n-cnt1,dp,map);
        }
        int count2 = process(strs,index+1,m,n,dp,map);

        dp[index][m][n] = Math.max(count1,count2);
        return dp[index][m][n];
    }

    //经典dp
    public static int findMaxForm2(String[] strs, int m, int n) {
        if(strs == null || strs.length ==0 || (m<0&&n<0)){
            return 0;
        }
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i = 0;i < m+1;i++){
            for(int j = 0;j < n+1;j++){
                dp[strs.length][i][j] = 0;
            }
        }
        int[][] map = new int[strs.length][2];
        for(int i = 0;i < strs.length;i++){
            char[] s = strs[i].toCharArray();
            int cnt0 = 0;
            int cnt1 = 0;
            for(int j = 0;j < s.length;j++){
                if(s[j]=='1'){
                    cnt1++;
                }else if(s[j] == '0'){
                    cnt0++;
                }
            }
            map[i][0] = cnt0;
            map[i][1] = cnt1;
        }
        for(int index = strs.length-1;index >= 0;index--){
            for(int j = 0;j < m+1;j++){
                for(int k = 0;k < n+1;k++){

                    int cnt0 = map[index][0];
                    int cnt1 = map[index][1];
                    int count1 = -1;
                    if(j >= cnt0 && k >= cnt1){
                        count1 = 1+dp[index+1][j-cnt0][k-cnt1];
                    }
                    int count2 = dp[index+1][j][k];

                    dp[index][j][k] = Math.max(count1,count2);
                }
            }
        }

        return dp[0][m][n];
    }
    public static void main(String[] args){
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm2(strs,m,n));
    }
}
