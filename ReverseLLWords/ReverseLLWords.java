import java.util.*;

class Node {
    Character data;
    Node next;

    Node(Character data) {
        this.data = data;
    }
}

public class ReverseLLWords {
    public static Node reverseWordsHelper(Node head, Node prev) {
        if(head == null)
            return prev;

        Node cur = head;
        
        while(cur.next != null && cur.next.data != ' ')
            cur = cur.next;

        if(cur.next == null) { 
            cur.next = prev;
            return head;
        }

        Node space = cur.next;
        Node nextStart = cur.next.next;
        cur.next = prev;
        space.next = head;
        return reverseWordsHelper(nextStart, space);
    }

    public static Node reverseWords(Node head) {
        return reverseWordsHelper(head, null);
    }

    public static Node createLinkedListForSentence(String sentence) {
        if(sentence.length() == 0 || sentence == null)
            return null;

        Node sentHead = new Node(sentence.charAt(0));
        Node curNode = sentHead;
        for(int i=1; i<sentence.length(); i++) {
            curNode.next = new Node(sentence.charAt(i));
            curNode = curNode.next;
        }

        return sentHead;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print("->" + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Node head = createLinkedListForSentence("Bangalore is a city in the state of Karnataka");
            printLinkedList(head);
            Node reversedHead = reverseWords(head);
            printLinkedList(reversedHead);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}