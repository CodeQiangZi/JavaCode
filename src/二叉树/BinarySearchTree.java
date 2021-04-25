package 二叉树;
import 二叉树.printer.BinaryTreeInfo;
import java.util.Comparator;
import java.util.IllegalFormatFlagsException;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
    }

    public void add(E element){
        elementNotNullCheck(element);

        // 添加第一个节点
        if (root == null) {
            root = new Node<>(element, null);
            size ++;
            return;
        }

        // 添加的不是第一个节点
        // 找到父节点
        Node<E> parent = root;
        Node<E> node = root;
        int cmp = 0;
        while(node != null){
            cmp = compare(element, node.element);

            parent = node;

            if (cmp > 0) {
                node = node.right;
            } else if(cmp < 0) {
                node = node.left;
            } else { // 相等
                return;
            }
        }

        // 看看插入到父节点的哪个位置
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
    }

    public void remove(E element){
    }

    public boolean contains(E element){
        return false;
    }

    /*
    * 返回值==0 代表 e1=e2;
    * 返回值>0 代表 e1>e2;
    * 返回值<0 代表 e1<e2;
    * */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalFormatFlagsException("element must not be null");
        }
    }

    // 节点结构
    private static class Node<E>{
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent){
            this.element = element;
            this.parent = parent;
        }
    }

    // 用于打印
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if(myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }

        return ((Node<E>)node).element + "_p(" + parentString + ")";
    }
}
