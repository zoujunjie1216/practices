package arithmetic.project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Map map=new HashMap();
        map.put("a",1);
        map.put(null,2);
        map.get("a");
        System.out.println(map.get(null));
        ConcurrentHashMap b=new ConcurrentHashMap();
        b.put("a",1);
        b.get("a");
        Hashtable c=new Hashtable();
        c.put("a",1);


        Lock lock=new ReentrantLock();
        lock.lock();
        Thread.sleep(300);
        ExecutorService es=Executors.newSingleThreadExecutor();
        es.execute(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("hello");
                lock.unlock();
            }
        });
        lock.unlock();
    }
}
