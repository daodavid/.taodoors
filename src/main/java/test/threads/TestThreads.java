package test.threads;


import java.util.ArrayList;
import java.util.List;

public class TestThreads {
    static volatile int k;



    static List<Thread> list = new ArrayList<Thread>();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 20; i++) {
            list.add(new Thread(new Runnable() {
                double i = 0;
                //public  synchronized void increment() throws InterruptedException {
                public  synchronized void increment() throws InterruptedException {
                        k++;
                    //wait();
                }

                @Override
                public void run() {
                    while (true) {
                        i++;
                        i = i / 10;
                        i = i / 100;
                        i = i + 100;

                        try {
                            increment();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                    }

                }
            }));
        }

        for (Thread a : list) {
            a.start();

        }

    }
/***
 * conclusion
 * when there are many threads and they don't share the one same syncronized  methods .They engege the   more cpu ,but when they become to wait and synchronized the performance can no to be achieve
 *
 *
 *
 */

}
