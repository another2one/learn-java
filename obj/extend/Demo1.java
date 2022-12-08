package obj.extend;

public class Demo1 extends SuperExtendDemo {
    protected int n;

    Demo1() { // 自动调用父类的无参数构造器
        System.out.println("SubClass");
    }

    public Demo1(int n) {
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass(int n):" + n);
        this.n = n;
    }
}
