public class BitSwitchRequired {
    public static void main(String[] args) {
        int a = 29;
        int b = 15;

        int count = 0;

        for(int c = a^b; c!=0; c = c>>1){
            count += c&1;
        }
        System.out.println("" + count);
    }
}