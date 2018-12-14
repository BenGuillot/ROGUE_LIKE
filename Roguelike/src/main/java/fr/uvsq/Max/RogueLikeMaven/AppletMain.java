package fr.uvsq.Max.RogueLikeMaven;



import fr.uvsq.Max.RogueLikeMaven.Screen.Screen;
import fr.uvsq.Max.RogueLikeMaven.Screen.StartScreen;
import asciiPanel.AsciiPanel;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class AppletMain extends Applet implements KeyListener {
    private static final long serialVersionUID = 2560255315130084198L;

    private AsciiPanel terminal;
    private Screen screen;

    public AppletMain(){
        super();
        terminal = new AsciiPanel();
        add(terminal);
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    @Override
    public void init(){
        super.init();
        this.setSize(terminal.getWidth() + 20, terminal.getHeight() + 20);
    }

    @Override
    public void repaint(){
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        try {
            screen = screen.respondToUserInput(e);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }
}