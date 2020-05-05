import java.util.Scanner;

public class StringPermutation {
    public boolean checkIfAllZero(int[] charArr) {
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] != 0)
                return false;
        }
        return true;
    }

    public boolean arePermutations(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
            
        int[] charArr = new int[256];

        for(int i=0; i<str1.length(); i++) {
            int val = str1.charAt(i);
            charArr[val] = 1;
        }
        for(int i=0; i<str2.length(); i++) {
            int val = str2.charAt(i);
            charArr[val] -= 1;
        }
        return checkIfAllZero(charArr);
    }

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String inpString1 = scanner.nextLine();
            String inpString2 = scanner.nextLine();
            System.out.println(sp.arePermutations(inpString1, inpString2));
        }
    }
}