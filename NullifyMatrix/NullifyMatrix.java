public class NullifyMatrix {
    public void nullifyRow(int[][] matrix, int row) {
        for(int j=0; j<matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public void nullifyColumn(int[][] matrix, int column) {
        for(int i=0; i<matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public int[][] setZero(int[][] matrix){
        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        //check if first row has a zero
        for(int j=0; j<matrix[0].length; j++) {
            if(matrix[0][j] == 0){
                firstRowZero = true;
                break;
            }
        }

        //check if first column has a zero
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        //iterate rest matrix and set in zeroth row/column about zero existence in that row/column
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //set zero in rows whose first column has been marked zero
        for(int i=1; i<matrix.length; i++) {
            if(matrix[i][0] == 0){
                nullifyRow(matrix, i);
            }
        }

        //set zero in columns whose first row has been marked zero
        for(int j=0; j<matrix[0].length; j++) {
            if(matrix[0][j] == 0){
                nullifyColumn(matrix,j);
            }
        }

        //finally nullify first row and column if required
        if(firstRowZero) {
            nullifyRow(matrix, 0);
        }

        if(firstColumnZero) {
            nullifyColumn(matrix, 0);
        }

        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        System.out.println();
        for(int i=0; i<matrix.length; i++) {
            System.out.println();
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,0,4,5},
                        {2,0,4,3,1},
                        {3,5,4,3,1},
                        {0,8,6,4,3}};
        NullifyMatrix nm = new NullifyMatrix();
        nm.printMatrix(matrix);
        int[][] finalMatrix = nm.setZero(matrix);
        nm.printMatrix(finalMatrix);
    }
}