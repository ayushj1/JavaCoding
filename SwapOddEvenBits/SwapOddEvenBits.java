public class SwapOddEvenBits {
    public static void main(String[] args) {
        int a = 33; //100001
        /*
        ip 33 100001
        op 18 010010
        op = num1 | num2
        num 1 = (100001 & 101010) >> 1 = (100000) >> 1 = 010000
        num 2 = (100001 & 010101) << 1 = (000001) << 1 = 000010
        op = 010000 | 000010 = 010010
        */
        int oneZeroBits = 0;
        int zeroOneBits = 0;
        for(int i=15; i>=0; i--) {
            if(i%2 == 0) {
                zeroOneBits = zeroOneBits | (int) Math.pow(2, i);
            } else {
                oneZeroBits = oneZeroBits | (int) Math.pow(2, i);
            }
        }

        int finalOddBits = (a & oneZeroBits) >> 1;
        int finalEvenBits = (a & zeroOneBits) << 1;
        int finalAnswer = finalOddBits | finalEvenBits;
        System.out.println(finalAnswer);
    }
}