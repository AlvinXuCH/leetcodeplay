package leetcodetest.locktest;

/**
 * Synchronized是java内置的锁，用于实现线程同步。是一个关键字，可用于修饰方法和类
 * 特点：可重入，互斥性，对象锁和类锁，不可中断
 */
public class SynchronizedTest {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("Increment to: " + count);
    }

    public synchronized void decrement() {
        count--;
        System.out.println("Decrement to: " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest test = new SynchronizedTest();
        Thread t1 = new Thread(() -> {
            for(int i=0;i<10;i++){
                test.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<10;i++){
                test.decrement();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + test.count);
    }
}
