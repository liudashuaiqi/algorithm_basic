package class11暴力递归;
//背包问题
//代码已经对过，但是使用自己的写法
public class Code07_Knapsack {
    public static int getMaxValue(int[] w,int[] v,int bag){
        return process(w,v,0,0,bag);
    }
    public static int process(int[] w,int[] v,int index,int alreadyW,int bag){
        if(alreadyW > bag){
            return -1;
        }
        if(index == w.length){
            return 0;
        }
        int p1 = process(w,v,index+1,alreadyW,bag);
        int p2 = process(w,v,index+1,alreadyW+w[index],bag);

        //自己的写法
        if(p2!=-1){
            p2 += v[index];
        }
        return Math.max(p1,p2);
    }
    public static int maxValue(int[] w,int []v, int bag){
        return process(w,v,0,bag);
    }
    public static int process(int[]w, int[] v,int index,int rest){
        if(rest < 0){
            return -1;
        }
        if(index == w.length){
            return 0;
        }
        int p1 = process(w,v,index+1,rest);
        int p2Next = process(w,v,index+1,rest-w[index]);
        int p2 = -1;
        if(p2Next!=-1){
            p2 = p2Next+v[index];
        }
        return Math.max(p1,p2);
    }

    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        int bag = 11;
        System.out.println(getMaxValue(weights, values, bag));
        System.out.println(maxValue(weights, values, bag));
    }
}
