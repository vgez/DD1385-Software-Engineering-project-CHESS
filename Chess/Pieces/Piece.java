package Chess.Pieces;

import Chess.Pieces.PiecesMovement.MovementBehaviour;

public abstract class Piece {

    int row, col;
    private MovementBehaviour movementBehaviour;
    Piece[][] status;
    private final String id;
    private final String name;
    final boolean isWhite;

    Piece(String idIN, String n, boolean c, int rIN, int cIN) {
        this.id = idIN;
        this.name = n;
        this.isWhite = c;
        this.row = rIN;
        this.col = cIN;
    }

    //calls the move method in corresponding movementBehavior
    public boolean move(int rowTo, int colTo, Piece[][] status, Piece p) {
        this.status = status;
        return chooseBehavior(rowTo, colTo) && movementBehaviour.move(rowTo, colTo, status, p);
    }

    //sets movementBehavior (diagonal/straight/knight)
    void setMovementBehaviour(MovementBehaviour movementBehaviour) {
        this.movementBehaviour = movementBehaviour;
    }

    //decides which movementBehavior to choose
    abstract boolean chooseBehavior(int rowTo, int colTo);

    //return this.row
    public int getRow() {
        return this.row;
    }

    //return this.col
    public int getCol() {
        return this.col;
    }

    //sets this.row to rIN
    public void setRow(int rIN) {
        this.row = rIN;
    }

    //sets this.col to cIN
    public void setCol(int cIN) {
        this.col = cIN;
    }

    //returns piece id, example white king ("WK")
    public String getPiece() {
        return this.id;
    }

    //returns piece name, example "whiteKing"
    public String getName() {
        return this.name;
    }

    //returns true if piece is white
    public boolean isWhite() {
        return this.isWhite;
    }

    /**
     * following are methods that check if movement
     * is valid for selected piece
     **/

    //returns true if move is diagonal
    boolean testDiagonal(int rowTo, int colTo) {
        return (Math.abs(this.row - this.col) == Math.abs(rowTo - colTo)) || (Math.abs(this.row - rowTo) == Math.abs(this.col - colTo));
    }

    //returns true if move is straight
    boolean testStraight(int rowTo, int colTo) {
        return this.row == rowTo || this.col == colTo;
    }

    //returns 1 if start row > target row, else -1, if equal returns 0
    public int compareRow(int row) {
        if (this.row == row) return 0;
        return this.row > row ? 1 : -1;
    }

    //returns 1 if start col > target col, else -1, if equal returns 0
    public int compareCol(int col) {
        if (this.col == col) return 0;
        return this.col > col ? 1 : -1;
    }
}
