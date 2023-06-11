package graph.dfs.eulerianCircuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FindRandomCircuit {

    public int N; // 정점의 개수
    public int E; // 간선의 개수
    public int[][] edges;
    public boolean[][] visited;
    public ArrayList<Integer>[] eulerian;
    public ArrayList<Integer> eulerianCircuit;

    FindRandomCircuit(int N, int E, int[][] edges) {
        this.N = N;
        this.E = E;
        this.edges = edges;
        this.visited = new boolean[this.N][this.N];
        this.eulerian = new ArrayList[this.N];
        this.eulerianCircuit = new ArrayList<>();

        for (int i = 0; i < eulerian.length; i++) {
            this.eulerian[i] = new ArrayList<>();
        }
    }

    public ArrayList<Integer> solution() {

        if (!isEven()) return new ArrayList<>(0);
        findRandomCircuit(0);
        return this.eulerianCircuit;
    }

    public void makeGraph() {

        for (int i = 0; i < edges.length; i++) {
            eulerian[edges[i][0]].add(edges[i][1]);
            eulerian[edges[i][1]].add(edges[i][0]);
        }
    }

    public boolean isEven() {

        for (int i = 0; i < eulerian.length; i++) {
            if (eulerian[i].size() % 2 != 0) return false;
        }
        return true;
    }

    public void findRandomCircuit(int node) {

        for (int i = 0; i < eulerian[node].size(); i++) {
            int next = eulerian[node].get(i);
            if (visited[node][next]) continue;
            visited[node][next] = true;
            visited[next][node] = true;
            if (next == node) return;
            findRandomCircuit(next);
            this.eulerianCircuit.add(node);
        }
    }
}

class test29 {

    public static void printArrayList(ArrayList<Integer> eulerianCircuit) {

        for (int i = 0; i < eulerianCircuit.size(); i++) {
            System.out.print(eulerianCircuit.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int E = Integer.parseInt(token[1]);

        int[][] edges = new int[E][2];
        for (int i = 0; i < E; i++) {
            token = bufferedReader.readLine().split("\\s");
            edges[i][0] = Integer.parseInt(token[0]);
            edges[i][1] = Integer.parseInt(token[1]);
        }

        FindRandomCircuit findRandomCircuit = new FindRandomCircuit(N, E, edges);
        findRandomCircuit.makeGraph();
        ArrayList<Integer> answer = findRandomCircuit.solution();
        Collections.reverse(answer);
        printArrayList(answer);
    }
}
