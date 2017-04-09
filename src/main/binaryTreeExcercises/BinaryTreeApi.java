package main.binaryTreeExcercises;


import struct.impl.LinkedBinaryTree;
import struct.istruct.BinaryTree;
import java.util.ArrayList;

/**
 * @author Agustin Bettati
 * @author Marcos Khabie
 * @version 1.0
 *
 * Class that contains several methods to interact and obtain information about binary trees.
 * @param <T>
 */
public class BinaryTreeApi<T> {
    FileInputOutput fileManager = new FileInputOutput();


    /**
     * A simple test to see the functioning of storing and retrieving a binary tree from a text
     * file.
     * @param args
     */
    public static void main(String[] args) {
        LinkedBinaryTree<Integer> leftTree = new LinkedBinaryTree<>(5);
        LinkedBinaryTree<Integer> childOfRightTree = new LinkedBinaryTree<>(4);
        LinkedBinaryTree<Integer> rightTree = new LinkedBinaryTree<>(7, null, childOfRightTree);
        LinkedBinaryTree<Integer> mainTree = new LinkedBinaryTree<>(10, leftTree, rightTree);

        BinaryTreeApi<Integer> api = new BinaryTreeApi<>();

        api.storeTreeInFile(mainTree, "binaryTree.txt");
        BinaryTree<Integer> generatedTree = api.generateTreeFromFile("binaryTree.txt");

        System.out.println(api.identicalTrees(mainTree, generatedTree));
    }


    /**
     * Return the amount of non empty nodes the binary tree contains.
     * @param aTree
     * @return
     */
    public int weightOfTree(BinaryTree<T> aTree) {
        if (aTree.isEmpty()) {
            return 0;
        } else {
            return 1 + weightOfTree(aTree.getLeft()) + weightOfTree(aTree.getRight());
        }

    }

    /**
     * return the amount of leaves the binary trees contains.
     * @param aTree
     * @return
     */
    public int numberOfLeaves(BinaryTree<T> aTree) {
        if ((!aTree.isEmpty()) && (aTree.getLeft().isEmpty()) && (aTree.getRight().isEmpty())) {
            return 1;
        } else {
            int left = 0;
            int right = 0;
            if (!aTree.getLeft().isEmpty()) {
                left = numberOfLeaves(aTree.getLeft());
            }
            if (!aTree.getRight().isEmpty()) {
                right = numberOfLeaves(aTree.getRight());
            }
            return right + left;
        }
    }

    /**
     * Returns the amount of time a certain value is present in the binary tree.
     * @param tree
     * @param element
     * @return
     */
    public int amountOfElementOcurrencies(BinaryTree<T> tree, T element) {
        if (tree.isEmpty()) {
            return 0;
        } else if (tree.getRoot().equals(element)) {
            return 1 + amountOfElementOcurrencies(tree.getLeft(), element) + amountOfElementOcurrencies(tree.getRight(), element);
        } else {
            return amountOfElementOcurrencies(tree.getLeft(), element) + amountOfElementOcurrencies(tree.getRight(), element);
        }
    }

    /**
     * returns the amount of non empty nodes in a given level.
     * @param a
     * @param level
     * @return
     */
    public int amountGivenLevel(BinaryTree<T> a, int level) {
        if (a.isEmpty()) {
            return 0;
        } else if (level == 1) {
            return 1;
        } else {
            return amountGivenLevel(a.getLeft(), level - 1) + amountGivenLevel(a.getRight(), level - 1);
        }
    }

