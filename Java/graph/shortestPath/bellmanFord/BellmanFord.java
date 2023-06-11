package graph.shortestPath.bellmanFord;

import java.util.ArrayList;

class Vertex {
    int vertex;
    int weight;

    Vertex(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class BellmanFord {

    public int V;
    public ArrayList<Vertex>[] graph;

    BellmanFord(int V, ArrayList<Vertex>[] graph) {
        this.V = V;
        this.graph = graph;
    }

    public ArrayList<Integer> bellmanFord(int src) {

        ArrayList<Integer> upper = new ArrayList<>();
        for (int i = 0; i < this.V; i++) {
            upper.add(Integer.MAX_VALUE);
        }

        upper.set(src, 0);
        boolean updated = false;

        for (int iter = 0; iter < this.V; iter++) {
            updated = false;
            for (int here = 0; here < this.V; here++) {
                int next = this.graph[here].get(here).vertex;
                int cost = this.graph[here].get(here).weight;
                if (upper.get(next) > upper.get(here) + cost) {
                    upper.set(next, upper.get(here) + cost);
                    updated = true;
                }
            }
            if (!updated) break;
        }
        if (updated) upper.clear();
        return upper;
    }
}

class test40 {

    public static void main(String[] args) {


    }
}
