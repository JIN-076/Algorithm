package greedy;

import java.util.ArrayList;
import java.util.Collections;

class timer implements Comparable<timer> {
    int end;
    int begin;
    public timer(int end, int begin) {
        this.end = end;
        this.begin = begin;
    }

    @Override
    public int compareTo(timer o) {
        if (o.end < this.end) return 1;
        else if (o.end == this.end) return 0;
        return -1;
    }
}

public class Reservation {

    public static int N = 11;
    public static int[] begin = { 2, 2, 0, 3, 2, 0, 5, 6, 8, 8, 10 };
    public static int[] end = { 4, 7, 4, 5, 4, 7, 9, 10, 9, 9, 10 };

    public int schedule() {
        ArrayList<timer> order = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            order.add(new timer(end[i], begin[i]));
        }
        Collections.sort(order);

        int earliest = 0;
        int selected = 0;

        for (int i = 0; i < order.size(); i++) {
            int meetingBegin = order.get(i).begin;
            int meetingEnd = order.get(i).end;
            if (earliest <= meetingBegin) {
                earliest = meetingEnd;
                ++selected;
            }
        }
        return selected;
    }
}

class test26 {

    public static void main(String[] args) {

        Reservation reservation = new Reservation();
        reservation.schedule();
    }
}