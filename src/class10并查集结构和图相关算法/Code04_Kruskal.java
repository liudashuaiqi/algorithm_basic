package class10并查集结构和图相关算法;

import java.util.*;
//一行行代码对过
public class Code04_Kruskal {
    public static class UnionSet{
        HashMap<Node,Node> parents;
        HashMap<Node,Integer> sizeMap;
        public UnionSet(){
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
        }
        public void makeSets(Collection<Node> nodes){
            parents.clear();
            sizeMap.clear();
            for(Node cur:nodes){
                parents.put(cur,cur);
                sizeMap.put(cur,1);
            }
        }
        public Node findFather(Node a){
            Stack<Node> path = new Stack<>();
            while(a!=parents.get(a)){
                path.push(a);
                a = parents.get(a);
            }
            while(!path.isEmpty()){
                parents.put(path.pop(),a);
            }

            return a;
        }
        public boolean isSameSet(Node a, Node b){
//            if(!parents.containsKey(a)||!parents.containsKey(b)){
//                return false;
//            }
            return findFather(a) == findFather(b);
        }
        public void Union(Node a, Node b){
            if(!parents.containsKey(a)||!parents.containsKey(b)){
                return;
            }
            Node aHead = findFather(a);
            Node bHead = findFather(b);
            if(aHead!=bHead){
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                Node big = aSize > bSize? aHead:bHead;
                Node small = big==aHead? bHead:aHead;
                parents.put(small,big);
                sizeMap.put(big,aSize+bSize);
                sizeMap.remove(small);
            }

        }
    }
    public static class MyComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }
    public static Set<Edge> kruskalMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new MyComparator());
        UnionSet unionSet = new UnionSet();
        unionSet.makeSets(graph.nodes.values());
        for(Edge edge:graph.edges){
            priorityQueue.add(edge);
        }
        Set<Edge> result = new HashSet<>();
        while(!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            if(!unionSet.isSameSet(edge.from,edge.to)){
                unionSet.Union(edge.from,edge.to);
                result.add(edge);
            }
        }
        return result;
    }
}
