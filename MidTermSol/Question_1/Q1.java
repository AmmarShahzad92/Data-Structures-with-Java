package Question_1;
import java.util.*;

class Node {
    Node prev = null;
    Node next = null;
    String song;

    Node(String song) {
        this.song = song;}}



//function form sr# 1-4 
public class Q1 {
    static Scanner console = new Scanner(System.in);

    // Play a song by position
    public static void playSong(Node head) {
        System.out.print("Enter song number: ");
        int a = console.nextInt();
        int index = 1;
        Node temp = head;
        while (temp != null && index < a) {   //cpunt index
            temp = temp.next;
            index++;		}
        //play song 
        if (temp != null) {
            System.out.println("--playing < " + temp.song + " >");
        } else {                                                   //if number is larger than the index
            System.out.println("Invalid song number!");
        }}
    
    

    // Add a song at a specific position (1-based index)
    public static Node addSongAtPosition(Node head, String newSong, int position) {
        Node newNode = new Node(newSong);

        if (position <= 1 || head == null) {  //first position
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;	 }
            head = newNode;
            return head;    }

        Node temp = head; //any position except 1st
        int index = 1;
        while (temp.next != null && index < position - 1) {
            temp = temp.next;
            index++;
        }

        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    
    
    
    // Delete a song by name
    static Node deleteSong(Node head, String songName) {
        Node temp = head;

        while (temp != null) {
            if (temp.song.equalsIgnoreCase(songName)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next; // Deleting head
                    }
                
                if (temp.next != null) {
                    temp.next.prev = temp.prev; }
                
                System.out.println("Deleted: " + songName);
                return head;  }
            
            temp = temp.next;   }
        System.out.println("Song not found: " + songName);
        return head;    }

    
    
    // Printig song play list 
    public static void printPlaylist(Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            System.out.println(size + " " + temp.song);
            temp = temp.next;
        }}

    
    
    public static void main(String[] args) {
        Node n1 = new Node("Nightcore");
        Node head = n1;
        Node tail = n1;

        Node n2 = new Node("League of legends");
        n2.prev = tail;
        tail.next = n2;
        tail = n2;

        Node n3 = new Node("Alen Walker");
        n3.prev = tail;
        tail.next = n3;
        tail = n3;

        Node n4 = new Node("Coke Studio");
        n4.prev = tail;
        tail.next = n4;
        tail = n4;

        Node n5 = new Node("AMV");
        n5.prev = tail;
        tail.next = n5;
        tail = n5;

        printPlaylist(head);

        // Add at position
        head = addSongAtPosition(head, "K9", 3);
        System.out.println("\nAfter inserting at position 3:");
        printPlaylist(head);
        
        // Delete a song
        head = deleteSong(head, "League of legends");
        System.out.println("\nAfter deleting 'League of legends':");
        printPlaylist(head);

        // Play song
        playSong(head);
    }
}
