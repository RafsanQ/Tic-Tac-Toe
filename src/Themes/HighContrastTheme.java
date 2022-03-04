package Themes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class HighContrastTheme extends Theme {
    public HighContrastTheme(){
        backGroundColor = Color.DARK_GRAY;
        TileBorderColor = Color.LIGHT_GRAY.darker();
        buttonColor = Color.BLACK;
        buttonFontColor = Color.WHITE;
        FontColor = Color.WHITE;
        try {
            Image playerImage = ImageIO.read(getClass().getResource("BlackIcon.png"));
            Image AIImage = ImageIO.read(getClass().getResource("WhiteIcon.png"));
            this.playerIcon = new ImageIcon(playerImage);
            this.AIIcon = new ImageIcon(AIImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
