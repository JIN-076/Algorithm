package graph.bfs;

import java.util.*;

public class TravelPath {

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
                else return o1[0].compareTo(o2[0]);
            }
        });
        boolean[] visited = new boolean[tickets.length];
        ArrayList<String> tmp = new ArrayList<>();
        dfs("ICN", 0, visited, tickets, tmp);
        String[] answer = tmp.toArray(new String[tmp.size()]);
        return answer;
    }

    public boolean dfs(String start, int cnt, boolean[] visited, String[][] tickets, ArrayList<String> tmp) {
        tmp.add(start);
        if (cnt == tickets.length) {
            return true;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!start.equals(tickets[i][0])) continue;
            if (visited[i]) continue;
            visited[i] = true;
            if (dfs(tickets[i][1], cnt + 1, visited, tickets, tmp)) return true;
            visited[i] = false;
        }
        tmp.remove(tmp.size() - 1);
        return false;
    }
}

class test21 {

    public static void print(String[] ret) {
        System.out.print("[ ");
        for (int i = 0; i < ret.length; i++) {
            if (i == ret.length - 1) System.out.print("\"" + ret[i] + "\"");
            else System.out.print("\"" + ret[i] + "\", ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {

        String[][] tockets = {
                { "ICN", "SFO" },
                { "ICN", "ATL" },
                { "SFO", "ATL" },
                { "ATL", "ICN" },
                { "ATL", "SFO" }
        };
        TravelPath travelPath = new TravelPath();
        String[] ret = travelPath.solution(tockets);
        print(ret);
    }
}

/**
 * { "ICN", "JFK" },
 * { "HND", "IAD" },
 * { "JFK", "HND" }
 */