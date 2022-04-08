import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.time.Duration;
import java.time.Instant;

public class twoQueue {

    public static void reverse(Queue<Integer> initQueue){
        /**
         * In order to reverse the Queue into a stack, you need to make a temporary/empty stack
         * Then, reverse the queue order by popping the elements from the stack and put the elements into the queue into the stack
         * Push the elements back into the Queue & print elements in the queue
         */
        Stack<Integer> temp = new Stack<>(); //creates a temporary stack

        //pushes element from queue to stack
        while(!initQueue.isEmpty()){
            temp.push(initQueue.poll());
        }

        //pop elements from stack to Queue
        while(!temp.isEmpty())
        {
            initQueue.add(temp.pop());
        }

        //print values from queue
        for(Integer value2: initQueue) {
            System.out.print(value2 + " -> ");
        }
        System.out.print("nil");


    }

    public static void main(String[] args){
        int time = 0;
        Queue<Integer> queue1 = new LinkedList<>();
        final Duration timeElapsed;
        Instant start = Instant.now();  // time capture -- start
        for (int i = 0; i < 100; i++) {
            queue1.add(i);
        }

        System.out.println("Initial Queue: "+ queue1);

        System.out.print("Reverse Queue: ");

        reverse(queue1);
        Instant end = Instant.now();    // time capture -- end
        timeElapsed = Duration.between(start, end);
        System.out.println();
        System.out.println("Nanoseconds: " + timeElapsed.getNano());
        time += timeElapsed.getNano();
        System.out.println("Total Nanoseconds: " + time );
        System.out.println("Total Seconds: " + time /1000000000.0);
    }
}