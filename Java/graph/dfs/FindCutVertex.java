package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class FindCutVertex {

    public int N;
    public int E;
    ArrayList<Integer>[] graph;
    public int[] discovered; // 각 정점의 발견 순서
    public boolean[] isCutVertex; // 각 정점이 절단점인지 여부
    public int counter;

    FindCutVertex(int N, int E, ArrayList<Integer>[] graph) {
        this.N = N;
        this.E = E;
        this.graph = graph;
        this.discovered = new int[N];
        this.isCutVertex = new boolean[N];
        this.counter = 0;

        Arrays.fill(this.discovered, -1);
        Arrays.fill(this.isCutVertex, false);
    }

    public ArrayList<Integer> solution() {
        findCutVertex(0, true);
        return printCutVertex();
    }

    public ArrayList<Integer> printCutVertex() {

        ArrayList<Integer> cutVertex = new ArrayList<>();
        for (int i = 0; i < this.isCutVertex.length; i++) {
            if (this.isCutVertex[i]) cutVertex.add(i);
        }
        return cutVertex;
    }

    /**
     * 무향그래프에서 here을 루트로 갖는 서브트리에 있는 절단첨 찾기
     * 처음 호출하는 정점에 대해, isRoot = true
     * @Return 해당 서브트리에서 역방향 간선으로 갈 수 있는 정점 중 가장 일찍 발견된 정점의 발견 순서
     */

    public int findCutVertex(int here, boolean isRoot) {

        this.discovered[here] = this.counter++;
        int ret = this.discovered[here];
        int childern = 0;

        for (int i = 0; i < this.graph[here].size(); i++) {
            int next = this.graph[here].get(i);

            /**
             * 발견된 적 없는 정점을 탐색했다면
             * next -> here의 자식이므로 ++child
             * next를 root로 하는 서브트리에서 재탐색 -> next와 인접한 정점들 중 가장 먼저 발견된 정점 순서를 반환
             *
             * 발견된 적 있는 정점을 탐색했다면
             * here -> next의 자식
             * 자신, here의 발견순서와 부모, next의 발견 순서 중 먼저 발견된 정점 순서를 반환
             */

            if (this.discovered[next] == -1) {
                ++childern;
                int subTree = findCutVertex(next, false);

                /**
                 * 자식, 서브트리가 반환한 발견 순서가 부모, here보다 크거나 같으면 절단점에 해당
                 */

                if (!isRoot && subTree >= this.discovered[here]) this.isCutVertex[here] = true;
                ret = Math.min(ret, subTree);
            } else {
                ret = Math.min(ret, this.discovered[next]);
            }
        }
        if (isRoot) this.isCutVertex[here] = (childern >= 2);
        return ret;
    }
}

class test32 {

    public static void print(ArrayList<Integer> answer) {

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }

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
            graph[Integer.parseInt(token[1])].add(Integer.parseInt(token[0]));
        }

        FindCutVertex findCutVertex = new FindCutVertex(N, E, graph);
        ArrayList<Integer> answer = findCutVertex.solution();
        print(answer);
    }
}
