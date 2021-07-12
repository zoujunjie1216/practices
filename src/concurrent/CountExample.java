package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class CountExample {
    private static int threadTotal=200;
    private static int clientTotal=5000;

    private  static  AtomicInteger count=new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService exec= Executors.newCachedThreadPool();//线程池
        //ExecutorService exe2= Executors.newScheduledThreadPool();//线程池
        final Semaphore semaphore=new Semaphore(threadTotal);//信号量
        final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
        for(int index=0;index<clientTotal;index++){
            exec.execute(()->{
                try{
                    //在这两个方法之间的操作只允许限定数量的线程进入
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        try{
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        exec.shutdown();
        System.out.println(count);
    }

    public static void add(){
        count.incrementAndGet();
    }
}
