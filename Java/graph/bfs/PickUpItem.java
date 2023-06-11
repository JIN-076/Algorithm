package graph.bfs;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Point;

class Pairs {
    Point point;
    int dist;

    Pairs(Point point, int dist) {
        this.point = point;
        this.dist = dist;
    }
}

public class PickUpItem {

    public static int dx[] = { -1, 0, 1, 0 };
    public static int dy[] = { 0, 1, 0, -1 };

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[101][101];
        Queue<Pairs> q = new LinkedList<>();

        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i].length; j++) {
                rectangle[i][j] *= 2;
            }
        }
        q.add(new Pairs(new Point(characterX * 2, characterY * 2), 0));
        visited[characterX][characterY] = true;
        int answer = pickUpItem(q, itemX * 2, itemY * 2, visited, rectangle);
        return answer;
    }

    public boolean isRectangleBoundary(int curx, int cury, int[][] rectangle) {
        int boundary = 0;
        int cnt = 0;
        for (int i = 0; i < rectangle.length; i++) {
            if ((curx == rectangle[i][0] || curx == rectangle[i][2]) &&
                    cury >= rectangle[i][1] && cury <= rectangle[i][3]) boundary++;
            else if ((cury == rectangle[i][1] || cury == rectangle[i][3]) &&
                    curx >= rectangle[i][0] && curx <= rectangle[i][2]) boundary++;
            if (curx >= rectangle[i][0] && curx <= rectangle[i][2] &&
                    cury >= rectangle[i][1] && cury <= rectangle[i][3]) cnt++;
        }
        if (boundary != 0 && boundary == cnt) return true;
        return false;
    }

    public int pickUpItem(Queue<Pairs> q, int itemX, int itemY, boolean[][] visited, int[][] rectangle) {
        while (!q.isEmpty()) {
            Pairs front = q.poll();
            if (front.point.x == itemX && front.point.y == itemY) return front.dist / 2;
            front.dist++;
            for (int dir = 0; dir < 4; dir++) {
                int nextX = front.point.x + dx[dir];
                int nextY = front.point.y + dy[dir];
                if (nextX <= 0 || nextX > 50 || nextY <= 0 || nextY > 50) continue;
                if (visited[nextX][nextY]) continue;
                if (!isRectangleBoundary(nextX, nextY, rectangle)) continue;
                visited[nextX][nextY] = true;
                q.add(new Pairs(new Point(nextX, nextY), front.dist));
            }
        }
        return 0;
    }
}

class test22 {

    public static void main(String[] args) {

        int[][] rectangle = {
                { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 }
        };
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        PickUpItem pickUpItem = new PickUpItem();
        int answer = pickUpItem.solution(rectangle, characterX, characterY, itemX, itemY);
        System.out.println(answer);
    }
}

/**
 * { 1, 1, 7, 4 }, { 3, 2, 5, 5 }, { 4, 3, 6, 9 }, { 2, 6, 8, 8 }, 1, 3, 7, 8
 * -> 17
 *
 * { 1, 1, 8, 4 }, { 2, 2, 4, 9 }, { 3, 6, 9, 8 }, { 6, 3, 7, 7 }, 9, 7, 6, 1
 * -> 11
 *
 * { 1, 1, 5, 7 }, 1, 1, 4, 7
 * -> 9
 *
 * { 2, 1, 7, 5 }, { 6, 4, 10, 10 }, 3, 1, 7, 10
 * -> 15
 *
 * { 2, 2, 5, 5 }, { 1, 3, 6, 4 }, { 3, 1, 4, 6 }, 1, 4, 6, 3
 * -> 10
 */
