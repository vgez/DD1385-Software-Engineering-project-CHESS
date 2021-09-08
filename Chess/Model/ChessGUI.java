package Chess.Model;

import Chess.View.ViewControl;

public class ChessGUI {

    public static void main(String[] args) {
        new ViewControl(new ChessModel()).setVisible(true);
    }
}
