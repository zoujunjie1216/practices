package concurrent;

import java.util.concurrent.CountDownLatch;


/**
 * 方法2需要在方法1之前执行，方法3需要在方法2之前执行
 * 使用 CountDownLatch 没有执行countDown操作之前，先执行别的方法会wait（）
 * 另外可以使用semaphore(控制代码的同一时间的线程数)当数量为0的时候就相当与一把锁
 * */
public class SquenceMethod {
    private CountDownLatch second=new CountDownLatch(1);
    private CountDownLatch third=new CountDownLatch(1);

    public SquenceMethod() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
