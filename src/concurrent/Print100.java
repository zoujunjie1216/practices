package concurrent;

/**
 * 两个线程交替打印奇数和偶数
 * */
public class Print100 {

    // synchronized（object） 方式去锁定对象
    public  static  Object lock=new Object();
    //记录打印值
    private   int index=1;
    //记录是否该当前线程打印了
   private volatile boolean aHasPrint=false;

   class A implements Runnable{
       @Override
       public void run() {
           //一共需要打印50次
           for(int i=0;i<50;i++){
               //直接加锁
               synchronized(lock){
                   if(aHasPrint){
                       try{
                           //如果当前线程打印过则进行阻塞
                           lock.wait();
                       }catch (InterruptedException e){
                           e.printStackTrace();
                       }
                   }
                   System.out.println("A:"+index);
                   index++;
                   aHasPrint=true;
                   //唤醒等待锁资源的其他线程
                   lock.notifyAll();
               }
           }
       }
   }

   class B implements Runnable{
       @Override
       public void run() {
           for(int i=0;i<50;i++){
               synchronized (lock){
                   if (!aHasPrint){
                       try{
                           //如果当前线程打印过则进行阻塞
                           lock.wait();
                       }catch (InterruptedException e){
                           e.printStackTrace();
                       }

                   }
                   aHasPrint=false;
                   System.out.println("B:"+index);
                   index++;
                   lock.notifyAll();
               }
           }
       }
   }

    public static void main(String[] args) {
        Print100 a=new Print100();
        Thread b=new Thread(a.new A());
        Thread c=new Thread(a.new B());
        b.start();
        c.start();
    }

}
