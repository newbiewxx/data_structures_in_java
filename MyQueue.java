/**
 * @time 2019年10月29日 13:10:38
 * 实现队列
 */
public class MyQueue {
    private int[] array;
    private int front;  // 对头
    private int rear; // 队尾

    public MyQueue(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * 入队
     * @param element 入队的元素
     */
    public void enQueue(int element) throws Exception {
        if ((rear+1) % array.length == front) {
            throw new Exception("队列已满");
        }
        else
        {
            array[rear] = element;
            rear = (rear+1) % array.length;
        }
    }

    /**
     * 出队
     */
    public int deQueue() throws Exception {
        if (rear == front) {
            throw new Exception("队列已空");
        }
        else
        {
            int deQueueElement = array[front];
            front = (front+1) % array.length;
            return deQueueElement;
        }
    }

    /**
     * 输出队列
     */
    public void output() {
        for (int i=front; i!=rear; i=(i+1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyQueue myqueue = new MyQueue(8);
        myqueue.enQueue(0);
        myqueue.enQueue(2);
        myqueue.enQueue(4);
        myqueue.enQueue(6);
        myqueue.enQueue(8);
        myqueue.enQueue(10);
        myqueue.deQueue();
        myqueue.deQueue();
        myqueue.enQueue(12);
        myqueue.output();
    }
}
