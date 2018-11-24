import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("ROGUE LIKE : first step", 10, 10);
        terminal.writeCenter("-- press [enter] to start --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}