package backtracking;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
     public boolean findFirstLetter(int idx, String word, String[][] board) {
         boolean compareTo = false;
         boolean result = false;
         for (int i = 0; i < board.length; i++) {
             for (int j = 0; j < board[i].length; j++) {
                 compareTo = board[i][j].equals(Character.toString(word.charAt(idx)));
                 if (compareTo)
                    if (!(result = hasWord(i, j, idx + 1, word, board))) continue;
                 if (result) break;
             }
             if (result) break;
         }
         return result;
     }
 */

public class Boggle {

    public static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    public static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public void solution(String word, String[][] board) {

        boolean result = false;
        result = findFirstLetter(0, word, board);
        System.out.println(result);
    }



    public boolean findFirstLetter(int idx, String word, String[][] board) {
        boolean compareTo = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                compareTo = board[i][j].equals(Character.toString(word.charAt(idx)));
                if (compareTo) {
                    if (hasWord(i, j, idx + 1, word, board))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean hasWord(int curx, int cury, int idx, String word, String[][] board) {

        if (idx == word.length()) return true;

        for (int d = 0; d < 8; d++) {
            int nextX = curx + dx[d], nextY = cury + dy[d];
            if (nextX < 0 || nextX > 4 || nextY < 0 || nextY > 4) continue;
            if (!board[nextX][nextY].equals(Character.toString(word.charAt(idx)))) continue;
            if (hasWord(nextX, nextY, idx + 1, word, board))
                return true;
        }
        return false;
    }
}

class test9 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        String[][] board = new String[N][N];
        String word;
        String line;
        for (int i = 0; i < N; i++) {
            line = bufferedReader.readLine();
            board[i] = line.split("\\s");
        }
        word = bufferedReader.readLine();
        Boggle boggle = new Boggle();
        boggle.solution(word, board);
    }
}

/**
 * 5
 * U R L P P
 * X P A E T
 * G I R E T
 * X T N Z Y
 * X O Q R S
 * PRETTY
 *
 * 5
 * N N N N S
 * N E E E N
 * N E Y E N
 * N E E E N
 * N N N N N
 * YES
 *
 * 5
 * U R L P M
 * X P R E T
 * G I A E T
 * X T N Z Y
 * X O Q R S
 * GIRL
 * PRETTY
 *
 * 5
 * O O O O O
 * O P R O T
 * O O O E T
 * O O O O Y
 * O O O O O
 * PRETTY
 *
 * 5
 * O O L O O
 * O O R O O
 * G I O O O
 * O O O O O
 * O O O O O
 * GIRL
 *
 * 5
 * O O O P O
 * O O R E O
 * O O A O O
 * O T O O O
 * O O O O O
 * REPEAT
 */
