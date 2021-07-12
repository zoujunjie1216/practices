package concurrent;


import java.util.function.IntConsumer;

/**
 * 三线程打印数据 synchronized（object）
 * */
public class ZeroEvenOdd {
   private int n;
   private int a=1;
   private static Object lock=new Object();
   //是否可以开启zero方法
   private boolean zeroFlag;
   //是否可以开启even 方法
   private boolean evenFlag;
   //是否可以开启odd 方法
   private boolean oddFlag;
   //判断开启even 方法还是 odd方法
   private boolean flag;

   public ZeroEvenOdd(int n){
       this.n=n;
   }

    public static void main(String[] args) {
        ZeroEvenOdd z=new ZeroEvenOdd(10);
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    z.odd();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }) ;
        Thread b=new Thread(new Runnable() {
            @Override
            public void run(){
               try {
                   z.zero();
               }catch (InterruptedException e){
                   e.printStackTrace();
               }
            }
        });
        Thread c=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    z.even();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();
        c.start();


    }

    public void zero() throws InterruptedException {
        for(int i = 1;i <= n;i++){
          synchronized(lock){
                while(zeroFlag){
                    lock.wait();
                }
              System.out.println(0);
                if(!flag){ // 可打印odd
                    oddFlag = true;
                }else{
                    evenFlag = true;
                }
                zeroFlag = true;
                lock.notifyAll();
            }

        }
    }
    public void even() throws InterruptedException {
        synchronized(lock){
            for(int i = 2;i <= n;i += 2){
                while(!evenFlag){ // evenFlag为false时，锁等待
                    lock.wait();
                }
                System.out.println(i);
                zeroFlag = false;
                evenFlag = false;
                flag = false;
                lock.notifyAll();
            }
        }

    }

    public void odd() throws InterruptedException {
        synchronized(lock){
            for(int i = 1;i <= n;i += 2){
                while(!oddFlag){  // oddFlag为false时，锁等待
                    lock.wait();
                }
                System.out.println(i);
                zeroFlag = false;
                oddFlag = false;
                flag = true;
                lock.notifyAll();
            }
        }
    }
}
