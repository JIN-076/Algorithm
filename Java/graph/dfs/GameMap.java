package graph.dfs;

public class GameMap {

    /**
     * BackTracking, DFS
     * 정확도 테스트: passed
     * 효율성 테스트: 시간초과
     */

    public static int MIN = Integer.MAX_VALUE;
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public int solution(int[][] maps) {
        maps[0][0] = 2;
        move(0, 0, 0, maps);
        if (MIN == Integer.MAX_VALUE) return -1;
        return MIN + 1;
    }

    /**
     * boolean[][] visited = new boolean[maps.length][maps[0].length];
     * for (int i = 0; i < maps.length; i++)
     *    Arrays.fill(visited[i], false);
     * visited[0][0] = true;
     * move(0, 0, 0, visited, maps);
     */

    public void move(int curx, int cury, int block, int[][] maps) {
        if (curx == 4 && cury == 4) {
            MIN = Math.min(MIN, block);
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nextX = curx + dx[dir];
            int nextY = cury + dy[dir];
            if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) continue;
            if (maps[nextX][nextY] == 0 || maps[nextX][nextY] == 2) continue;
            maps[nextX][nextY] = 2;
            move(nextX, nextY, block + 1, maps);
            maps[nextX][nextY] = 1;
        }
    }
}

class test17 {

    public static void main(String[] args) {

        int[][] maps = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        GameMap gameMap = new GameMap();
        int result = gameMap.solution(maps);
        System.out.println(result);
    }
}
