package Chess.Pieces;

import Chess.Pieces.PiecesMovement.PieceMovement;

public class King extends Piece {

    public King(String idIN, String n, boolean c, int rIN, int cIN) {
        super(idIN, n, c, rIN, cIN);
    }

    @Override
    boolean chooseBehavior(int rowTo, int colTo) {
        if (Math.abs(this.row - rowTo) == 1 || Math.abs(this.col - colTo) == 1)
            if (this.testDiagonal(rowTo, colTo) || this.testStraight(rowTo, colTo)) {
                this.setMovementBehaviour(new PieceMovement());
                return true;
            }
        return false;
    }
}