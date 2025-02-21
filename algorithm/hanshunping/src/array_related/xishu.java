package array_related;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 稀疏数组和二维数组相互转化
 */
public class xishu {
    // 二维数组转稀疏数组，原数组是11 X 11
    //1. 遍历 原始的二维数组，得到有效数据的个数 sum
    //2. 根据sum 就可以创建 稀疏数组 sparseArr int［sum +1］［3］
    //3. 将二维数组的有效数据数据存入到 稀疏数组

    public static int[][] toXishu(int[][] original) {
        // 1
        int sum = 0;
        for (int[] ints : original) {
            for (int i : ints) {
                if (i != 0) {
                    sum++;
                }
            }
        }
        // 2
        int[][] xishuArray = new int[sum + 1][3];

        // 3
        xishuArray[0][0] = 11;
        xishuArray[0][1] = 11;
        xishuArray[0][2] = sum;
        int row = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (original[i][j]!=0){
                    xishuArray[row][0] = i;
                    xishuArray[row][1] = j;
                    xishuArray[row][2] = original[i][j];
                    row++;
                }

            }
        }

        // 输出：
        System.out.println("原数组为：");
        for (int[] ints : original) {
            for (int i : ints) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
        System.out.println("---------");

        System.out.println("稀疏数组为：");
        for (int[] ints : xishuArray) {
            for (int i : ints) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
        return xishuArray;

    }
    // 稀疏转二维 思路分析
    // 1 根据第一行数据，new 二维数组
    // 2 根据下面几行，赋值
    public static int[][] toOrdinary(int[][] xishuArray) {
        // 1
        int[][] original = new int[xishuArray[0][0]][xishuArray[0][1]];
        // 2
        for (int i = 1; i < xishuArray.length; i++) {
            original[xishuArray[i][0]][xishuArray[i][1]] = xishuArray[i][2];
        }
        // 输出：
        System.out.println("---------");
        System.out.println("---------");

        System.out.println("稀疏数组为：");
        for (int[] ints : xishuArray) {
            for (int i : ints) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
        System.out.println("---------");

        System.out.println("原数组为：");
        for (int[] ints : original) {
            for (int i : ints) {
                System.out.print(i + "  ");
            }
            System.out.println();
        }
        return original;

    }

    public static void main(String[] args) {
        int[][] original = new int[11][11];
        original[2][5] = 6;
        original[3][7] = 8;
        int[][] xishu = toXishu(original);

        toOrdinary(xishu);



    }

}
