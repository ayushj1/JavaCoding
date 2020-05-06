public class DPMatrix {
    public static void main(String[] args) {
        int x = 3;
        int y = 3;
        int[][] arr = new int[x][y];

        arr[0][0] = 0;
        for(int i=1; i<x; i++) {
            arr[i][0] = 1;
        }
        for(int j=1; j<y; j++) {
            arr[0][j] = 1;
        }

        for(int i=1; i<x; i++) {
            for(int j=1; j<y; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }

        System.out.println(arr[x-1][y-1]);
    }
}