package p1;

public class Test1 {
    public static void main(String[] args) {
        // 二维数组
        // 1 定义
        int[][] twoDArray;

        // 或者 (第一个维度（行数）是需要确定的，第二个维度（列数）不需要确定)
        int[][] twoDArray2 = new int[2][];


        // 2 定义时初始化
        int[][] twoDArray1 = {
                {1,2,3},
                {4,5,6}
        };

        // 3 初始化
        twoDArray = new int[][]{
                {1,2,3},
                {4,5,6}
        };

        // 4 遍历
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                System.out.println(twoDArray[i][j]);
            }
        }




    }
}

