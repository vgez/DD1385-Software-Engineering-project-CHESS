package Chess.Pieces;

import Chess.Pieces.PiecesMovement.KnightMovement;

public class Knight extends Piece {

    public Knight(String idIN, String n, boolean c, int rIN, int cIN) {
        super(idIN, n, c, rIN, cIN);
    }

    @Override
    boolean chooseBehavior(int rowTo, int colTo) {
        setMovementBehaviour(new KnightMovement());
        return true;
    }
}
