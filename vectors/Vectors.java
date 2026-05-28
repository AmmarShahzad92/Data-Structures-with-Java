import java.util.Vector;

public class Vectors {
    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();

        numbers.add(5);
        numbers.add(10);
        numbers.add(15);

        System.out.println("First: " + numbers.firstElement());
        System.out.println("Last: " + numbers.lastElement());
        System.out.println("Size: " + numbers.size());
        System.out.println("All numbers: " + numbers);
    }
}
