package main.queues.priorityQueue;

/**
 * @author Marcos Khabie
 * @author Agustin Bettati
 * @version 1.0
 *
 * Class that is used to test the functioning of priority queue.
 */
public class PriorityQueueTest {


    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.enqueue("Low fever", 3);
        priorityQueue.enqueue("Surgery", 1);
        priorityQueue.enqueue("High fever", 2);
        priorityQueue.enqueue("Transplant", 1);

        for(int i = 0; i<3;i++){
            System.out.println(priorityQueue.dequeue());
        }
        System.out.println();
        System.out.println("New patiente added: heart attack (priority 1)");
        System.out.println();

        priorityQueue.enqueue("Heart attack", 1);

        int size = priorityQueue.size();
        for(int i =0; i < size; i++){
            System.out.println(priorityQueue.dequeue());
        }
    }
}
