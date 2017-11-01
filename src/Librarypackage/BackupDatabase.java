package Librarypackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class BackupDatabase extends LibraryMgt {

    JFrame frame;
    JPanel GrayDashboard, toppane, centerpane, southpane;

    public static String path, user, pass, dbname, mysqlPath;

    String s[];

    public BackupDatabase() {
        Init();
    }

    public BackupDatabase(String user, String pass, String dbname, String mysqlPath) {
        this.user = user;
        this.pass = pass;
        this.dbname = dbname;
        this.mysqlPath = mysqlPath;

        System.out.println(user + pass + dbname + mysqlPath);

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
                //  frame.setVisible(false);
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

        JLabel BrowseLocation = new JLabel("Browse Location");
        BrowseLocation.setForeground(Color.LIGHT_GRAY);

        final JTextField usernametext = new JTextField(30);
        usernametext.setHorizontalAlignment(JTextField.CENTER);
        usernametext.setBackground(Color.LIGHT_GRAY);
        usernametext.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));

        JLabel note = new JLabel("Click 'Browse' to choose where you want to save the Backup file (.sql file) ");
        note.setForeground(Color.GRAY);

        JButton Browse = new JButton("Browse");
        Browse.setHorizontalAlignment(JTextField.CENTER);
        Browse.setBackground(Color.LIGHT_GRAY);
        //Browse.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        Browse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser FileChooser = new JFileChooser("C:\\users\\kapersky\\desktop\\");

                String filename = null;
                FileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int result = FileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        filename = FileChooser.getSelectedFile().getCanonicalPath().toString();
                    } catch (IOException ex) {
                        Logger.getLogger(DbPath.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                usernametext.setText(filename);

            }

        });

        JButton Save = new JButton("Save");
        Save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                backUp(usernametext.getText(), user, pass, dbname, mysqlPath);

            }
        });
        Save.setHorizontalAlignment(JTextField.CENTER);
        // Save.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        Save.setBackground(Color.LIGHT_GRAY);

        JLabel Backup = new JLabel("Backup");
        Backup.setForeground(Color.GRAY);
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        Firstpane.add(BrowseLocation, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        Firstpane.add(usernametext, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        Firstpane.add(note, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 3;
        Firstpane.add(Browse, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 4;
        Firstpane.add(Save, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 5;
        Firstpane.add(Backup, gbc0);

        centerpane.add(Firstpane, BorderLayout.CENTER);

        JPanel Secondpane = new JPanel();
        Secondpane.setBackground(Color.DARK_GRAY);
        JButton Settings = new JButton("Settings");
        Settings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DbPath().setVisible(true);
            }
        });

        Secondpane.add(Settings);

        centerpane.add(Secondpane, BorderLayout.EAST);

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

    public void backUp(String path, String user, String pass, String dbname, String mysqlPath) {
        int processComplete = 1;
        try {

            String filename = path.concat("\\") + dbname + "Backup".concat(".sql");
            File file = new File(filename);
            if (file.exists()) {
                Object option[] = {"Yes", "No"};
                int result = JOptionPane.showOptionDialog(null, "Do you want to replace this file?", "File Exist", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);

                if (result == JOptionPane.YES_OPTION) {
                    String executeCmd = mysqlPath.concat("\\") + "mysqldump.exe -v -v -v --host=localhost --user=" + user + " --port=3306 --protocol=tcp --force --allow-keywords --compress --add-drop-table --result-file=" + filename + " --databases " + dbname;
                    Process backup = Runtime.getRuntime().exec(executeCmd);
                    processComplete = backup.waitFor();
                }

            } else {
                String executeCmd = mysqlPath.concat("\\") + "mysqldump.exe -v -v -v --host=localhost --user=" + user + " --port=3306 --protocol=tcp --force --allow-keywords --compress --add-drop-table --result-file=" + filename + " --databases " + dbname;
                Process backup = Runtime.getRuntime().exec(executeCmd);
                processComplete = backup.waitFor();
            }
            if (processComplete == 0) {
                JOptionPane.showMessageDialog(this.frame, "Backup Successfully!");
            } else {
                JOptionPane.showMessageDialog(this.frame, "Backup failed!", "Failed", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error.!", 2);
        }

    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//
//                new BackupDatabase();
//            }
//        });
//
//    }
}
