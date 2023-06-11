package string;

import java.util.ArrayList;
import java.util.Collections;

class strInfo implements Comparable<strInfo> {
    int idx;
    String str;

    strInfo(int idx, String str) {
        this.idx = idx;
        this.str = str;
    }

    @Override
    public int compareTo(strInfo o) {
        if (this.str.length() > o.str.length()) return 1;
        else if (this.str.length() == o.str.length()) {
            if (this.idx > o.idx) return 1;
            else if (this.idx == o.idx) return 0;
            else return -1;
        }
        else return -1;
    }
}

public class StringEx {

    public static void main(String[] args) {

        String str = "hello";

        System.out.println(str.indexOf("e")); // 1
        System.out.println(str.indexOf("l")); // 2
        System.out.println(str.indexOf("llo")); // 2

        String sub = str.substring(2);
        System.out.println(sub); // llo

        String sub2 = str.substring(2, 4); // 2 - 3 추출
        System.out.println(sub2); // ll

        String concat = sub.concat(sub2);
        System.out.println(concat); // lloll

        System.out.println(str.startsWith("h"));
        System.out.println(str.startsWith("e", 1));
        System.out.println(str.startsWith("l", 0));

        System.out.println(str.endsWith("o"));

        System.out.println(str.replace("ll", "llllll"));
        System.out.println(str);

        String replace = str.replace("ll", "lllll");
        System.out.println(replace);

        String replace2 = str.replaceAll("hello", "helloWorld");
        System.out.println(replace2);

        String replace3 = str.replaceAll("ll", "lllllo");
        System.out.println(replace3);

        String trim = "   he  ll o  ";
        System.out.println(trim.trim());

        String str2 = "a";
        String str3 = "b";
        String str4 = "ab";
        System.out.println(str2.compareTo(str3)); // str2 기준. 사전 순으로 빠른 순서 -1
        System.out.println(str2.compareTo(str4));
        System.out.println(str3.compareTo(str2)); // str3 기준. 사전 순으로 늦은 순서 1
        System.out.println(str3.compareTo(str4)); // str3 기준. 사전 순으로 늦은 순서 1

        ArrayList<strInfo> list = new ArrayList<>();
        list.add(new strInfo(1, "abcdef"));
        list.add(new strInfo(2, "abc"));
        list.add(new strInfo(3, "zyx"));
        list.add(new strInfo(3, "zdflkjslk"));
        Collections.sort(list);

        list.stream().forEach(elem -> System.out.println(elem.idx + ", " + elem.str));

        String str5 = "helloWorld";
        System.out.println(str5.contains("Wor"));
        System.out.println(str5.contains("z"));
        System.out.println(str5.contains("h"));

        System.out.println(str5.charAt(2));
    }
}
