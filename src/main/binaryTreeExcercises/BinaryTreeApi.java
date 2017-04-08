package main.binaryTreeExcercises;


import struct.impl.LinkedBinaryTree;
import struct.istruct.BinaryTree;

import java.util.ArrayList;

/**
 * Created by marcos on 8/4/17.
 */
public class BinaryTreeApi<T> {

    public int weightOfTree (BinaryTree<T> aTree){
        if (aTree.isEmpty()){
            return 0;
        }
        else{
            return 1+ weightOfTree(aTree.getLeft())+ weightOfTree(aTree.getRight());
        }

    }
    public int numberOfLeaves(BinaryTree<T> aTree){
        if ((!aTree.isEmpty())&&(aTree.getLeft().isEmpty())&&(aTree.getRight().isEmpty())){
            return 1 ;
        }
        else {
            int left=0;
            int right =0;
            if(!aTree.getLeft().isEmpty()){
                left=numberOfLeaves(aTree.getLeft());
            }
            if(!aTree.getRight().isEmpty()){
                right=numberOfLeaves(aTree.getRight());
            }
            return right + left;
        }
    }

    public int amountOfElementOcurrencies (BinaryTree<T> a, T element){
        if(a.isEmpty()) {
            return 0;
        }
        else if(a.getRoot().equals(element)) {
            return 1 + amountOfElementOcurrencies(a.getLeft(), element) + amountOfElementOcurrencies(a.getRight(), element);
        }
        else {
            return amountOfElementOcurrencies(a.getLeft(), element) + amountOfElementOcurrencies(a.getRight(), element);
        }
    }

    public int amountGivenLevel(BinaryTree<T> a, int level) {
        if (a.isEmpty()){
            return 0;
        }
        else if (level == 1){
            return 1;
        }
        else{
           return amountGivenLevel(a.getLeft(), level-1) + amountGivenLevel(a.getRight(), level-1);
        }
    }

    public ArrayList<T> getTreePreOrder(BinaryTree<T> tree){
        ArrayList<T> list  = new ArrayList<>();
        getTreePreOrder(tree, list);
        return list;

    }
    private void getTreePreOrder(BinaryTree<T> tree, ArrayList<T> list){
        if(!tree.isEmpty()){
            list.add(tree.getRoot());
            getTreePreOrder(tree.getLeft(), list);
            getTreePreOrder(tree.getRight(), list);
        }
    }

    public ArrayList<T> getTreeInOrder(BinaryTree<T> tree){
        ArrayList<T> list  = new ArrayList<>();
        getTreeInOrder(tree, list);
        return list;

    }
    private void getTreeInOrder(BinaryTree<T> tree, ArrayList<T> list){
        if(!tree.isEmpty()){
            getTreeInOrder(tree.getLeft(), list);
            list.add(tree.getRoot());
            getTreeInOrder(tree.getRight(), list);
        }
    }

    public ArrayList<T> getTreePostOrder(BinaryTree<T> tree){
        ArrayList<T> list  = new ArrayList<>();
        getTreePostOrder(tree, list);
        return list;

    }
    private void getTreePostOrder(BinaryTree<T> tree, ArrayList<T> list){
        if(!tree.isEmpty()){
            getTreePostOrder(tree.getLeft(), list);
            getTreePostOrder(tree.getRight(), list);
            list.add(tree.getRoot());
        }
    }

    public ArrayList<T> getTreeLevelOrder(BinaryTree<T> tree){
        ArrayList<T> list  = new ArrayList<>();
        for(int i = 1; i <= height(tree); i++){
            addElementsOfLevelToList(tree, i, list);
        }
        return list;
    }

    private void addElementsOfLevelToList (BinaryTree<T> tree ,int level, ArrayList<T> list)
    {
        if (tree.isEmpty())
            return;
        if (level == 1)
            list.add(tree.getRoot());
        else if (level > 1)
        {
            addElementsOfLevelToList(tree.getLeft(), level-1, list);
            addElementsOfLevelToList(tree.getRight(), level-1, list);
        }
    }

    public int height(BinaryTree<T> tree) {
        if (tree.isEmpty())
            return 0;
        else
        {
            int leftHeight = height(tree.getLeft());
            int rightHeight = height(tree.getRight());

            if (leftHeight > rightHeight)
                return(leftHeight+1);
            else return(rightHeight+1);
        }
    }

    public int sumOfElements(BinaryTree<Integer> tree){

        if(tree.isEmpty()){
            return 0;
        }
        int partialResult = 0;
        partialResult += tree.getRoot();
        partialResult += sumOfElements(tree.getLeft()) + sumOfElements(tree.getRight());

        return partialResult;
    }

    public int sumOfElementsThatAreDivisibleBy3(BinaryTree<Integer> tree){
        if(tree.isEmpty()){
            return 0;
        }
        int partialResult = 0;
        if(tree.getRoot() % 3 == 0){
            partialResult += tree.getRoot();
        }
        partialResult += sumOfElementsThatAreDivisibleBy3(tree.getLeft()) +
                 sumOfElementsThatAreDivisibleBy3(tree.getRight());

        return partialResult;
    }


}
