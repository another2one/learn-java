package base.arr;

import java.util.Arrays;

public class Descr {

    public static void main(String[] args) {

        // double[] myList;

        // int size = 4;
        // double[] myList = new double[size];

        double[] myList = {1.1, 1.2, 1.3};

        System.out.println(myList[1]);

        // 循环遍历 第一种方式
        for (double elem : myList) {
            System.out.println(elem);
        }

        // 循环遍历 第二种方式
        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i]);
        }

        // 多维数组
        String[][] strArr = new String[3][4];
        // 修改
        strArr[1][3] = "4";
        // 打印
        System.out.println(Arrays.deepToString(strArr));

        // Arrays 类
        
    }
}
