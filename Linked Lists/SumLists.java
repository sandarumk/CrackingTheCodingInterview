import sun.awt.image.ImageWatched;

import java.util.Scanner;

/**
 * Given two numbers represented by a linked list in reverse order
 * Sume them up
 * Give the result as a linked list
 * Created by dinu on 12/25/16.
 */
public class SumLists {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int firstsize = sc.nextInt();

        LinkedList firstlinkedList = new LinkedList();
        for (int i = 0; i < firstsize; i++) {
            if (firstlinkedList.head == null) {
                firstlinkedList.head = new Node();
                firstlinkedList.head.data = sc.nextInt();
            } else {
                Node current = firstlinkedList.head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node();
                current.next.data = sc.nextInt();
            }
        }
        printLinkedList(firstlinkedList);

        int secondtsize = sc.nextInt();

        LinkedList secondLinkedList = new LinkedList();
        for (int i = 0; i < secondtsize; i++) {
            if (secondLinkedList.head == null) {
                secondLinkedList.head = new Node();
                secondLinkedList.head.data = sc.nextInt();
            } else {
                Node current = secondLinkedList.head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = new Node();
                current.next.data = sc.nextInt();
            }
        }
        printLinkedList(secondLinkedList);

        LinkedList sumList = sumTwoLinkedLists(firstlinkedList,secondLinkedList);


        printLinkedList(sumList);

    }


    /**
     * This method is brute force
     * You can directly sum straight from the linked list
     * @param firstlinkedList
     * @param secondLinkedList
     * @return
     */
    private static LinkedList sumTwoLinkedLists(LinkedList firstlinkedList, LinkedList secondLinkedList) {
        int a = getNumericalValue(firstlinkedList);
        int b = getNumericalValue(secondLinkedList);
        int sum = a+b;
        LinkedList sumlist = convertToLinkedList(sum);
        return sumlist;
    }

    private static LinkedList convertToLinkedList(int sum) {
        int count = 1;
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node();
        Node current = linkedList.head;
        while(current!=null){
            current.data = sum % 10;
            sum = sum/10;
            count++;
            if(sum > 0){
                Node node = new Node();
                current.next = node;
                current = current.next;
            }else{
                break;
            }

        }
        return linkedList;
    }

    private static int getNumericalValue(LinkedList linkedList) {
        int count = 0;
        int value = 0;
        if(linkedList.head==null){
            return 0;
        }

        Node current = linkedList.head;
        while(current!=null){
            value += current.data * (int) Math.pow(10,count);
            count++;
            if(current.next == null){
                break;
            }
            current = current.next;
        }
        return value;
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
