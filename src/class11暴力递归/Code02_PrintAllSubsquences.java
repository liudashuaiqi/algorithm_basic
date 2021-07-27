package class11暴力递归;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//测试，正确
public class Code02_PrintAllSubsquences {
    public static List<String> subs(String s){
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process1(str,0,ans,path);
        return ans;
    }
    public static void process1(char[] str,int index,List<String> ans, String path){
        if(index == str.length){
            ans.add(path);
            return;
        }
        String no = path;
        process1(str,index+1,ans,no);
        String yes = path+String.valueOf(str[index]);
        process1(str,index+1,ans,yes);
    }

    public static List<String> subsNoRepeat(String s){
        char[] str = s.toCharArray();
        String path = "";
        HashSet<String> ans = new HashSet<>();
        process2(str,0,ans,path);
        List<String> result = new ArrayList<>();
        for(String cur:ans){
            result.add(cur);
        }
        return result;
    }
    public static void process2(char[] str,int index,Set<String> ans, String path){
        if(index == str.length){
            ans.add(path);
            return;
        }
        String no = path;
        process2(str,index+1,ans,no);
        String yes = path+String.valueOf(str[index]);
        process2(str,index+1,ans,yes);
    }
    public static void main(String[] args) {
        String test = "aacc";
        List<String> ans1 = subs(test);
        List<String> ans2 = subsNoRepeat(test);

        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=================");
        for (String str : ans2) {
            System.out.println(str);
        }
        System.out.println("=================");

    }
}
