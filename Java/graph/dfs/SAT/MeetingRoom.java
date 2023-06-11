package graph.dfs.SAT;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MeetingRoom {

    public int N;
    public int[] a;
    public int[] b;
    public int[] c;
    public int[] d;
    public ArrayList<Integer>[] graph;

    MeetingRoom(int N, int[] a, int[] b, int[] c, int[] d) {
        this.N = N;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.graph = new ArrayList[4 * N]; // 4N

        for (int i = 0; i < this.graph.length; i++) {
            this.graph[i] = new ArrayList<>();
        }
    }

    public void solution() {
        ArrayList<Point> meeting = makeList();
        makeGraph(meeting);
    }

    public ArrayList<Point> makeList() {

        ArrayList<Point> meeting = new ArrayList<>();
        for (int i = 0; i < this.N; i++) {
            meeting.add(new Point(a[i], b[i]));
            meeting.add(new Point(c[i], d[i]));
        }
        return meeting;
    }

    public boolean disjoint(Point a, Point b) {
        return a.y <= b.x || b.y <= a.x;
    }

    public void makeGraph(ArrayList<Point> meeting) {

        int vars = meeting.size(); // 2N

        for (int i = 0; i < vars; i += 2) {
            int j = i + 1;
            this.graph[i * 2 + 1].add(j * 2); // ~i -> j
            this.graph[j * 2 + 1].add(i * 2); // ~j -> i
        }

        for (int i = 0; i < vars; i++) {
            for (int j = 0; j < i; j++) {
                if (!disjoint(meeting.get(i), meeting.get(j))) {
                    this.graph[i * 2].add(j * 2 + 1); // i -> ~j
                    this.graph[j * 2].add(i * 2 + 1); // j -> -i
                }
            }
        }
    }
}

class test34 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[N];
        int[] d = new int[N];
        for (int i = 0; i < N; i++) {
            String[] token = bufferedReader.readLine().split("\\s");
            a[i] = Integer.parseInt(token[0]);
            b[i] = Integer.parseInt(token[1]);
            c[i] = Integer.parseInt(token[2]);
            d[i] = Integer.parseInt(token[3]);
        }

        MeetingRoom meetingRoom = new MeetingRoom(N, a, b, c, d);
    }
}
