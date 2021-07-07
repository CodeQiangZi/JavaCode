package 二叉树;
import 二叉树.printer.BinaryTrees;

public class Main {
    static void test1(){
        Integer data[] = new Integer[] {
//                85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rb = new RBTree<>();
        for(int i = 0; i < data.length; i ++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
    }

    public static void main(String[] args) {
        test1();
    }
}
