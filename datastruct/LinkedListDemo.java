package datastruct;

import java.util.Collections;
import java.util.LinkedList;

// https://www.runoob.com/java/java-LinkList.html
// 场景 头部和中间添加操作较多
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<String>();
        a.add("1");
        a.add("3");
        a.add(1, "2");

        System.out.printf("LinkedList： \n");
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%s \n", a.get(i));
        }

        a.remove(1);
        a.add("2");
        System.out.printf("LinkedList： \n");
        for (String i : a) {
            System.out.printf("%s \n", i);
        }
        Collections.sort(a);
        System.out.println(a);
    }
}
