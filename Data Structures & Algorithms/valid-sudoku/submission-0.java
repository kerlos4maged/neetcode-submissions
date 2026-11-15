class Solution {
    public boolean isValidSudoku(char[][] board) {
        // we have three phases

        // validate rows
        for (int row = 0; row < 9; row++) {
            HashSet seen = new HashSet<>();
            for (int columns = 0; columns < 9; columns++) {
                if (seen.contains(board[row][columns])) {
                    return false;
                } else if (board[row][columns] != '.') {
                    seen.add(board[row][columns]);
                }
            }
        }

        // validate columns
        for (int row = 0; row < 9; row++) {
            HashSet seen = new HashSet<>();
            for (int columns = 0; columns < 9; columns++) {
                if (seen.contains(board[columns][row])) {
                    return false;
                } else if (board[columns][row] != '.') {
                    seen.add(board[columns][row]);
                }
            }
        }

        // validate box

        /**
         * [
         * [0,0],[0,3],[0,6],
         * [3,0],[3,3],[3,6],
         * [6,0],[6,3],[6,6],
         * ]
         */

        for (int row = 0; row < 9; row = row + 3) {
            for (int column = 0; column < 9; column = column + 3) {
                HashSet seen = new HashSet<>();
                for (int j = 0; j < 3; j++) {
                    for (int i = 0; i < 3; i++) {
                        if (board[row + j][column + i] != '.') {
                            if (seen.contains(board[row + j][column + i])) {
                                return false;
                            } else {
                                seen.add(board[row + j][column + i]);
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

}
