package Chess.Pieces;

import Chess.Pieces.PiecesMovement.PieceMovement;

public class Rook extends Piece {

    public Rook(String idIN, String n, boolean c, int rIN, int cIN) {
        super(idIN, n, c, rIN, cIN);
    }

    @Override
    boolean chooseBehavior(int rowTo, int colTo) {
        if (this.testStraight(rowTo, colTo)) {
            setMovementBehaviour(new PieceMovement());
            return true;
        }
        return false;
    }
}
