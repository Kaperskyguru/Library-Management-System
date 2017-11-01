package Librarypackage;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.apache.http.NameValuePair;
import javax.swing.border.LineBorder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Login extends LibraryMgt {

    private JFrame frame;
    private JPanel  GrayDashboard, toppane, centerpane, southpane;
    private JTextField  passwordtext;
    private JLabel key, wrong;
    private JButton login;
    //private Validator v = new Validator();
    private LibraryMgt l = new LibraryMgt();

    public Login() {
        Init();
        allEvents();
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
        GrayDashboard.setBorder(new LineBorder(Color.BLACK, 10));
        GrayDashboard.setBounds(10, 10, 763, 541);
        Dashboard.add(GrayDashboard, BorderLayout.CENTER);

        toppane = new JPanel(new GridBagLayout());
        toppane.setBackground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 1, 1, 1);
        JLabel logo = new JLabel(resizeImage(Logo_icon));
        JLabel logo1 = new JLabel("Departmental Library:");
        logo1.setForeground(Color.MAGENTA);
        JLabel logo2 = new JLabel("Department of computer Science ( CS )");
        logo2.setForeground(Color.WHITE);
        gbc.gridy = 0;
        gbc.gridx = 0;
        toppane.add(logo, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        toppane.add(logo1, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        toppane.add(logo2, gbc);
        GrayDashboard.add(toppane, BorderLayout.NORTH);

        centerpane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.insets = new Insets(3, 3, 3, 3);
        centerpane.setBackground(Color.DARK_GRAY);
        centerpane.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        JLabel username = new JLabel("Username");
        username.setForeground(Color.LIGHT_GRAY);
        JLabel password = new JLabel("Password");
        password.setForeground(Color.LIGHT_GRAY);
        loginUsernameText = new JTextField(15);
        loginUsernameText.setHorizontalAlignment(JTextField.CENTER);
        loginUsernameText.setBackground(Color.LIGHT_GRAY);
        loginUsernameText.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));
        passwordtext = new JPasswordField(15);

        passwordtext.setHorizontalAlignment(JTextField.CENTER);
        passwordtext.setBackground(Color.LIGHT_GRAY);
        passwordtext.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));
        login = new JButton("Login");

        key = new JLabel(resizeImage2(ChangePass_icon));
        key.setVisible(false);
        key.setCursor(new Cursor(Cursor.HAND_CURSOR));

        wrong = new JLabel("Wrong Username & Password !!");
        wrong.setVisible(false);
        wrong.setForeground(Color.CYAN);

        gbc0.gridx = 0;
        gbc0.gridy = 0;
        centerpane.add(wrong, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        centerpane.add(username, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        centerpane.add(loginUsernameText, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 3;
        centerpane.add(password, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 4;
        centerpane.add(passwordtext, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 5;
        centerpane.add(login, gbc0);
        gbc0.gridx = 1;
        gbc0.gridy = 4;
        centerpane.add(key, gbc0);
        GrayDashboard.add(centerpane, BorderLayout.CENTER);

        southpane = new JPanel(new GridBagLayout());
        southpane.setBackground(Color.GRAY);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(1, 1, 5, 1);
        JLabel log = new JLabel("   More Details...     ");
        log.setForeground(Color.LIGHT_GRAY);
        log.setBorder(new LineBorder(Color.LIGHT_GRAY));
        JLabel lo = new JLabel("Develeoped By");
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
        gbc1.gridy = 3;
        gbc1.gridx = 0;
        southpane.add(log, gbc1);
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

    public void login() {
        String name = loginUsernameText.getText().trim().toLowerCase();
        String pass = String.valueOf(passwordtext.getText().trim());
        try {
            String stt = "select Username, Password from admindetails where Username = ? and Password = ?";
            PreparedStatement pre = l.DbConnection().prepareStatement(stt);
            pre.setString(1, name);
            pre.setString(2, pass);
            ResultSet rs1 = pre.executeQuery();
            int count = 0;
            while (rs1.next()) {
                count++;
            }
            if (count == 1) {
                //frame.setVisible(false);
                Dashboard d = new Dashboard();
                frame.dispose();
            } else if (count == 0) {
                wrong.setVisible(true);
                key.setVisible(true);
            }
        } catch (Exception ex) {

            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*
     public static void main(String[] args) {
     EventQueue.invokeLater(new Runnable() {
     public void run() {
     new Login();
     }
     });

 
     }*/
    private void allEvents() {
        key.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //frame.setVisible(false);
                new RecoverDetails();
                frame.dispose();

            }

            public void mouseEntered(MouseEvent e) {
                key.setOpaque(true);
                key.setIcon(resizeImage2(ChangePass_icon));

            }

            public void mouseExited(MouseEvent e) {
                key.setIcon(resizeImage2(ChangePass_icon));
                key.setOpaque(false);

            }

        });

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
              // try {

                // sendToServer();
                // } catch (IOException ex) {
                //  Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                // }
            }

        });

        passwordtext.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if (passwordtext.hasFocus()) {
                    wrong.setVisible(false);
                    key.setVisible(false);
                }
            }
        });

    }

    public void sendToServer() throws IOException {
        try {
            String host = "http://police.app/api/add_convict/";
            final String USER_AGENT = "Mozilla/5.0";

            String username = loginUsernameText.getText();
            String password = passwordtext.getText();

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost post = new HttpPost(host);

            post.setHeader("User_Agent", USER_AGENT);

            ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("Username", username));
            list.add(new BasicNameValuePair("Password", password));
            post.setEntity(new UrlEncodedFormEntity(list));

            HttpResponse response = httpclient.execute(post);
            //String d = response.getStatusLine();

            //HttpResponse re = new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
            //re.
            System.out.println("\nSending 'POST' request to URL : " + host);
            System.out.println("Post parameters : " + list);
            System.out.println("Response Message = ");
//+ d
        } catch (MalformedURLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //url.close();

    }

}
