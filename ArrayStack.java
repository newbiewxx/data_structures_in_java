import sun.java2d.pipe.AAShapePipe;

/**
 * @time 2019年11月3日 10:41:49
 */
public class ArrayStack {
    private  String [] items;
    private int count;
    private int n;

    public ArrayStack(int n) {
        // 为数组分配大小为n的内存空间
        this.items = new String[n];
        this.n = n;
        this.count = 0;
    }

    // 入栈操作
    public boolean push(String item) {
        // 空间不够，返回false
        if (count == n) {
            return false;
        } else {
            items[count] = item;
            count++;
            return true;
        }
    }

    // 出栈操作
    public String pop() {
        // 栈空则返回null
        if (count == 0) {
            return null;
        } else {
            String tmp = items[count-1];
            count--;
            return tmp;
        }
    }

    public static void main(String[] args) {
        ArrayStack ArrSta = new ArrayStack(10);
        ArrSta.push("a");
        ArrSta.push("b");
        ArrSta.push("c");
        String str1 = ArrSta.pop();
        String str2 = ArrSta.pop();
        System.out.println(str1);  // c
        System.out.println(str2);  // b
    }
}
