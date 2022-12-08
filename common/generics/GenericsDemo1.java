package common.generics;

public class GenericsDemo1<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        GenericsDemo1<Integer> integerBox = new GenericsDemo1<>();
        GenericsDemo1<String> stringBox = new GenericsDemo1<>();

        integerBox.set(10);
        stringBox.set("菜鸟教程");

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());
    }
}
