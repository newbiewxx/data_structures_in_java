/**
 * @time 2019年11月3日 09:05:18
 *
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 有序表合并
 * 4) 删除倒数第K个结点
 */

public class LinkedListAlgo {
    class Node{
        int  data;
        Node next;
    }

    // 单链表反转
    public static Node reverse(Node list) {
        Node curr = list;
        Node prev = null;
        Node next = null;

        while (curr != null) {
            // 保存下一节点
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 链表中环的检测
    public static boolean checkCircle(Node list) {
        if (list == null) {  // 头结点为空
            return false;
        }

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
    // 有序表合并
    public  Node mergeTwoLists (Node l1, Node l2) {
        Node soldier = new Node();  // 设置哨兵结点
        Node p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }

        return soldier.next;
    }
    // 删除倒数第K个结点
    public static Node deleteLaskKth(Node list, int k) {
        Node fast = list;
        int i = 1;

        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return list;
        }

        Node slow = list;
        Node prev = null;

        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }
}

