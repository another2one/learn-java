package base.io;

public class Descr {

    public static void main(String[] args) {

        // double[] myList;

        // int size = 4;
        // double[] myList = new double[size];

        double[] myList = {1.1, 1.2, 1.3};

        System.out.println(myList[1]);

        // 循环遍历
        for (double elem : myList) {
            System.out.println(elem);
        }

        for (int i = 0; i < myList.length; i++) {
            System.out.println(myList[i]);
        }

        // 多维数组
        String[][] str = new String[3][4];
        System.out.println(str);

        // Arrays 类
        
    }
}
