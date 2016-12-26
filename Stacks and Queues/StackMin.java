import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Find the stack min in constant time
 * Store the stack min at every stack node
 * Created by dinu on 12/26/16.
 */
public class StackMin {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfItems = sc.nextInt();
        Stack stack = new Stack();
        for (int i = 0; i < numberOfItems ; i++) {
            stack.push(sc.nextInt());
        }
        System.out.println(stack.getMin());

    }

}

class Stack {
    StackNode top;

    void push(int data){
        StackNode item = new StackNode(data);
        if(isEmpty()){
            item.stackMin=item.data;
        }else{
            if(peek().stackMin<= item.data){
                item.stackMin = peek().stackMin;
            }else{
                item.stackMin=item.data;
            }
        }
        item.next = top;
        top = item;


    }

    int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            StackNode node = top;
            top = top.next;
            return node.data;
        }
    }

    StackNode peek(){
        if(top !=null){
            return top;
        }else{
            return null;
        }
    }

    boolean isEmpty(){
        return (top == null);
    }

    int getMin(){
        return top.stackMin;
    }
}

class StackNode{
    int data;
    StackNode next;
    int stackMin;

    StackNode(int data){
        this.data=data;
    }
}
