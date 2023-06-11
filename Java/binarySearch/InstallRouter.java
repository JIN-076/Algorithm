package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InstallRouter {

    public static int C;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        C = Integer.parseInt(token[1]);

        int[] house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(house);

        int answer = binarySearch(house);
        System.out.println(answer);
    }

    public static int binarySearch(int[] house) {

        int left = 1;
        int right = house[house.length - 1] - house[0] + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (canInstall(house, mid) < C) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static int canInstall(int[] house, int key) {

        int count = 1;
        int last = house[0];

        for (int i = 1; i < house.length; i++) {
            int locate = house[i];
            if (locate - last >= key) {
                count++;
                last = locate;
            }
        }

        return count;
    }
}
