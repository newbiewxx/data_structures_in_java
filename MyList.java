/* 2019年10月22日 20:49:22 */

/**
 * 链表结点
 */

public class MyList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    // 头结点指针
    private Node head;
    // 尾结点指针
    private Node last;
    // 链表实际长度
    private int size;

    /**
     * 链表插入元素
     * @param data 插入元素
     * @param index 插入位置
     */
    public void insert(int data, int index) throws Exception {
        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException("超出链结点范围");
        }
        Node insertedNode = new Node(data);
        if (size == 0) {
            // 空链表
            head = insertedNode;
            last = insertedNode;
        }
        else if (index == 0) {
            // 插入头部
            insertedNode.next = head;
            head = insertedNode;
        }
        else
        {
            // 插入中间
            Node prevNode = get(index-1);
            Node nextNode = prevNode.next;
            prevNode.next = insertedNode;
            insertedNode.next = nextNode;
        }
        size++; // 链长+1
    }

    /**
     * 链表删除元素
     * @param index 删除的位置
     */
    public Node remove(int index) throws Exception {
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出链结点范围");
        }
        Node removedNode = null;
        if (index == 0) {
            // 删除头结点
            removedNode = head;
            head = head.next;
        }
        else if (index == size-1)
        {
            // 删除尾结点
            Node prevNode = get(size-1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        }
        else
        {
            // 删除中间节点
            Node prevNode = get(index-1);
            Node nextNode = prevNode.next.next;
            removedNode = prevNode.next;
            prevNode.next = nextNode;
        }
        size--;
        return removedNode;
    }

    /**
     * 链表查找元素
     * @param index 查找的位置
     */
    public  Node get(int index) throws Exception {
        if (index<0 || index >=size) {
            throw new IndexOutOfBoundsException("超出链结点范围");
        }
        Node temp = head;
        for (int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 输出链表
     */
    public void output() {
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws Exception{
        MyList mylist = new MyList();
        mylist.insert(1,0);
        mylist.insert(2,1);
        mylist.insert(4,2);
        mylist.insert(8,3);
        mylist.insert(16,4);
        mylist.remove(1);
        mylist.output();
    }
}
