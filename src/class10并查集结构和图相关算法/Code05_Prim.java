package class10并查集结构和图相关算法;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
//一行行代码对过
public class Code05_Prim {
    public static class MyComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }
    public static Set<Edge> primMST(Graph graph){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new MyComparator());
        HashSet<Node> nodeSet = new HashSet<>();
        HashSet<Edge> result = new HashSet<>();
        for(Node node:graph.nodes.values()){
            if(!nodeSet.contains(node)){
                nodeSet.add(node);
                for(Edge edge:node.edges){
                    priorityQueue.add(edge);
                }
                while(!priorityQueue.isEmpty()){
                    Edge nowEdge = priorityQueue.poll();
                    Node toNode = nowEdge.to;
                    if(!nodeSet.contains(toNode)){
                        result.add(nowEdge);
                        nodeSet.add(toNode);
                        for(Edge nextEdge:toNode.edges){
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
            break;
        }
        return result;
    }
}
