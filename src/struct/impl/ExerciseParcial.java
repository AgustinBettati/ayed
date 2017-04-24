package struct.impl;

import struct.istruct.BinaryTree;

/**
 * Created by marcos on 24/4/17.
 */
public class ExerciseParcial<T> {


    private boolean isInLeaves(T element,BinaryTree<T> binaryTree){
        if (binaryTree.isEmpty())return false;
        if (binaryTree.getLeft().isEmpty()&& binaryTree.getRight().isEmpty()){
            if (element.equals(binaryTree.getRoot())){
                return true;
            }
            else return false;
        }
        else {
            return isInLeaves(element,binaryTree.getRight())|| isInLeaves(element,binaryTree.getLeft());
        }

    }


    private BinaryTree<Integer> sumAndIsomorphic(BinaryTree<Integer> binaryTree){

       if (binaryTree.isEmpty()) return new LinkedBinaryTree<>();

        int sum= sumWithItsDecendants(binaryTree);

        LinkedBinaryTree<Integer> leftTree= (LinkedBinaryTree<Integer>) sumAndIsomorphic(binaryTree.getLeft());

        LinkedBinaryTree<Integer> rightTree= (LinkedBinaryTree<Integer>) sumAndIsomorphic(binaryTree.getRight());

        return new LinkedBinaryTree<Integer>(sum,leftTree,rightTree);
    }



    private int sumWithItsDecendants(BinaryTree<Integer> binaryTree){
        int result=0;
        if (binaryTree.isEmpty())return result;
//        if (binaryTree.getLeft().isEmpty()||binaryTree.getRight().isEmpty()){
//            if (binaryTree.getLeft().isEmpty()){
//                result+= binaryTree.getRoot()+binaryTree.getRight().getRoot();
//            }
//            else if (binaryTree.getRight().isEmpty()){
//                result+=binaryTree.getRoot()+binaryTree.getLeft().getRoot();
//            }
//        }
        else{
            result+= binaryTree.getRoot();

        }
        return result + sumWithItsDecendants(binaryTree.getLeft())+sumWithItsDecendants(binaryTree.getRight());
    }

}

//    public static void main(String[] args) {
//
//    }

