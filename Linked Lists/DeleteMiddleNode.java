import sun.awt.image.ImageWatched;

import java.util.Scanner;

/**
 * Created by dinu on 12/25/16.
 */
public class DeleteMiddleNode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        Node n = new Node();

        //Create the Linked List
        // to simulate the scenario we take linked lists more than size 4
        // 3 is the node to delete
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {
            if (linkedList.head == null) {
                linkedList.head = new Node();
                linkedList.head.data = sc.nextInt();
            } else {
                Node current = linkedList.head;
                while (current.next != null) {
                    current = current.next;
                }
                if(i==2){
                    current.next = n;
                }else{
                    current.next = new Node();
                }

                current.next.data = sc.nextInt();
            }
        }
        printLinkedList(linkedList);
        deleteMiddleNode(n,linkedList);
        printLinkedList(linkedList);



    }

    private static void printLinkedList(LinkedList linkedList) {
        Node node = linkedList.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }

    /**
     * Since we do have only access to that node we can't delete it
     * But we can copy the data in the next node to this and delete next
     * @param n
     * @param linkedList
     */
    private static void deleteMiddleNode(Node n, LinkedList linkedList){
        Node current = n.next;
        n.data = n.next.data;
        n.next = n.next.next;
    }
}
