package graph.shortestPath.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node {
    int vertex;
    int weight;

    Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class Nthlon {

    public int N;
    public int START;
    public ArrayList<Integer> a;
    public ArrayList<Integer> b;
    public ArrayList<Node>[] graph;

    Nthlon(int N, ArrayList<Integer> a, ArrayList<Integer> b) {
        this.N = N;
        this.START = 401;
        this.a = a;
        this.b = b;
        this.graph = new ArrayList[401];
        init();
    }

    public void init() {
        for (int i = 0; i < this.graph.length; i++) {
            this.graph[i] = new ArrayList<>();
        }
    }

    public int vertex(int delta) {
        return delta + 200;
    }

    public ArrayList<Integer> dijkstra(int here) {

        ArrayList<Integer> dist = new ArrayList<>();

        return dist;
    }

    public int solve(ArrayList<Integer> a, ArrayList<Integer> b) {

        for (int i = 0; i < a.size(); i++) {
            int delta = a.get(i) - b.get(i);
            this.graph[START].add(new Node(vertex(delta), a.get(i)));
        }

        for (int delta = -200; delta <= 200; delta++) {
            for (int i = 0; i < a.size(); i++) {
                int next = delta + a.get(i) - b.get(i);
                if (Math.abs(next) > 200) continue;
                this.graph[vertex(delta)].add(new Node(vertex(next), a.get(i)));
            }
        }
        ArrayList<Integer> shortest = dijkstra(START);
        int ret = shortest.get(vertex(0));
        if (ret == Integer.MAX_VALUE) return -1;
        return ret;
    }
}

class test39 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] token = bufferedReader.readLine().split("\\s");
            a.add(Integer.parseInt(token[0]));
            b.add(Integer.parseInt(token[1]));
        }

        Nthlon nthlon = new Nthlon(M, a, b);
    }
}
