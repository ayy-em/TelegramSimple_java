import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ProfileSettingsForm {

    public JPanel rootPaneProfSet;
    private JPanel backgroundPaneProfSet;
    private JTextPane profileSettingsTextPane;
    private JTextField firstNameSettings;
    private JTextField lastNameSettings;
    private JButton closeButSettings;
    private JButton minimizeButSettings;
    private JPanel topPanelSettings;
    private JButton logoutButton;
    private JTextPane yourNumber;
    private JButton backButtonSettings;

    public ProfileSettingsForm() {

        //Size
        backgroundPaneProfSet.setBackground(new Color(0, 0, 0,185));
        //rootPaneProfSet.setSize(800,600);
        backgroundPaneProfSet.setSize(800,600);
        rootPaneProfSet.setOpaque(false);

        //first/last name text fields' borders
        MatteBorder noBorder = BorderFactory.createMatteBorder(0,0,3,0, Color.WHITE);
        firstNameSettings.setBorder(noBorder);
        lastNameSettings.setBorder(noBorder);

        //------------Top panel ActionListeners------------
        closeButSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loader.frame.dispose();
            }
        });
        minimizeButSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loader.frame.setState(Frame.ICONIFIED);
            }
        });


    }

    private void createUIComponents() throws IOException, FontFormatException {

        //main text pane
        profileSettingsTextPane = new JTextPane();
        Font font3;
        font3 = Font.createFont(Font.TRUETYPE_FONT,new File("res/OpenSansRegular.ttf"));
        profileSettingsTextPane.setFont(font3);
        profileSettingsTextPane.setFont(profileSettingsTextPane.getFont().deriveFont(24f));
        //and center it
        StyledDocument doc = profileSettingsTextPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        profileSettingsTextPane.setParagraphAttributes(center,false);

        //TODO: white underlines

        //back button - bottom left
        backButtonSettings = new JButton();
        ImageIcon backButSet = (new ImageIcon("res/icon-back.png"));
        backButtonSettings.setIcon(backButSet);
        backButtonSettings.setOpaque(false);
        backButtonSettings.setContentAreaFilled(false);
        backButtonSettings.setFocusPainted(false);
        backButtonSettings.setBorderPainted(false);
        backButtonSettings.setBorder(null);

        //log out button - bottom right
        logoutButton = new JButton();
        ImageIcon logOutIcon = (new ImageIcon("res/logout.png"));
        logoutButton.setIcon(logOutIcon);
        logoutButton.setOpaque(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setFocusPainted(false);
        logoutButton.setBorderPainted(false);
        logoutButton.setBorder(null);

        //yourPhoneNumber JTextPane
        yourNumber = new JTextPane();
        Font font6 = Font.createFont(Font.TRUETYPE_FONT, new File("res/OpenSansLight.ttf"));
        yourNumber.setFont(font6.deriveFont(16f));
        yourNumber.setForeground(Color.white);
        yourNumber.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        yourNumber.setOpaque(false);


        //-------------TOP BAR + TOP BUTTONS----------------
        //close button stuff
        closeButSettings = new JButton();
        Image img = ImageIO.read(new File("res/icon-close.png"));
        closeButSettings.setIcon(new ImageIcon(img));
        closeButSettings.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        closeButSettings.setBorder(new MatteBorder(0,3,0,0,new Color(230,230,230)));
        //minimize button stuff
        minimizeButSettings = new JButton();
        Image imgMinimize = ImageIO.read(new File("res/icon-hide.png"));
        minimizeButSettings.setIcon(new ImageIcon(imgMinimize));
        minimizeButSettings.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        minimizeButSettings.setBorder(new MatteBorder(0,0,0,3,new Color(230,230,230)));

    }

    //---------SETTERS AND GETTERS---------

    public JPanel getBackgroundPaneProfSet() {return backgroundPaneProfSet; }
    public JPanel getRootPaneProfSet() { return rootPaneProfSet; }
    public void setPhoneNumberSettings(String phone) { yourNumber.setText(phone);}
    public void setFirstNameSettings(String firstName) {firstNameSettings.setText(firstName);}
    public void setLastNameSettings(String lastName) {firstNameSettings.setText(lastName);}
    public JButton getLogoutButton() { return logoutButton; }
    public JButton getBackButtonSettings() { return backButtonSettings; }

}
