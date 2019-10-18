package ai.evision.tangwang.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @program: Java-BasicKnowledge
 * @description: 线程池使用
 * @author: WangTang
 * @create: 2019-10-18 13:46
 **/

public class TryTheadPool {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("demo-thread-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(4,10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(256), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        executorService.execute(()->System.out.println(Thread.currentThread().getName()));
        executorService.execute(()->System.out.println(Thread.currentThread().getName()));
        executorService.execute(()->System.out.println(Thread.currentThread().getName()));
        executorService.shutdown();
    }
}
