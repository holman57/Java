public class candy_crush {
//    If three or more candies of the same type are adjacent vertically or horizontally, crush them all at
//    the same time - these positions become empty.

//    After crushing all candies simultaneously, if an empty space on the board has candies on top of itself,
//    then these candies will drop until they hit a candy or bottom at the same time. No new candies will drop
//    outside the top boundary.

//    After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the
//    above steps.

//    If there does not exist more candies that can be crushed (i.e., the board is stable), then return the
//    current board.
    int m, n;
    public boolean findAndCrush(int[][] board) {
        boolean complete = true;
        for (int r = 1; r < m - 1; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 0) continue;
                if (Math.abs(board[r][c]) == Math.abs(board[r - 1][c]) && Math.abs(board[r][c]) == Math.abs(board[r + 1][c])) {
                    board[r][c] = -Math.abs(board[r][c]);
                    board[r - 1][c] = -Math.abs(board[r - 1][c]);
                    board[r + 1][c] = -Math.abs(board[r + 1][c]);
                    complete = false;
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 1; c < n - 1; c++) {
                if (board[r][c] == 0) continue;
                if (Math.abs(board[r][c]) == Math.abs(board[r][c - 1]) && Math.abs(board[r][c]) == Math.abs(board[r][c + 1])) {
                    board[r][c] = -Math.abs(board[r][c]);
                    board[r][c - 1] = -Math.abs(board[r][c - 1]);
                    board[r][c + 1] = -Math.abs(board[r][c + 1]);
                    complete = false;
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] < 0) board[r][c] = 0;
            }
        }
        return complete;
    }

    public void drop (int[][] board) {
        for (int c = 0; c < n; c++) {
            int lowestZero = -1;
            for (int r = m - 1; r >= 0; r--) {
                if (board[r][c] == 0) {
                    lowestZero = Math.max(lowestZero, r);
                } else if (lowestZero >= 0) {
                    int temp = board[r][c];
                    board[r][c] = board[lowestZero][c];
                    board[lowestZero][c] = temp;
                    lowestZero--;
                }
            }
        }
    }

    public int[][] candyCrush(int[][] board) {
        m = board.length;
        n = board[0].length;
        while (!findAndCrush(board)) drop(board);
        return board;
    }
}
