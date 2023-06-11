package string;

public class StringBuilderEx {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        builder.append("helllllo");
        builder.deleteCharAt(5); // 5 삭제
        System.out.println(builder.toString());
        builder.delete(1, 3); // 1 - 2 삭제
        System.out.println(builder.toString());

        System.out.println(builder.length());

        // builder.setLength(8);
        System.out.println(builder.toString());

        System.out.println(builder.reverse());

        builder.replace(0, 2, "replace"); // 0 ~ 1
        System.out.println(builder);
    }
}
