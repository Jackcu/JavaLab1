package commDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jack on 5/20/2016.
 */
public class ThreadTest extends TestCase {


    public static Logger logger = null;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ThreadTest(String testName) {

        super(testName);

        logger = LogManager.getLogger(testName);//T1.class.getName()

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ThreadTest.class);
    }

    public void test_td1() throws InterruptedException {

        Thread t = new Thread(() -> {

            while (true) {

                try {


                    logger.trace("t");
                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                    break;

                }

            }

        });


        t.start();

        Thread.sleep(5000);

        t.interrupt();

    }

    public void test_td2() throws InterruptedException {

        Object m1 = new Object();

        Thread t1 = new Thread(() -> {

            while (true) {

                try {

                    synchronized (m1) {

                        logger.trace("t1");
                        Thread.sleep(1000);

                    }
                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    //e.printStackTrace();

                    break;

                }

            }

        });
        t1.setPriority(1);

        Thread t2 = new Thread(() -> {

            while (true) {

                try {

                    synchronized (m1) {
                        logger.trace("t2");
                        Thread.sleep(1000);
                    }
                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    //e.printStackTrace();

                    break;

                }

            }

        });
        t1.setPriority(1);


        t1.start();
        t2.start();

        Thread.sleep(50000);

        t1.interrupt();
        t2.interrupt();

    }

    public void test_td3() throws InterruptedException {

        final Lock reentrantLock = new ReentrantLock(true);//公平重入锁

        Thread t1 = new Thread(() -> {

            while (true) {

                try {

                    reentrantLock.lock();

                    logger.trace("t1");

                    Thread.sleep(1000);

                    reentrantLock.unlock();

                    //Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                    break;

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {


                }

            }

        });

        t1.setPriority(2);

        Thread t2 = new Thread(() -> {

            while (true) {

                try {

                    reentrantLock.lock();

                    logger.trace("t2");
                    Thread.sleep(1000);

                    reentrantLock.unlock();

                    //Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                    break;

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {


                }

            }

        });

        t2.setPriority(1);


        t2.start();
        t1.start();

        Thread.sleep(5000);

        t1.interrupt();
        t2.interrupt();

    }

    public void test_td4() throws InterruptedException {

        final Lock reentrantLock = new ReentrantLock();

        Thread t1 = new Thread(() -> {

            while (true) {

                try {

                    reentrantLock.lockInterruptibly();

                    logger.trace("t1");

                    Thread.sleep(1000);

                    reentrantLock.unlock();

                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                    break;

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {


                }

            }

        });


        reentrantLock.lock();
        t1.start();
        Thread.sleep(5000);
        t1.interrupt();

        t1.join();

    }

    public void test_td5() throws InterruptedException {

        final ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock(true);//公平重入读写锁

        Thread t1 = new Thread(() -> {

            while (true) {

                try {

                    rw1.readLock().lockInterruptibly();

                    logger.trace("t1");

                    Thread.sleep(1000);

                    rw1.readLock().unlock();

                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                    break;

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {


                }

            }

        });


        //rw1.writeLock().lock();
        rw1.readLock().lock();

        t1.start();
        Thread.sleep(5000);
        t1.interrupt();

        t1.join();

    }

    public void test_td6() throws InterruptedException {

        final AutoResetEvent semp = new AutoResetEvent(false);//类似 autoresetevent

        Thread t1 = new Thread(() -> {

            while (true) {

                try {

                    semp.waitOne();

                    logger.trace("t1");

                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                    break;

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {


                }

            }

        });

        t1.start();

        Thread.sleep(5000);
        semp.set();

        Thread.sleep(15000);
        t1.interrupt();

        t1.join();

    }

    public void test_td7() throws InterruptedException {

        final ManualResetEvent semp = new ManualResetEvent(false);//类似 ManualResetEvent

        Thread t1 = new Thread(() -> {

            while (true) {

                try {

                    semp.waitOne();

                    logger.trace("t1");

                    Thread.sleep(1000);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                    break;

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {


                }

            }

        });

        t1.start();

        Thread.sleep(5000);
        semp.set();

        Thread.sleep(15000);
        t1.interrupt();

        t1.join();

    }

    public void test_td8() throws InterruptedException {

        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semp = new Semaphore(5);//信号量

        // 模拟20个客户端访问

        for (int index = 0; index < 20; index++) {

            final int NO = index;

            Runnable run = () -> {

                try {

                    // 获取许可

                    semp.acquire();

                    System.out.println("Accessing: " + NO);

                    Thread.sleep((long) (Math.random() * 10000));

                    // 访问完后，释放

                    semp.release();

                    System.out.println("-----------------" + semp.availablePermits());

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            };

            exec.execute(run);

        }

        // 退出线程池
        //logger.trace("退出线程池");
        //exec.shutdown();


        Thread.sleep(15001110);

    }


}
