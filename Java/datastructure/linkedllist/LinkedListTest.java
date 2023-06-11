package datastructure.linkedllist;

import java.util.*;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(5);
        linkedList.addLast(1);
        linkedList.add(3);
        linkedList.add(2, 10);
        System.out.println(linkedList);

        linkedList.remove(); // 첫 번째 데이터 삭제
        linkedList.remove(2);
        linkedList.remove(new Integer(1));
        System.out.println(linkedList);

        linkedList.clear();
        System.out.println(linkedList);

        linkedList.addAll(new LinkedList<>(Arrays.asList(5, 4, 3, 2, 1)));
        System.out.println(linkedList);

        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 1));
        System.out.println(list.contains(1));
        System.out.println(list.indexOf(1));
        System.out.println(list.lastIndexOf(1));

        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1));
        list1.removeFirstOccurrence(new Integer(3));
        System.out.println(list1);
        list1.removeLastOccurrence(new Integer(3));
        System.out.println(list1);

        LinkedList<String> listA = new LinkedList<String>(Arrays.asList("hello", "my", "name"));
        LinkedList<String> listB = new LinkedList<String>(Arrays.asList("hello", "name"));
        listA.retainAll(listB); // listB 와 겹치지 않는 요소는 모두 삭제. 공통 요소만 남김
        System.out.println(listA);

        /**
        LinkedList<Integer> listC = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Iterator iterator = listC.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(listC.peek());
        System.out.println(listC.peekFirst());
        System.out.println(listC.peekLast());

        LinkedList<Integer> listD = new LinkedList<>(Arrays.asList(6, 5, 4, 3, 2, 1));
        System.out.println(listD.peek());
        System.out.println(listD.peekFirst());
        System.out.println(listD.peekLast());

        System.out.println(listC.poll());
        System.out.println(listC);

        System.out.println(listD.poll());
        System.out.println(listD);
        */

        LinkedList<Integer> listE = new LinkedList<>(Arrays.asList(3, 5, 2, 1, 6, 4));
        System.out.println(listE.peek()); // 3
        System.out.println(listE.peekFirst()); // 3
        System.out.println(listE.peekLast()); // 4
        System.out.println(listE.poll()); // 3
        System.out.println(listE.pollFirst()); // 5
        System.out.println(listE.pollLast()); // 4

        LinkedList<Integer> listF = new LinkedList<>(Arrays.asList(1, 3, 5, 2, 4, 6));
        System.out.println(listF.pop());
        System.out.println(listF);
        listF.push(8);
        System.out.println(listF);
        System.out.println(listF.pop());
        System.out.println(listF);
        listF.set(0, 10);
        System.out.println(listF);

        Object[] arr = listF.toArray();
        System.out.println(arr[0]);

        LinkedList<String> listG = new LinkedList<>(Arrays.asList("abc", "def", "ghi", "jkl"));
        String[] strArr = listG.toArray(new String[listG.size()]);
        System.out.println(strArr[0]);

        listF.offer(new Integer(11));
        System.out.println(listF);
        listF.offerFirst(15);
        System.out.println(listF);
        listF.offerLast(20);
        System.out.println(listF);
    }
}
