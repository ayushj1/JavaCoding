import java.util.*;

public class FirstNRStream {
    final static int MAX_SIZE = 256;
    public static void findFirstNonRepeating() {
        List<Character> inDLL = new ArrayList<Character>();
        boolean[] repeated = new boolean[MAX_SIZE];
        String stream = "aarjukaushalayushjainshubhajainrahulpanditaayrapandit";
        for(int i=0; i<stream.length(); i++) {
            char x = stream.charAt(i);
            System.out.println("Read character ---> " + x + " <--- from stream");
            if(!repeated[x]) {
                if(!inDLL.contains(x))
                    inDLL.add(x);
                else {
                    inDLL.remove((Character)x);
                    repeated[x] = true; 
                }
            }
            if(inDLL.size() != 0) {
                System.out.println("Current First Non Repeating Character is ---> " + inDLL.get(0) + " <---");
            }
        }
    }

    public static void main(String[] args) {
        try {
            findFirstNonRepeating();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}