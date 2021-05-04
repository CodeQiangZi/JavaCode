package 二叉树;
import 二叉树.printer.BinaryTrees;

public class Main {
    static void test1(){
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        AVLTree<Integer> bst = new AVLTree<>();
        for(int i = 0; i < data.length; i ++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
        bst.remove(7);

        BinaryTrees.println(bst);
    }

    public static void main(String[] args) {
        test1();
    }
}
