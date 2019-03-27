import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NameLastNameForm {

    private JPanel rootPanelNameLast;
    private JPanel backgroundPanel;
    private JButton closeButtonNLN;
    private JButton minimizeButtonNLN;
    private JLabel logoNLN;
    private JPanel topPanelNLN;
    private JTextPane inputNLNPane;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JButton continueButtonNLN;
    private BufferedImage backgroundImg;

    public String firstNameGiven;
    public String lastNameGiven;

    public NameLastNameForm() throws IOException, FontFormatException {

        //background
        backgroundImg = ImageIO.read(new File("res/background.png"));
        //continue button
        try {
            continueButtonNLN.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSansRegular.ttf")));
            continueButtonNLN.setFont(continueButtonNLN.getFont().deriveFont(18f));
        } catch (FontFormatException e) {e.printStackTrace();}
        //textfield borders
        firstNameField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE));
        lastNameField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.WHITE));
        firstNameField.setFont(Font.createFont(Font.TRUETYPE_FONT,new File("res/OpenSansRegular.ttf")));
        lastNameField.setFont(Font.createFont(Font.TRUETYPE_FONT,new File("res/OpenSansRegular.ttf")));
        firstNameField.setFont(firstNameField.getFont().deriveFont(20f));
        lastNameField.setFont(lastNameField.getFont().deriveFont(20f));
        firstNameField.setForeground(Color.white);
        lastNameField.setForeground(Color.white);

        //----------------ACTION LISTENERS-------------------
        //focus for text fields
        firstNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (firstNameField.getText().equals("Имя")) {firstNameField.setText("");}
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (firstNameField.getText().length() == 0) {
                    firstNameField.setText("Имя");
                }
            }
        });
        lastNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (lastNameField.getText().equals("Фамилия")) {lastNameField.setText("");}
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (lastNameField.getText().length() == 0) {
                    lastNameField.setText("Фамилия");
                }
            }
        });

    }

    private void createUIComponents() throws IOException, FontFormatException {

        //-------------TOP BAR + TOP BUTTONS----------------
        //close button stuff
        closeButtonNLN = new JButton();
        Image img = ImageIO.read(new File("res/icon-close.png"));
        closeButtonNLN.setIcon(new ImageIcon(img));
        closeButtonNLN.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        closeButtonNLN.setMargin(new Insets(0, 0, 0, 0));
        //minimize button stuff
        minimizeButtonNLN = new JButton();
        Image imgMinimize = ImageIO.read(new File("res/icon-hide.png"));
        minimizeButtonNLN.setIcon(new ImageIcon(imgMinimize));
        minimizeButtonNLN.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        minimizeButtonNLN.setMargin(new Insets(0, 0, 0, 0));
        //--------------------BACKGROUND-------------------
        backgroundPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImg,0,0,getWidth(),getHeight(),this);
            }
        };
        //----------------TEXT PANE------------------------
        //textPane - font
        inputNLNPane = new JTextPane();
        Font font;
        font = Font.createFont(Font.TRUETYPE_FONT,new File("res/OpenSansRegular.ttf"));
        inputNLNPane.setFont(font);
        inputNLNPane.setFont(inputNLNPane.getFont().deriveFont(16f));
        inputNLNPane.setForeground(Color.white);
        //and center it
        StyledDocument doc = inputNLNPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        inputNLNPane.setParagraphAttributes(center,false);
        //---------------OTHER ELEMENTS--------------------
        //logo at the top
        logoNLN = new JLabel(new ImageIcon("res/logo.png"));

    }

    //---------SETTERS AND GETTERS---------
    public JButton getCloseButton() {
        return closeButtonNLN;
    }
    public JButton getContinueButtonNLN() {
        return continueButtonNLN;
    }

    public JButton getMinimizeButton() {
        return minimizeButtonNLN;
    }
    public JPanel getRootPanelNameLast() {
        return rootPanelNameLast;
    }
}
