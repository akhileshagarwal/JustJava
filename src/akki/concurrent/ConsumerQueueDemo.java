package akki.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ConsumerQueueDemo {
    public static void main(String[] args) {
        //making hot spot code
//        for (int i = 0; i < 100; i++) {
//            blockingVersion(false);
//            lockFreeVersion(false);
//        }
        System.err.println("///=============///");
        blockingVersion(true);
        //lockFreeVersion(true);

    }

    private static void blockingVersion(boolean print) {
        List<Integer> array = g();
        BlockingQueue blockingQueue = new ArrayBlockingQueue(array.size(), false, array);
        long startMills = System.currentTimeMillis();
        int threadNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            pool.execute(new BlockingConsumer(blockingQueue, countDownLatch));
        }
        pool.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            //
        }
        if (print)
            System.out.println("blocking version cost ms:" + (System.currentTimeMillis() - startMills));

    }

    private static void lockFreeVersion(boolean print) {
        List<Integer> array = g();
        ConcurrentLinkedQueue linkedQueue = new ConcurrentLinkedQueue(Arrays.asList(array));
        long startMills = System.currentTimeMillis();
        int threadNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            pool.execute(new LockFreeConsumer(linkedQueue, countDownLatch));
        }
        pool.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            //
        }
        if (print)
            System.out.println("lock free cost ms:" + (System.currentTimeMillis() - startMills));

    }

    static class BlockingConsumer implements Runnable {
        final BlockingQueue blockingQueue;
        final CountDownLatch countDownLatch;
        BlockingConsumer(BlockingQueue blockingQueue, CountDownLatch countDownLatch) {
            this.blockingQueue = blockingQueue;
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            try {
                for (; ; ) {
                    Object object = blockingQueue.poll();
                    if (object == null) {
                        return;
                    }
                    //doing works
                    Thread.sleep(20L);
                }
            } catch (InterruptedException e) {
                //
            } finally {
                countDownLatch.countDown();
            }

        }
    }

    static class LockFreeConsumer implements Runnable {
        final ConcurrentLinkedQueue linkedQueue;
        final CountDownLatch countDownLatch;
        LockFreeConsumer(ConcurrentLinkedQueue linkedQueue, CountDownLatch countDownLatch) {
            this.linkedQueue = linkedQueue;
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            try {
                for (; ; ) {
                    Object object = linkedQueue.poll();
                    if (object == null) {
                        return;
                    }
                    //doing works
                    Thread.sleep(20L);
                }
            } catch (InterruptedException e) {
                //
            } finally {
                countDownLatch.countDown();
            }

        }
    }

    static List<Integer> g() {
        Integer[] array = new Integer[10_000];
        Arrays.fill(array, 0);
        return Arrays.asList(array);
    }
}

