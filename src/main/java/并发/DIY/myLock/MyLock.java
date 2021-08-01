package 并发.DIY.myLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义锁
 */
public class MyLock implements Lock {

    private Sync sync;

    public MyLock() {
        sync = new Sync();
    }

    @Override
    public void lock() {
        sync.acquire(1);
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "尝试获取锁，状态为" + thread.getState());
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    private class Sync extends AbstractQueuedSynchronizer {
        /**
         * 需要实现Condition效果则需要另外
         * 重写isHeldExclusively方法
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            //是否处于占用状态
            return getState() == 1;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            Thread thread = Thread.currentThread();
            int c = getState();
            // 无锁状态 可以直接获取锁
            if (c == 0) {
                // 如果没有前继节点（自己就是头结点） 则尝试直接获取锁
                if (!hasQueuedPredecessors() && compareAndSetState(0, arg)) {
                    // 设置占有锁的线程
                    setExclusiveOwnerThread(thread);
                    System.out.println(Thread.currentThread().getName() + "获取到锁");
                    return true;
                }

            } else {
                // 有锁状态 竞争
                int state = c + arg;
                // 如果是当前线程 则可重入
                if (getExclusiveOwnerThread() == thread) {
                    setState(state);
                    System.out.println(Thread.currentThread().getName() + "重入获取到锁");
                    return true;
                }
            }
            // acquire方法 如果tryAcquire失败 会将当前线程加入同步队列中
            System.out.println(Thread.currentThread().getName() + "尝试获取锁失败");
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            int c = getState() - arg;
            boolean free = false;
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new IllegalMonitorStateException();
            }
            // 因为存在可重入锁  加几次锁就需要解几次锁 否则会一直阻塞 当state为0时锁才会全部释放
            if (c == 0) {
                free = true;
                // 设置占有线程为空
                setExclusiveOwnerThread(null);
                System.out.println(Thread.currentThread().getName() + "释放锁");
            }
            // 设置状态
            setState(c);
            return free;
        }
        Condition newCondition() {
            return new ConditionObject();
        }
    }

}
