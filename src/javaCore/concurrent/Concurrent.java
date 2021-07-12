package javaCore.concurrent;

public class Concurrent {
    public static void main(String[] args) {

        Runnable runnable1=new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<100;i++) {
                        System.out.println("test concurrent"+i);
                        Thread.sleep(10);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable = () -> {
            try {
                for(int i=0;i<100;i++) {
                    System.out.println("test concurrent"+i);
                    Thread.sleep(10);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 =new Thread(runnable);
        t1.start();
        t2.start();
    }
}
