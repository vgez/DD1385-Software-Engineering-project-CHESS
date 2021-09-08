package Chess.Model;

import Chess.Pieces.Piece;

import java.util.ArrayList;

public abstract class InitPieces {

    InitPieces() {
    }

    static ArrayList<Piece> initWhite() {
        ArrayList<Piece> wPieces = new ArrayList<>();
        //white pieces initialize
        for (int i = 0; i < 8; i++) {
            wPieces.add(new Chess.Pieces.Pawn("WP", "Pawn nr" + (i + 1), true, 1, i, true));
        }
        Piece wKing = new Chess.Pieces.King("WKING", "King", true, 0, 3);
        Piece wQueen = new Chess.Pieces.Queen("WQ", "Queen", true, 0, 4);
        Piece wBish1 = new Chess.Pieces.Bishop("WB", "Bishop nr1", true, 0, 2);
        Piece wBish2 = new Chess.Pieces.Bishop("WB", "Bishop nr2", true, 0, 5);
        Piece wKnight1 = new Chess.Pieces.Knight("WK", "Knight nr1", true, 0, 1);
        Piece wKnight2 = new Chess.Pieces.Knight("WK", "Knight nr2", true, 0, 6);
        Piece wRook1 = new Chess.Pieces.Rook("WR", "Rook nr1", true, 0, 0);
        Piece wRook2 = new Chess.Pieces.Rook("WR", "Rook nr2", true, 0, 7);
        wPieces.add(wKing);
        wPieces.add(wQueen);
        wPieces.add(wBish1);
        wPieces.add(wBish2);
        wPieces.add(wKnight1);
        wPieces.add(wKnight2);
        wPieces.add(wRook1);
        wPieces.add(wRook2);
        return wPieces;
    }

    static ArrayList<Piece> initBlack() {
        ArrayList<Piece> bPieces = new ArrayList<>();
        //black pieces initialize
        for (int i = 0; i < 8; i++) {
            bPieces.add(new Chess.Pieces.Pawn("BP", "Pawn nr" + (i + 1), false, 6, i, true));
        }
        Piece bKing = new Chess.Pieces.King("BKING", "King", false, 7, 3);
        Piece bQueen = new Chess.Pieces.Queen("BQ", "Queen", false, 7, 4);
        Piece bBish1 = new Chess.Pieces.Bishop("BB", "Bishop nr1", false, 7, 2);
        Piece bBish2 = new Chess.Pieces.Bishop("BB", "Bishop nr2", false, 7, 5);
        Piece bKnight1 = new Chess.Pieces.Knight("BK", "Knight nr1", false, 7, 1);
        Piece bKnight2 = new Chess.Pieces.Knight("BK", "Knight nr2", false, 7, 6);
        Piece bRook1 = new Chess.Pieces.Rook("BR", "Rook nr1", false, 7, 0);
        Piece bRook2 = new Chess.Pieces.Rook("BR", "Rook nr2", false, 7, 7);
        bPieces.add(bKing);
        bPieces.add(bQueen);
        bPieces.add(bBish1);
        bPieces.add(bBish2);
        bPieces.add(bKnight1);
        bPieces.add(bKnight2);
        bPieces.add(bRook1);
        bPieces.add(bRook2);
        return bPieces;
    }
}
