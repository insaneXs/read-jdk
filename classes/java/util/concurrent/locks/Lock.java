
package java.util.concurrent.locks;
import java.util.concurrent.TimeUnit;

/**
 * 锁接口
 */
public interface Lock {

    /**
     * 获取锁，如果该锁未被其他线程占用，则该线程获取锁，如果已被其他线程占用，则该线程一直阻塞
     */
    void lock();

    /**
     * 可中断的获取锁，如果锁未被其他线程占用，则该线程获取锁，否则一直阻塞，直到获取锁。
     * 若线程在阻塞时被中断，则该方法抛出InterruptedException。
     */
    void lockInterruptibly() throws InterruptedException;

    /**
     * 尝试获取锁，无论是否成功获取，该方法均会立即返回。
     * 返回值 true 表示锁获取成功， 返回值 false 表示锁获取失败
     */
    boolean tryLock();

    /**
     * 在一定时间内尝试获取锁，未成功获取锁时，线程为阻塞状态，如果此时线程被中断，则抛出InterruptedException
     * 在时间内若能获取锁，则返回 true，否则返回 false
     */
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    /**
     * 释放锁
     * 通常在释放前，需要验证线程是否持有锁，如果未持有，则可能抛出异常
     */
    void unlock();

    /**
     * 获取锁对象的Condition对象，在调用Condition的wait方法前，线程需要占有锁
     */
    Condition newCondition();
}
