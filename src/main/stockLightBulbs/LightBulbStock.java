package main.stockLightBulbs;

import struct.impl.BinarySearchTree;
import java.util.ArrayList;

/**
 * Created by marcos on 22/4/17.
 */
public class LightBulbStock {
    BinarySearchTree<LightBulb> lightBulbTree;

    public LightBulbStock() {
        lightBulbTree = new BinarySearchTree<>();
    }

    public LightBulbStock(ArrayList<LightBulb> oldList){
        lightBulbTree=new BinarySearchTree<>();
        for (LightBulb lightBulb: oldList) {
            lightBulbTree.insert(lightBulb);
        }
    }

    public void addNewLightBulb(LightBulb lightBulb){
        lightBulbTree.insert(lightBulb);
    }

    public void deleteLightBulb(LightBulb lightBulb){
        lightBulbTree.delete(lightBulb);
    }

    public void modifyLightBulb(LightBulb newValues){
        lightBulbTree.delete(newValues);
        lightBulbTree.insert(newValues);
    }

    public ArrayList<LightBulb> getOrderedList(){
        ArrayList<LightBulb> list = new ArrayList<>();
        getTreeInOrder(lightBulbTree, list);
        return list;

    }

    private void getTreeInOrder(BinarySearchTree<LightBulb> tree, ArrayList<LightBulb> list) {
        if (!tree.isEmpty()) {
            getTreeInOrder(tree.getLeft(), list);
            list.add(tree.getRoot());
            getTreeInOrder(tree.getRight(), list);
        }
    }

}
