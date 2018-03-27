package animeworld;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TestConditon {

	public static void main(String[] args) {
		MyCount myCount =new MyCount("995566332211", 10000);
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Thread t1 = new SaveThread("张三", myCount, 1000);
        Thread t2 = new SaveThread("李四", myCount, 1000);
        Thread t3 = new DrawThread("王五", myCount, 12600);
        Thread t4 = new SaveThread("老张", myCount, 1600);
        Thread t5 = new DrawThread("老牛", myCount, 1300);
        Thread t6 = new DrawThread("胖子", myCount, 2800);
        Thread t7 = new SaveThread("测试", myCount, 2100);
        // 执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        // 关闭线程池
        pool.shutdown();
	}
	
}
