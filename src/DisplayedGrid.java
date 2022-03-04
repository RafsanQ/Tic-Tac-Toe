import Themes.Theme;

import javax.swing.*;
import java.awt.*;

public class DisplayedGrid extends JPanel {

    private tile[][] tiles = new tile[3][3];

    private GridTracker virtualGrid;

    private Theme currentTheme;

    void setVirtualGrid(GridTracker addedGrid){
        this.virtualGrid = addedGrid;
    }

    void setTheme(Theme theme){
        this.currentTheme = theme;
    }

    void setBackGround(){
        this.setBackground(currentTheme.getBackgroundColor());
    }

    // For Changing Theme
    void editTile(tile tile){
        tile.setVirtualGrid(virtualGrid);       // Add the virtual grid to take player input.
        tile.setTheme(currentTheme);        // Add the theme to the tile.
    }

    void addButtons(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                tiles[i][j] = new tile(i, j);
                editTile(tiles[i][j]);
                this.add(tiles[i][j]);
            }
        }
    }

    void DisableALlPlayerMoves(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                tiles[i][j].setEnabled(false);
            }
        }
    }

    void EnableALlPlayerMoves(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                tiles[i][j].setEnabled(true);
            }
        }
    }

    //updates the tiles if in the middle of a game
    void updateTiles(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                tiles[i][j].setEnabled(true);

                editTile(tiles[i][j]);

                if(virtualGrid.checkIfOccupied(new Location(i,j))){
                    if(virtualGrid.getOccupiedPlayer(new Location(i,j)) == 1)
                        tiles[i][j].putPlayerMove();
                    else
                        tiles[i][j].putAIMove();
                }
            }
        }
    }

    void changeTheme(Theme theme){
        setTheme(theme);
        setBackGround();
        updateTiles();
    }

    void Refresh(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                tiles[i][j].setIcon(null);
                tiles[i][j].setEnabled(true);
                editTile(tiles[i][j]);
            }
        }
    }

    void setAIMove(Location moveCordinate){
        tiles[moveCordinate.x][moveCordinate.y].putAIMove();
    }

    DisplayedGrid() {
        this.setLayout(new GridLayout(3,3));
    }
}
