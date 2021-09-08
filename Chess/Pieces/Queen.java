package Chess.Pieces;

import Chess.Pieces.PiecesMovement.PieceMovement;

public class Queen extends Piece {

    public Queen(String idIN, String n, boolean c, int rIN, int cIN) {
        super(idIN, n, c, rIN, cIN);
    }

    @Override
    boolean chooseBehavior(int rowTo, int colTo) {
        if (this.testDiagonal(rowTo, colTo) || this.testStraight(rowTo, colTo)) {
            this.setMovementBehaviour(new PieceMovement());
            return true;
        }
        return false;
    }
}