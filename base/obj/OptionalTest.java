package base.obj;

import java.util.Optional;

// https://www.runoob.com/java/java-string.html
public class OptionalTest {
    public static void main(String[] args) {
        Person p = new Person();
        String s;

        try {
            s = p.address.city.toLowerCase();
        } catch (NullPointerException e) {
            System.out.print("正常会出现空指针\n");
        }

        // 正常逻辑
        if (p.address != null && p.address.city != null) {
            s = p.address.city.toLowerCase();
        } else {
            s = "";
        }
        System.out.printf("[s] == %s \n", s);

        // 使用 optional
        s = Optional.of(p.address).map(u -> u.city).map(String::toLowerCase).orElse("");
        System.out.printf("[s] == %s \n", s);
    }
}

class Person {
   public Address address = new Address();
}

class Address {
    public String city;
}