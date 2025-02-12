package basic;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * 异或的应用
 * 1 数组中有 任意个偶数个数+1个奇数个数，求出那个数
 * 2 数组中有 任意个偶数个数+2个奇数个数，求出那两个数
 */
public class Yihuo {

    // 题目1
    public static void one(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println("数字为: " + eor);
    }

    public static void two(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        int rightOne = eor & (~eor + 1);// 提取出最右的1
        int onlyOne = 0; // eor'
        for (int cur : arr) {
            if ((cur & rightOne) == 1) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));

    }


    public static void main(String[] args) {
        int[] arr = {3, 3, 2, 4, 4};
//        one(arr);
        int[] arr1 = {3, 3, 2, 4, 4, 5};
        two(arr1);



    }

}
