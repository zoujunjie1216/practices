package gongdao2021.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {
    ReentrantLock lock =new ReentrantLock();
    //氢气的条件队列
    Condition hcon =lock.newCondition();
    //氧气的条件队列
    Condition oCon = lock.newCondition();

    int num = 0;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
       lock.lock();
       try {
           //氢原子数量等于2
           while (num == 2){
               //氧气条件队列首节点移出
               oCon.signal();
               //当前线程进入氢气条件队列
               hcon.await();
           }
           releaseHydrogen.run();
           num++;
       }finally {
           lock.unlock();
       }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (num!=2){
                //氢气条件队列唤醒
                hcon.signal();
                //当前线程进入氧气气条件队列
                oCon.await();
            }
            releaseOxygen.run();
            num = 0;
        }finally {
            lock.unlock();
        }
    }

}
