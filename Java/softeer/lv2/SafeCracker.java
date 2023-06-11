package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class pair implements Comparable<pair> {
    int metal;
    int price;
    pair(int metal, int price) {
        this.metal = metal;
        this.price = price;
    }

    @Override
    public int compareTo(pair p) {
        if (p.price > this.price) return 1;
        else if (p.price == this.price) return 0;
        else return -1;
    }
}

public class SafeCracker {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        line = bufferedReader.readLine();
        String[] token = line.split("\\s");
        int backpack = Integer.parseInt(token[0]);
        int kind = Integer.parseInt(token[1]);
        ArrayList<pair> list = new ArrayList<>();
        for (int i = 0; i < kind; i++) {
            String[] tokens = bufferedReader.readLine().split("\\s");
            list.add(new pair(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));
        }
        Collections.sort(list);
        int possible = backpack;
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).metal <= possible) {
                answer += list.get(i).price * list.get(i).metal;
                possible -= list.get(i).metal;
            }
            else {
                answer += list.get(i).price * possible;
                possible -= possible;
            }
        }
        System.out.println(answer);
    }
}
