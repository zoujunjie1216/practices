package gongdao2021.thread;

import java.util.function.IntConsumer;

/**
 * 多线程 输出不同的 字母
 * */
public class FizzBuzz {

    private int n;

    private volatile int num = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(num<n){
            if(num%3==0&&num%5!=0){
                printFizz.run();
                num++;
            }else{
                Thread.sleep(0);
            }

        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(num<n){
            if(num%3!=0&&num%5==0){
                printBuzz.run();
                num++;
            }else{
                Thread.sleep(0);
            }

        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(num<n){
            if(num%3==0&&num%5==0){
                printFizzBuzz.run();
                num++;
            }else{
                Thread.sleep(0);
            }

        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(num<n){
            if(num%3!=0&&num%5!=0){
                printNumber.accept(num);
                num++;
            }else{
                Thread.sleep(0);
            }

        }
    }
}
