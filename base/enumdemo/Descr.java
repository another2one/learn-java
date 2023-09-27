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
             System.out.printf("%s \n", a);
        }

        WeekDay mon = WeekDay.MON;
        for (WeekDay a : WeekDay.values()) {
            System.out.printf("%s \n", a);
        }
    }

    enum WeekDay {
        MON(1, "周一"),
        TUE(2, "周二"),
        SAT(3, "周三");

        private final int value;
        private final String name;

        private WeekDay (int value, String name) {
            this.value = value;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
