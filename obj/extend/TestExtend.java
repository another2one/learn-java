package obj.extend;

public class TestExtend {
    public static void main (String args[]){
        // 初始化时子类构造器必须先调用父类构造器(父类有不含参数的构造器时不用显示指定)
        System.out.println("------ExtendDemo 类继承------");
        Demo sc1 = new Demo();
        Demo sc2 = new Demo(100);

        System.out.println("------ExtendDemo1 类继承------");
        Demo1 sc3 = new Demo1();
        Demo1 sc4 = new Demo1(200);
    }
}
