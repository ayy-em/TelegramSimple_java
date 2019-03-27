import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InputPhoneNumberForm {

    private JPanel rootPanelInputPhone;
    private JLabel Logo;
    private JPanel backgroundPanel;
    private JTextPane inputPhoneTextPane;
    public JTextField inputPhoneNumberTextField;
    private JButton continueButton1;
    private JLabel phoneImage;
    private JPanel topPanel;
    private JButton closeButton;
    private JButton minimizeButton;
    private BufferedImage background;
    public String phoneNumberGiven;

    public InputPhoneNumberForm() throws IOException, FontFormatException {

        //background
        background = ImageIO.read(new File("res/background.png"));
        //button font
        continueButton1.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSansRegular.ttf")));
        continueButton1.setFont(continueButton1.getFont().deriveFont(18f));

        //no border textfield
        MatteBorder border = BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE);
        inputPhoneNumberTextField.setBorder(border);

        //textfield font
        inputPhoneNumberTextField.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSansRegular.ttf")));
        inputPhoneNumberTextField.setFont(inputPhoneNumberTextField.getFont().deriveFont(22f));
        
        //set focus
        inputPhoneNumberTextField.requestFocusInWindow();
        inputPhoneNumberTextField.setCaretPosition(inputPhoneNumberTextField.getDocument().getLength());

    }

    private void createUIComponents() throws IOException, FontFormatException {

        //logo at the top
        Logo = new JLabel(new ImageIcon("res/logo.png"));

        //background
        backgroundPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background,0,0,getWidth(),getHeight(),this);
                g.setColor(Color.WHITE);
                g.drawLine(240,415,560,415);
            }
        };

        //textPane - font
        inputPhoneTextPane = new JTextPane();
        Font font;
        font = Font.createFont(Font.TRUETYPE_FONT,new File("res/OpenSansRegular.ttf"));
        inputPhoneTextPane.setFont(font);
        inputPhoneTextPane.setFont(inputPhoneTextPane.getFont().deriveFont(18f));
        inputPhoneTextPane.setForeground(Color.white);

        //phone image next to input field
        phoneImage = new JLabel(new ImageIcon("res/icon-phone.png"));

        //center the JTextPane
        StyledDocument doc = inputPhoneTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        inputPhoneTextPane.setParagraphAttributes(center,false);

        //close button stuff
        closeButton = new JButton();
        Image img = ImageIO.read(new File("res/icon-close.png"));
        closeButton.setIcon(new ImageIcon(img));
        closeButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        closeButton.setMargin(new Insets(0, 0, 0, 0));

        //minimize button stuff
        minimizeButton = new JButton();
        Image imgMinimize = ImageIO.read(new File("res/icon-hide.png"));
        minimizeButton.setIcon(new ImageIcon(imgMinimize));
        minimizeButton.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        minimizeButton.setMargin(new Insets(0, 0, 0, 0));
    }

    //---------SETTERS AND GETTERS---------
    public String getPhoneNumberGiven() {
        phoneNumberGiven = inputPhoneNumberTextField.getText().trim();
        return phoneNumberGiven;
    }

    public JButton getContinueButton1() {
        return continueButton1;
    }

    public JTextField getInputPhoneNumberTextField() { return inputPhoneNumberTextField; }

    public JPanel getRootPanelInputPhone() {
        return rootPanelInputPhone;
    }

    public JButton getCloseButton() {
        return closeButton;
    }

    public JButton getMinimizeButton() {
        return minimizeButton;
    }

}
