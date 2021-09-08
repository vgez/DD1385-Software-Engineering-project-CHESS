package Chess.View;

import javax.swing.*;
import java.awt.*;

class Square extends JButton {

    int row, col;
    private JLabel icon;

    Square(int iIN, int jIN) {
        row = iIN;
        col = jIN;
        if ((row + col) % 2 == 0) {
            this.setBackground(Color.lightGray);
        } else {
            this.setBackground(Color.white);
        }
        setOpaque(true);
        setBorderPainted(false);
    }

    void setIcon(String iconNm) {
        icon = new JLabel(new ImageIcon(this.getClass().getResource(iconNm + ".png")));
        this.add(icon);
    }

    void removeIcon() {
        if (icon != null) {
            this.remove(icon);
        }
    }

    void selectSquare() {
        this.setBorderPainted(true);
    }

    void deselectSquare() {
        this.setBorderPainted(false);
    }
}
