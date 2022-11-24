package base.obj;

// https://www.runoob.com/java/java-number.html
public class Number {
    public static void main(String[] args) {
        // Object 向下分别
        // Number: Byte Short Integer Long Float Double
        // Boolean
        // Character
        numberTips();
    }

    public static void numberTips() {
        Integer x = 5; // x 被赋为整型值时，由于x是一个对象，所以编译器要对x进行装箱
        x+= 10; // 然后，为了使x能进行加运算，所以要对x进行拆箱
        System.out.printf("x=%d\n, x.value=%d \n", x, x.intValue());

        // Java 会对 -128 ~ 127 的整数进行缓存，所以当定义两个变量初始化值位于 -128 ~ 127 之间时，两个变量使用了同一地址
        Integer a = 123; // 实际为 Integer a = Integer.valueOf(123)
        Integer b = 123;
        System.out.printf("a,b 为123 时：a==b is %b, a.equals(b) is %b \n", a==b, a.equals(b));
        Integer c = 1230;
        Integer d = 1230;
        System.out.printf("c,d 为1230 时：c==d is %b, c.equals(d) is %b \n", c==d, c.equals(d));
        // Integer 是引用类型，实际是一个对象，Integer 存储的是引用对象的地址
        Integer i = new Integer(123);
        Integer j = new Integer(123);
        System.out.printf("i,j 同样 new 方法生成时:i==j is %b, i.equals(j) is %b, a==i is %b \n", i==j, i.equals(j), a==i);
    }
}
