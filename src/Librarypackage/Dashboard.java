package Librarypackage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Dashboard extends LibraryMgt {
    
    JFrame frame;
    JPanel GrayDashboard, toppane, centerpane, southpane;
    
    public Dashboard() {
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
        
        GrayDashboard = new JPanel(new BorderLayout(5, 10));
        GrayDashboard.setBackground(Color.GRAY);
        GrayDashboard.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        GrayDashboard.setBounds(10, 10, 763, 541);
        Dashboard.add(GrayDashboard, BorderLayout.CENTER);
        
        toppane = new JPanel(new GridBagLayout());
        toppane.setBackground(Color.GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 1, 1, 1);
        JLabel logo = new JLabel(resizeImage(Logo_icon));
        JLabel logo1 = new JLabel("Departmental Library:");
        logo1.setForeground(Color.MAGENTA);
        JLabel logo2 = new JLabel("Department of Computer Science ( CS ):");
        logo2.setFont(new Font("Times New Roman", Font.PLAIN, 28));
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
        gbc0.weightx = 0.01;
        centerpane.setBackground(Color.LIGHT_GRAY);
        centerpane.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        final JLabel StudentsInfo = new JLabel(StudentsInfo_icon);
        StudentsInfo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new StudentInformation();
                frame.dispose();

            }
            
            public void mouseEntered(MouseEvent e) {
                StudentsInfo.setIcon(StudentsInfoHover_icon);
                
            }
            
            public void mouseExited(MouseEvent e) {
                StudentsInfo.setIcon(StudentsInfo_icon);
                
            }
            
        });
        StudentsInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JTextArea st = new JTextArea(" Student's \nInformation");
        JTextArea st1 = new JTextArea("Collection \n of Books");
        JTextArea st2 = new JTextArea("Search \n Books");
        JTextArea st3 = new JTextArea("Borrow" + "\n" + " Books");
        JTextArea st4 = new JTextArea("Change" + "\n" + " Admin Info");
        JTextArea st5 = new JTextArea("Backup" + "\n" + " Database");
        JTextArea st6 = new JTextArea("Generate" + "\n" + " Report");
        st.setEditable(false);
        st.setBackground(Color.LIGHT_GRAY);
        st1.setEditable(false);
        st1.setBackground(Color.LIGHT_GRAY);
        st2.setEditable(false);
        st2.setBackground(Color.LIGHT_GRAY);
        st3.setEditable(false);
        st3.setBackground(Color.LIGHT_GRAY);
        st4.setEditable(false);
        st4.setBackground(Color.LIGHT_GRAY);
        st5.setEditable(false);
        st5.setBackground(Color.LIGHT_GRAY);
        st6.setEditable(false);
        st6.setBackground(Color.LIGHT_GRAY);
        
        final JLabel se1 = new JLabel(BCol_icon);
        se1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new BookCollection();
              frame.dispose();

            }
            
            public void mouseEntered(MouseEvent e) {
                se1.setIcon(BColHover_icon);
                
            }
            
            public void mouseExited(MouseEvent e) {
                se1.setIcon(BCol_icon);
                
            }
            
        });
        final JLabel se2 = new JLabel(search_icon);
        
        se2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new SearchPage();
                frame.dispose();

            }
            
            public void mouseEntered(MouseEvent e) {
                se2.setIcon(searchHover_icon);
                
            }
            
            public void mouseExited(MouseEvent e) {
                se2.setIcon(search_icon);
                
            }
            
        });
        
        final JLabel se3 = new JLabel(BorrowBook_icon);
        
        se3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new BorrowBooks();
                frame.dispose();

            }
            
            public void mouseEntered(MouseEvent e) {
                se3.setIcon(BorrowBookHover_icon);
                
            }
            
            public void mouseExited(MouseEvent e) {
                se3.setIcon(BorrowBook_icon);
                
            }
            
        });
        
        final JLabel se4 = new JLabel(ChangePass_icon);
        
        se4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new ChangeAdminInfo();
                frame.dispose();

            }
            
            public void mouseEntered(MouseEvent e) {
                se4.setIcon(ChangePassHover_icon);
                
            }
            
            public void mouseExited(MouseEvent e) {
                se4.setIcon(ChangePass_icon);
                
            }
            
        });
        
        final JLabel se5 = new JLabel(BackUpDb_icon);
        
        se5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new BackupDatabase();
               frame.dispose();

            }
            
            public void mouseEntered(MouseEvent e) {
                se5.setIcon(BackUpDbHover_icon);
                
            }
            
            public void mouseExited(MouseEvent e) {
                se5.setIcon(BackUpDb_icon);
                
            }
            
        });
        
        final JLabel se6 = new JLabel(Greport_icon);
        
        se6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new GenerateReport();
                frame.dispose();

            }
            
            public void mouseEntered(MouseEvent e) {
                se6.setIcon(GreportHover_icon);
                
            }
            
            public void mouseExited(MouseEvent e) {
                se6.setIcon(Greport_icon);
                
            }
            
        });
        
        se1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        se2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        se3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        se4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        se5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        se6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        centerpane.add(StudentsInfo, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        centerpane.add(st, gbc0);
        gbc0.gridx = 1;
        gbc0.gridy = 0;
        centerpane.add(se1, gbc0);
        gbc0.gridx = 1;
        gbc0.gridy = 1;
        centerpane.add(st1, gbc0);
        gbc0.gridx = 2;
        gbc0.gridy = 0;
        centerpane.add(se2, gbc0);
        gbc0.gridx = 2;
        gbc0.gridy = 1;
        centerpane.add(st2, gbc0);
        gbc0.gridx = 3;
        gbc0.gridy = 0;
        centerpane.add(se3, gbc0);
        gbc0.gridx = 3;
        gbc0.gridy = 1;
        centerpane.add(st3, gbc0);
        gbc0.gridx = 4;
        gbc0.gridy = 0;
        centerpane.add(se4, gbc0);
        gbc0.gridx = 4;
        gbc0.gridy = 1;
        centerpane.add(st4, gbc0);
        gbc0.gridx = 5;
        gbc0.gridy = 0;
        centerpane.add(se5, gbc0);
        gbc0.gridx = 5;
        gbc0.gridy = 1;
        centerpane.add(st5, gbc0);
        gbc0.gridx = 6;
        gbc0.gridy = 0;
        centerpane.add(se6, gbc0);
        gbc0.gridx = 6;
        gbc0.gridy = 1;
        centerpane.add(st6, gbc0);
        GrayDashboard.add(centerpane, BorderLayout.CENTER);
        
        southpane = new JPanel(new GridBagLayout());
        southpane.setBackground(Color.GRAY);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(1, 1, 5, 1);
        final JLabel log = new JLabel(Close_icon);
        log.setCursor(new Cursor(Cursor.HAND_CURSOR));
        log.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
                
            }
            
            public void mouseEntered(MouseEvent e) {
                log.setOpaque(true);
                log.setIcon(Close_icon);
                
            }
            
            public void mouseExited(MouseEvent e) {
                log.setIcon(Close_icon);
                log.setOpaque(false);
                
            }
            
        }
        );
        
        JLabel lo = new JLabel("Develeoped By");
        lo.setForeground(Color.LIGHT_GRAY);
        JLabel lo1 = new JLabel("Ekpedeme Eseme Solomon A.K.A Kapersky");
        lo1.setForeground(Color.LIGHT_GRAY);
        JLabel l = new JLabel("ND 1 Second Semester - 2015; Matrix No.: 2014/NDM/20076/CS; AbiaPoly.");
        l.setForeground(Color.LIGHT_GRAY);
        gbc1.gridy = 0;
        gbc1.gridx = 0;
        southpane.add(log, gbc1);
        gbc1.gridy = 1;
        gbc1.gridx = 0;
        southpane.add(lo, gbc1);
        gbc1.gridy = 2;
        gbc1.gridx = 0;
        southpane.add(lo1, gbc1);
        gbc1.gridy = 3;
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
//                new Dashboard();
//            }
//        });
//        
//    }
}
