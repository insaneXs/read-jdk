package java.util.concurrent.locks;

/**
 * AbstractOwnableSynchronizer 直译的话可以叫可拥有的锁
 * 主要提供的能力就是定义锁的拥有者
 */
public abstract class AbstractOwnableSynchronizer
    implements java.io.Serializable {

    /** Use serial ID even though all fields transient. */
    private static final long serialVersionUID = 3737899427754241961L;

    /**
     * Empty constructor for use by subclasses.
     */
    protected AbstractOwnableSynchronizer() { }

    /**
     * 排它性的持有锁的线程
     */
    private transient Thread exclusiveOwnerThread;

    /**
     * 设置 排它性的持有锁的线程
     */
    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    /**
     * 获取 排它性的持有锁的线程
     */
    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }
}