    /**
     * returns the height of the binary tree.
     * @param tree
     * @return
     */
    public int height(BinaryTree<T> tree) {
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

    /**
     * Given a binary tree of integers, it return the sum of all the values it contains.
     * @param tree
     * @return
     */
    public int sumOfElements(BinaryTree<Integer> tree) {

        if (tree.isEmpty()) {
            return 0;
        }
        int partialResult = 0;
        partialResult += tree.getRoot();
        partialResult += sumOfElements(tree.getLeft()) + sumOfElements(tree.getRight());


        return partialResult;
    }

    /**
     * Given a binary tree of integers, it return the sum of all the values that can be divided
     * by 3.
     * @param tree
     * @return
     */
    public int sumOfElementsThatAreDivisibleBy3(BinaryTree<Integer> tree) {
        if (tree.isEmpty()) {
            return 0;
        }
        int partialResult = 0;
        if (tree.getRoot() % 3 == 0) {
            partialResult += tree.getRoot();
        }
        partialResult += sumOfElementsThatAreDivisibleBy3(tree.getLeft()) +
                sumOfElementsThatAreDivisibleBy3(tree.getRight());

        return partialResult;
    }

    /**
     * Examines if two tree have the same structure and values.
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean identicalTrees(BinaryTree<T> tree1, BinaryTree<T> tree2) {
        if (tree1 == null || tree2 == null)
            return tree1 == tree2;

        if (tree1.isEmpty() && tree2.isEmpty())
            return true;

        else if(!tree1.isEmpty() && !tree2.isEmpty()){

            if(!tree1.getRoot().equals(tree2.getRoot())){
                return false;
            }
            else if(! (identicalTrees(tree1.getLeft(),tree2.getLeft()) &&
                    identicalTrees(tree1.getRight(), tree2.getRight())) ){
                return false;
            }
            else
                return true;
        }
        else
            return false;

    }

    /**
     * examines if two trees haves the same structure.
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean isomorphicTrees(BinaryTree<T> tree1, BinaryTree<T> tree2) {

        if (tree1.isEmpty() && tree2.isEmpty())
            return true;

        if ((tree1.isEmpty() && !tree2.isEmpty()) || (!tree1.isEmpty() && tree2.isEmpty()))
            return false;

        return isomorphicTrees(tree1.getLeft(), tree2.getLeft())
                && isomorphicTrees(tree1.getRight(), tree2.getRight());
    }

    /**
     * Given two trees that dont contain repeated values, it examines if they contain the same
     * values.
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean treesContainSameElements(BinaryTree<T> tree1, BinaryTree<T> tree2){
        ArrayList<T> elementsOfTree1 = getTreeInOrder(tree1);
        ArrayList<T> elementsOfTree2 = getTreeInOrder(tree2);

        for (T element : elementsOfTree1){
            if(!elementsOfTree2.contains(element)){
                return false;
            }
        }
        return true;
    }


    /**
     * examines if a binary tree is complete, this means all its non empty nodes must either
     * have both of its child nodes, or non.
     * @param tree
     * @return
     */
    public boolean binaryTreeIsComplete(BinaryTree<T> tree){
        if(tree.isEmpty()){
            return true;
        }
        else if((tree.getLeft().isEmpty() && !tree.getRight().isEmpty()) ||
                (!tree.getLeft().isEmpty() && tree.getRight().isEmpty())){
            return false;
        }
        else {
            return binaryTreeIsComplete(tree.getLeft()) && binaryTreeIsComplete(tree.getRight());
        }
    }

    /**
     * Examines if a binary tree is full, this means its last level must have all of its leaves.
     * @param tree
     * @return
     */
    public boolean binaryTreeIsFull(BinaryTree<T> tree){

        if(!binaryTreeIsComplete(tree)){
            return false;
        }
        return numberOfLeaves(tree) == (int)Math.pow(2, height(tree)-1);
    }


    /**
     * given a binary tree of integers, it checks that all child nodes must contain smaller
     * values than its father.
     * @param tree
     * @return
     */
    public boolean stableBinaryTree(BinaryTree<Integer> tree){
        if(tree.isEmpty()){
            return true;
        }
        else if(!tree.isEmpty() && tree.getLeft().isEmpty() && tree.getRight().isEmpty()){
            return true;

        }
        else if(!tree.getLeft().isEmpty() && tree.getRoot() <= tree.getLeft().getRoot()){
            return false;
        }
        else if(!tree.getRight().isEmpty() && tree.getRoot() <= tree.getRight().getRoot()){
            return false;
        }
        else{
            return stableBinaryTree(tree.getLeft()) && stableBinaryTree(tree.getRight());
        }
    }

    /**
     * Examines if tree2 is a subtree of tree1.
     * @param tree1
     * @param tree2
     * @return
     */
    public boolean oneTreeInsideTheOther(BinaryTree<T> tree1, BinaryTree<T> tree2){
        if(tree2.isEmpty()){
            return true;
        }
        else if(tree1.isEmpty()){
            return false;
        }
        else if(identicalTrees(tree1, tree2)){
            return true;
        }
        else {
            return oneTreeInsideTheOther(tree1.getLeft(), tree2) ||
                    oneTreeInsideTheOther(tree1.getRight(), tree2);
        }
    }

    /**
     * prints the elements contained in the leaves of a binary tree.
     * @param tree
     */
    public void printLeaves(BinaryTree<T> tree){
        String leaves = "";
        for(T leaf : getLeaves(tree)){
            leaves += leaf + " ";
        }
        System.out.println(leaves);
    }

    /**
     * Returns a list containing the elements of the leaves in a binary tree.
     * @param tree
     * @return
     */
    public ArrayList<T> getLeaves(BinaryTree<T> tree){
        ArrayList<T> list = new ArrayList<T>();
        getLeaves(tree, list);
        return list;
    }
    private void getLeaves(BinaryTree<T> tree, ArrayList<T> list){
        if(!tree.isEmpty() && tree.getLeft().isEmpty() && tree.getRight().isEmpty()){
            list.add(tree.getRoot());
        }
        else if(!tree.isEmpty()){
            getLeaves(tree.getLeft(), list);
            getLeaves(tree.getRight(), list);
        }
    }

    /**
     * Returns a list with the elements of the binary tree in pre order.
     * @param tree
     * @return
     */
    public ArrayList<T> getTreePreOrder(BinaryTree<T> tree) {
        ArrayList<T> list = new ArrayList<>();
        getTreePreOrder(tree, list);
        return list;

    }

    private void getTreePreOrder(BinaryTree<T> tree, ArrayList<T> list) {
        if (!tree.isEmpty()) {
            list.add(tree.getRoot());
            getTreePreOrder(tree.getLeft(), list);
            getTreePreOrder(tree.getRight(), list);
        }
    }

    /**
     * Returns a list with the elements of the binary tree in  InOrder.
     * @param tree
     * @return
     */
    public ArrayList<T> getTreeInOrder(BinaryTree<T> tree) {
        ArrayList<T> list = new ArrayList<>();
        getTreeInOrder(tree, list);
        return list;

    }

    private void getTreeInOrder(BinaryTree<T> tree, ArrayList<T> list) {
        if (!tree.isEmpty()) {
            getTreeInOrder(tree.getLeft(), list);
            list.add(tree.getRoot());
            getTreeInOrder(tree.getRight(), list);
        }
    }

    /**
     * Returns a list with the elements of the binary tree in post order.
     * @param tree
     * @return
     */
    public ArrayList<T> getTreePostOrder(BinaryTree<T> tree) {
        ArrayList<T> list = new ArrayList<>();
        getTreePostOrder(tree, list);
        return list;

    }

    private void getTreePostOrder(BinaryTree<T> tree, ArrayList<T> list) {
        if (!tree.isEmpty()) {
            getTreePostOrder(tree.getLeft(), list);
            getTreePostOrder(tree.getRight(), list);
            list.add(tree.getRoot());
        }
    }

    /**
     * Returns a list with the elements of the binary tree in level order.
     * @param tree
     * @return
     */
    public ArrayList<T> getTreeLevelOrder(BinaryTree<T> tree) {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 1; i <= height(tree); i++) {
            addElementsOfLevelToList(tree, i, list);
        }
        return list;
    }

