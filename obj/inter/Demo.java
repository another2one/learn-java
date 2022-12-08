package obj.inter;

public class Demo {
    public static void main(String[] args) {
        System.out.printf("%s \n", Animal.EAT);
        show(new Dog());
        show(new Cat());
    }

    public static void show(Animal a) {
        a.say();
    }
}

interface Animal {
    static final String EAT = "食草动物";
    public void say();
}

class Dog implements Animal {
    public void say() {
        System.out.printf("汪汪 \n");
    }
}

class Cat implements Animal {
    public void say() {
        System.out.printf("喵喵 \n");
    }
}