package softeer.lv2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class ObstacleAwareness {

    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void bfs(Queue<Point> q, boolean[][] visited, int[][] map, int N) {

        int x = -1;
        int y = -1;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) continue;
                x = i;
                y = j;
                break;
            }
            if (y != -1) break;
        }

        if (y == -1) return;

        int answer = 0;

        q.add(new Point(x, y));
        visited[x][y] = true;
        map[x][y] -= 1;
        answer++;

        while (!q.isEmpty()) {
            Point front = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextX = front.x + dx[dir];
                int nextY = front.y + dy[dir];
                if (nextX < 0 || nextX > N - 1 || nextY < 0 || nextY > N - 1) continue;
                if (map[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                map[nextX][nextY] -= 1;
                q.add(new Point(nextX, nextY));
                answer++;
            }
        }

        list.add(answer);
        bfs(q, visited, map, N);
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String line;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = bufferedReader.readLine();
            map[i] = Stream.of(line.split("")).mapToInt(Integer::parseInt).toArray();
        }
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        bfs(q, visited, map, N);

        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
