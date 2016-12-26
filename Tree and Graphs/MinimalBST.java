/**
 * Create the minimum BST given the sorted string
 * Created by dinu on 12/26/16.
 */
public class MinimalBST {

    public static void main(String[] args){

        int[] sortedArray = new int[]{1,2,3};
        BSTNode root = CreateBSTFromSortedArray(sortedArray,0,2);
        System.out.println(root.value);
    }



    private static BSTNode CreateBSTFromSortedArray(int[] sortedArray, int start, int end) {
        if(start >= end){
            return null;
        }
        BSTNode parent = new BSTNode();
        int midIndex = (end - start )/2;
        parent.value = sortedArray[midIndex];
        parent.leftChild = CreateBSTFromSortedArray(sortedArray,start,midIndex-1);
        parent.rightChild = CreateBSTFromSortedArray(sortedArray,midIndex+1,end);
        return parent;
    }

}

class BST{
    BSTNode root;
}

class BSTNode{
    int value;
    BSTNode leftChild;
    BSTNode rightChild;
}