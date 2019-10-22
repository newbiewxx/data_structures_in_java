/* 2019年10月22日 17:44:03 */

/*
 * 1.数组中间插入元素
 * 2.扩容数组
 * 3.删除元素
 */

public class MyArray {
    private int[] array;  // 定义数组
    private int size;  // 实际元素数量
    /**
     * @param capacity 创建数组的大小
     */
    public MyArray(int capacity) {
        this.array = new int[capacity];  // 动态初始化创建一个容量为capacity的数组
        size = 0;
    }

    /** 数组插入元素
     * @param element 插入的元素
     * @param index  插入的位置
     */
    public void insert(int element, int index) throws Exception {
        // 判断访问下标是否超出范围
        if (index<0 || index>size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        // 如果实际元素达到数组容量上限，对数组进行扩容
        if (size >= array.length) {
            resize();
        }
        // 从右向左遍历元素,元素依次向后移
        for (int i=size-1; i>=index; i-- ) {
            array[i+1] = array[i];
        }
        // 腾出的位置放入新元素
        array[index] = element;
        size++;  // 元素个数+1
    }

    /**
     * 删除元素
     * @param index 删除的位置
     */
    public int delete(int index) throws Exception {
        // 判断访问的下标是否超出范围
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        int deleteElement = array[index];
        // 从左向右循环，将元素往左移
        for (int i=index; i<=size-1; i++) {
            array[i] =  array[i+1];
        }
        size--;
        return deleteElement;
    }

    /**
     * 数组扩容
     */
    public void resize() {
        int[] arrayNew = new int[array.length*2];
        // 将旧数组赋值到新数组
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }
    /**
     * 输出数组
     */
    public void output() {
        for (int i=0; i<size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(4);

        myArray.insert(3,0);
        myArray.insert(5,1);
        myArray.insert(7,2);
        myArray.insert(4,3);
        // 加了resize()方法后
        myArray.insert(9,1);
        myArray.insert(6,3);
        myArray.delete(1);
        myArray.output();

    }
}
