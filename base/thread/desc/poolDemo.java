package base.thread.desc;

import util.CommonHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class poolDemo {
    public static long[] resArr = new long[200];
    public static void main(String[] args) {
        CommonHelper.timeSpend("main");
        //创建线程池对象  参数5，代表有5个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(20);
        //创建Runnable线程任务对象
        for (int i = 0; i < 30; i++) {
            TaskRunnable task1 = new TaskRunnable("task" + i, i);
            TaskRunnable task2 = new TaskRunnable("task" + (i + 100), i + 100);
            //从线程池中获取线程对象
            service.submit(task1);
            //再获取一个线程对象
            service.submit(task2);
        }

        //关闭线程池
        service.shutdown();

        while (true) {//等待所有任务都执行结束
            if (service.isTerminated()) {//所有的子线程都结束了
                CommonHelper.timeSpend("main");
                break;
            }
        }

    }
}

class TaskRunnable implements Runnable{
    private String name;
    private int max;
    TaskRunnable(String name, int max) {
        this.name = name;
        this.max = max;
    }
    @Override
    public void run() {
        CommonHelper.timeSpend(this.name);
        long j = 0;
        for (int i = 0; i < 1000000000 + max; i++) {
            j+=i;
        }
        CommonHelper.timeSpend(this.name);
//        System.out.printf("%s \n", j);
        poolDemo.resArr[this.max] = j;
    }
}