package ejercicio2;

public class SudokuSolver {
    private int[][] board;

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num == 0 ? "." : num);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private boolean findEmptyLocation(int[] location) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    location[0] = row;
                    location[1] = col;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean usedInRow(int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInCol(int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean usedInBox(int boxStartRow, int boxStartCol, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxStartRow + i][boxStartCol + j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLocationIsSafe(int row, int col, int num) {
        return !usedInRow(row, num) &&
                !usedInCol(col, num) &&
                !usedInBox(row - row % 3, col - col % 3, num);
    }

    public boolean solve() {
        int[] location = new int[2];
        if (!findEmptyLocation(location)) {
            return true;
        }
        int row = location[0];
        int col = location[1];

        for (int num = 1; num <= 9; num++) {
            if (checkLocationIsSafe(row, col, num)) {
                board[row][col] = num;
                if (solve()) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }
}
