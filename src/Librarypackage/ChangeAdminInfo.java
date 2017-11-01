package Librarypackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class ChangeAdminInfo extends LibraryMgt {

    JFrame frame;
    JPanel Dashboard, GrayDashboard, toppane, centerpane, southpane;
    JTextField usernametext, EmailAddressText, EnterPasswordText, currentPasstext1, EnterNewPasswordtext, ConfirmNewPasswordtext;
    JButton login, login1;

    public ChangeAdminInfo() {
        Init();
        Dbload_Details();
    }

    public void Init() {

        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout(100, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dashboard = new JPanel(new BorderLayout());
        Dashboard.setBackground(Color.GRAY);
        Dashboard.setBorder(new LineBorder(Color.WHITE, 10));
        frame.add(Dashboard, BorderLayout.CENTER);

        GrayDashboard = new JPanel(new BorderLayout(150, 10));
        GrayDashboard.setBackground(Color.GRAY);
        GrayDashboard.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        GrayDashboard.setBounds(10, 10, 763, 541);
        Dashboard.add(GrayDashboard, BorderLayout.CENTER);

        toppane = new JPanel(new BorderLayout(1, 10));
        JPanel middletop = new JPanel(new GridBagLayout());
        middletop.setBackground(Color.GRAY);

        toppane.setBackground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 60, 1, 1);
        JLabel logo = new JLabel(resizeImage(Logo_icon));
        JLabel logo1 = new JLabel("Departmental Library:");

        logo1.setForeground(Color.MAGENTA);
        JLabel logo2 = new JLabel("Department of computer Science ( CS )");
        logo2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        logo2.setForeground(Color.WHITE);
        gbc.gridy = 0;
        gbc.gridx = 0;
        middletop.add(logo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        middletop.add(logo1, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        middletop.add(logo2, gbc);
        toppane.add(middletop, BorderLayout.CENTER);

        JPanel icons = new JPanel();
        icons.setBackground(Color.GRAY);

        final JLabel logo3 = new JLabel(Home_icon);
        logo3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logo3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new Dashboard();
                frame.dispose();

            }

            public void mouseEntered(MouseEvent e) {
                logo3.setOpaque(true);
                logo3.setIcon(Home_icon);

            }

            public void mouseExited(MouseEvent e) {
                logo3.setIcon(Home_icon);
                logo3.setOpaque(false);

            }

        }
        );

        JLabel logo4 = new JLabel(Help_icon);
        JLabel logo5 = new JLabel(Close_icon);

        icons.add(logo3);
        icons.add(logo4);
        icons.add(logo5);
        toppane.add(icons, BorderLayout.EAST);
        GrayDashboard.add(toppane, BorderLayout.NORTH);

        centerpane = new JPanel(new BorderLayout());
        centerpane.setBorder(new LineBorder(Color.LIGHT_GRAY, 10));
        centerpane.setBackground(Color.LIGHT_GRAY);

        JPanel Firstpane = new JPanel(new GridBagLayout());

        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.insets = new Insets(3, 3, 3, 3);
        gbc0.weightx = 0.01;
        gbc0.weightx = 0.01;
        Firstpane.setBackground(Color.DARK_GRAY);

        JLabel Username = new JLabel("Username ");
        Username.setForeground(Color.LIGHT_GRAY);

        usernametext = new JTextField(15);
        usernametext.setHorizontalAlignment(JTextField.CENTER);
        usernametext.setBackground(Color.LIGHT_GRAY);
        usernametext.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));

        JLabel EmailAddress = new JLabel("Email Address ");
        EmailAddress.setForeground(Color.LIGHT_GRAY);

        EmailAddressText = new JTextField(15);
        EmailAddressText.setHorizontalAlignment(JTextField.CENTER);
        EmailAddressText.setBackground(Color.LIGHT_GRAY);
        EmailAddressText.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));

        JLabel EnterPassword = new JLabel("Enter Current Password ");
        EnterPassword.setForeground(Color.LIGHT_GRAY);

        EnterPasswordText = new JPasswordField(15);
        EnterPasswordText.setHorizontalAlignment(JTextField.CENTER);
        EnterPasswordText.setBackground(Color.LIGHT_GRAY);
        EnterPasswordText.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));

        login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dbupdate_Info_Details();
            }

        });
        //ConfirmNewPassword.setForeground(Color.CYAN);
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        Firstpane.add(Username, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        Firstpane.add(usernametext, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        Firstpane.add(EmailAddress, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 3;
        Firstpane.add(EmailAddressText, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 4;
        Firstpane.add(EnterPassword, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 5;
        Firstpane.add(EnterPasswordText, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 6;
        Firstpane.add(login, gbc0);

        centerpane.add(Firstpane, BorderLayout.EAST);

        JPanel Secondpane = new JPanel(new GridBagLayout());

        Secondpane.setBackground(Color.DARK_GRAY);

        JLabel EnterCurrentPassword = new JLabel("Enter Current Password ");
        EnterCurrentPassword.setForeground(Color.LIGHT_GRAY);

        currentPasstext1 = new JPasswordField(15);
        currentPasstext1.setHorizontalAlignment(JTextField.CENTER);
        currentPasstext1.setBackground(Color.LIGHT_GRAY);
        currentPasstext1.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));

        JLabel EnterNewPassword = new JLabel("Enter New Password ");
        EnterNewPassword.setForeground(Color.LIGHT_GRAY);

        EnterNewPasswordtext = new JPasswordField(15);
        EnterNewPasswordtext.setHorizontalAlignment(JTextField.CENTER);
        EnterNewPasswordtext.setBackground(Color.LIGHT_GRAY);
        EnterNewPasswordtext.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));

        JLabel ConfirmNewPassword = new JLabel("Confirm New Password ");
        ConfirmNewPassword.setForeground(Color.LIGHT_GRAY);

        ConfirmNewPasswordtext = new JPasswordField(15);
        ConfirmNewPasswordtext.setHorizontalAlignment(JTextField.CENTER);
        ConfirmNewPasswordtext.setBackground(Color.LIGHT_GRAY);
        ConfirmNewPasswordtext.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));

        login1 = new JButton("Login");
        login1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dbupdate_Password_Info();
            }

        });

        gbc0.gridx = 0;
        gbc0.gridy = 0;
        Secondpane.add(EnterCurrentPassword, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        Secondpane.add(currentPasstext1, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        Secondpane.add(EnterNewPassword, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 3;
        Secondpane.add(EnterNewPasswordtext, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 4;
        Secondpane.add(ConfirmNewPassword, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 5;
        Secondpane.add(ConfirmNewPasswordtext, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 6;
        Secondpane.add(login1, gbc0);

        centerpane.add(Secondpane, BorderLayout.WEST);

        GrayDashboard.add(centerpane, BorderLayout.CENTER);

        southpane = new JPanel(new GridBagLayout());
        southpane.setBackground(Color.GRAY);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(1, 1, 5, 1);
        JLabel lo = new JLabel("Developed By");
        lo.setForeground(Color.CYAN);
        JLabel lo1 = new JLabel("Ekpedeme Eseme Solomon A.K.A Kapersky");
        lo1.setForeground(Color.LIGHT_GRAY);
        JLabel l = new JLabel("ND 1 Second Semester - 2015; Matrix No.: 2014/NDM/20076/CS; AbiaPoly.");
        l.setForeground(Color.LIGHT_GRAY);
        gbc1.gridy = 0;
        gbc1.gridx = 0;
        southpane.add(lo, gbc1);
        gbc1.gridy = 1;
        gbc1.gridx = 0;
        southpane.add(lo1, gbc1);
        gbc1.gridy = 2;
        gbc1.gridx = 0;
        southpane.add(l, gbc1);
        GrayDashboard.add(southpane, BorderLayout.SOUTH);

        southpane = new JPanel();
        southpane.setBackground(Color.GRAY);
        GrayDashboard.add(southpane, BorderLayout.WEST);

        southpane = new JPanel();
        southpane.setBackground(Color.GRAY);
        GrayDashboard.add(southpane, BorderLayout.EAST);

    }



    public ImageIcon resizeImage1(ImageIcon Path) {
        Image image1 = Path.getImage();
        Image newImage = image1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
    }

    public void Dbupdate_Password_Info() {
        try {
            String user = currentPasstext1.getText();
            String newpass = EnterNewPasswordtext.getText();
            String conPass = ConfirmNewPasswordtext.getText();

            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("select * from admindetails where password = '" + user + "'");
            if (rs.next() || !rs.next() && user.equals(rs.getString("Password"))) {
                rs.updateString("Password", newpass);
                rs.updateRow();
                JOptionPane.showMessageDialog(null, "Password Updated Successfully");
            } else if (!newpass.equals(conPass)) {
                JOptionPane.showMessageDialog(null, "Password Do Not Match");
            } else {
                JOptionPane.showMessageDialog(null, "Current Password Incorrect");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Current Password Incorrect");
        }

    }

    public void Dbload_Details() {
        //String loginText = loginUsernameText.getText();
        try {
            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("select * from admindetails");

            if (rs.next()) {
                usernametext.setText(rs.getString("Username"));
                EmailAddressText.setText(rs.getString("Email Address"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ChangeAdminInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Dbupdate_Info_Details() {
        String user = usernametext.getText();
        String email = EmailAddressText.getText();
        String currentPass = EnterPasswordText.getText();

        try {
            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("select * from admindetails");
            if (rs.next() && currentPass.equals(rs.getString("Password"))) {
                rs.updateString("Username", user);
                rs.updateString("Email Address", email);
                rs.updateRow();
                JOptionPane.showMessageDialog(null, "Updated Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Password Incorrect");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void Dbupdate_Other_Details() {

        try {
            String user = usernametext.getText();
            String email = EmailAddressText.getText();
            String curentpass = EnterPasswordText.getText();
            String loginText = loginUsernameText.getText();

            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("select * from admindetails");
            if (loginText.equalsIgnoreCase(rs.getString("Username"))) {
                usernametext.setText(rs.getString("Username"));
                EmailAddressText.setText(rs.getString("Email Address"));
            }

            if (rs.next() || !rs.next() && curentpass.equals(rs.getString("Password"))) {

                rs.updateString("Username", user);
                rs.updateString("Email Address", email);
                rs.updateRow();
                JOptionPane.showMessageDialog(null, "Password Updated Successfully");

            } /*else if (!newpass.equals(conPass)) {
             JOptionPane.showMessageDialog(null, "Password Do Not Match");
             } else {
             JOptionPane.showMessageDialog(null, "Current Password Incorrect");
             }*/

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Current Password Incorrect");
        }

    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChangeAdminInfo();
//            }
//        });
//
//    }
}
