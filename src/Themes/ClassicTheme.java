package Themes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClassicTheme extends Theme {
    public ClassicTheme(){
        backGroundColor = Color.WHITE;
        TileBorderColor = Color.BLACK;
        buttonColor = Color.BLACK;
        buttonFontColor = Color.WHITE;
        FontColor = Color.BLACK;
        try {
            Image playerImage = ImageIO.read(getClass().getResource("X.png"));
            Image AIImage = ImageIO.read(getClass().getResource("O.png"));
            this.playerIcon = new ImageIcon(playerImage);
            this.AIIcon = new ImageIcon(AIImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
