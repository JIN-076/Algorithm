package graph.shortestPath.dijkstra;

import datastructure.linkedllist.LinkedListTest;

import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntToDoubleFunction;

class Info implements Comparable<Info> {
    double noise;
    int vertex;

    Info(double noise, int vertex) {
        this.noise = noise;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Info o) {
        if (this.noise > o.noise) return 1;
        else if (this.noise == o.noise) return 0;
        else return -1;
    }
}

public class Routing {

    public int N;
    public int E;
    public boolean[] visited;
    public ArrayList<Info>[] graph;

    Routing(int N, int E, ArrayList<Info>[] graph) {
        this.N = N;
        this.E = E;
        this.visited = new boolean[this.N];
        this.graph = graph;
    }

    public ArrayList<Double> dijkstra() {

        ArrayList<Double> dist = new ArrayList<>();
        for (int i = 0; i < this.N; i++) {
            dist.add(Double.MAX_VALUE);
        }

        dist.set(0, Math.log10(1.0));
        Arrays.fill(this.visited, false);

        while (true) {
            double closest = Double.MAX_VALUE;
            int here = -1;
            for (int i = 0; i < this.N; i++) {
                if (!this.visited[i] && dist.get(i) < closest) {
                    here = i;
                    closest = dist.get(i);
                }
            }

            if (closest == Double.MAX_VALUE) break;
            this.visited[here] = true;

            for (int i = 0; i < this.graph[here].size(); i++) {
                int next = this.graph[here].get(i).vertex;
                if (visited[next]) continue;
                double nextNoise = dist.get(here) + Math.log10(this.graph[here].get(i).noise);
                dist.set(next, Math.min(dist.get(next), nextNoise));
            }
        }
        return dist;
    }
}

class test37 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        ArrayList<Info>[] graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            token = bufferedReader.readLine().split("\\s");
            graph[Integer.parseInt(token[0])].add(new Info(Double.parseDouble(token[2]), Integer.parseInt(token[1])));
            graph[Integer.parseInt(token[1])].add(new Info(Double.parseDouble(token[2]), Integer.parseInt(token[0])));
        }

        Routing routing = new Routing(N, M, graph);
        ArrayList<Double> answer = routing.dijkstra();
        System.out.println(Math.pow(10, answer.get(N - 1)));
    }
}
