package class11暴力递归;

//已对过，正确
public class Code08_CardsInLine {
    //暴力递归
    public static int win1(int[] arr){
        if(arr == null|| arr.length == 0){
            return 0;
        }
        return Math.max(
                f(arr,0,arr.length-1),
                s(arr,0,arr.length-1)
        );
    }
    public static int f(int[] arr,int L, int R){
        if(L == R){
            return arr[L];
        }
        return Math.max(
                arr[L] + s(arr,L+1,R),
                arr[R] + s(arr,L,R-1)
                );
    }
    public static int s(int[] arr,int L, int R){
        if(L == R){
            return 0;
        }
        return Math.min(f(arr,L+1,R),f(arr,L,R-1));
    }

    //经典动态规划
    public static int win2(int[] arr) {
        if(arr == null|| arr.length == 0){
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for(int i = 0;i < N;i++){
            f[i][i] = arr[i];
        }
        for(int i = 1;i < N;i++){
            int L = 0;
            int R = i;
            while(L < N && R <N){
                f[L][R] = Math.max(
                        arr[L] + s[L+1][R],
                        arr[R] + s[L][R-1]);
                s[L][R] = Math.min(f[L+1][R],f[L][R-1]);
                L++;
                R++;
            }
        }

        return Math.max(f[0][N-1], s[0][N-1]);
    }

    //不讲究组织形式的记忆化搜索方式(自己写的)
    public static int win3(int[] arr) {
        if(arr == null|| arr.length == 0){
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];
        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                f[i][j] = -1;
                s[i][j] = -1;
            }
        }
        for(int i = 0;i < N;i++){
            f[i][i] = arr[i];
            s[i][i] = 0;
        }
        return Math.max(
                ff(arr,0,arr.length-1,f,s),
                ss(arr,0,arr.length-1,f,s)
        );
    }

    public static int ff(int[] arr,int L, int R,int[][] f,int[][] s){
        if(f[L][R]!=-1){
            return f[L][R];
        }
        if(L == R){
            f[L][R] = arr[L];
            return f[L][R];
        }
        f[L][R] = Math.max(
                arr[L] + ss(arr,L+1,R,f,s),
                arr[R] + ss(arr,L,R-1,f,s)
        );
        return f[L][R];
    }
    public static int ss(int[] arr,int L, int R,int[][] f,int[][] s){
        if(s[L][R]!=-1){
            return s[L][R];
        }
        if(L == R){
            s[L][R] = 0;
            return s[L][R];
        }
        s[L][R] = Math.min(ff(arr,L+1,R,f,s),ff(arr,L,R-1,f,s));
        return s[L][R];
    }

    public static void main(String[] args) {
        int[] arr = { 4,7,9,5 };
        // 4 7 9 5
        // A 4 9
        // B 7 5
        System.out.println(win3(arr));
        System.out.println(win2(arr));
        System.out.println(win1(arr));
    }
}
