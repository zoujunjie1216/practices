package gongdao2021.thread;

import concurrent.Print100;

/**
 * 两个线程交替打印数字100
 * */
public class StepPrint {

  //相应的lock（Object的wait 和 notifyAll） 操作必须在synchronize 关键字中进行 否则无法确定状态
  private Object lock = new Object();

  private volatile boolean hasPrint = true;

  private int a = 0;

  class A implements Runnable{
      @Override
      public void run() {
          for(int i =0;i<50;i++){
              synchronized (lock){
                  if(hasPrint){
                       try {
                           //wait 表示持有对象锁 的线程进入等待状态 并释放锁
                           lock.wait();
                       }catch (Exception e){

                       }
                  }
                  hasPrint = true;
                  System.out.println("A: "+ a++);
                  //通知所有等待锁的线程
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
                  if(!hasPrint){
                   try {
                       lock.wait();
                   }catch (Exception e){

                   }
                  }
                  hasPrint = false;
                  System.out.println("B:"+ a++);
                  lock.notifyAll();
              }
          }
      }
  }
    public static void main(String[] args) {
        StepPrint a=new StepPrint();
        Thread b=new Thread(a.new A());
        Thread c=new Thread(a.new B());
        b.start();
        c.start();
    }
}
