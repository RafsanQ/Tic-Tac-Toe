import javax.swing.*;

public class GridTracker {

    // Grid to keep track of the Game. 0 means unoccupied. 1 means player. 2 means AI.
    private int[][] grid = new int[3][3];

    DisplayedGrid DisplayedGrids;
    SettingsEditor settingsEditorPanel;
    AI ai;

    public GridTracker(){
        settingsEditorPanel = new SettingsEditor();
        DisplayedGrids = new DisplayedGrid();

        settingsEditorPanel.addDisplayGrid(DisplayedGrids);        // The theme of the Displayed Grids can be changed from the setting Editor Panel. This will allow it to make such changes/
        settingsEditorPanel.setVirtualGrid(this);         // The AI can be changed from the Settings Editor Panel. This will allow it to make such changes.
        DisplayedGrids.setVirtualGrid(this);         // The AI needs to send its moves to be displayed in the Displayed Grids. This will allow it to do so.

        setUpTheDisplayedGrids();

        setAI(new AI());    // Setting the AI as the Normal (Random) AI as Default
    }

    // Necessary Operations to prepare the Displayed Grids
    private void setUpTheDisplayedGrids(){
        DisplayedGrids.setTheme(settingsEditorPanel.getCurrentTheme());      // The selected Theme is passed to the Displayed Grids
        DisplayedGrids.setBackGround();
        DisplayedGrids.addButtons();
    }

    void Refresh(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                grid[i][j] = 0;
            }
        }
        DisplayedGrids.Refresh();
    }

    void setAI(AI ai){
        this.ai = ai;
    }

    int getOccupiedPlayer(Location location){
        return grid[location.x][location.y];
    }

    // For the Defensive AI.
    boolean checkIfPlayerOccupied(Location location){
        if(getOccupiedPlayer(location) == 1)
            return true;
        return false;
    }

    void putPlayerMove(int x, int y){
        grid[x][y] = 1;
    }

    void putAIMove(int x, int y){
        grid[x][y] = 2;
    }

    public boolean checkIfOccupied(Location location){
        if(getOccupiedPlayer(location) == 0)
            return false;
        return true;
    }

    private boolean checkIfMovesRemain(){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(!checkIfOccupied(new Location(i, j)))
                    return true;
            }
        }
        return false;
    }

    // Iterate through 3 rows and check if the input player has occupied the three tiles
    private boolean checkIfPlayerHasRow(int inputPlayer){
        for(int i=0; i<3; i++){
            if(getOccupiedPlayer(new Location(i,0)) == inputPlayer && getOccupiedPlayer(new Location(i,1)) == inputPlayer && getOccupiedPlayer(new Location(i,2)) == inputPlayer)
                return true;
        }
        return false;
    }

    // Iterate through 3 columns and check if the input player has occupied the three tiles
    private boolean checkIfPlayerHasColumn(int inputPlayer){
        for(int i=0; i<3; i++){
            if(getOccupiedPlayer(new Location(0,i)) == inputPlayer && getOccupiedPlayer(new Location(1,i)) == inputPlayer && getOccupiedPlayer(new Location(2,i)) == inputPlayer)
                return true;
        }
        return false;
    }

    // Iterate through the 2 diagonals and check if input Player has occupied any one of the two diagonals
    private boolean checkIfPlayerHasDiagonal(int inputPlayer){
        if(getOccupiedPlayer(new Location(0,0)) == inputPlayer && getOccupiedPlayer(new Location(1,1)) == inputPlayer && getOccupiedPlayer(new Location(2,2)) == inputPlayer)
            return true;
        if(getOccupiedPlayer(new Location(0,2)) == inputPlayer && getOccupiedPlayer(new Location(1,1)) == inputPlayer && getOccupiedPlayer(new Location(2,0)) == inputPlayer)
            return  true;

        return false;
    }

    // Player's value is 1. So check if 1 is occupied serially 3 times.
    private boolean checkIfPlayerWon(){
        int inputValue = 1;
        return checkIfPlayerHasRow(inputValue) || checkIfPlayerHasColumn(inputValue) || checkIfPlayerHasDiagonal(inputValue);
    }

    // AI's value is 2. So check if 2 is occupied serially 3 times.
    private boolean checkIfAIWon(){
        int inputValue = 2;
        return checkIfPlayerHasRow(inputValue) || checkIfPlayerHasColumn(inputValue) || checkIfPlayerHasDiagonal(inputValue);
    }

    private void AIMove(){
        DisplayedGrids.DisableALlPlayerMoves();     // Wait for AI's Move. The player can not press any tiles within this time.

        Location aiMove = ai.makeMove(this);
        putAIMove(aiMove.x, aiMove.y);
        DisplayedGrids.setAIMove(aiMove);
        DisplayedGrids.EnableALlPlayerMoves();      // Enable the player's move after AI has made its move.
    }

    void onPlayerMove(Location playerMove){
        putPlayerMove(playerMove.x, playerMove.y);
        if(checkIfPlayerWon()){
            JOptionPane.showMessageDialog(null, "Player Won");
            Refresh();
            return;
        }
        if(!checkIfMovesRemain()){
            JOptionPane.showMessageDialog(null, "Draw");
            Refresh();
            return;
        }

        AIMove();

        if(checkIfAIWon()){
            JOptionPane.showMessageDialog(null, "Player Lost");
            Refresh();
            return;
        }
        if(!checkIfMovesRemain()){
            JOptionPane.showMessageDialog(null, "Draw");
            Refresh();
            return;
        }
    }
}