    private void addElementsOfLevelToList(BinaryTree<T> tree, int level, ArrayList<T> list) {
        if(tree.isEmpty()){
            return;
        }
        else if (level == 1)
            list.add(tree.getRoot());
        else if (level > 1) {
            addElementsOfLevelToList(tree.getLeft(), level - 1, list);
            addElementsOfLevelToList(tree.getRight(), level - 1, list);
        }
    }


    /**
     * Given a binary tree, it creates a text file and stores its value and structure
     * so that is can be retrieved later on.
     * null values are represented with a 'n'.
     * @param tree
     * @param fileName
     */
    public void storeTreeInFile(BinaryTree<T> tree, String fileName){
        String content = "";
        ArrayList<T> treeInLevelOrder = getTreeLevelOrderWithNulls(tree);
        for(int i = 0; i < treeInLevelOrder.size(); i++){
            if(treeInLevelOrder.get(i) == null){
                content+="n";
            }
            else {
                content+= treeInLevelOrder.get(i);
            }

            if(i < treeInLevelOrder.size() -1){
                content += "/";
            }
        }
        fileManager.writeStringToTxtFile(content, fileName);

    }

    private ArrayList<T> getTreeLevelOrderWithNulls(BinaryTree<T> tree) {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 1; i <= height(tree); i++) {
            addElementsOfLevelToListWithNulls(tree, i, list);
        }
        return list;
    }

    private void addElementsOfLevelToListWithNulls(BinaryTree<T> tree, int level, ArrayList<T> list) {
        if(tree.isEmpty()){
            list.add(null);
        }
        else if (level == 1)
            list.add(tree.getRoot());
        else if (level > 1) {
            addElementsOfLevelToListWithNulls(tree.getLeft(), level - 1, list);
            addElementsOfLevelToListWithNulls(tree.getRight(), level - 1, list);
        }
    }

    /**
     * Given a file name, it will look at the content of the file and generate
     * the corresponding binary tree that is stored.
     * @param fileName
     * @return
     */
    public BinaryTree<Integer> generateTreeFromFile(String fileName){
        String content = fileManager.getStringFromFile(fileName);
        String[] array = content.split("/");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if(array[i].equals("n")){
                list.add(null);
            }
            else {
                int number = Integer.parseInt(array[i]);
                list.add(number);
            }
        }
        BinaryTree<Integer> tree = generateTreeFromlist(list);
        return tree;
    }
    /**
     * Takes a list that represents a binary tree stored in level order, with nulls
     * representing empty nodes.
     * It returns the binaryTree stored in the given list.
     * @param input
     * @return
     */
    private BinaryTree<Integer> generateTreeFromlist(ArrayList<Integer> input){
        LinkedBinaryTree<Integer> root = createTree(input,1);
        return root;
    }

    private LinkedBinaryTree<Integer> createTree(ArrayList<Integer> input, int index){
        if(index<=input.size()){
            Integer value = input.get(index -1);
            if(value!=null){

                LinkedBinaryTree<Integer> leftTree = createTree(input, index*2);
                LinkedBinaryTree<Integer> rightTree = createTree(input, index*2+1);
                LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>(value, leftTree, rightTree);
                return t;
            }
        }
        return null;
    }

}




