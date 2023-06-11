package graph.dfs.eulerianCircuit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class EulerianCircuit {

    public int N; // 정점의 개수
    public int E; // 간선의 개수
    public int[][] edges;
    public boolean[][] visited;
    public ArrayList<Integer>[] eulerian;
    public ArrayList<Integer> eulerianCircuit;

    EulerianCircuit(int N, int E, int[][] edges) {
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

    public void makeGraph() {

        for (int i = 0; i < edges.length; i++) {
            eulerian[edges[i][0]].add(edges[i][1]);
            eulerian[edges[i][1]].add(edges[i][0]);
        }
    }

    public boolean isEven(int node) {

        int size = this.eulerian[node].size();
        if (size % 2 != 0) return false;
        return true;
    }

    public ArrayList<Integer> findRamdomCircuit() {

        for (int i = 0; i < edges.length; i++) {
            if (!visited[edges[i][0]][edges[i][1]] && !visited[edges[i][1]][edges[i][0]]) {
                if (!isEven(edges[i][0])) return new ArrayList<>(0);
                dfs(edges[i][0], edges[i][0], false);
            }
        }
        return this.eulerianCircuit;
    }

    public void dfs(int begin, int end, boolean flag) {

        if (flag && begin == end) return;

        for (int i = 0; i < this.eulerian[begin].size(); i++) {
            int next = this.eulerian[begin].get(i);
            if (visited[begin][next]) continue;
            visited[begin][next] = true;
            visited[next][begin] = true;
            flag = true;
            dfs(next, end, flag);
            this.eulerianCircuit.add(next);
        }
    }
}

class test28 {

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

        EulerianCircuit eulerianCircuit = new EulerianCircuit(N, E, edges);
        eulerianCircuit.makeGraph();
        ArrayList<Integer> answer = eulerianCircuit.findRamdomCircuit();
        Collections.reverse(answer);
        printArrayList(answer);
    }
}
