package array_related;

/**
 * 用数组的结构存储队列的数据
 * 无法完全利用数组的空间
 */

public class MakeQueueLow {
    public static void main(String[] args) {
        ArrayQueueLow arrayQueue = new ArrayQueueLow(10);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);

        arrayQueue.remove();

        arrayQueue.showOne(); // 2
        arrayQueue.showAll(); // 2 3
    }
}

class ArrayQueueLow{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    public ArrayQueueLow(int max){
        maxSize = max;
        // 分别表示 要添加的位置 以及 要删除的位置
        rear = 0;
        front = 0;
        arr = new int[maxSize];
    }
    public boolean isEmpty(){
        if (rear == front){
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull(){
        if (rear == maxSize){
            return true;
        }else {
            return false;
        }
    }

    public void add(int expected){
        if (isFull()){
            System.out.println("you cannot add any more,cause the queue is full");
            return;
        }
        arr[rear++] = expected;
        System.out.println("you added: "+arr[rear-1]);
    }

    public void remove(){
        if (isEmpty()){
            System.out.println("you cannot remove any more,cause the queue is empty");
            return;
        }
        System.out.println("you removed: "+ arr[front]);
        front++;
    }

    public void showOne(){
        if (isEmpty()){
            System.out.println("the queue is empty");
            return;
        }
        System.out.println("you get: "+ arr[front]);
    }

    public void showAll(){
        if (isEmpty()){
            System.out.println("the queue is empty");
            return;
        }
        for (int i = front ; i < rear;i++){
            System.out.println(arr[i]);
        }
    }

}
