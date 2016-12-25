import java.util.HashMap;
import java.util.Scanner;

/**
 * Remove duplicates from unsorted linked list
 * Created by dinu on 12/25/16.
 */
public class RemoveDups {

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        //Create the Linked List
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < size; i++) {
            if(linkedList.head == null){
                linkedList.head = new Node();
                linkedList.head.data = sc.nextInt();
            }else{
                Node current = linkedList.head;
                while(current.next !=null){
                    current=current.next;
                }
                current.next = new Node();
                current.next.data = sc.nextInt();
            }
        }

        printLinkedList(linkedList);
        linkedList= removeDuplicatestwoPointerBased(linkedList);
        printLinkedList(linkedList);
        linkedList = removeDuplicatesHashMapBased(linkedList);
        printLinkedList(linkedList);
    }

    /**
     * Add the elements to an hashmap and check from there
     * Additional space needed
     * Only one iteration
     * Eunning time complexity O(N)
     * @param linkedList
     * @return
     */
    private static LinkedList removeDuplicatesHashMapBased(LinkedList linkedList) {
        //iterate through the array add the elements to the hahmap
        HashMap<Integer,Integer> map = new HashMap<>();
        if(linkedList.head!=null){
            Node current = linkedList.head;
            map.put(current.data,1);
            while(current.next!=null){
                if(map.containsKey(current.next.data)){
                    if(current.next.next!=null){
                        current.next=current.next.next;
                    }else{
                        current.next=null;
                    }
                }else{
                    map.put(current.next.data,1);
                    current = current.next;
                }
            }
        }else{
            return null;
        }
        return linkedList;
    }

    /**
     * Keep two pointers
     * Current pointer iterates through the linked list
     * Checker iterate through the list checking for duplicates for the current
     * Complexity O(N^2)
     * @param linkedList
     * @return
     */
    private static LinkedList removeDuplicatestwoPointerBased(LinkedList linkedList) {
        Node current = linkedList.head;
            while(current.next!=null){
                Node checker = current;
                while(checker.next != null){
                    if(current.data == checker.next.data){
                        if(checker.next.next!=null){
                            checker.next = checker.next.next;
                        }else{
                            checker.next=null;
                            break;
                        }

                    }else{
                        checker=checker.next;
                    }

                }
                if(current.next!=null){
                    current=current.next;
                }

            }
        return linkedList;


    }

    private static void printLinkedList(LinkedList linkedList) {
        Node node= linkedList.head;
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println("");
    }
}

class Node{
    Node next;
    int data;
}

class LinkedList{
    Node head;

}

