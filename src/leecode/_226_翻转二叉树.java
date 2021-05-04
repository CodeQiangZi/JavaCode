package leecode;

// https://leetcode-cn.com/problems/invert-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        // 前序遍历
//        if (root == null) return root;
//
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//        return root;

//        // 后序遍历
//        if (root == null) return root;
//
//        invertTree(root.left);
//        invertTree(root.right);
//
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        return root;

//        // 中序遍历
//        if (root == null) return root;
//
//        invertTree(root.left);
//
//        TreeNode tmp = root.left;
//        root.left = root.right;
//        root.right = tmp;
//
//        invertTree(root.left);
//
//        return root;

        // 测序遍历
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
