package class07二叉树的基本算法;

//叠纸小游戏
//main函数为测试代码
public class Code08_PaperFolding {
    public static void printAllFolds(int n){
        printProcess(1, n, true);
    }
    public static void printProcess(int i, int n, boolean down){
        if(i > n){
            return;
        }
        printProcess(i+1,n,true);
        System.out.println(down==true?"凹":"凸");
        printProcess(i+1,n,false);
    }
    public static void main(String[] args){
        printAllFolds(3);
    }
}
