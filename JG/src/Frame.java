import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Frame extends JFrame {

    InputPhoneNumberForm ipnf = new InputPhoneNumberForm();
    AuthorizationForm authf = new AuthorizationForm();
    NameLastNameForm nlnf = new NameLastNameForm();
    ChatWindowForm cwf = new ChatWindowForm();
    //ipnf -> authf -> nlnf -> cwf

    public Frame() throws IOException, FontFormatException {

        //initial content - first window (Input Phone #)
        setContentPane(ipnf.getRootPanelInputPhone());

        //-----------CONTINUE BUTTON ACTION LISTENERS-------------
        //-----ipnf
        ipnf.getContinueButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authf.setDisplayedPhoneNum(ipnf.inputPhoneNumberTextField.getText().trim());
                cwf.setPhoneNumberGivenByUser(ipnf.inputPhoneNumberTextField.getText().trim());
                setContentPane(authf.getRootPanelAuth());
                //revalidate();
                //repaint();
            }
        });
        //TODO: Enter also transfers you
        //TODO: limit char length, recognize phone codes
        //TODO: make it so you can't proceed without a phone number
        //-----authf
        authf.getContinueButtonAuth().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setContentPane(nlnf.getRootPanelNameLast());
            }
        });
        //TODO: Enter also transfers you
        //TODO: make it so you can't proceed without the authorization code
        //TODO: Limit max chars to 5
        //-----nlnf
        nlnf.getContinueButtonNLN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setContentPane(cwf.getRootPanelChat());
            }
        });
        //TODO: Enter also transfers you
        //TODO: Make it so proceeding without giving a name is not possible
        //TODO: transfer names to ChatWindowForm
        //-----cwf
        //TODO: Transfer to Settings, Edit contact, Add Contact
        //TODO: transfer userNameGiven & userIcon from NLNForm

        //-----------CLOSE/MINIMIZE ACTION LISTENERS--------------
        //-----ipnf
        ipnf.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        ipnf.getMinimizeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(ICONIFIED);
            }
        });
        //-----authf
        authf.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        authf.getMinimizeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(ICONIFIED);
            }
        });
        //-----nlnf
        nlnf.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        nlnf.getMinimizeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(ICONIFIED);
            }
        });
        //-----cwf
        cwf.getCloseButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        cwf.getMinimizeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setState(ICONIFIED);
            }
        });
        //--------END OF CLOSE/MINIMIZE ACTION LISTENERS-----------
    }
}
