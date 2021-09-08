package Chess.Model;

public interface Boardgame {
    //returns true if move is OK, else false
    boolean move(int rowFrom, int colFrom, int rowTo, int colTo);

    //returns content on square (row, col)
    String getStatus(int row, int col);

    //returns true if selected square holds current players content
    boolean matchTurn(int row, int col);

    //returns info (if move is OK, removed pieces,...)
    String getMessage();
}
