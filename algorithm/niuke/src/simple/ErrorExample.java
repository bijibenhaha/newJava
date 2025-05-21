package simple;

public class ErrorExample {
    public static void main(String[] args) {
        methodA();
    }

    public static void methodA() {
        methodB();
    }

    public static void methodB() {
        int[] arr = new int[2];
        // 这里会抛出数组越界异常
        System.out.println(arr[2]);
    }
}