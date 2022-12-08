package datastruct;

import java.util.ArrayList;
import java.util.Collections;

// https://www.runoob.com/java/java-arraylist.html
// 场景 末尾添加操作较多
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        a.add("1");
        a.add("3");
        a.add(1, "2");

        System.out.printf("数组： \n");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%s \n", a.get(i));
        }

        a.remove(1);
        a.add("2");
        System.out.printf("数组： \n");
        for (String i : a) {
            System.out.printf("%s \n", i);
        }
        Collections.sort(a);
        System.out.println(a);
    }
}
