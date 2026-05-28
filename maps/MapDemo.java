import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();

        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Cara", 95);

        System.out.println("Bob score: " + scores.get("Bob"));
        System.out.println("Contains Alice: " + scores.containsKey("Alice"));
        System.out.println("Size: " + scores.size());
        System.out.println("All entries: " + scores);
    }
}
