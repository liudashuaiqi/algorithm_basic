package class10并查集结构和图相关算法;

import java.util.*;
//一行行代码对过
public class Code03_TopologySort {
    //directed graph and no loop
    //有向无环图
    public static List<Node> sortedTopology(Graph graph){
        HashMap<Node,Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new LinkedList<>();

        for(Node node:graph.nodes.values()){
            inMap.put(node,node.in);
            if(node.in==0){
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while(!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for(Node next:cur.nexts){
                inMap.put(next,inMap.get(next)-1);
                if(inMap.get(next)==0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
