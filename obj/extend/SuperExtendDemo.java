package obj.extend;

public class SuperExtendDemo {
    protected int n;
    SuperExtendDemo(){
        System.out.println("SuperClass():" + this.n);
    }
    SuperExtendDemo(int n) {
        this.n = n;
        System.out.println("SuperClass(int n):" + this.n);
    }
}
