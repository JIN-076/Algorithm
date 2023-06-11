package graph.shortestPath.dijkstra;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int cost;
    int vertex;

    Pair(int cost, int vertex) {
        this.cost = cost;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.cost > o.cost) return 1;
        else if (this.cost == o.cost) return 0;
        else return -1;
    }
}

public class Dijkstra {

    public int N;
    public int E;
    ArrayList<Point>[] graph;

    /**
     * this.graph
     * x: 연결된 정점 번호
     * y: 간선 가중치
     */

    Dijkstra(int N, int E, ArrayList<Point>[] graph) {
        this.N = N;
        this.E = E;
        this.graph = graph;
    }

    public ArrayList<Integer> dijkstra(int src) {

        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < this.N; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        dist.set(src, 0);
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair front = pq.poll();
            int cost = front.cost;
            int here = front.vertex;
            if (dist.get(here) < cost) continue;

            for (int i = 0; i < this.graph[here].size(); i++) {
                int next = this.graph[here].get(i).x;
                int nextDist = cost + this.graph[here].get(i).y;
                if (dist.get(next) > nextDist) {
                    dist.set(next, nextDist);
                    pq.add(new Pair(nextDist, next));
                }
            }
        }
        return dist;
    }
}

class test35 {

    public static void print(ArrayList<Integer> answer) {

        for (int i = 0; i < answer.size(); i++) {
            System.out.println("dist[" + i + "] = " + answer.get(i));
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int E = Integer.parseInt(token[1]);

        ArrayList<Point>[] graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            token = bufferedReader.readLine().split("\\s");
            graph[Integer.parseInt(token[0])].add(new Point(Integer.parseInt(token[1]), Integer.parseInt(token[2])));
        }

        Dijkstra dijkstra = new Dijkstra(N, E, graph);
        ArrayList<Integer> answer = dijkstra.dijkstra(0);
        print(answer);
    }
}
