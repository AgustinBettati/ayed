package main.binaryTreeExcercises;


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

}
