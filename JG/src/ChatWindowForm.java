import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChatWindowForm {

    private JPanel rootPanelChat;
    private JPanel bgPanelChat;
    private JPanel topPanelChat;
    private JButton closeButtonChat;
    private JButton minimizeButtonChat;
    private JPanel logoContactNamePane;
    private JLabel smallLogo;
    private JButton settingsButton;
    private JPanel contactsListPane;
    private JPanel chatWindowPane;
    private JLabel userIcon;
    private JTextPane userName;
    private JTextField searchField;
    private JLabel magniIcon;
    private JPanel searchPanel;
    private JButton addContactButton;
    private JPanel currentContactAndEdit;
    private JLabel selectedContactIcon;
    private JTextPane selectedContactName;
    private JButton editContactButton;
    private JPanel fullChatPane;
    private JPanel chatEnterTextPane;
    private JTextField chatTextField;
    private JButton chatSendButton;
    private JPanel msgInPanel;
    private JTextPane messageRec1;
    private JTextPane messageRec1Time;
    private JLabel inIcon;
    private JLabel msgInTopIcon;
    private JLabel msgInBotIcon;
    private JScrollPane contactListNamesPane;
    private JPanel msgOutPanel;
    private JTextPane msgOut1;
    private JTextPane msgOut1Time;
    private JLabel msgOutTopIcon;
    private JLabel msgOutBotIcon;
    private JLabel outIcon;
    private JScrollPane contactsScrollPane;
    private JPanel contactListPane;
    private JPanel contact1;
    private JPanel contact2;
    private JTextPane contMessaging1MsgName;
    private JTextPane contMessaging1MsgText;
    private JTextPane timeRec;
    private JLabel contactMessaging1;
    public String userNameGiven;



    public String firstNameGiven;
    public String lastNameGiven;
    public String phoneNumberGivenByUser;
    ProfileSettingsForm psf = new ProfileSettingsForm();

    public ChatWindowForm() throws IOException, FontFormatException {

        //transfer first/last name
        if (firstNameGiven != null && lastNameGiven != null) {
        userNameGiven = firstNameGiven.trim() + " " + lastNameGiven.trim(); }

        //----------2ND BAR STUFF---------------------
        //user name text
        userName.setText(userNameGiven);
        userName.setOpaque(false);
        Font font;
        font = Font.createFont(Font.TRUETYPE_FONT,new File("res/OpenSansLight.ttf"));
        userName.setFont(font);
        userName.setFont(userName.getFont().deriveFont(16f));
        userName.setForeground(Color.white);

        //----------CONTACT LIST STUFF---------------------
        //search field
        searchField.setText("Поиск");
        searchField.setFont(font);
        searchField.setFont(searchField.getFont().deriveFont(16f));
        searchField.setForeground(Color.GRAY);
        searchField.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        searchField.setOpaque(false);
        //setting listeners to clear text on focus
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Поиск")) {searchField.setText("");}
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().length() == 0) {
                    searchField.setText("Поиск");
                }
            }
        });

        //-------------------CHAT WINDOW STUFF---------------
        //contact name + edit icon pane
        currentContactAndEdit.setBorder(new MatteBorder(0,0,1,0,Color.lightGray));
        //Contact name
        Font font2;
        font2 = Font.createFont(Font.TRUETYPE_FONT,new File("res/OpenSansLight.ttf"));
        selectedContactName.setFont(font2);
        selectedContactName.setFont(selectedContactName.getFont().deriveFont(16f));
        selectedContactName.setForeground(Color.GRAY);
        selectedContactName.setBorder(BorderFactory.createEmptyBorder(0,5,0,10));
        //chat text input field
        chatTextField.requestFocusInWindow();
        chatTextField.setFont(font2);
        chatTextField.setFont(chatTextField.getFont().deriveFont(16f));
        chatTextField.setForeground(Color.GRAY);
        Border rounded = new LineBorder(new Color(230,230,230), 1, true);
        Border empty = new EmptyBorder(0, 3, 0, 0);
        Border compBorder = new CompoundBorder(rounded, empty);
        chatTextField.setBorder(compBorder);

        //----MSG IN----
        //center text horizontally in message_in panes
        StyledDocument doc = messageRec1.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_LEFT);
        messageRec1.setParagraphAttributes(center,false);
        //font of msg_in pane & time sent
        messageRec1.setFont(font2);
        messageRec1.setFont(messageRec1.getFont().deriveFont(15f));
        messageRec1.setForeground(Color.WHITE);
        messageRec1Time.setFont(font2);
        messageRec1Time.setFont(messageRec1Time.getFont().deriveFont(13f));
        messageRec1Time.setForeground(Color.GRAY);
        //IN icon left border
        inIcon.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
        //----MSG OUT----
        //center text horizontally in message_in panes
        StyledDocument doc2 = msgOut1.getStyledDocument();
        SimpleAttributeSet center1 = new SimpleAttributeSet();
        StyleConstants.setAlignment(center1, StyleConstants.ALIGN_LEFT);
        msgOut1.setParagraphAttributes(center,false);
        //font of msg_in pane & time sent
        msgOut1.setFont(font2);
        msgOut1.setFont(msgOut1.getFont().deriveFont(15f));
        msgOut1.setForeground(Color.WHITE);
        msgOut1Time.setFont(font2);
        msgOut1Time.setFont(msgOut1Time.getFont().deriveFont(13f));
        msgOut1Time.setForeground(Color.GRAY);
        //IN icon left border
        outIcon.setBorder(BorderFactory.createEmptyBorder(0,0,0,15));

        //action listener for "send" button
        chatSendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatTextField.setText("");
                //TODO: Actually send text, not just clear the field
            }
        });

        //-----------CONTACT LIST + SEARCH STUFF-------------
        contactsListPane.setBorder(new MatteBorder(0,0,1,1,Color.lightGray));
        searchPanel.setBorder(new MatteBorder(0,0,1,0,Color.lightGray));

        //-----LAYERED BULLSHIT THAT'S DRIVING ME INSANE------
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //copy current frame content
                Container c = Loader.frame.getContentPane();
                //get frame's layered pane
                JLayeredPane jlp = Loader.frame.getLayeredPane();
                //add background (current pane, 1) and overlay (psf's JPanel)
                jlp.removeAll();
                Loader.frame.setContentPane(c);
                jlp.add(psf.getBackgroundPaneProfSet(),JLayeredPane.MODAL_LAYER,2);
                psf.setPhoneNumberSettings(phoneNumberGivenByUser);
                Loader.frame.repaint();
                Loader.frame.setVisible(true);
            }
        });
        //---------PROFILE SETTINGS ACTION LISTENERS----------
        psf.getBackButtonSettings().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Loader.frame.getLayeredPane().removeAll();
                Loader.frame.setContentPane(rootPanelChat);
            }
        });
    }

    private void createUIComponents() throws IOException {

        //-------------TOP BAR + TOP BUTTONS----------------
        //close button stuff
        closeButtonChat = new JButton();
        Image img = ImageIO.read(new File("res/icon-close.png"));
        closeButtonChat.setIcon(new ImageIcon(img));
        closeButtonChat.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        closeButtonChat.setBorder(new MatteBorder(0,3,0,0,new Color(230,230,230)));
        //minimize button stuff
        minimizeButtonChat = new JButton();
        Image imgMinimize = ImageIO.read(new File("res/icon-hide.png"));
        minimizeButtonChat.setIcon(new ImageIcon(imgMinimize));
        minimizeButtonChat.setBorder(BorderFactory.createMatteBorder(0,0,0,0, Color.WHITE));
        minimizeButtonChat.setBorder(new MatteBorder(0,0,0,3,new Color(230,230,230)));

        //-----------SECOND TOP BAR (LOGO, CONTACT)--------
        //logo top left
        smallLogo = new JLabel(new ImageIcon("res/logo-micro.png"));
        smallLogo.setBorder(BorderFactory.createEmptyBorder(0,13,0,10));
        //settings button
        settingsButton = new JButton();
        ImageIcon buttonImg = (new ImageIcon ("res/icon-settings.png"));
        settingsButton.setIcon(buttonImg);
        settingsButton.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        //user icon
        userIcon = new JLabel(new ImageIcon("res/your-face.png"));
        userIcon.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        //margins around username
        userName = new JTextPane();
        userName.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));

        //--------------CONTACT PANE + SEARCH BAR--------------------
        //search icon
        magniIcon = new JLabel(new ImageIcon("res/icon-search.png"));
        magniIcon.setBorder(BorderFactory.createEmptyBorder(0, 15, 0,10));
        //add user icon
        addContactButton = new JButton();
        ImageIcon addContButImg = (new ImageIcon ("res/icon-plus.png"));
        addContactButton.setIcon(addContButImg);
        addContactButton.setBorder(BorderFactory.createEmptyBorder(0,15,15,0));

        //-----------------CHAT WINDOW STUFF--------------------------
        //selected contact icon
        selectedContactIcon = new JLabel(new ImageIcon("res/current-user.png"));
        selectedContactIcon.setBorder(BorderFactory.createEmptyBorder(0,15,0,10));
        //edit contact button
        editContactButton = new JButton();
        ImageIcon editButtonImg = (new ImageIcon("res/icon-edit.png"));
        editContactButton.setIcon(editButtonImg);
        editContactButton.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        //chat send button
        chatSendButton = new JButton();
        ImageIcon chatSendButtonIcon = (new ImageIcon("res/button-send.png"));
        chatSendButton.setIcon(chatSendButtonIcon);
        chatSendButton.setBorder(null);
        //----MSG IN----
        //msg received
        inIcon = new JLabel(new ImageIcon("res/message-in-left.png"));
        //msg in icons
        msgInBotIcon = new JLabel(new ImageIcon("res/message-in-bottom.png"));
        msgInTopIcon = new JLabel(new ImageIcon("res/message-in-top.png"));
        //----MSG OUT----
        //right triangle icon
        outIcon = new JLabel(new ImageIcon("res/message-out-right.png"));
        //msg out top/bot borders
        msgOutBotIcon = new JLabel(new ImageIcon("res/message-out-bottom.png"));
        msgOutTopIcon = new JLabel(new ImageIcon("res/message-out-top.png"));
        //---------------CONTACT LIST----------
        //guy messaging
        contactMessaging1 = new JLabel(new ImageIcon("res/mask-gray-online.png"));
        //TODO: DELETE PANE WITH OUT MSG
    }

    //---------SETTERS AND GETTERS---------
    public JButton getCloseButton() {
        return closeButtonChat;
    }
    public JButton getMinimizeButton() {
        return minimizeButtonChat;
    }
    public JPanel getRootPanelChat() {
        return rootPanelChat;
    }
    public JButton getSettingsButton() {
        return settingsButton;
    }
    public JButton getAddContactButton() {
        return addContactButton;
    }
    public JButton getEditContactButton() {
        return editContactButton;
    }
    public void setPhoneNumberGivenByUser(String phone) {this.phoneNumberGivenByUser = phone;}
    public void setFirstNameGiven(String firstNameGiven) { this.firstNameGiven = firstNameGiven; }
    public void setLastNameGiven(String lastNameGiven) { this.lastNameGiven = lastNameGiven; }
}
