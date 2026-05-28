import java.util.ArrayDeque;

public class Queues {
    public static void main(String[] args) {
        java.util.Queue<Integer> queue = new ArrayDeque<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.remove());
        System.out.println("Size: " + queue.size());
        System.out.println("Empty: " + queue.isEmpty());
    }
}
