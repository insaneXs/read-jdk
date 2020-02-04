/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * This file is available under and governed by the GNU General Public
 * License version 2 only, as published by the Free Software Foundation.
 * However, the following notice accompanied the original version of this
 * file:
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent.locks;
import java.util.concurrent.TimeUnit;
import java.util.Date;

/**
 *  条件对象
 */
public interface Condition {

    /**
     * 让线程进入等待，如果其他线程调用同一Condition对象的notify/notifyAll，那么等待的线程可能被唤醒
     */
    void await() throws InterruptedException;

    /**
     * 不抛出中断异常的await方法
     */
    void awaitUninterruptibly();

    /**
     * 带超时的await
     */
    long awaitNanos(long nanosTimeout) throws InterruptedException;

    /**
     * 带超时的await（可指定时间单位）
     */
    boolean await(long time, TimeUnit unit) throws InterruptedException;

    /**
     * 带超时的await（指定截止时间）
     */
    boolean awaitUntil(Date deadline) throws InterruptedException;

    /**
     * 唤醒等待的线程
     */
    void signal();

    /**
     * 唤醒所有线程
     */
    void signalAll();
}
