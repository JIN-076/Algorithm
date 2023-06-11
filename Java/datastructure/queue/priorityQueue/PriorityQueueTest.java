package datastructure.queue.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(1);
        pq2.add(1);
        pq.add(5);
        pq2.add(5);
        pq.add(3);
        pq2.add(3);
        pq.add(2);
        pq2.add(2);
        pq.add(9);
        pq2.add(9);

        while (!pq.isEmpty() && !pq2.isEmpty()) {
            System.out.println(pq.poll() + ", " + pq2.poll());
        }
    }
}