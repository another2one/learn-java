package obj.polym;

public class Demo {
    public static void main(String[] args) {
        show(new Dog());
        show(new Cat());
    }

    public static void show (Animal a) {
        a.say();
    }
}

abstract class Animal {
    abstract void say();
}

class Dog extends Animal {
    public void say() {
        System.out.printf("汪汪 \n");
    }
}

class Cat extends Animal {
    public void say() {
        System.out.printf("喵喵 \n");
    }
}