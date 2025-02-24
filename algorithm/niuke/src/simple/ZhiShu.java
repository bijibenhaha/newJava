package simple;

import java.util.Scanner;

/**
 * HJ6 质数因子
 * 描述：输出某个数的所有质数
 */
public class ZhiShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long sqrt = (long) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num = num / i;
            }
        }
        System.out.print(num == 1 ? "" : num + "");
    }
}
