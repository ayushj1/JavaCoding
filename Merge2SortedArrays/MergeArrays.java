public class MergeArrays {
    public static void main(String[] args) {
        int[] a = new int[8];
        int[] b = new int[3];

        a[0] = 1;
        a[1] = 3;
        a[2] = 5;
        a[3] = 7;
        a[4] = 9;
        b[0] = 4;
        b[1] = 6;
        b[2] = 8;

        int finalLength = a.length-1;
        int lasta = 0;
        int lastb = b.length-1;
        for(int i=0; i<finalLength;i++) {
            if(a[i] == 0) {
                lasta = i-1;
                break;
            }
        }

        int i,j;

        for(i=lasta, j=lastb; (i>=0 && j>=0);) {
            if(a[i] > b[j]){
                a[finalLength--] = a[i];
                i--;
            } else {
                a[finalLength--] = b[j];
                j--;
            }
        }

        while(j>=0) {
            a[finalLength--] = b[j--];
        }
        for(i=0; i<a.length; i++) {
            System.out.println("" + a[i] + " ");
        }
    }
}