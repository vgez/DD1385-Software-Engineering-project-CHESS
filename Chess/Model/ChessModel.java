package Chess.Model;

import Chess.Pieces.Piece;

import java.util.ArrayList;

class ChessModel implements Boardgame {

    //holds position of pieces
    private Piece[][] status = new Piece[8][8];
    //white pieces
    private ArrayList<Piece> wPieces = InitPieces.initWhite();
    //black pieces
    private ArrayList<Piece> bPieces = InitPieces.initBlack();
    //pieces removed by draws
    private ArrayList<String> killWhite = new ArrayList<>();
    private ArrayList<String> killBlack = new ArrayList<>();
    //
    private boolean turnWhite = true;
    private String message = getPlayer();
    private final static String l = "ABCDEFGH";


    ChessModel() {
        placePiece(wPieces);
        placePiece(bPieces);
    }

    @Override
    public boolean move(int rowFrom, int colFrom, int rowTo, int colTo) {
        Piece p1 = status[rowFrom][colFrom];
        if (status[rowTo][colTo] != null) {
            Piece p2 = status[rowTo][colTo];
            if (p1.move(rowTo, colTo, status, p1)) {
                killPiece(p2);
                togTurn();
                setMessage(true, p1, rowTo, colTo);
                setStatus(rowTo, colTo, p1);
                return true;
            }
        } else if (p1.move(rowTo, colTo, status, p1)) {
            togTurn();
            setMessage(true, p1, rowTo, colTo);
            setStatus(rowTo, colTo, p1);
            return true;
        }
        setMessage(false, p1, rowTo, colTo);
        return false;
    }

    @Override
    //returns piece_id of selected square, else null
    public String getStatus(int row, int col) {
        return (status[row][col] != null) ? status[row][col].getPiece() : null;
    }

    @Override
    //returns true if selected piece corresponds with turnWhite
    public boolean matchTurn(int row, int col) {
        return turnWhite == status[row][col].isWhite();
    }

    @Override
    public String getMessage() {
        return message;
    }

    private void setMessage(boolean valid, Piece p, int rowTo, int colTo) {
        if (valid) {
            message = "<html>VALID DRAW: " + p.getName() + ", FROM: " + String.valueOf(l.charAt(p.getRow())) + "" + (p.getCol() + 1) + ", TO: " + String.valueOf(l.charAt(rowTo)) + "" + (colTo + 1);
            message += "<br><br>NEXT: " + getPlayer();
            printKilled();
            return;
        }
        message = "<html><font color=#FF0000>ILLEGAL DRAW: " + p.getName() + ", FROM: " + String.valueOf(l.charAt(p.getRow())) + "" + (p.getCol() + 1) + ", TO: " + String.valueOf(l.charAt(rowTo)) + "" + (colTo + 1) + "</font>";
        printKilled();
    }

    private void printKilled() {
        message += "<br><br>KILLED WHITE PIECES:";
        message += "<font color=#848484>";
        for (String s : killWhite) {
            message += " <br>" + s;
        }
        message += "</font><br><br>KILLED BLACK PIECES:";
        message += "<font color=#848484>";
        for (String s : killBlack) {
            message += " <br>" + s;
        }
        message += "</font></html>";
    }

    private String getPlayer() {
        return turnWhite ? "PLAYER WHITE" : "PLAYER BLACK";
    }

    //places pieces according to row/col
    private void placePiece(ArrayList<Piece> pieces) {
        for (Piece p : pieces) {
            int row = p.getRow();
            int col = p.getCol();
            status[row][col] = p;
        }
    }

    //updates status when correct move is made
    private void setStatus(int rowTo, int colTo, Piece p1) {
        status[p1.getRow()][p1.getCol()] = null;
        status[rowTo][colTo] = p1;
        p1.setRow(rowTo);
        p1.setCol(colTo);
    }

    private void killPiece(Piece p2) {
        status[p2.getRow()][p2.getCol()] = null;
        if (p2.isWhite()) {
            wPieces.remove(p2);
            killWhite.add(p2.getName());
        } else {
            bPieces.remove(p2);
            killBlack.add(p2.getName());
        }
    }

    //toggles turnWhite (black/white)
    private void togTurn() {
        turnWhite = !turnWhite;
    }


}

