import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<String> tags = new HashSet<>();

        tags.add("java");
        tags.add("data");
        tags.add("java");

        System.out.println("Contains data: " + tags.contains("data"));
        System.out.println("Size: " + tags.size());
        System.out.println("All tags: " + tags);
    }
}
