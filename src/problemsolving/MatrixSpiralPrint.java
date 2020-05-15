package problemsolving;

public class MatrixSpiralPrint {
    static int rlstarti =0;
    static int colst;
    static int lrrowstarti =0;
    static int rlcolendi =0;
    static int rlst=1;
    static int tbendi;
    public static void main(String[] args) {

        int [][] matrix = new int[][]{
                {1, 2,   3,  4, 17},
                {5, 6,   7,  8, 18},
                {9, 10, 11, 12, 19},
                {13,14, 15, 16, 20},
                {21,22, 23, 24, 25}  };
        // 1 2 3 4 17 18 19 20 16,15,14,13,9,5,6,7,8,12,11,10
        int m=4, n=3;

        rlstarti =m;
        colst=0;
        tbendi=m;
        printSpiral(matrix, m, n);


    }

    private static void printSpiral(int[][] matrix, int row, int col) {

        int uprowstart=row;
        //int uprowend = col;
        int downrowstart = col;
        //int downrowend =

        //recursion base case
        if(row==1 || col==1)
            return;

        /*if(lrrowstarti == rlcolendi) {
            //System.out.print(matrix[tbendi][tbendi]);
            return;
        }*/

        //left to right
        for (int uprowend = lrrowstarti; uprowend <= col ; uprowend++) {
            System.out.print(matrix[lrrowstarti][uprowend] + " ");
        }
        lrrowstarti++;
        //top to bottom
        for (int i = lrrowstarti; i < tbendi; i++) {
            System.out.print(matrix[i][col] + " ");
        }
        tbendi--;
        //right to left
        for (int i = col; i >= rlcolendi; i--) {
            System.out.print(matrix[rlstarti][i] + " ");
        }
        rlcolendi++;
        rlstarti--;
        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        //bottom to top
        for (int i = rlstarti; i >= rlst ; i--) {
            System.out.print(matrix[i][colst] + " ");
        }
        colst++;
        rlst++;

        printSpiral(matrix, row-1, col-1);
    }
}
