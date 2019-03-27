import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by J_Mironov on 24/03/2019
 */

public class Loader {

    static Frame frame;

    static {
        try {
            frame = new Frame();
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, FontFormatException {

        frame.setTitle("JavaGram v0.1 - Simple Messaging Tool");
        frame.setUndecorated(true);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
