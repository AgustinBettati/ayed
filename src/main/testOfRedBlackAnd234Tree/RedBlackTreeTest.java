package main.testOfRedBlackAnd234Tree;

import main.util.Scanner;
import struct.impl.RedBlackTree;
import struct.istruct.BinaryTree;

import java.util.ArrayList;

/**
 * @author Agustin Bettati
 * @version 1.0
 */
public class RedBlackTreeTest {

    public static void main(String[] args) {
        RedBlackTree<Integer> rbTree = new RedBlackTree<>();

//        System.out.println("Enter 0 when you want to view the red-black tree. ");
//        while(true){
//            int newDni = Scanner.getInt("Enter DNI: ");
//            if(newDni == 0){
//
//                System.exit(0);
//            }
//            rbTree.insert(newDni);
//        }

        rbTree.insert(5);
        rbTree.insert(7);
        rbTree.insert(9);
        rbTree.insert(4);
        rbTree.insert(3);
        int position = 0;
        int toFinishLevel = 1;
        for(RedBlackTree.RedBlackNode node : getTreeLevelOrderWithNulls(rbTree)){
            if(position == toFinishLevel){
                System.out.println();
                position = 0;
                toFinishLevel = toFinishLevel * 2;
            }
            if(node != null){
                String color = "";
                if(node.getColor() == 0){
                    color = "Black";
                }
                else {
                    color = "Red";
                }
                System.out.print("< Data: "+ node.getData() +", "+color+" > ");
            }
            else {
                System.out.print(" < Empty node > ");
            }
            position++;
        }

    }

    private static ArrayList<RedBlackTree.RedBlackNode> getTreeLevelOrderWithNulls(RedBlackTree<Integer> tree) {
        ArrayList<RedBlackTree.RedBlackNode> list = new ArrayList<>();
        for (int i = 1; i <= height(tree); i++) {
            addElementsOfLevelToListWithNulls(tree, i, list);
        }
        return list;
    }

    private static void addElementsOfLevelToListWithNulls(RedBlackTree<Integer> tree, int level, ArrayList<RedBlackTree.RedBlackNode> list) {
        if(tree.isEmpty()){
            list.add(null);
        }
        else if (level == 1)
            list.add(tree.getNode());
        else if (level > 1) {
            addElementsOfLevelToListWithNulls(tree.getLeft(), level - 1, list);
            addElementsOfLevelToListWithNulls(tree.getRight(), level - 1, list);
        }
    }


    private static int height(BinaryTree<Integer> tree) {
        if (tree.isEmpty())
            return 0;
        else {
            int leftHeight = height(tree.getLeft());
            int rightHeight = height(tree.getRight());

            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else return (rightHeight + 1);
        }
    }
}
