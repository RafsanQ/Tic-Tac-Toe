import Themes.ClassicTheme;
import Themes.ForestTheme;
import Themes.HighContrastTheme;
import Themes.Theme;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsEditor extends JPanel {

    private JLabel label_theme;
    private JRadioButton classic, forest, high_contrast;
    private ButtonGroup themeSelector;
    private JButton startRandomAI, startDefensiveAI;
    private Theme currentTheme = new ClassicTheme();    // Set the classic theme as Default
    private DisplayedGrid displayedGrids;
    private GridTracker virtualGrid;

    void addDisplayGrid(DisplayedGrid grid){
        this.displayedGrids = grid;
    }

    void setBackGround(){
        this.setBackground(currentTheme.getBackgroundColor());
    }

    void setVirtualGrid(GridTracker virtualGrid){
        this.virtualGrid = virtualGrid;
    }

    Theme getCurrentTheme(){
        return currentTheme;
    }

    private void createButtonGroup(){
        themeSelector = new ButtonGroup();
        themeSelector.add(classic);
        themeSelector.add(forest);
        themeSelector.add(high_contrast);
    }

    // This is for when the Theme is Changed.
    void editAIButtons(){
        startDefensiveAI.setBackground(currentTheme.getButtonColor());
        startDefensiveAI.setForeground(currentTheme.getButtonFontColor());
        startRandomAI.setBackground(currentTheme.getButtonColor());
        startRandomAI.setForeground(currentTheme.getButtonFontColor());
    }

    private void createAIButtons(){
        startRandomAI = new JButton("START With Random AI");
        startDefensiveAI = new JButton("START With Defensive AI");

        editAIButtons();

        startRandomAI.setAlignmentX(Component.CENTER_ALIGNMENT);
        startDefensiveAI.setAlignmentX(Component.CENTER_ALIGNMENT);

        startRandomAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                virtualGrid.setAI(new AI());
                virtualGrid.Refresh();
            }
        });

        startDefensiveAI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                virtualGrid.setAI(new DefensiveAI());
                virtualGrid.Refresh();
            }
        });

        this.add(startRandomAI);
        this.add(startDefensiveAI);
    }

    // This is for the when Theme is changed.
    void editRadioButtons(){
        classic.setBackground(currentTheme.getBackgroundColor());
        classic.setForeground(currentTheme.getFontColor());
        forest.setBackground(currentTheme.getBackgroundColor());
        forest.setForeground(currentTheme.getFontColor());
        high_contrast.setBackground(currentTheme.getBackgroundColor());
        high_contrast.setForeground(currentTheme.getFontColor());
    }

    private void createRadioButtons(){
        classic = new JRadioButton("Classic", true);
        forest = new JRadioButton("Forest");
        high_contrast = new JRadioButton("High Contrast");
        editRadioButtons();
        classic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTheme = new ClassicTheme();
                changeTheme();
            }
        });

        forest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTheme = new ForestTheme();
                changeTheme();
            }
        });

        high_contrast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentTheme = new HighContrastTheme();
                changeTheme();
            }
        });

        classic.setAlignmentX(Component.CENTER_ALIGNMENT);
        forest.setAlignmentX(Component.CENTER_ALIGNMENT);
        high_contrast.setAlignmentX(Component.CENTER_ALIGNMENT);
        createButtonGroup();
        this.add(classic);
        this.add(forest);
        this.add(high_contrast);
    }

    private void setLabel_theme(){
        label_theme = new JLabel("Theme:");
        label_theme.setFont(new Font("SansSerif", Font.BOLD, 20));
        label_theme.setForeground(currentTheme.getFontColor());
        label_theme.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label_theme);
    }

    private void changeTheme(){
        editRadioButtons();
        setBackGround();
        label_theme.setForeground(currentTheme.getFontColor());
        displayedGrids.changeTheme(currentTheme);
        editAIButtons();
    }

    SettingsEditor(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackGround();
        setLabel_theme();
        createRadioButtons();
        createAIButtons();
    }
}
