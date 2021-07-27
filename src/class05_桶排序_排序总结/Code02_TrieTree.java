package class05_桶排序_排序总结;

//对数器跑过。正确!!!
//使用hashmap实现trie 代码省略   以后一定要补上!!!!!!!!!!
public class Code02_TrieTree {
    public static class Node1{
        public int pass;
        public int end;
        public Node1[] nexts;
        public Node1(){
            pass = 0;
            end = 0;
            nexts = new Node1[26];
        }
    }
    public static class Trie1{
        public Node1 root;
        public Trie1(){
            root = new Node1();
        }
        public void insert(String word){
            if(word == null){
                return;
            }
            char[] s = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int path = 0;
            for(int i = 0;i < s.length;i++){
                path = s[i]-'a';
                if(node.nexts[path]==null){
                    node.nexts[path] = new Node1();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }
        public void delete(String word){
            if(search(word)!=0){
                char[] s = word.toCharArray();
                Node1 node = root;
                int path = 0;
                node.pass--;
                for(int i = 0;i < s.length;i++){
                    path = s[i]-'a';
                    if(--node.nexts[path].pass==0){
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }
        //查询加入过几次
        public int search(String word){
            if(word == null){
                return 0;
            }
            char[] s = word.toCharArray();
            Node1 node = root;
            int path = 0;
            for(int i = 0;i < s.length;i++){
                path = s[i]-'a';
                if(node.nexts[path]==null){
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.end;
        }
        //查询有多少个字符串以pre作为前缀
        public int preFixNumber(String pre){
            if(pre == null){
                return 0;
            }
            char[] s = pre.toCharArray();
            Node1 node = root;
            int path = 0;
            for(int i = 0;i < s.length;i++){
                path = s[i]-'a';
                if(node.nexts[path]==null){
                    return 0;
                }
                node = node.nexts[path];
            }
            return node.pass;
        }
    }
}
