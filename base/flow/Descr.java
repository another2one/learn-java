package base.flow;

public class Descr {

    public static void main(String[] args) {
        // while
        int a = 3;
        while (a > 0) {
            a--;
            System.out.println(a);
        }

        // do while
        do {
            System.out.println(a);
            a++;
        } while (a < 3);

        // for
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        int[] numbers = {0, 1, 2};
        for (int i : numbers) {
            System.out.println(i);
        } 

        // if else
        if (a == 1) {
            System.out.println("a==1");
        } else if (a == 2) {
            System.out.println("a==2");
        } else {
            System.out.println("a");
        }

        // switch 
        char c = 'A';
        switch (c) {
            case 'A':
                System.out.println("A");
                break;
        
            default:
                System.out.println(c);
                break;
        }
    }
}
