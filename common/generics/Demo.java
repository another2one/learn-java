package common.generics;

import java.util.ArrayList;
import java.util.List;

// 所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的 <E>）
// 每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符
// 类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符
// 泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像 int、double、char 等）
// 泛型标记符: E T K V N ?
public class Demo {
    public static void main(String[] args) {
        Integer[] i = {1, 2, 3};
        Double[] f = {1.1, 2.2, 3.3};
        String[] s = {"a", "b", "c"};
        printArray(i);
        printArray(f);
        printArray(s);

        System.out.printf("%s \n", max(i));
        System.out.printf("%s \n", max(f));

        ArrayList<String> sArr = new ArrayList<>();
        sArr.add("a");
        printFirst(sArr);
        ArrayList<Integer> iArr = new ArrayList<>();
        iArr.add(1);
        printFirst(iArr);
    }

    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T max(T[] arr)
    {
        if (arr.length == 0) {
            throw new IllegalArgumentException("empty max value");
        }
        if (arr.length == 1) {
            return arr[0];
        }
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = arr[i].compareTo(arr[i-1]) > 0 ? arr[i] : arr[i-1];
        }
        return max;
    }

    public static <E> void printArray(E[] arr) {
        for (E elem: arr) {
            System.out.printf("%s \n", elem.toString());
        }
    }

    /**
     * ? extends Comparable<?>
     * @param data
     */
    public static void printFirst(List<?> data) {
        System.out.printf("%s \n", data.get(0));
    }
}
