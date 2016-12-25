import java.util.Scanner;

/**
 * Created by dinu on 12/25/16.
 */
public class ReturnKthToLast {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int size = sc.nextInt();

        //Create the Linked List
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
        if(linkedList.head != null || size < k){
            System.out.println(returnElement(k,linkedList));
        }

    }


    /**
     * two pointers
     * O(N)
     * @param k
     * @param linkedList
     * @return
     */
    private static int returnElement(int k, LinkedList linkedList) {
        Node current = linkedList.head;
        for (int i = 1; i < k; i++) {
            current = current.next;
        }
        Node knode = linkedList.head;
        while(current.next!=null){
            current=current.next;
            knode = knode.next;
        }
        return knode.data;
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


