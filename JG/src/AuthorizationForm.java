import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AuthorizationForm {

    private JPanel rootPanelAuth;
    private JPanel backgroundPanelAuth;
    private JButton closeButtonAuth;
    private JButton minimizeButtonAuth;
    private JLabel logoAuth;
    private JLabel phoneNumberEnteredText;
    private JTextPane codeSentTextPane;
    private JTextArea authCodeInput;
    private JLabel lockIcon;
    private JButton continueButtonAuth;
    private JPasswordField authCodeField;
    private JButton contButtonAuth;
    private BufferedImage backgroundAuth;

    public AuthorizationForm() throws IOException, FontFormatException {

        //background
        backgroundAuth = ImageIO.read(new File("res/background.png"));

        //main button font
        try {
            continueButtonAuth.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSansRegular.ttf")));
            continueButtonAuth.setFont(continueButtonAuth.getFont().deriveFont(18f));
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        //no border textfield
        MatteBorder border = BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE);
        authCodeField.setBorder(border);

        //textfield font
        authCodeField.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSansRegular.ttf")));
        authCodeField.setFont(authCodeField.getFont().deriveFont(22f));
        authCodeField.setForeground(Color.WHITE);

        //set focus
        authCodeField.requestFocusInWindow();
        authCodeField.setCaretPosition(authCodeField.getDocument().getLength());

        //TODO: add window listener focus
    }

    private void createUIComponents() throws IOException, FontFormatException {
        //logo at the top
        logoAuth = new JLabel(new ImageIcon("res/logo.png"));
        //close button stuff
        closeButtonAuth = new JButton();
        Image img = ImageIO.read(new File("res/icon-close.png"));
        closeButtonAuth.setIcon(new ImageIcon(img));
        closeButtonAuth.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        closeButtonAuth.setMargin(new Insets(0, 0, 0, 0));
        //minimize button stuff
        minimizeButtonAuth = new JButton();
        Image imgMinimize = ImageIO.read(new File("res/icon-hide.png"));
        minimizeButtonAuth.setIcon(new ImageIcon(imgMinimize));
        minimizeButtonAuth.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        minimizeButtonAuth.setMargin(new Insets(0, 0, 0, 0));
        //textPane - font
        codeSentTextPane = new JTextPane();
        Font font;
        font = Font.createFont(Font.TRUETYPE_FONT,new File("res/OpenSansRegular.ttf"));
        codeSentTextPane.setFont(font);
        codeSentTextPane.setFont(codeSentTextPane.getFont().deriveFont(16f));
        codeSentTextPane.setForeground(Color.white);
        //and center it
        StyledDocument doc = codeSentTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        codeSentTextPane.setParagraphAttributes(center,false);
        //given phone number goes here
        phoneNumberEnteredText = new JLabel();
        Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSansLight.ttf"));
        phoneNumberEnteredText.setFont(font2.deriveFont(32f));
        phoneNumberEnteredText.setForeground(Color.white);
        //logo at the top
        lockIcon = new JLabel(new ImageIcon("res/icon-lock.png"));
        //background and underline for the text input
        backgroundPanelAuth = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundAuth,0,0,getWidth(),getHeight(),this);
                g.setColor(Color.WHITE);
                g.drawLine(320,415,480,415);
            }
        };

    }

    //---------SETTERS AND GETTERS---------
    public JButton getCloseButton() {
        return closeButtonAuth;
    }

    public JButton getMinimizeButton() {
        return minimizeButtonAuth;
    }

    public JButton getContinueButtonAuth() {
        return continueButtonAuth;
    }

    public JPanel getRootPanelAuth() {return rootPanelAuth;}


    void setDisplayedPhoneNum(String text) {
        //String phoneNumToBeDisplayed = text.substring(0,1) + " (" + text.substring(2,4) + ") " + text.substring(5,text.length()+1);
        //TODO: implement googlei18n/libphonenumber to identify codes
        phoneNumberEnteredText.setText(text);
    }


}
