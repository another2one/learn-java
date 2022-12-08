package datastruct;

import java.util.HashSet;

// https://www.runoob.com/java/java-LinkList.html
// 通过 hashMap 实现 实际时就是map键
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> a = new HashSet<String>();
        a.add("1");
        a.add("3");
        a.add("2");
        a.remove("1");
        a.add("1");
        System.out.printf("HashSet： \n");
        for (String i : a) {
            System.out.printf("%s \n", i);
        }
        System.out.println(a);
    }
}
