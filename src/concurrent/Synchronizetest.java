package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchronizetest {
    public  synchronized void test1() {

            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(5);
                    System.out.println("t1-"+i);
                } catch (Exception e) {

                }
            }
        }

    public  static synchronized void test2() {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(5);
                    System.out.println("t2-"+i);
                } catch (Exception e) {

                }
            }
        }


    public static void main(String[] args) {
        ExecutorService executors=Executors.newCachedThreadPool();
        Synchronizetest m=new Synchronizetest();
        Synchronizetest n=new Synchronizetest();
        String a="123";
        String b=new String("123");
        System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(m.equals(n));
        System.out.println(m instanceof Synchronizetest);
        executors.execute(new Runnable() {
            @Override
            public void run() {
              m.test1();
            }
        });
        executors.execute(new Runnable() {
            @Override
            public void run() {

                    n.test1();

            }
        });
        executors.shutdown();

    }
}
