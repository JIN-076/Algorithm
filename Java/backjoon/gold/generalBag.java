package backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class item {
    int weight;
    int value;

    item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class generalBag {

    public int N;
    public int K;
    public ArrayList<item> bag;
    public int[][] dp;

    generalBag(int N, int K, ArrayList<item> bag) {
        this.N = N;
        this.K = K;
        this.bag = bag;
        this.dp = new int[N + 1][K + 1];
    }

    public int solution() {

        init();
        dp();
        return this.dp[N][K];
    }

    public void init() {

        for (int i = 0; i < this.dp.length; i++) {
            for (int j = 0; j < this.dp[i].length; j++) {
                if (i == 0 || j == 0) this.dp[i][j] = 0;
            }
        }
    }

    public void dp() {

        for (int elem = 1; elem <= N; elem++) { // 해당 elem을 넣을까 말까
            for (int wgt = 1; wgt <= K; wgt++) { // 넣을 수 있는 무게 제한
                if (bag.get(elem).weight <= wgt) { // 지금 넣을 물건이 제한에 걸리지 않으면
                    // 이득( 가치(현재 elem 선택함) ) > 이득( 가치(현재 elem 선택 안함) )
                    if ((bag.get(elem).value + this.dp[elem - 1][wgt - bag.get(elem).weight]) > this.dp[elem - 1][wgt]) {
                        this.dp[elem][wgt] = bag.get(elem).value + this.dp[elem - 1][wgt - bag.get(elem).weight];
                    } else {
                        this.dp[elem][wgt] = this.dp[elem - 1][wgt];
                    }
                } else {
                    this.dp[elem][wgt] = this.dp[elem - 1][wgt];
                }
            }
        }
    }
}

class gold5 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int K = Integer.parseInt(token[1]);

        ArrayList<item> bag = new ArrayList<>();
        bag.add(new item(0, 0));
        for (int i = 0; i < N; i++) {
            token = bufferedReader.readLine().split("\\s");
            bag.add(new item(Integer.parseInt(token[0]), Integer.parseInt(token[1])));
        }
        generalBag generalBag = new generalBag(N, K, bag);
        int answer = generalBag.solution();
        System.out.println(answer);
    }
}
