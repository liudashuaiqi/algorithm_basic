package class10并查集结构和图相关算法;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//一行一行的代码对过
public class Code01_UnionFind {
    public static class Node<V>{
        V value;
        public Node(V v){
            value = v;
        }
    }

    public static class UnionSet<V>{
        public HashMap<V,Node<V>> nodes;
        public HashMap<Node<V>,Node<V>> parents;
        public HashMap<Node<V>,Integer> sizeMap;

        public UnionSet(List<V> values){
            nodes = new HashMap<>();
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for(V cur:values){
                Node<V> node = new Node<>(cur);
                nodes.put(cur,node);
                parents.put(node,node);
                sizeMap.put(node,1);
            }
        }
        public Node<V> findFather(Node<V> cur){
            Stack<Node<V>> path = new Stack<>();
            while(cur!=parents.get(cur)){
                path.push(cur);
                cur = parents.get(cur);
            }
            while(!path.isEmpty()){
                parents.put(path.pop(),cur);
            }
            return cur;
        }
        public boolean isSameSet(V a,V b){
            if(!nodes.containsKey(a)||!nodes.containsKey(b)){
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }
        public void union(V a, V b){
            if(!nodes.containsKey(a)||!nodes.containsKey(b)){
                return ;
            }
            Node<V> aHead = findFather(nodes.get(a));
            Node<V> bHead = findFather(nodes.get(b));
            if(aHead != bHead){
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node<V> big = aSize>bSize? aHead:bHead;
                Node<V> small = big==aHead? bHead:aHead;
                parents.put(small,big);
                sizeMap.put(big,aSize+bSize);
                sizeMap.remove(small);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        UnionSet<Integer> uS = new UnionSet<>(list);
        uS.union(1,4);
        System.out.println(uS.isSameSet(1,4));
    }
}
