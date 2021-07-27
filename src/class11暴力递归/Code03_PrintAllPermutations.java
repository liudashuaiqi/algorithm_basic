package class11暴力递归;

import java.util.ArrayList;
import java.util.List;

//已经测试，正确
public class Code03_PrintAllPermutations {
    public static ArrayList<String> permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if(str == null||str.length()==0){
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs,0,res);
        return res;
    }
    public static void process(char[] str,int index,ArrayList<String> res){
        if(index == str.length){
            res.add(String.valueOf(str));
            return;
        }
        for(int i = index;i<str.length;i++){
            swap(str,i,index);
            process(str,index+1,res);
            swap(str,i,index);
        }
    }
    public static ArrayList<String> permutationNoRepeat(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null||str.length()==0){
            return res;
        }
        char[] chs = str.toCharArray();
        process1(chs,0,res);
        return res;
    }
    public static void process1(char[] str,int index,ArrayList<String> res){
        if(index == str.length){
            res.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for(int i = index;i<str.length;i++){
            if(!visit[str[i]-'a']){
                visit[str[i]-'a'] = true;
                swap(str,i,index);
                process1(str,index+1,res);
                swap(str,i,index);
            }
        }
    }
    public static void swap(char[] str,int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    public static void main(String[] args) {
        String s = "aac";
        List<String> ans1 = permutation(s);
        for (String str : ans1) {
            System.out.println(str);
        }
        System.out.println("=======");
        List<String> ans2 = permutationNoRepeat(s);
        for (String str : ans2) {
            System.out.println(str);
        }

    }
}
