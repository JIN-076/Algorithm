package graph.bfs;

import graph.dfs.GameMap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class GameMapShortestPath {

    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public int solution(int[][] maps) {

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++) {
            Arrays.fill(visited[i], false);
        }

        Queue<Points> q = new LinkedList<>();
        q.add(new Points(new Point(0, 0), 0));
        visited[0][0] = true;
        return bfs(q, visited, maps);
    }

    public int bfs(Queue<Points> q, boolean[][] visited, int[][] maps) {
        while (!q.isEmpty()) {
            Points points = q.poll();
            points.cnt++;
            for (int dir = 0; dir < 4; dir++) {
                if (points.point.x == maps.length - 1 && points.point.y == maps[0].length - 1) return points.cnt;
                int nextX = points.point.x + dx[dir];
                int nextY = points.point.y + dy[dir];
                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) continue;
                if (maps[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;
                q.add(new Points(new Point(nextX, nextY), points.cnt));
                visited[nextX][nextY] = true;
            }
        }
        return -1;
    }
}

class Points {
    public Point point;
    public int cnt;

    public Points(Point point, int cnt) {
        this.point = point;
        this.cnt = cnt;
    }
}

class test18 {

    public static void main(String[] args) {

        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        GameMapShortestPath shortestPath = new GameMapShortestPath();
        int result = shortestPath.solution(maps);
        System.out.println(result);
    }

}
