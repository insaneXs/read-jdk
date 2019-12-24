package java.util;

/**
 * 栈-后进先出的数据结构（线程安全）
 *
 * @author  Jonathan Payne
 * @since   JDK1.0
 */
public class Stack<E> extends Vector<E> {
    /**
     * Creates an empty Stack.
     */
    public Stack() {
    }

    /**
     * push时add进vector的表尾
     */
    public E push(E item) {
        addElement(item);

        return item;
    }

    /**
     * pop时，从vector表头弹出
     */
    public synchronized E pop() {
        E       obj;
        int     len = size();

        obj = peek();
        removeElementAt(len - 1);

        return obj;
    }

    /**
     * 返回栈顶元素（Vector的尾部）
     */
    public synchronized E peek() {
        int     len = size();

        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    /**
     * 栈是否为空
     */
    public boolean empty() {
        return size() == 0;
    }

    /**
     * 查找某个元素的栈深度
     */
    public synchronized int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    /** use serialVersionUID from JDK 1.0.2 for interoperability */
    private static final long serialVersionUID = 1224463164541339165L;
}
