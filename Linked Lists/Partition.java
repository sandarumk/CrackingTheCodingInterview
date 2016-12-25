import java.util.Scanner;

/**
 * Partition the linked list around a given value
 * Created by dinu on 12/25/16.
 */
public class Partition {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int partitionElement = sc.nextInt();
        int size = sc.nextInt();

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
                current.next = new Node();
                current.next.data = sc.nextInt();
            }
        }
        printLinkedList(linkedList);
        linkedList=partition(linkedList,partitionElement);
        printLinkedList(linkedList);

    }

    /**
     * Create another linked list for the elements larger and equal
     * Iterate through the current list deleting the larger elements
     * Putting them into the second linked list
     * O(N)
     * @param linkedList
     * @param partitionElement
     * @return
     */
    private static LinkedList partition(LinkedList linkedList, int partitionElement) {
        if(linkedList.head == null){
            return null;
        }else if (linkedList.head.next == null){
            return linkedList;
        }
        Node current = linkedList.head;
        Node partitionHead = null;
        Node partitionCurrent = partitionHead;
        while (current.next!=null){
            if(current.next.data >= partitionElement){
                if(partitionHead == null){
                    partitionHead = new Node();
                    partitionHead.data = current.next.data;
                    partitionCurrent = partitionHead;
                }else{
                    Node newNode = new Node();
                    newNode.data = current.next.data;
                    partitionCurrent.next = newNode;
                    partitionCurrent=partitionCurrent.next;
                }
                current.next = current.next.next;
            }else{
                current= current.next;
            }
        }
        current.next = partitionHead;
        return linkedList;

    }

    private static void printLinkedList(LinkedList linkedList) {
        Node node = linkedList.head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("");
    }
}
