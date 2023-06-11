package divideNconquer;

public class fastSum {

    int fastSum(int n) {
        if (n == 1) return 1;
        if (n % 2 == 1) return fastSum(n - 1) + n;
        return 2 * fastSum(n / 2) + (n / 2) * (n / 2);
    }
}

class test24 {

    public static void main(String[] args) {

        fastSum fastSum = new fastSum();
        int result = fastSum.fastSum(10);
        System.out.println(result);
    }
}
