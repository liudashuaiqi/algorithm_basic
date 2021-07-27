package class12暴力递归到动态规划;

//已经测试 正确
//跟左视频中的写法一样，但是跟他之前写在笔记上的不一样
public class Code07_HorseJump {

    //我自己写的暴力递归的方法 已测试
    //此题暴力递归求的就是递归树中叶子节点的个数
    //如果此题问的是在最短路径的话，就是求的是递归树中的所有分支中，最短的那一个.
    //也就是说在硬币凑目标值的那道题目，如果问的是能有多少种拼凑方法，那就是求叶子节点的数量
    //如果问的是拼凑出目标值最少用几个硬币，那求的就是递归树的所有分支中最短的分支
    public static int ways(int a, int b, int step) {
        return process(a,b,step);
    }

    public static int process(int x,int y, int step){
        if(step == 0){
            return x == 0&&y == 0?1:0;
        }

        if(x<0 || x > 9|| y <0 || y > 8){
            return 0;
        }

        //不管状态存不存在，我都强行开这个状态，那么我就要再加一个base case，专门用来判断新开的状态是否合法,暴力递归用的这种方法
        //或者是我先判断，只有状态合法的时候我才去开这个状态,否则我就不去开这个状态,dp方法用的这种方法
        //所以暴力递归改dp的时候稍微不太一样
        return  process(x-2,y-1,step-1)+process(x-2,y+1,step-1)+
                process(x+2,y-1,step-1)+process(x+2,y+1,step-1)+
                process(x-1,y+2,step-1)+process(x-1,y-2,step-1)+
                process(x+1,y+2,step-1)+process(x+1,y-2,step-1);
    }

    //我自己写的暴力递归的方法改成的dp,已测试
    public static int waysdp(int a, int b, int step) {
        int[][][] dp = new int[10][9][step+1];
        dp[0][0][0] = 1;

        //dp数组最外层的变量为暴力递归中具有单调性的变量，比如index,step,单调递增或者是单调递减
        //暴力递归中从顶向下算，那么在dp中此变量从低向上算
        for(int index = 1;index < step+1;index++){
            for(int i = 0;i < 10;i++){
                for(int j = 0;j < 9;j++){
                    dp[i][j][index] =
                            getValue(dp,i-2,j-1,index-1)+
                            getValue(dp,i-2,j+1,index-1)+
                            getValue(dp,i+2,j-1,index-1)+
                            getValue(dp,i+2,j+1,index-1)+
                            getValue(dp,i-1,j+2,index-1)+
                            getValue(dp,i-1,j-2,index-1)+
                            getValue(dp,i+1,j+2,index-1)+
                            getValue(dp,i+1,j-2,index-1);

                }
            }
        }

        return dp[a][b][step];
    }
    public static int getValue(int[][][] dp, int x, int y,int step){
        if(x<0 || x > 9|| y <0 || y > 8){
            return 0;
        }
        return dp[x][y][step];
    }

    public static void main(String[] args) {
        int x = 7;
        int y = 7;
        int step = 10;
        System.out.println(ways(x, y, step));
        System.out.println(waysdp(x, y, step));
    }

}
