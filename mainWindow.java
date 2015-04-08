package Ass2;
import javax.swing.*;

public class mainWindow extends GuiWithFileClass {
	
	private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(false);
        JFrame frame = new JFrame("Personal Record");
        
        //Create and set up the content pane.
        GuiWithFileClass sample = new GuiWithFileClass();
        frame.setContentPane(sample.myContentPaneCreater());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	createAndShowGUI();
            }
        });

    }}



	


