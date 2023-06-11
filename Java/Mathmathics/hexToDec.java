package Mathmathics;

public class hexToDec {

    public static void main(String[] args) {

        String hex1 = "0x7FFFFFFF";
        int decimal1 = Integer.decode(hex1);
        System.out.println(decimal1);

        String hex2 = "0x24";
        int decimal2 = Integer.decode(hex2);
        System.out.println(decimal2);

        String hex3 = "7FFFFFFF";
        int decimal3 = Integer.parseInt(hex3, 16);
        System.out.println(decimal3);

        String hex4 = "7FFFFFFF";
        Integer decimal4 = Integer.valueOf(hex4, 16);
        System.out.println(decimal4);

        /*
         * -> NumberFormatException: For input string: "0x7FFFFFFF"
         * String hex4 = "0x7FFFFFFF";
         * int decimal4 = Integer.parseInt(hex4, 16);
         * System.out.println(decimal4);
        */
    }
}
