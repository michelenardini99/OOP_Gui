package it.unibo.oop.lab.mvcio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unibo.oop.lab.iogui.BadIOGUI;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My first Java graphical interface");


    /**
     * @param ctrl
     */
    public SimpleGUI(final Controller ctrl) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea aText = new JTextArea();
        JButton save = new JButton("Save");
        JPanel aPanel = new JPanel();
        aPanel.setLayout(new BorderLayout());
        aPanel.add(aText, BorderLayout.CENTER);
        aPanel.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    ctrl.saveContentFile(aText.getText());
                    System.out.println("File salvato!");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        frame.setContentPane(aPanel);
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        frame.setLocationByPlatform(true);
    }
    private void display() {
        frame.setVisible(true);
    }
    /**
     * @param a
     */
    public static void main(final String... a) {
        final SimpleGUI gui = new SimpleGUI(new Controller());
        gui.display();
    }

}
