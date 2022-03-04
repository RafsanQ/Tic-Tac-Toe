package Themes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ForestTheme extends Theme {
    public ForestTheme(){
        backGroundColor = Color.GREEN.darker().darker();
        TileBorderColor = Color.GREEN.darker().darker().darker().darker();
        buttonColor = Color.DARK_GRAY.darker().darker();
        buttonFontColor = Color.WHITE;
        FontColor = Color.WHITE;;
        try {
            Image playerImage = ImageIO.read(getClass().getResource("Flower.png"));
            Image AIImage = ImageIO.read(getClass().getResource("Fruit.png"));
            this.playerIcon = new ImageIcon(playerImage);
            this.AIIcon = new ImageIcon(AIImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
