package class08二叉树的递归套路;

import java.util.ArrayList;
import java.util.List;

//已经测试，代码正确
public class Code09_MaxHappy {
    public static class Employee{
        public int happy;
        List<Employee> nexts;
        public Employee(int h){
            happy = h;
            nexts = new ArrayList<>();
        }
    }
    public static class Info{
        public int yes;
        public int no;
        public Info(int y,int n){
            yes = y;
            no = n;
        }
    }
    public static int maxHappy2(Employee boss){
        if(boss == null) return 0;
        Info a = process2(boss);
        return Math.max(a.yes,a.no);
    }

    public static Info process2(Employee X){
        if(X.nexts==null){
            return new Info(X.happy,0);
        }
        int yes = X.happy;
        int no = 0;
        for(Employee next:X.nexts){
            Info nextInfo = process2(next);
            yes+= nextInfo.no;
            no+= Math.max(nextInfo.yes,nextInfo.no);
        }
        return new Info(yes,no);
    }
}
