package Chess.Pieces.PiecesMovement;

import Chess.Pieces.Piece;

public class PieceMovement implements MovementBehaviour {

    private int targetRow, targetCol;

    @Override
    public boolean move(int rowTo, int colTo, Piece[][] status, Piece p) {
        targetRow = rowTo;
        targetCol = colTo;
        int checkRow = p.compareRow(rowTo);
        int checkCol = p.compareCol(colTo);
        while (!(p.getRow() == rowTo && p.getCol() == colTo)) {
            if (testSquare(rowTo, colTo, status)) {
                rowTo = rowTo + checkRow;
                colTo = colTo + checkCol;
            } else {
                return false;
            }
        }
        return true;
    }

    private boolean testSquare(int row, int col, Piece[][] status) {
        return row == targetRow && col == targetCol || status[row][col] == null;
    }
}
