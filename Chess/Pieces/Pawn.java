package Chess.Pieces;

import Chess.Pieces.PiecesMovement.PieceMovement;

public class Pawn extends Piece {

    private boolean firstMove;

    public Pawn(String idIN, String n, boolean c, int rIN, int cIN, boolean fM) {
        super(idIN, n, c, rIN, cIN);
        firstMove = fM;
    }

    private void setMoved() {
        if (this.firstMove) {
            this.firstMove = false;
        }
    }

    @Override
    boolean chooseBehavior(int rowTo, int colTo) {
        //checks white pawn
        if (this.isWhite) {
            if ((((this.row - rowTo) == -1) && (this.col == colTo)) || (((this.row - rowTo) == -2) && (this.col == colTo) && (this.firstMove))) {
                if (status[rowTo][colTo] == null) {
                    setMovementBehaviour(new PieceMovement());
                } else return false;
            } else if ((((this.row - rowTo) == -1) && (Math.abs(this.col - colTo) == 1)) && status[rowTo][colTo] != null) {
                setMovementBehaviour(new PieceMovement());
            } else return false;
        }
        //checks black pawn
        if (!this.isWhite) {
            if ((((this.row - rowTo) == 1) && (this.col == colTo)) || (((this.row - rowTo) == 2) && (this.col == colTo) && (this.firstMove))) {
                if (status[rowTo][colTo] == null) {
                    setMovementBehaviour(new PieceMovement());
                } else return false;
            } else if ((((this.row - rowTo) == 1) && (Math.abs(this.col - colTo) == 1)) && status[rowTo][colTo] != null) {
                setMovementBehaviour(new PieceMovement());
            } else return false;

        }
        this.setMoved();
        return true;
    }
}
