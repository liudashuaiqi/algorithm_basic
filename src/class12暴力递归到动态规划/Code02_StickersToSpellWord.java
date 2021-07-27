package class12暴力递归到动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode 691已测试，正确
public class Code02_StickersToSpellWord {
    //在主函数中加过滤来解决问题1
    public static int minStickers1(String[] stickers,String target){
        int n = stickers.length;

        int[][] map = new int[n][26];
        for(int i = 0;i < n;i++){
            char[] s = stickers[i].toCharArray();
            for(int j = 0;j < s.length;j++){
                map[i][s[j]-'a']++;
            }
        }
        //如果本来就拼不了目标字符串，直接返回-1就行了
        if(!isNotMissing(map,target)){
            return -1;
        }

        HashMap<String,Integer> dp = new HashMap<>();
        dp.put("",0);
        return process1(dp,map,target);
    }
    public static int process1(HashMap<String,Integer> dp,int[][] map,String rest){
        if(dp.containsKey(rest)){
            return dp.get(rest);
        }
        int ans = Integer.MAX_VALUE;
        int[] tmap = new int[26];
        char[] target = rest.toCharArray();
        for(int i = 0;i < target.length;i++){
            tmap[target[i]-'a']++;
        }
        int n = map.length;

        for(int i = 0;i < n;i++){
            if(map[i][target[0]-'a']==0){
                continue;
            }
            StringBuffer sb = new StringBuffer();
            for(int j = 0;j < 26;j++){
                if(tmap[j] > 0){
                    for(int k = 0;k < Math.max(0,tmap[j]-map[i][j]);k++){
                        sb.append((char)('a'+j));
                    }
                }
            }
            String s = sb.toString();
            int cnt = process1(dp,map,s);
            ans = Math.min(ans,1+cnt);
        }
        dp.put(rest,ans);
        return dp.get(rest);
    }
    public static boolean isNotMissing(int[][] map,String rest){
        int[] tmap = new int[26];
        char[] target = rest.toCharArray();
        for(int i = 0;i < target.length;i++){
            tmap[target[i]-'a']++;
        }
        int n = map.length;
        for(int i = 0;i < 26;i++){
            if(tmap[i] > 0){
                boolean flag = false;
                for(int j = 0;j < n;j++){
                    if(map[j][i] > 0){
                        flag = true;
                    }
                }
                if(flag == false){
                    return false;
                }
            }
        }
        return true;
    }

    //手动在递归函数中做出此边界条件的判定
    //如果dp数组有一个-1，则全都是-1
    public static int minStickers2(String[] stickers, String target) {
        int n = stickers.length;

        int[][] map = new int[n][26];
        for(int i = 0;i < n;i++){
            char[] s = stickers[i].toCharArray();
            for(int j = 0;j < s.length;j++){
                map[i][s[j]-'a']++;
            }
        }

        HashMap<String,Integer> dp = new HashMap<>();
        dp.put("",0);
        int x = process2(dp,map,target);

        // for (Map.Entry<String, Integer> entry : dp.entrySet()) {
        //     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        // }


        return x;
    }
    public static int process2(HashMap<String,Integer> dp,int[][] map,String rest){
        if(dp.containsKey(rest)){
            return dp.get(rest);
        }
        int ans = Integer.MAX_VALUE;
        int[] tmap = new int[26];
        char[] target = rest.toCharArray();
        for(int i = 0;i < target.length;i++){
            tmap[target[i]-'a']++;
        }
        int n = map.length;

        for(int i = 0;i < n;i++){
            if(map[i][target[0]-'a']==0){
                continue;
            }
            StringBuffer sb = new StringBuffer();
            for(int j = 0;j < 26;j++){
                if(tmap[j] > 0){
                    for(int k = 0;k < Math.max(0,tmap[j]-map[i][j]);k++){
                        sb.append((char)('a'+j));
                    }
                }
            }
            String s = sb.toString();
            int cnt = process2(dp,map,s);
            if(cnt != -1){
                ans = Math.min(ans,1+cnt);
            }
        }
        dp.put(rest,ans==Integer.MAX_VALUE?-1:ans);
        return dp.get(rest);
    }

    //还有一种尝试方法,省略了


    public static void main(String[] args) {
        String[] arr = {"aaaa","bbaa","ccddd"};
        String str = "abcccccdddddbbbaaaaa";
        System.out.println(minStickers1(arr, str));
        System.out.println(minStickers2(arr, str));
    }
}
