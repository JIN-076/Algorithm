package backtracking;

import java.util.ArrayList;

public class TravelingSalesmanProblem {

    public static int MAX = 20;
    public static int N;
    public static double[][] dist = new double[MAX][MAX];

    public int back(ArrayList<Integer> path) {
        return path.get(path.size() - 1);
    }

    public double shortestPath(ArrayList<Integer> path, boolean[] visited, double curlen) {
        if (curlen == N) return curlen + dist[path.get(0)][back(path)];

        double ret = Double.MAX_VALUE;

        for (int next = 0; next < N; next++) {
            if (visited[next]) continue;
            int here = path.get(path.size() - 1);
            path.add(next);
            visited[next] = true;
            double res = shortestPath(path, visited, curlen + dist[here][next]);
            ret = Math.min(ret, res);
            visited[next] = false;
            path.remove(path.get(path.size() - 1));
        }
        return ret;
    }
}
