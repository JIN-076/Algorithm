package graph.dfs.unrootedTree.dominatingSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Gallery {

    public static int UNWATCHED = 0;
    public static int WATCHED = 1;
    public static int INSTALLED = 2;

    public int G;
    public int H;
    ArrayList<Integer>[] tree;
    boolean[] visited;
    public int installed;

    Gallery(int G, int H, ArrayList<Integer>[] tree) {
        this.G = G;
        this.H = H;
        this.tree = tree;
        this.visited = new boolean[G];
        this.installed = 0;
    }

    public int solution() {
        return installCamera();
    }

    /**
     * 최소 지배 집합 찾기
     *
     * 1. 잎의 노드는 선택하지 않는다.
     * 2. 자기 자손 중, 아직 지배당하지 않은 노드가 하나라도 있다면 현재 노드를 선택한다.
     * 3. 외의 경우, 현재 노드를 선택하지 않는다.
     */

    public int dfs(int here) {

        this.visited[here] = true;
        int[] childern = { 0, 0, 0 };
        for (int i = 0; i < this.tree[here].size(); i++) {
            int next = this.tree[here].get(i);
            if (!visited[next]) ++childern[dfs(next)];
        }

        /**
         * UNWATCHED: 다른 노드에게 지배당하고 있지 않음
         * WATCHED: 다른 노드에게 지배당하고 있음
         * INSTALLED: 지배 집합의 일부로 선택되었음
         *
         * 1. 자손 노드 중, 감시되지 않는 노드가 있다면 카메라 설치
         * 2. 자손 노드 중, 카메락가 설치된 노드가 있을 경우
         */

        if (childern[UNWATCHED] != 0) {
            ++installed;
            return INSTALLED;
        }
        if (childern[INSTALLED] != 0) {
            return WATCHED;
        }
        return UNWATCHED;
    }

    public int installCamera() {

        this.installed = 0;
        Arrays.fill(this.visited, false);

        for (int i = 0; i < G; i++) {
            if (!visited[i] && dfs(i) == UNWATCHED) ++installed;
        }
        return installed;
    }
}

class test33 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int G = Integer.parseInt(token[0]);
        int H = Integer.parseInt(token[1]);

        ArrayList<Integer>[] tree = new ArrayList[G];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < H; i++) {
            token = bufferedReader.readLine().split("\\s");
            tree[Integer.parseInt(token[0])].add(Integer.parseInt(token[1]));
            tree[Integer.parseInt(token[1])].add(Integer.parseInt(token[0]));
        }

        Gallery gallery = new Gallery(G, H, tree);
        int answer = gallery.solution();
        System.out.println(answer);
    }
}
