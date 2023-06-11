package graph.shortestPath.dijkstra;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraWithoutPQ {

    public int N;
    public int E;
    public boolean[] visited;
    ArrayList<Point>[] graph;

    /**
     * this.graph
     * x: 연결된 정점 번호
     * y: 간선 가중치
     */

    DijkstraWithoutPQ(int N, int E, ArrayList<Point>[] graph) {
        this.N = N;
        this.E = E;
        this.visited = new boolean[N];
        this.graph = graph;
    }

    public ArrayList<Integer> dijkstra(int src) {

        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < this.N; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        Arrays.fill(this.visited, false);
        dist.set(src, 0);

        while (true) {
            int closest = Integer.MAX_VALUE;
            int here = -1;
            for (int i = 0; i < this.N; i++) {
                if (!this.visited[i] && dist.get(i) < closest) {
                    here = i;
                    closest = dist.get(i);
                }
            }
            if (closest == Integer.MAX_VALUE) break;
            this.visited[here] = true;

            for (int i = 0; i < this.graph[here].size(); i++) {
                int next = this.graph[here].get(i).x;
                if (visited[next]) continue;
                int nextDist = dist.get(here) + this.graph[here].get(i).y;
                dist.set(next, Math.min(dist.get(next), nextDist));
            }
        }
        return dist;
    }
}

class test36 {

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

        DijkstraWithoutPQ dijkstraWithoutPQ = new DijkstraWithoutPQ(N, E, graph);
        ArrayList<Integer> answer = dijkstraWithoutPQ.dijkstra(0);
        print(answer);
    }
}

/**
 * 7 9
 * 0 1 5
 * 0 2 1
 * 2 3 2
 * 3 1 1
 * 3 4 5
 * 1 5 6
 * 1 6 3
 * 3 5 3
 * 5 6 2
 */