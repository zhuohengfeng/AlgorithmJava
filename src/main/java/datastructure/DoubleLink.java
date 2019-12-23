package datastructure;

/**
 * 双向链表
 * @param <T>
 */
public class DoubleLink<T> {

    class DNode<T> {
        public DNode preNode;
        public DNode nextNode;
        public T value;

        public DNode(T value, DNode prev, DNode next) {
            this.preNode = prev;
            this.nextNode = next;
            this.value = value;
        }
    }

    // 表头
    private DNode<T> mHead;
    // 链表中的个数
    private int mCount = 0;

    public DoubleLink() {
        mHead = new DNode<T>(null, null, null);
        mHead.preNode = mHead.nextNode = mHead;
        mCount = 0;
    }

    public int getCount() {
        return mCount;
    }

    public boolean isEmpty() {
        return mCount == 0;
    }

    public T get(int index) {
        return getNode(index).value;
    }

    public T getFirst() {
        return getNode(0).value;
    }

    public T getLast() {
        return getNode(mCount - 1).value;
    }

    private DNode<T> getNode(int index) {
        if (index >= mCount || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (index <= mCount / 2) {
            DNode<T> node = mHead.nextNode;
            for (int i = 0; i < index; i++) {
                node = node.nextNode;
            }
            return node;
        }

        // 正向查找
        DNode<T> rnode = mHead.preNode;
        int rindex = mCount - index - 1;
        for (int j = 0; j < rindex; j++) {
            rnode = rnode.preNode;

        }
        return rnode;
    }

    /**
     * 插入节点
     * @param index
     * @param t
     */
    public void insert(int index, T t) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            DNode<T> newOne = new DNode<T>(t, mHead, mHead.nextNode);
            mHead.nextNode.preNode = newOne;
            mHead.nextNode = newOne;
            mCount++;
            return;
        }

        DNode<T> fNode = getNode(index);
        DNode<T> newOne = new DNode<T>(t, fNode.preNode, fNode);
        fNode.preNode.nextNode = newOne;
        fNode.preNode = newOne;
        mCount++;
    }

    // 将节点插入第一个节点处。
    public void insertFirst(T t) {
        insert(0, t);
    }

    // 将节点追加到链表的末尾
    public void appendLast(T t) {
        DNode<T> node = new DNode<T>(t, mHead.preNode, mHead);
        mHead.preNode.nextNode = node;
        mHead.preNode = node;
        mCount++;
    }

    // 删除index位置的节点
    public void del(int index) {
        DNode<T> inode = getNode(index);
        inode.preNode.nextNode = inode.nextNode;
        inode.nextNode.preNode = inode.preNode;
        mCount--;
    }

    // 删除第一个节点
    public void deleteFirst() {
        del(0);
    }

    // 删除最后一个节点
    public void deleteLast() {
        del(mCount-1);
    }


    public static void main(String[] args) {

        DoubleLink<Integer> mDLink = new DoubleLink<Integer>();

    }

}
