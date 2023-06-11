package graph.dfs;

import datastructure.linkedllist.LinkedListTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 무향그래프: 간선의 분류 X
 * 방향그래프: 간선의 분류 O
 * 1. Tree Edge
 * 2. Forward Edge
 * 3. Back Edge
 * 4. Cross Edge
 */

public class AboutEdge {

    public int N;
    public int E;
    public int counter; // 지금까지 발견한 정점의 수
    public ArrayList<Integer>[] graph;
    public int[] discovered; // i번 정점의 발견순서
    public boolean[] finished; // dfs(i)의 종료 여부

    AboutEdge(int N, int E, ArrayList<Integer>[] graph) {
        this.N = N;
        this.E = E;
        this.counter = 0;
        this.graph = graph;
        this.discovered = new int[N];
        Arrays.fill(this.discovered, -1);
        this.finished = new boolean[N];
        Arrays.fill(this.finished, false);
    }

    public void solution() {
        dfs(0);
    }

    /**
     * DFS를 통해 현재 정점 u와 인접한 정점들을 탐색
     * 1-1. 인접한 정점 v가 아직 탐색되지 않았다면 -> Tree Edge
     * 1-2. 인접한 정점 v가 이미 탐색되었다면
     * 2-1. 인접한 정점 v가 현재 정점 u보다 늦게 발견되었다면 -> v는 u의 후손. Forward Edge
     * 2-2. 인접한 정점 v가 현재 정점 u보다 빨리 발견되었다면
     * 3-1. 인접한 정점 v의 dfs가 아직 종료되지 않았다면 -> u는 v의 후손. Back Edge
     * 3-2. 인접한 정점 v의 dfs가 이미 종료되었다면 -> u와 v는 선조-자손 관계 X. Cross Edge
     */

    public void dfs(int here) {
        this.discovered[here] = this.counter++;
        for (int i = 0; i < this.graph[here].size(); i++) {
            int next = this.graph[here].get(i);
            System.out.print("( " + here + ", " + next + " ) ia a ");
            if (this.discovered[next] == -1) {
                System.out.println("Tree Edge");
                dfs(next);
            }
            else if (this.discovered[here] < this.discovered[next]) {
                System.out.println("Forward Edge");
            }
            else if (!this.finished[next]) {
                System.out.println("Back Edge");
            }
            else {
                System.out.println("Cross Edge");
            }
        }
        this.finished[here] = true;
    }
}

class test31 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int E = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            String[] token = bufferedReader.readLine().split("\\s");
            graph[Integer.parseInt(token[0])].add(Integer.parseInt(token[1]));
        }

        AboutEdge aboutEdge = new AboutEdge(N, E, graph);
        aboutEdge.solution();
    }
}
