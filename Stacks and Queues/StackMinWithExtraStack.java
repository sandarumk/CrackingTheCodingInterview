import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Find the stack min with O(1) time
 * Use a separate stack of stack mins
 * Do not have to store the stack min at each node
 * Created by dinu on 12/26/16.
 */
public class StackMinWithExtraStack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfItems = sc.nextInt();
        StackWithMinStack stack = new StackWithMinStack();
        for (int i = 0; i < numberOfItems ; i++) {
            stack.push(sc.nextInt());
        }
        System.out.println(stack.minStack.peek());

    }

}

class StackWithMinStack extends StackOriginal{
    StackOriginal minStack;

    StackWithMinStack(){
        minStack = new StackOriginal();
    }

    @Override
    void push(int data){
        if(minStack.isEmpty()){
            minStack.push(data);
        }else{
            if(minStack.peek() >= data ){
                minStack.push(data);
            }
        }
        super.push(data);
    }

    @Override
    int pop() {
        if(top == null && minStack.top == null){
            throw new EmptyStackException();
        }
        if(peek() == minStack.peek()){
            minStack.pop();
        }
        return super.pop();

    }
}


class StackOriginal {
    OriginalStackNode top;

    void push(int data){
        OriginalStackNode item = new OriginalStackNode(data);
        if(isEmpty()){
            top =item;
        }else{
            item.next = top;
            top = item;
        }

    }

    int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }else{
            OriginalStackNode node = top;
            top = top.next;
            return node.data;
        }
    }

    int peek(){
        if(top !=null){
            return top.data;
        }else{
            return Integer.MAX_VALUE;
        }
    }

    boolean isEmpty(){
        return (top == null);
    }


}

class OriginalStackNode{
    int data;
    OriginalStackNode next;

    OriginalStackNode(int data){
        this.data=data;
    }

}
