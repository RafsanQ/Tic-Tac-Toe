import javax.swing.*;
import java.awt.*;

public class Front {

    private JFrame window;
    private GridTracker gridTracker;

    private void createWindow(){
        window = new JFrame("Tic Tac Toe");
        window.setLayout(new GridLayout(1,2));
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(1200,600);
        window.setResizable(false);
    }

    private void addSettingsEditorJPanel(){
        window.add(gridTracker.settingsEditorPanel);
    }

    private void createGridTracker(){
        gridTracker = new GridTracker();
        window.add(gridTracker.DisplayedGrids);
    }

    Front(){
        createWindow();
        createGridTracker();
        addSettingsEditorJPanel();
        window.setVisible(true);
    }
}
