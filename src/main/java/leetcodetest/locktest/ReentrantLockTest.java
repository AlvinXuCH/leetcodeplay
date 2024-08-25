package leetcodetest.locktest;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {
        lock.lock();
        try {
            count++;
            System.out.println("Incrment to:" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            count--;
            System.out.println("Decrement to:" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                reentrantLockTest.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                reentrantLockTest.decrement();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count:" + reentrantLockTest.count);
    }
}
