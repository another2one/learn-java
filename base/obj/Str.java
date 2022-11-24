package base.obj;

// https://www.runoob.com/java/java-string.html
public class Str {
    public static void main(String[] args) {
        // Object 向下分别
        // Number: Byte Short Integer Long Float Double
        // Boolean
        // Character
        numberTips();
    }

    public static void numberTips() {
        // String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上
        String s1 = "lizhi";
        s1 = "test";
        System.out.println(s1);
        // s1[0] = 'a'; 不能直接修改
        char[] s2 = s1.toCharArray();
        s2[0] = 'a';
        s1 = new String(s2);
        String s3 = s1 + " ss"; // 底层 new StringBuffer().append(a).append(b).toString();
        System.out.println(s3);
        // 当一个字符串是一个字面量时，它会被放到一个常量池中，等待复用
        String s4 = "test";
        String s5 = new String(s4);
        String s6 = new String("test");
        String s7 = "test";
        String s8 = "te" + "st"; // 编译时就优化为 test 了 但是含有变量是还是走 new StringBuffer()
        System.out.printf("s4 == s7 is %b, s4 == s5 is %b, s4 == s6 is %b, s4 == s8 is %b \n", s7 == s4, s4 == s5, s4 == s6, s4 == s8);

        // 如果要操作少量的数据用 String
        // 单线程操作大量数据用 StringBuilder
        // 多线程操作大量数据，用 StringBuffer
    }
}
