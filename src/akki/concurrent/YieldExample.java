package akki.concurrent;

public class YieldExample {

    public static void main(String[] args)
    {
        Runnable  producer = () -> {
            for (int i = 0; i < 5; i++)
            {
                System.out.println("I am Producer : Produced Item " + i);
                Thread.yield();
            }
        };

        System.out.println("helllo");
        Thread producerThread = new Thread(producer);
        Thread consumer = new Consumer();

        producerThread.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producerThread.start();
        consumer.start();
    }
}

class Consumer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}
