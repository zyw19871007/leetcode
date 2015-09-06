public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Sudoku sudoku = new Sudoku();
        sudoku.initBoard();
        sudoku.initDancingLinks();
        sudoku.solveSudoku();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku.getBoard()[i][j]);

            }
            System.out.println();
        }

    }
}
