package backjoon.gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class populationMovement {

    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static int counter = 0;
    public static int answer = 0;

    public int N;
    public int L;
    public int R;
    public int[][] country;
    public boolean[][] visited;

    populationMovement(int N, int L, int R, int[][] country) {
        this.N = N;
        this.L = L;
        this.R = R;
        this.country = country;
        this.visited = new boolean[N][N];
    }

    public int solution() {

        moveUntilImpossible();
        return answer - 1;
    }

    public void moveUntilImpossible() {

        while (true) {
            if (counter == N * N) break;
            bfsAll();
        }
    }

    public void bfsAll() {

        counter = 0;
        answer++;
        init();
        for (int i = 0; i < country.length; i++) {
            for (int j = 0; j < country[i].length; j++) {
                if (!visited[i][j]) bfs(i, j);
            }
        }
    }

    public void init() {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public void bfs(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        ArrayList<Point> union = new ArrayList<>();

        q.add(new Point(x, y));
        union.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point front = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nextX = front.x + dx[dir];
                int nextY = front.y + dy[dir];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;
                if (!canOpen(front.x, front.y, nextX, nextY)) continue;
                visited[nextX][nextY] = true;
                q.add(new Point(nextX, nextY));
                union.add(new Point(nextX, nextY));
            }
        }

        if (union.size() == 1) counter++;
        else move(union);
    }

    public void move(ArrayList<Point> union) {

        int sum = 0;
        for (Point point : union) {
            sum += country[point.x][point.y];
        }

        sum /= union.size();

        for (Point point : union) {
            country[point.x][point.y] = sum;
        }
    }

    public boolean canOpen(int x1, int y1, int x2, int y2) {

        return Math.abs(country[x1][y1] - country[x2][y2]) >= this.L && Math.abs(country[x1][y1] - country[x2][y2]) <= this.R;
    }
}

class gold7 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int L = Integer.parseInt(token[1]);
        int R = Integer.parseInt(token[2]);

        int[][] country = new int[N][N];
        for (int i = 0; i < N; i++) {
            token = bufferedReader.readLine().split("\\s");
            country[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }
        populationMovement populationMovement = new populationMovement(N, L, R, country);
        int answer = populationMovement.solution();
        System.out.println(answer);
    }
}
