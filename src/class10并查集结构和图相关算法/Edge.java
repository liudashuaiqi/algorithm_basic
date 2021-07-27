package class10并查集结构和图相关算法;

public class Edge {
    public int weight;
    public Node from;
    public Node to;
    public Edge(int weight,Node form,Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
