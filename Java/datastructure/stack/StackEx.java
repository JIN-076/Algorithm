package datastructure.stack;

import java.util.Stack;

/**
 * 1. LIFO -> Last In First Out
 * 2. 그래프의 DFS에서 사용
 * 3. Recursion 함수를 호출할 때 사용
 */

public class StackEx {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int elem = stack.pop(); // 3
        System.out.println(elem);

        int peek = stack.peek(); // 2
        System.out.println(peek);

        boolean ret = stack.contains(3); // false
        System.out.println(ret);

        int update = stack.set(0, 5); // 1
        System.out.println(update);

        System.out.println(stack.size()); // 2
        stack.add(2, 10); // 2
        System.out.println(stack.size()); // 3

        Integer[] arr = new Integer[stack.size()];
        arr[0] = 1;
        arr[1] = 2;

        stack.copyInto(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println(stack.isEmpty());
        System.out.println(stack.empty());
        System.out.println(stack.size());

        System.out.println();
    }
}
