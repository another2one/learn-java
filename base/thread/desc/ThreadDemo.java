package base.thread.desc;

// 洗杯子 5s 烧水 5s 倒茶 2s
// 没有多线程则顺序进行
public class ThreadDemo extends java.lang.Thread {


    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                ThreadDemo.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread(this, threadName);
            t.start ();
        }
    }

    public static void main(String args[]) {
        ThreadDemo R1 = new ThreadDemo( "Thread-1");
        R1.start();

        ThreadDemo R2 = new ThreadDemo( "Thread-2");
        R2.start();
    }
}