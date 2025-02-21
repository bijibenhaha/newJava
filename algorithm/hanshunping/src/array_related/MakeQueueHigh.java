package array_related;

/**
 * 用数组的结构存储队列的数据
 * 完全利用数组的空间(使用环形数组)
 * 以下的方法 会有一个空内存空间，即最大存储空间为 maxSize-1
 * 难点：
 * 1 getSize() 获取存储空间的长度
 * 2 下一个数据的下标：（position+1） % maxSize
 */
public class MakeQueueHigh {
    public static void main(String[] args) {
        ArrayQueueHigh arrayQueue = new ArrayQueueHigh(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);

        arrayQueue.remove();
        arrayQueue.remove();
        arrayQueue.remove();

        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);

        arrayQueue.showOne(); // 2
        arrayQueue.showAll(); // 2 3
    }
}

class ArrayQueueHigh {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueueHigh(int max) {
        maxSize = max;
        // 分别表示 要添加的位置 以及 要删除的位置
        rear = 0;
        front = 0;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        if (rear == front) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if ((rear + 1) % maxSize == front) {
            return true;
        } else {
            return false;
        }
    }

    public void add(int expected) {
        if (isFull()) {
            System.out.println("you cannot add any more,cause the queue is full");
            return;
        }
        arr[rear] = expected;
        System.out.println("you added: " + arr[rear]);
        rear = (rear + 1) % maxSize;
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("you cannot remove any more,cause the queue is empty");
            return;
        }
        System.out.println("you removed: " + arr[front]);
        front = (front + 1) % maxSize;
    }

    public void showOne() {
        if (isEmpty()) {
            System.out.println("the queue is empty");
            return;
        }
        System.out.println("you get: " + arr[front]);
    }

    public void showAll() {
        if (isEmpty()) {
            System.out.println("the queue is empty");
            return;
        }
        int size = getSize();

        for (int i = front; i < front + size; i++) {
            int i1 = arr[i % maxSize];
            System.out.println("当前值为: " + i1);
        }
    }

    public int getSize() {
        return (rear + maxSize - front) % maxSize;
    }


}


