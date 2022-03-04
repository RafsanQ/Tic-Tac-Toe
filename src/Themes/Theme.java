package Themes;

import javax.swing.*;
import java.awt.*;

public class Theme {
    Color backGroundColor, TileBorderColor, buttonColor, buttonFontColor, FontColor;
    ImageIcon playerIcon, AIIcon;

    public Color getBackgroundColor(){
        return backGroundColor;
    }

    public Color getTileBorderColor() {
        return TileBorderColor;
    }

    public ImageIcon getAIIcon() {
        return AIIcon;
    }

    public ImageIcon getPlayerIcon() {
        return playerIcon;
    }

    public Color getButtonColor() {
        return buttonColor;
    }

    public Color getButtonFontColor() {
        return buttonFontColor;
    }

    public Color getFontColor() {
        return FontColor;
    }
}
