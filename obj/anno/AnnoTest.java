package obj.anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnoTest {

    public AnnoTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Check(length = 20)
    public String name = "";

    @Check(max = 100, min = 20)
    public int age = 0;

    public static void main (String args[]) throws IllegalAccessException {
        AnnoTest annoTest = new AnnoTest("lizhi", 300);
        for (Field field : annoTest.getClass().getDeclaredFields()) {
            // 利用注解检查
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof Check) {
                    field.setAccessible(true);
                    if (String.class.equals(field.getType())) {
                        String s = (String) field.get(annoTest);
                        if (((Check) annotation).length() > s.length()) {
                            System.out.printf("[%s 字段长度为 %d 字段类型检查通过] \n", field.getName(), s.length());
                        } else {
                            System.out.printf("[%s 字段长度为 %d 字段类型检查没有通过] \n", field.getName(), s.length());
                        }
                    } else if (field.getType().getName().equals("int")) {
                        int i = field.getInt(annoTest);
                        if (((Check) annotation).max() > i && ((Check) annotation).min() < i) {
                            System.out.printf("[%s 字段范围检查通过] \n", field.getName());
                        } else {
                            System.out.printf("[%s 字段范围检查通过] \n", field.getName());
                        }
                    }
                } else {
                    System.out.printf("暂时不处理注解 %s \n", annotation.getClass().getName());
                }
            }
        }
    }
}
