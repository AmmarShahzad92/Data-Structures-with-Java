package Question_2;

public class Q2 {
    public static void main(String[] args) {
        String[] Gmail = {"HI", "Party"};
        String[] Yahoo = {"Interview", "HI"
        		+ "", "Party"};
        int a = Gmail.length;
        int b = Yahoo.length;
        String[] GYmail = new String[a + b];
        int index = 0;

        // Add all Gmail elements
        for (int i = 0; i < a; i++) {
            GYmail[index] = Gmail[i];
            index++;
        }

        // Add Yahoo elements only when there is non duplication
        for (int i = 0; i < b; i++) {
            boolean found = false;
            for (int j = 0; j < a; j++) {
                if (Yahoo[i].equals(Gmail[j])) {
                    found = true;
                    break; 				}}
            
           if (!found) {
                GYmail[index] = Yahoo[i];
                index++;				}}

        
        
        // Print the result
        System.out.println("The GYmail are:");
        for (int i = 0; i < index; i++) {
            System.out.println(GYmail[i]);
        }
        
}}