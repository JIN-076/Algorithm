package graph.dfs.topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Dictionary {

    public int N;
    public String[] word;
    public ArrayList<Integer>[] alphabet;
    public ArrayList<Integer> order;
    public boolean[] visited;

    Dictionary(int N, String[] word) {
        this.N = N;
        this.word = word;
        this.alphabet = new ArrayList[26];
        this.order = new ArrayList<>();
        this.visited = new boolean[26];
    }

    public void makeGraph() {

        int[] tmp = new int[26];
        Arrays.fill(tmp, -1);
        for (int i = 0; i < 26; i++) {
            this.alphabet[i] = (ArrayList<Integer>) Arrays.stream(tmp)
                    .boxed()
                    .collect(Collectors.toList());
        }

        for (int j = 1; j < this.word.length; j++) {
            int i = j - 1;
            int len = Math.min(this.word[i].length(), this.word[j].length());
            for (int k = 0; k < len; k++) {
                if (this.word[i].charAt(k) != this.word[j].charAt(k)) {
                    int a = this.word[i].charAt(k) - 'a';
                    int b = this.word[j].charAt(k) - 'a';
                    this.alphabet[a].add(b);
                    break;
                }
            }
        }
    }

    public void dfs(int start) {

        this.visited[start] = true;
        for (int i = 0; i < this.alphabet[start].size(); i++) {
            int next = this.alphabet[start].get(i);
            if (next == -1) continue;
            if (!visited[next])
                dfs(this.alphabet[start].get(i));
        }
        this.order.add(start);
    }

    public ArrayList<Integer> topologicalSort() {

        int size = this.alphabet.length;
        Arrays.fill(this.visited, false);
        this.order.clear();

        for (int i = 0; i < size; i++) {
            if (!this.visited[i]) dfs(i);
        }

        Collections.reverse(this.order);

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (this.alphabet[this.order.get(j)].get(this.order.get(i)) != -1)
                    return new ArrayList<Integer>(0);
            }
        }
        return this.order;
    }
}

class test27 {

    public static void printArrayList(ArrayList<Integer> answer){

        for (int i = 0; i < answer.size(); i++) {
            System.out.print((char)(answer.get(i) + 'a'));
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < test_case; i++) {

            int N = Integer.parseInt(bufferedReader.readLine());

            String[] word = new String[N];
            for (int j = 0; j < N; j++) {
                word[j] = bufferedReader.readLine();
            }
            Dictionary dictionary = new Dictionary(N, word);
            dictionary.makeGraph();
            ArrayList<Integer> answer = dictionary.topologicalSort();
            if (answer.size() == 0) System.out.println("INVALID HYPOTHESIS");
            else printArrayList(answer);
        }
    }
}
