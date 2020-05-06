public class MergeNMBits {
    public int clearBit(int num, int i) {
        int mask = ~(1<<i);
        return num & mask;
    }

    public static void main(String[] args) {
        MergeNMBits mnmb = new MergeNMBits();

        /*
        N = 10000000000 - 1024
        M = 10011 - 19
        i=2, j=6
        OP = 10001001100 - 1100
        Approach:
            1. Clear N Bits from j through i
            2. Shift bits in M so that they align with N's j to i
            3. Merge N and M
        */

        int N = 1024;
        int M = 19;
        int i = 2;
        int j = 6;

        // Step 1
        for(int k = i; k <= j; k++) {
            N = mnmb.clearBit(N, k);
        }

        // Step 2
        M <<= i;

        // Step 3
        N |= M;

        System.out.println(N);
    }
}