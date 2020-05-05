import java.util.Scanner;

public class StringDuplicate {
    public boolean hasDuplicate(String str) {
        boolean[] charArr = new boolean[256];
        for(int i=0; i<str.length(); i++) {
            int val = str.charAt(i);
            if(charArr[val]) {
                return true;
            }
            charArr[val] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        StringDuplicate sd = new StringDuplicate();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String inpString = scanner.nextLine();
            System.out.println(sd.hasDuplicate(inpString));
        }
    }
}