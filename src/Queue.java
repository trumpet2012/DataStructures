import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by William Trent Holliday on 10/12/14.
 * Data Structures - Youming Li
 */
public class Queue<T> {
    private int count;

    private Node first;
    private Node rear;

    private class Node{
        private T content;
        private Node next;

        public String toString(){
            return content.toString();
        }
    }

    public Queue(){}

    /**
     * Method to add an object to the end of the queue.
     *
     * @param add the object to add to the queue
     * @return the Queue
     */
    public Queue enqueue(T add){
        System.out.println("*Begin enqueue method");
        System.out.println("*--Create temporary node to hold current value of rear node");
        Node current = this.rear;
        System.out.println("*--Create new node and store it in rear");
        rear = new Node();
        System.out.println("*--Add the content of the new rear node");
        rear.content=add;
        System.out.println("*--Check size of the queue");
        if( count == 0 ){
            System.out.println("*--Only one node in linked list so set first equal to last");
            first = rear;
        }else {
            System.out.println("*--Set the next for the old rear Node equal to the new rear Node");
            current.next = rear;
        }
        System.out.println("*--Increment the size of the queue");
        count++;
        return this;
    }

    /**
     * Method to remove the first object in the queue
     * @return the object removed from the queue
     */
    public T dequeue(){
        System.out.println("+Begin dequeue method");
        System.out.println("+--Checking count of queue. If 0 then thow an exception.");
        if(count == 0) throw new NoSuchElementException();
        System.out.println("+--Create new node to store the current first Node");
        Node removed = first;
        System.out.println("+--Set first Node equal to the second Node");
        first = first.next;
        System.out.println("+--Decrement the size of the queue");
        count--;
        System.out.println("+--Check count of queue. If 0 then set rear to null.");
        if ( count == 0)
            rear = null;

        return removed.content;
    }

    /**
     * Get the first Node in the queue
     * @return the first Node
     */
    public Node first(){
        return first;
    }

    /**
     * Get the size of the queue
     * @return number of elements in the queue
     */
    public int size(){
        return count;
    }

    /**
     * Outputs the contents of the queue into a readable string format
     * @return String representing the contents of the queue
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node tmp = first;
        while (tmp != null) {
            if(tmp.next != null)
                sb.append(tmp.content).append( ", ");
            else
                sb.append(tmp.content);
            tmp = tmp.next;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Queue<Integer> queue = new Queue<Integer>();
        Random random = new Random();
        // Loop to add 20 elements to the queue
        for(int i=0; i<20; i++){
            int randNum = random.nextInt(100000);
            queue.enqueue(randNum);
        }
        System.out.println(queue);

        // Queue to hold 10000 elements
        Queue<Integer> bigQueue = new Queue<Integer>();
        long startTime = System.currentTimeMillis();
        for(int i=0; i<10000; i++){
            bigQueue.enqueue(i);
        }
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("\nIt took " + endTime + "ms to create a queue of 10000 elements.");
    }

}
