package datastructure.array;

import java.util.Arrays;

public class arrayStream {

    public static void main(String[] args) {

        int[] arr = { -1, 9, 10, 4, 392, 53, 8 };
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        System.out.println(max + ", " + min);
    }
}
