package class11暴力递归;

//已经测试正确
public class Code06_ConvertToLetterString {
    public static int number(String str){
        if(str == null|| str.length()==0){
            return 0;
        }
        int result = process(str.toCharArray(),0);
        return result;
    }
    public static int process(char[] str,int i){
        if(i==str.length){
            return 1;
        }
        if(str[i] == '0'){
            return 0;
        }
        if(str[i]=='1'){
            int res = process(str,i+1);
            if(i+1<str.length){
                res+=process(str,i+2);
            }
            return res;
        }
        if(str[i]=='2'){
            int res = process(str,i+1);
            if(i+1<str.length&&str[i+1]>'0'&&str[i+1]<='6'){
                res+=process(str,i+2);
            }
            return res;
        }
        int res = process(str,i+1);
        return res;
    }
    public static int dpWays2(String s){
        if(s == null|| s.length()==0){
            return 0;
        }
        int N = s.length();
        char[] str = s.toCharArray();
        int[] dp = new int[N+1];
        dp[N] = 1;
        for(int i = N-1;i >= 0; i--){
            if (str[i] == '0') {
                dp[i] = 0;
            }else if (str[i] == '1') {
                int res = dp[i + 1];
                if (i + 1 < str.length) {
                    res += dp[i + 2];
                }
                dp[i] = res;
            }else if (str[i] == '2') {
                int res = dp[i+1];
                if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                    res += dp[i+2]; // (i和i+1)作为单独的部分，后续有多少种方法
                }
                dp[i] = res;
            }else{
                dp[i] = dp[i+1];
            }

        }
        return dp[0];
    }
    public static void main(String[] args) {
        System.out.println(number("11111"));
        System.out.println(dpWays2("11111"));
    }
}
