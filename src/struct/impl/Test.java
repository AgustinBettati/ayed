package struct.impl;

/**
 * Created by agustin on 5/4/17.
 */
public class Test {

    public static void main(String[] args) {
        StaticQueue<Integer> queue = new StaticQueue<>(4);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);


        for (int i =0 ; i < 5; i++){
            System.out.println(queue.dequeue());
        }
        System.out.println();
        System.out.println(queue.size());
    }
}
