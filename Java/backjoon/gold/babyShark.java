package backjoon.gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class babyShark {

    public int N;
    public int[][] place;

    babyShark(int N, int[][] place) {
        this.N = N;
        this.place = place;
    }

    public static int[] dx = { -1, 0, 0, 1 };
    public static int[] dy = { 0, -1, 1, 0 };
    public static Queue<Point> adventure;
    public static Queue<Integer> dist;
    public static boolean[][] visited;
    public static int size;
    public static int ate;
    public static int time;

    public int solution() {

        size = 2;
        ate = 0;
        time = 0;

        findBabyShark();
        return time;
    }

    public void bfs(int x, int y, int size) {

        adventure = new LinkedList<>();
        dist = new LinkedList<>();
        visited = new boolean[place.length][place[0].length];

        visited[x][y] = true;
        adventure.add(new Point(x, y));
        dist.add(0);

        if (ate == size) {
            size++;
            ate = 0;
        }

        while (!adventure.isEmpty() && !dist.isEmpty()) {
            Point front = adventure.poll();
            int frontDist = dist.poll();

            if (place[front.x][front.y] < size && place[front.x][front.y] != 0) {
                time += frontDist;
                place[front.x][front.y] = 0;
                ate++;
                bfs(front.x, front.y, size);
            }

            frontDist++;

            for (int dir = 0; dir < 4; dir++) {
                int nextX = front.x + dx[dir];
                int nextY = front.y + dy[dir];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;
                if (place[nextX][nextY] > size) continue;
                visited[nextX][nextY] = true;
                adventure.add(new Point(nextX, nextY));
                dist.add(frontDist);
            }
        }
    }

    public void findBabyShark() {

        int x = -1;
        int y = -1;
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length; j++) {
                if (place[i][j] == 9) {
                    x = i;
                    y = j;
                    place[x][y] = 0;
                    break;
                }
            }
            if (y != -1) break;
        }

        bfs(x, y, size);
    }
}

class gold4 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        String[] token;
        int[][] place = new int[N][N];
        for (int i = 0; i < N; i++) {
            token = bufferedReader.readLine().split("\\s");
            place[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }

        babyShark babyShark = new babyShark(N, place);
        int answer = babyShark.solution();
        System.out.println(answer);
    }
}
