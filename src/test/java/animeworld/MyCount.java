package animeworld;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyCount {
	private String oid; // 账号
	private int cash; // 账户余额
	private Lock lock = new ReentrantLock();// 账户锁
	private Condition _save = lock.newCondition(); // 存款条件
	private Condition _draw = lock.newCondition(); // 取款条件

	public MyCount(String oid, int cash) {
		this.oid = oid;
		this.cash = cash;
	}

	/**
	 * @param name
	 *            操作人
	 * @param x
	 *            存款金额
	 * @Description: TODO
	 * @author ジャック
	 * @date 2018年3月26日
	 */
	public void saving(String name, int x) {
		lock.lock(); // 获取锁
		if (x > 0) {
			cash += x;
			System.out.println(name + "存款" + x + "，当前余额为" + cash);
		}
		_draw.signalAll();//唤醒所有的取款操作
		lock.unlock();
	}

	/**
	 * @param name
	 *            操作人
	 * @param x
	 *            取款金额
	 * @Description: TODO
	 * @author ジャック
	 * @date 2018年3月26日
	 */
	public void drawing(String name, int x) {
		lock.lock(); // 获取锁
		try {
			while (cash - x < 0) {
				_draw.await(); // 阻塞取款操作, await之后就隐示自动释放了lock，直到被唤醒自动获取

				System.out.println(name + "阻塞中");
			}{
				cash -= x; // 取款
				System.out.println(name + "取款" + x + "，当前余额为" + cash);
			}
			
			_save.signalAll(); // 唤醒所有存款操作
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
