import Screen.Screen;
import Screen.StartScreen;
import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApplicationMain extends JFrame implements KeyListener {
    private static final long serialVersionUID = 1060623638149583738L;

    private AsciiPanel terminal;
    private Screen screen;
    /*
    AFFICHAGE DE L'INTERFACE DE JEU
     */
    public ApplicationMain(){
        super();
        terminal = new AsciiPanel();
        add(terminal);
        pack();
        /*
        appel a l'écran de démarage
         */
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    /*
    met a jour l'écran en fonction des commandes
     */
    @Override
    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    /*
    MAIN de l'application
     */
    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permet de quitter le jeu en fermant la fenêtre
        app.setVisible(true);
    }
}