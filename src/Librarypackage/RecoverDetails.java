package Librarypackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class RecoverDetails extends LibraryMgt {

    private JButton login;
    private JFrame frame;
    private JPanel GrayDashboard, toppane, centerpane, southpane;
    private JTextField emailtext;

    public RecoverDetails() {
        Init();
    }

    public void Init() {

        frame = new JFrame();
        frame.setTitle("Personal LibApp");
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

        toppane = new JPanel(new BorderLayout(255, 100));
        JPanel middletop = new JPanel(new GridBagLayout());
        middletop.setBackground(Color.GRAY);

        toppane.setBackground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 280, 1, 1);
        final JLabel logo = new JLabel(resizeImage(Logo_icon));

        JLabel logo1 = new JLabel("Departmental Library:");

        logo1.setForeground(Color.MAGENTA);
        JLabel logo2 = new JLabel("Department of computer Science ( CS )");
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
        final JLabel logo3 = new JLabel(Close_icon);
        JLabel logo4 = new JLabel("Depar");
        JLabel logo5 = new JLabel("Depar");

        logo3.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                logo3.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

        });

        icons.add(logo3);
        //icons.add(logo4);
        //icons.add(logo5);
        toppane.add(icons, BorderLayout.EAST);
        GrayDashboard.add(toppane, BorderLayout.NORTH);

        centerpane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.insets = new Insets(3, 3, 3, 3);
        centerpane.setBackground(Color.DARK_GRAY);
        centerpane.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        JTextArea username = new JTextArea("\t   This option is use only to recover your forgotten username & password \n"
                + "\tWhen you enter the valid email address, system will send you an email that \n"
                + "\t   contains the username and password, otherwise system will redirect to \n"
                + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tHOME automatically !!");
        username.setBackground(Color.DARK_GRAY);
        username.setForeground(Color.LIGHT_GRAY);
        username.setTabSize(1);
        username.setWrapStyleWord(true);
        username.setEditable(false);
        JLabel password = new JLabel("");
        JLabel usernametext = new JLabel("Enter Your Valid Email Address");
        usernametext.setForeground(Color.green);
        emailtext = new JTextField(30);
        //emailtext.setPreferredSize(new Dimension(50,50));
        emailtext.setHorizontalAlignment(JTextField.CENTER);
        emailtext.setBackground(Color.LIGHT_GRAY);
        emailtext.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));
        login = new JButton("Send");
        login.addActionListener(new ActionListener() {
            @SuppressWarnings("empty-statement")
            public void actionPerformed(ActionEvent e) {

                String username = null;
                String password = null;
                String text = emailtext.getText();

                Validator v = new Validator();
                if (v.EmailValidate(text)) {
                    String[] address = {emailtext.getText()};
                    try {
                        con = DbConnection();
                        st = con.createStatement();
                        ResultSet rs = st.executeQuery("select * from admindetails");
                        if (rs.next()) {
                            username = rs.getString("Username");
                            password = rs.getString("Password");
                            sendMail send = new sendMail();
                            boolean snd = send.sendMail("solomoneseme@gmail.com", "Changeless", "UserName : "
                                    + username + "\n" + " Password : " + password, address);
                            if (snd) {
                                JOptionPane.showMessageDialog(null, "Message Sent Successfully!!!");

                                new Login();
                                frame.dispose();
                            }

                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                        new Login();
                        frame.dispose();

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Email Address");
                }

            }

        });
        JLabel wrong = new JLabel("REMEMBER !!");
        wrong.setForeground(Color.CYAN);
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        centerpane.add(wrong, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        centerpane.add(username, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        centerpane.add(password, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 3;
        centerpane.add(usernametext, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 4;
        gbc0.ipadx = 300;
        //gbc0.weightx = 0.5;
        centerpane.add(emailtext, gbc0);
        GridBagConstraints b = new GridBagConstraints();
        b.gridx = 0;
        b.gridy = 10;

        centerpane.add(login, b);
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

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RecoverDetails();
//            }
//        });
//
//    }
}
