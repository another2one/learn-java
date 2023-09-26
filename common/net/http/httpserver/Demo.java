package common.net.http.httpserver;

public class Demo {
    static int count = 1;

    static Demo instance;

    public int level = 0;

    public static Demo instance() {
        if (instance == null) {
            instance = new Demo();
        }
        return instance;
    }
}
