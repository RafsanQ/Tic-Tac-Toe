import Themes.Theme;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tile extends JButton {

    private ImageIcon playerIcon, AIIcon;
    private GridTracker virtualGrid;
    private Location thisLocation;
    private Theme currentTheme;

    // Getting the Required Theme from the Displayed Grid
    void setVirtualGrid(GridTracker virtualGrid){
        this.virtualGrid = virtualGrid;
    }

    private void setImageIcons(){
        this.playerIcon = currentTheme.getPlayerIcon();
        this.AIIcon = currentTheme.getAIIcon();
    }

    // Operations to set up the button
    private void setSettings(){
        this.setBackground(currentTheme.getBackgroundColor());
        this.setBorder(BorderFactory.createLineBorder(currentTheme.getTileBorderColor(), 6));
    }

    void setTheme(Theme theme){
        this.currentTheme = theme;
        setImageIcons();
        setSettings();
    }

    private void onClick(){
        if(virtualGrid.checkIfOccupied(thisLocation))
            return;
        putPlayerMove();
        virtualGrid.onPlayerMove(thisLocation);
    }

    void putPlayerMove(){
        this.setIcon(playerIcon);
    }

    void putAIMove(){
        this.setIcon(AIIcon);
    }

    tile(int x, int y){
        thisLocation = new Location(x, y);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
    }
}
