package 二叉树;
import 二叉树.printer.BinaryTrees;

public class Main {
    static void test1(){
        Integer data[] = new Integer[] {
                85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56
        };

        AVLTree<Integer> bst = new AVLTree<>();
        for(int i = 0; i < data.length; i ++) {
            bst.add(data[i]);
//            BinaryTrees.println(bst);
        }
        BinaryTrees.println(bst);
    }

    public static void main(String[] args) {
        test1();
    }
}
