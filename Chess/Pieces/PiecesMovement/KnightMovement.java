package Chess.Pieces.PiecesMovement;

import Chess.Pieces.Piece;
import javafx.util.Pair;
import java.util.ArrayList;

public class KnightMovement implements MovementBehaviour {

    private ArrayList<Pair<Integer, Integer>> posMoves = new ArrayList<>();

    @Override
    public boolean move(int rowTo, int colTo, Piece[][] status, Piece p) {
        Pair<Integer, Integer> move = new Pair<>(rowTo, colTo);
        posMoves = setMoves(p);
        for (Pair pM : posMoves)
            if (pM.equals(move)) {
                return true;
            }
        return false;
    }

    private ArrayList<Pair<Integer, Integer>> setMoves(Piece p) {
        posMoves.add(new Pair<>(p.getRow() + 1, p.getCol() + 2));
        posMoves.add(new Pair<>(p.getRow() + 2, p.getCol() + 1));
        posMoves.add(new Pair<>(p.getRow() + 2, p.getCol() - 1));
        posMoves.add(new Pair<>(p.getRow() + 1, p.getCol() - 2));
        posMoves.add(new Pair<>(p.getRow() - 1, p.getCol() - 2));
        posMoves.add(new Pair<>(p.getRow() - 2, p.getCol() - 1));
        posMoves.add(new Pair<>(p.getRow() - 2, p.getCol() + 1));
        posMoves.add(new Pair<>(p.getRow() - 1, p.getCol() + 2));
        return posMoves;
    }
}
