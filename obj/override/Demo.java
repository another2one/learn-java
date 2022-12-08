package obj.override;

public class Demo {

    // 重写: 修改继承的方法逻辑 通过super调用被重写的父类方法
    // 参数列表与被重写方法的参数列表必须完全相同
    // 返回类型与被重写方法的返回类型可以不相同，但是必须是父类返回值的派生类
    // 访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为 public，那么在子类中重写该方法就不能声明为 protected
    // 父类的成员方法只能被它的子类重写
    // 声明为 final 的方法不能被重写
    // 声明为 static 的方法不能被重写，但是能够被再次声明
    // 子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为 private 和 final 的方法
    // 子类和父类不在同一个包中，那么子类只能够重写父类的声明为 public 和 protected 的非 final 方法
    // 重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以
    // 构造方法不能被重写
    // 如果不能继承一个类，则不能重写该类的方法

    // 重载：java方法应该是通过方法名和参数类型来确定

    public static void main(String[] args) {
        Animal a = new Animal();
        a.move();
        Dog d = new Dog();
        d.move();
        d.move(3);
        d.bark();
    }

}

class Dog extends Animal {
    public void move(int step) {
        System.out.println("狗子可以移动" + step);
    }

    public void bark() {
        System.out.println("狗子可以吠叫");
    }
}

class Animal {
    public void move() {
        System.out.println("动物可以移动");
    }
}

