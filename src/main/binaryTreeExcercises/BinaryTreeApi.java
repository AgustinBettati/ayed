package main.binaryTreeExcercises;


import struct.impl.LinkedBinaryTree;
import struct.istruct.BinaryTree;

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

    public static void main(String[] args) {
        LinkedBinaryTree<Integer> leftTree=new LinkedBinaryTree<>(5);
        LinkedBinaryTree<Integer> rrightTree=new LinkedBinaryTree<>(6);
        LinkedBinaryTree<Integer> rightTree=new LinkedBinaryTree<>(3, new LinkedBinaryTree<>(), rrightTree);

        LinkedBinaryTree<Integer> mainTree=new LinkedBinaryTree<>(6, leftTree, rightTree);

        BinaryTreeApi<Integer> api = new BinaryTreeApi<>();
        System.out.println(api.weightOfTree(mainTree));
        System.out.println(api.numberOfLeaves(mainTree));
        System.out.println(api.amountOfElementOcurrencies(mainTree,6));

        System.out.println(api.amountGivenLevel(mainTree,3));
    }

}
