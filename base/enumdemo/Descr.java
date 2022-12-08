package base.enumdemo;

enum Num {
    ONE, TWO, THREE;
}

public class Descr {
    enum Color {
        RED, GREEN, BLUE;

        private Color() {
            System.out.println("Constructor called for : " + this.toString());
        }

        public void colorInfo() {
            System.out.println("Universal Color");
        }
    }

    // 执行输出结果
    public static void main(String[] args) {
        Color c1 = Color.RED;
        c1.colorInfo();
        Num n1 = Num.ONE;
        System.out.printf("%s, %s \n", c1, n1);

        for (Color a : Color.values()) {
            // System.out.printf("%s \n", a);
        }
    }
}
