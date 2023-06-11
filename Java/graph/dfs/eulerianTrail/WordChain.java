package graph.dfs.eulerianTrail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordChain {

    public int N;
    public String[] words;
    public ArrayList<String>[][] graph; // i로 시작하고 j로 끝나는 단어 목록
    public ArrayList<Integer>[] chains; // i로 시작하고 j로 끝나는 간선의 수
    public ArrayList<Integer> indegree; // i로 끝나는 단어. i로 들어오는 간선
    public ArrayList<Integer> outdegree; // i로 시작하는 단어. i에서 나가는 간선

    WordChain(int N, String[] words) {
        this.N = N;
        this.words = words;
        this.graph = new ArrayList[26][26];
        this.chains = new ArrayList[26];

        int[] tmp = new int[26];
        Arrays.fill(tmp, 0);

        this.indegree = (ArrayList<Integer>) Arrays.stream(tmp)
                .boxed()
                .collect(Collectors.toList());
        this.outdegree = (ArrayList<Integer>) Arrays.stream(tmp)
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < this.graph.length; i++) {
            for (int j = 0; j < this.graph[i].length; j++) {
                this.graph[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < this.chains.length; i++) {
            this.chains[i] = (ArrayList<Integer>) Arrays.stream(tmp)
                    .boxed()
                    .collect(Collectors.toList());
        }
    }

    public void makeGraph() {



        for (int i = 0; i < this.words.length; i++) {
            int a = this.words[i].charAt(0) - 'a';
            int b = this.words[i].charAt(this.words[i].length() - 1) - 'a';
            this.graph[a][b].add(words[i]);
            this.chains[a].set(b, this.chains[a].get(b) + 1);
            this.outdegree.set(a, this.outdegree.get(a) + 1);
            this.indegree.set(b, this.indegree.get(b) + 1);
        }
    }

    public void getEulerCircuit(int here, ArrayList<Integer> answer) {
        for (int i = 0; i < this.chains.length; i++) {
            while (this.chains[here].get(i) > 0) {
                this.chains[here].set(i, this.chains[here].get(i) - 1);
                getEulerCircuit(i, answer);
            }
        }
        answer.add(here);
    }

    /**
     * EulerCircuit
     * 시작점: 들어오는 간선과 나가는 간선의 수가 같아야 함
     * 도착점: 들어오는 간선과 나가는 간선의 수가 같아야 함
     *
     * EulerTrail
     * 도착점에서 나가서 시작점으로 들어가는 간선을 한 개 추가!
     * 시작점: 들어오는 간선보다 나가는 간선이 한 개 더 많아야 함
     * 도착점: 들어오는 간선이 나가는 간선보다 한 개 더 많아야 함
     */

    public ArrayList<Integer> getEulerTrailOrCircuit() {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (this.outdegree.get(i) == this.indegree.get(i) + 1) {
                getEulerCircuit(i, answer);
                return answer;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (this.outdegree.get(i) != 0) {
                getEulerCircuit(i, answer);
                return answer;
            }
        }
        return answer;
    }

    /**
     * EulerCircuit
     * 시작점: 들어오는 간선의 수와 나가는 간선의 수 동일
     * 도착점: 들어오는 간선의 수와 나가는 간선의 수 동일
     * 나머지: 들어오는 간선의 수와 나가는 간선의 수 동일
     * plus == 0 && minus == 0 -> EulerCircuit
     *
     * EulerTrail
     * 시작점: 들어오는 간선보다 나가는 간선의 수가 한 개 많아야 함
     * 도착점: 들어오는 간선의 수가 나가는 간선보다 한 개 많아야 함
     * 나머자: 들어오는 간선의 수와 나가는 간선의 수 동일
     * plus == 1 && minus == 1 -> EulerTrail
     */

    public boolean checkEuler() {

        int plus = 0;
        int minus = 0;
        for (int i = 0; i < 26; i++) {
            int delta = this.outdegree.get(i) - this.indegree.get(i);
            if (delta < -1 || delta > 1) return false;
            if (delta == 1) plus++;
            if (delta == -1) minus++;
        }
        return (plus == 1 && minus == 1) || (plus == 0 && minus == 0);
    }

    public String solution() {

        makeGraph();
        if (!checkEuler()) return "IMPOSSIBLE";
        ArrayList<Integer> circuit = getEulerTrailOrCircuit();
        if (circuit.size() != words.length + 1) return "IMPOSSIBLE";

        Collections.reverse(circuit);
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < circuit.size(); i++) {
            int a = circuit.get(i - 1);
            int b = circuit.get(i);
            if (builder.length() != 0) builder.append(" ");
            builder.append(graph[a][b].get(graph[a][b].size() - 1));
            graph[a][b].remove(graph[a][b].size() - 1);
        }
        return builder.toString();
    }
}

class test30 {

    public static void print(ArrayList<String> answer) {

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < C; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] words = new String[N];
            for (int j = 0; j < N; j++) {
                words[j] = bufferedReader.readLine();
            }
            WordChain wordChain = new WordChain(N, words);
            String answer = wordChain.solution();
            System.out.println(answer);
        }
    }
}
