package 二叉树;

import com.sun.source.tree.BinaryTree;
import 二叉树.printer.BinaryTrees;

import java.io.File;
import java.nio.file.Files;
import java.util.Comparator;

public class Main {
//    public static class PersonComparator implements Comparator<Person>{
//        public int compare(Person e1, Person e2) {
//            return e1.getAge() - e2.getAge();
//        }
//    }
//    public static class PersonComparator2 implements Comparator<Person>{
//        public int compare(Person e1, Person e2) {
//            return e2.getAge() - e1.getAge();
//        }
//    }

    static void test1(){
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i = 0; i < data.length; i ++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
    }

    static void test2(){
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Person> bst1 = new BinarySearchTree<>();
        for(int i = 0; i < data.length; i ++) {
            bst1.add(new Person(data[i]));
        }
        BinaryTrees.println(bst1);


        BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        for(int i = 0; i < data.length; i ++) {
            bst2.add(new Person(data[i]));
        }
        BinaryTrees.println(bst2);
    }

    static void test3(){
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i = 0; i < data.length; i ++) {
            bst.add(data[i]);
        }

//        BinaryTrees.println(bst);
//
//        bst.levelOrderTraversal();



//        bst.levelOrder(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public void visit(Integer element) {
//                System.out.println("_" + element + "_");
//            }
//        });

//        bst.inorder(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public void visit(Integer element) {
//                System.out.println("_" + element + "_");
//            }
//        });

//        bst.postorder(new BinarySearchTree.Visitor<Integer>() {
//            @Override
//            public void visit(Integer element) {
//                System.out.println("_" + element + "_");
//            }
//        });

        BinaryTrees.println(bst);
        System.out.println(bst.height1());
    }

    public static void main(String[] args) {
        test3();
    }
}
