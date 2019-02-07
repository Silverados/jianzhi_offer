package jianzhi_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weiyuwang
 * @since 2019/1/21 20:22
 *
 * 问题是在多线程下无法使用。
 *
 */
class Singleton {

    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}

/**
 * 线程安全，但是多线程效率低下
 * 懒汉式
 */
class Singleton1 {
    private static Singleton1 instance = null;

    private Singleton1() {
    }

    public synchronized Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

/**
 * 饿汉式
 */
class Singleton2 {
    private static Singleton2 instance = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

/**
 * 静态内部类加载
 */
class Singleton3 {
    private static class SingletonInner{
        private static Singleton3 instance = new Singleton3();
    }

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return SingletonInner.instance;
    }
}

class Singleton4 {
    private static volatile Singleton4 instance = null;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}


public class Q2_SingletonTest{
    public static ExecutorService executor = Executors.newFixedThreadPool(10);
    public static List<Singleton> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                list.add(Singleton.getInstance());
            }
        });
        boolean hasDiff = false;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) != list.get(i + 1)) {
                hasDiff = true;
                break;
            }
        }
        if (hasDiff) {
            System.out.println("sorry!you make mistake");
        }else {
            System.out.println("yeah!you are right!");
        }

    }
}
