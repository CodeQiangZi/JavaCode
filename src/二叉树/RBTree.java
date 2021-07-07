package 二叉树;

import java.util.Comparator;

public class RBTree<E> extends BBST<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RBTree(){
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) return node;
        ((RBNode<E>)node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node){
        return node == null ? BLACK : ((RBNode<E>)node).color;
    }

    private boolean isBlack(Node<E> node){
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node){
        return colorOf(node) == RED;
    }

    @Override
    protected Node createNode(Object element, Node parent) {
        return new RBNode<>(element, parent);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;

        // 添加的是根节点
        if(parent == null) {
            black(node);
            return;
        }

        // 情况一、如果父节点是黑色，直接返回
        if (isBlack(parent)) return;

        // 叔父节点
        Node<E> uncle = parent.sibling();
        // 祖父节点
        Node<E> grand = parent.parent;
        if (isRed(uncle)) { // 情况二、叔父节点是红色
            black(parent);
            black(uncle);
            // 祖父节点当作是新添加的节点
            afterAdd(red(grand));
            return;
        } else {
            // 情况三、叔父节点不是红色
            if (parent.isLeftChild()) {   // L
                red(grand);
                if (node.isLeftChild()) { // LL
                    black(parent);
                } else { // LR
                    black(node);
                    rotateLeft(parent);
                }
                rotateRight(grand);
            } else { // R
                red(grand);
                if (node.isLeftChild()) { // RL
                    black(node);
                    rotateRight(parent);
                } else { // RR
                    black(parent);
                }
                rotateLeft(grand);
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node) {
        super.afterRemove(node);
    }

    private static class RBNode<E> extends Node<E> {
        boolean color = RED;
        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            return str + element.toString();
        }
    }
}
