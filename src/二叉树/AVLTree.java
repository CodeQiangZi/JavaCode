package 二叉树;

import java.util.Comparator;

public class AVLTree<E> extends BBST<E> {
    public AVLTree(){
        this(null);
    }

    public AVLTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                // 平衡：更新高度
                updateHeight(node);
            } else {
                // 不平衡的：恢复平衡
                rebalance(node);
                // 整棵树恢复平衡
                break;
            }
        }
    }

    @Override
    protected void afterRemove(Node<E> node, Node<E> replacement) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                // 平衡：更新高度
                updateHeight(node);
            } else {
                // 不平衡的：恢复平衡
                rebalance(node);
            }
        }
    }

    @Override
    protected void afterRotate(Node<E> grand, Node<E> parent, Node<E> child) {
        super.afterRotate(grand, parent, child);
        // 更新高度
        updateHeight(grand);
        updateHeight(parent);
    }

    @Override
    protected void rotare(Node<E> r, Node<E> b, Node<E> c, Node<E> d, Node<E> e, Node<E> f) {
        super.rotare(r, b, c, d, e, f);
        // 更新高度
        updateHeight(b);
        updateHeight(f);
        updateHeight(d);
    }

    /**
     * 恢复平衡
     * @param grand 高度最低的不平衡节点
     */
//    private void rebalance2(Node<E> grand) { // 结合资料中的图看：g\p\n节点
//        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
//        Node<E> node = ((AVLNode<E>)parent).tallerChild();
//        if (parent.isLeftChild()) { // L
//            if (node.isLeftChild()) { //LL
//                rotateRight(grand);
//            } else { // LR
//                rotateLeft(parent);
//                rotateRight(grand);
//            }
//        } else { // R
//            if (node.isLeftChild()) { //RL
//                rotateRight(parent);
//                rotateLeft(grand);
//            } else { // RR
//                rotateLeft(grand);
//            }
//        }
//    }

    // 统一所有旋转操作
    private void rebalance(Node<E> grand) { // 结合资料中的图看：g\p\n节点
        Node<E> parent = ((AVLNode<E>)grand).tallerChild();
        Node<E> node = ((AVLNode<E>)parent).tallerChild();
        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) { //LL
                rotare(grand, node, node.right, parent, parent.right, grand);
            } else { // LR
                rotare(grand, parent, node.left, node, node.right, grand);
            }
        } else { // R
            if (node.isLeftChild()) { //RL
                rotare(grand, grand, node.left, node, node.right, parent);
            } else { // RR
                rotare(grand, grand, parent.left, parent, node.left, node);
            }
        }
    }

    @Override
    protected Node<E> createNode(Object element, Node parent) {
        return new AVLNode<>(element, parent);
    }

    private boolean isBalanced(Node<E> node) {
        return Math.abs(((AVLNode<E>)node).balanceFactor()) <= 1;
    }

    private void updateHeight(Node<E> node) {
        ((AVLNode<E>)node).updateHeight();
    }

    private static class AVLNode<E> extends Node<E> {
        int height = 1;

        public AVLNode(E element, Node<E> parent){
            super(element, parent);
        }

        public int balanceFactor(){ // 平衡因子：左子树-右子树
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            return leftHeight - rightHeight;
        }

        public void updateHeight(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            height = 1 + Math.max(leftHeight, rightHeight);
        }

        public Node<E> tallerChild(){
            int leftHeight = left == null ? 0 : ((AVLNode<E>)left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>)right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return isLeftChild() ? left : right;
        }

        @Override
        public String toString() {
            String parentString = "null";
            if(parent != null) {
                parentString = parent.element.toString();
            }
            return element + "_p(" + parentString + ")_h(" + height + ")";
        }
    }
}
