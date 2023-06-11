package graph.shortestPath.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Infos implements Comparable<Infos> {
    int vertex;
    int weight;

    Infos(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Infos o) {
        if (this.weight > o.weight) return 1;
        else if (this.weight == o.weight) return 0;
        else return -1;
    }
}

public class FireTrucks {

    public int V;
    public int E;
    public int N;
    public int M;
    public boolean[] visited;
    public ArrayList<Integer> firePlaces;
    public ArrayList<Integer> fireTrucks;
    public ArrayList<Infos>[] graph;

    FireTrucks(int V, int E, int N, int M, ArrayList<Integer> firePlaces, ArrayList<Integer> fireTrucks, ArrayList<Infos>[] graph) {
        this.V = V;
        this.E = E;
        this.N = N;
        this.M = M;
        this.firePlaces = firePlaces;
        this.fireTrucks = fireTrucks;
        this.visited = new boolean[V + 1];
        this.graph = graph;
    }

    public ArrayList<Integer> dijkstra() {

        ArrayList<Integer> dist = new ArrayList<>();
        for (int i = 0; i < this.graph.length; i++) {
            dist.add(Integer.MAX_VALUE);
        }

        Arrays.fill(this.visited, false);

        for (int i = 0; i < fireTrucks.size(); i++) {
            this.graph[this.V].add(new Infos(fireTrucks.get(i), 0));
            this.graph[fireTrucks.get(i)].add(new Infos(this.V, 0));
        }

        dist.set(this.V, 0);

        while (true) {
            int closest = Integer.MAX_VALUE;
            int here = -1;
            for (int i = 0; i < this.graph.length; i++) {
                if (!visited[i] && dist.get(i) < closest) {
                    here = i;
                    closest = dist.get(i);
                }
            }

            if (closest == Integer.MAX_VALUE) break;
            this.visited[here] = true;

            for (int i = 0; i < this.graph[here].size(); i++) {
                int next = this.graph[here].get(i).vertex;
                if (this.visited[next]) continue;
                int nextDist = dist.get(here) + this.graph[here].get(i).weight;
                dist.set(next, Math.min(dist.get(next), nextDist));
            }
        }
        return dist;
    }

    public void print(ArrayList<Integer> dist) {

        for (int i = 0; i < dist.size(); i++) {
            System.out.println("dist[" + i + "] = " + dist.get(i));
        }
    }

    public int solution() {
        int answer = 0;

        ArrayList<Integer> dist = dijkstra();
        print(dist);

        for (int i = 0; i < dist.size(); i++) {
            if (firePlaces.contains(i)) answer += dist.get(i);
        }

        return answer;
    }
}

class test38 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int V = Integer.parseInt(token[0]);
        int E = Integer.parseInt(token[1]);
        int N = Integer.parseInt(token[2]);
        int M = Integer.parseInt(token[3]);

        ArrayList<Infos>[] graph = new ArrayList[V + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            token = bufferedReader.readLine().split("\\s");
            graph[Integer.parseInt(token[0]) - 1].add(new Infos(Integer.parseInt(token[1]) - 1, Integer.parseInt(token[2])));
            graph[Integer.parseInt(token[1]) - 1].add(new Infos(Integer.parseInt(token[0]) - 1, Integer.parseInt(token[2])));
        }

        token = bufferedReader.readLine().split("\\s");
        ArrayList<Integer> firePlaces = new ArrayList<>(N);
        for (int i = 0; i < token.length; i++) {
            firePlaces.add(Integer.parseInt(token[i]) - 1);
        }

        token = bufferedReader.readLine().split("\\s");
        ArrayList<Integer> fireTrucks = new ArrayList<>(M);
        for (int i = 0; i < token.length; i++) {
            fireTrucks.add(Integer.parseInt(token[i]) - 1);
        }

        FireTrucks fireTruck = new FireTrucks(V, E, N, M, firePlaces, fireTrucks, graph);
        int answer = fireTruck.solution();
        System.out.println(answer);
    }
}
