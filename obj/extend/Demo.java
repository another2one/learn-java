package obj.extend;

public class Demo extends SuperExtendDemo {
    protected int n;

    Demo(){
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass");
    }

    public Demo(int n){
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }
}
