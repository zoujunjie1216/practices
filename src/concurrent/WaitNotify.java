package concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    /**
     * 1.使用wait().notify() notifyAll()时需要先对调用对象加锁
     * 2.使用wait线程由running 变为waiting，并将当前对象放到等待队列
     * 3 notify和notifyAll使用后依然需要等待对象锁被释放才能返回
     * 4.notify和notifyAll的线程由waiting变为blocked
     * 5 wait 方法返回的前提是获得锁对象
     * */
    static boolean flag=true;
    static Object lock=new Object();
    public static void main(String[] args) {
        Thread waitThread=new Thread(new Wait(),"waitThread");
        waitThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        Thread notifyThread=new Thread(new Notify(),"notifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable{
        @Override
        public void run() {
            //加锁
            synchronized (lock){
                while(flag){
                    try{
                        System.out.println(Thread.currentThread()+new SimpleDateFormat("HH:mm:ss").format(new Date())+"  true_flag");
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread()+new SimpleDateFormat("HH:mm:ss").format(new Date())+"  false_flag");
                }
            }
        }
    }

    static  class Notify implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                System.out.println(Thread.currentThread()+new SimpleDateFormat("HH:mm:ss").format(new Date())+" lock_notify " );
                lock.notifyAll();
                flag=false;
                try{
                    Thread.sleep(5);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            //到这里lock被释放 两个线程抢锁  谁先抢到谁执行 输出结果顺序可能不同
            synchronized (lock) {
                System.out.println(Thread.currentThread()+new SimpleDateFormat("HH:mm:ss").format(new Date())+" lock_again " );
                try{
                    Thread.sleep(5);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
