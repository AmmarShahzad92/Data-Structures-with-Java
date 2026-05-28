import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.remove());
        System.out.println("Size: " + queue.size());
        System.out.println("Empty: " + queue.isEmpty());
    }
}
