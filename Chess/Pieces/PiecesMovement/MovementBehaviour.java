package Chess.Pieces.PiecesMovement;

import Chess.Pieces.Piece;

public interface MovementBehaviour {

    boolean move(int rowTo, int colTo, Piece[][] status, Piece p);

}
