import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @time 2019年11月6日 19:07:43
 * 创建二叉树并进行二叉树的遍历
 */
public class MyTree {
    // 二叉树结点
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }
    /**
     * 构建二叉树
     * @param inputList 输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;

        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        // 如果元素不存在，则跳出递归
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     * @param node 二叉树结点
     */
    public static void preOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     * @param node   二叉树节点
     */
    public static void inOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.println(node.data);
        inOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树后序遍历
     * @param node   二叉树节点
     */
    public static void postOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 二叉树非递归前序遍历
     * @param root 二叉树根节点
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;

        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }
    public static void main(String[] args) {
        LinkedList<Integer> inputList =
                new LinkedList<Integer>(Arrays.asList(new Integer[]{3,2,8,null,null,10,null,5,null,4} ));
        TreeNode treeNode = createBinaryTree(inputList);

        System.out.print("前序遍历: ");
        preOrderTraversal(treeNode);
        System.out.print("中序遍历: ");
        inOrderTraversal(treeNode);
        System.out.print("后序遍历: ");
        postOrderTraversal(treeNode);
        preOrderTraveralWithStack(treeNode);
    }

}
