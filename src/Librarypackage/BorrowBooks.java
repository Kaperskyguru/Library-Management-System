package Librarypackage;

import static Librarypackage.LibraryMgt.con;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class BorrowBooks extends LibraryMgt {

    JFrame frame;
    JPanel GrayDashboard, toppane, centerpane, southpane, southpane1;
    JTable table, table1;
    JTextField typeReg, nametext, Accessiontext, typeReg2;
    JComboBox yeartext, semestertext;
    JButton Ac, retur;
    //public JLabel notOk = new JLabel();
    int mouseX;
    int mouseY;

    public BorrowBooks() {
        Init();
    }

    public void Init() {

        frame = new JFrame();
        frame.setTitle("Personal LibApp");
        //frame.setUndecorated(true);
        frame.setSize(frame.getX() + 900, frame.getY() + 600);
        //frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dashboard = new JPanel(new BorderLayout());

        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();

            }

            public void mouseDragged(MouseEvent e) {

            }
        });

        frame.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                frame.setLocation(x - mouseX, y - mouseY);
            }

            public void mouseMoved(MouseEvent e) {
            }
        });

        Dashboard.setBackground(Color.GRAY);
        Dashboard.setBorder(new LineBorder(Color.WHITE, 10));
        frame.add(Dashboard, BorderLayout.CENTER);

        GrayDashboard = new JPanel(new BorderLayout(50, 10));
        GrayDashboard.setBackground(Color.GRAY);
        GrayDashboard.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        GrayDashboard.setBounds(10, 10, 763, 541);
        Dashboard.add(GrayDashboard, BorderLayout.CENTER);

        toppane = new JPanel(new BorderLayout(1, 10));
        toppane.setBackground(Color.GRAY);
        JPanel middletop = new JPanel(new GridBagLayout());
        middletop.setBackground(Color.GRAY);

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
        logo5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logo5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);

            }
        });

        icons.add(logo3);
        icons.add(logo4);
        icons.add(logo5);
        toppane.add(icons, BorderLayout.EAST);
        GrayDashboard.add(toppane, BorderLayout.NORTH);

        centerpane = new JPanel(new BorderLayout());
        JTabbedPane tab = new JTabbedPane();

        JPanel BorrowBook = new JPanel(new BorderLayout());
        BorrowBook.setBackground(Color.GRAY);

        JPanel Regpane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc0_1 = new GridBagConstraints();

        gbc0_1.insets = new Insets(0, 4, 1, 4);
        gbc0_1.fill = GridBagConstraints.HORIZONTAL;
        gbc0_1.weighty = 0.01;

        GridBagConstraints gbc0_3 = new GridBagConstraints();
        gbc0_3.insets = new Insets(0, 4, 1, 4);
        gbc0_3.fill = GridBagConstraints.HORIZONTAL;
        gbc0_3.weightx = 0.01;

        JLabel RegNo1 = new JLabel("Rgistration No :     ");
        gbc0_3.gridx = 0;
        gbc0_3.gridy = 0;
        Regpane.add(RegNo1, gbc0_3);
        Regpane.setBackground(Color.GRAY);
        Regpane.setBorder(new LineBorder(Color.DARK_GRAY, 8));

        typeReg = new JTextField(8);
        typeReg.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                Dbupdate_Info();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }
        });

        typeReg.setHorizontalAlignment(JTextField.CENTER);
        typeReg.setBackground(Color.WHITE);
        typeReg.setBorder(new LineBorder(Color.WHITE, 3));
        gbc0_3.gridx = 0;
        gbc0_3.gridy = 1;
        Regpane.add(typeReg, gbc0_3);

        JPanel AutoPane = new JPanel(new GridBagLayout());
        AutoPane.setBackground(Color.GRAY);
        AutoPane.setBorder(new LineBorder(Color.DARK_GRAY, 8));
        JLabel text = new JLabel("Automatically Fill Up :     ");
        text.setForeground(Color.LIGHT_GRAY);
        JLabel name = new JLabel("Name : ");
        name.setForeground(Color.LIGHT_GRAY);
        JLabel year = new JLabel("Year :     ");
        year.setForeground(Color.LIGHT_GRAY);
        JLabel semester = new JLabel("Semester : ");
        semester.setForeground(Color.LIGHT_GRAY);

        nametext = new JTextField(5);
        nametext.setHorizontalAlignment(JTextField.CENTER);
        nametext.setBackground(Color.WHITE);
        nametext.setBorder(new LineBorder(Color.WHITE, 3));

        yeartext = new JComboBox();
        yeartext.setBackground(Color.WHITE);

        semestertext = new JComboBox();
        semestertext.setBackground(Color.WHITE);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 0;
        AutoPane.add(text, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 1;
        AutoPane.add(name, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 2;
        AutoPane.add(nametext, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 3;
        AutoPane.add(year, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 4;
        AutoPane.add(yeartext, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 5;
        AutoPane.add(semester, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 6;
        AutoPane.add(semestertext, gbc0_1);

        JPanel AccessPanemain = new JPanel(new BorderLayout(70, 10));
        JPanel AccessPane = new JPanel(new FlowLayout());
        JLabel RegNo3 = new JLabel("Accession No :     ");
        RegNo3.setForeground(Color.GRAY);
        AccessPane.add(RegNo3);
        JLabel RegNo4 = new JLabel("Accession No :     ");
        RegNo4.setForeground(Color.GRAY);
        AccessPane.add(RegNo4);
        JLabel RegN3 = new JLabel("Accession No :     ");
        RegN3.setForeground(Color.GRAY);
        AccessPane.add(RegN3);
        JLabel RegNo5 = new JLabel("Accession No :     ");
        RegNo5.setForeground(Color.GRAY);
        AccessPane.add(RegNo5);
        AccessPanemain.add(AccessPane, BorderLayout.NORTH);

        JPanel AccessPane1 = new JPanel(new GridBagLayout());

        JLabel Accession = new JLabel("Accession No :     ");
        Accession.setForeground(Color.LIGHT_GRAY);
        JLabel A = new JLabel("Accession No :     ");

        Ac = new JButton("Accession No :     ");
        Ac.setEnabled(false);
        Ac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Dbborrow_Book();

            }

        });
        Accessiontext = new JTextField(10);
        Accessiontext.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                Ac.setEnabled(false);
            }

            public void keyReleased(KeyEvent e) {
                DBenable_button();
                //Dbupdate_Copies();

            }

        });
        Accessiontext.setHorizontalAlignment(JTextField.CENTER);
        Accessiontext.setBackground(Color.WHITE);
        Accessiontext.setBorder(new LineBorder(Color.WHITE, 3));

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 0;
        AccessPane1.add(Accession, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 1;
        AccessPane1.add(Accessiontext, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 2;
        AccessPane1.add(A, gbc0_1);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 3;
        AccessPane1.add(Ac, gbc0_1);

        southpane = new JPanel();
        southpane.setBackground(Color.GRAY);
        AccessPanemain.add(southpane, BorderLayout.EAST);

        southpane = new JPanel();
        southpane.setBackground(Color.GRAY);
        AccessPanemain.add(southpane, BorderLayout.WEST);

        AccessPane.setBackground(Color.GRAY);
        AccessPane1.setBackground(Color.GRAY);
        AccessPanemain.setBackground(Color.GRAY);
        AccessPanemain.setBorder(new LineBorder(Color.DARK_GRAY, 8));
        AccessPanemain.add(AccessPane1, BorderLayout.CENTER);
        BorrowBook.add(Regpane, BorderLayout.WEST);

        BorrowBook.add(AutoPane, BorderLayout.CENTER);
        BorrowBook.add(AccessPanemain, BorderLayout.EAST);

        tab.addTab("Borrow Book", BorrowBook);

        JPanel BorrowersLists = new JPanel(new BorderLayout(10, 10));
        BorrowersLists.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        BorrowersLists.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc0_2 = new GridBagConstraints();
        gbc0_2.insets = new Insets(3, 3, 3, 3);
        JPanel list = new JPanel(new GridBagLayout());
        list.setBackground(Color.DARK_GRAY);

        JButton listofbook = new JButton("Borrower's List ");
        listofbook.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Dbupdate_Table();

            }
        });
        listofbook.setForeground(Color.LIGHT_GRAY);
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 0;
        list.add(listofbook, gbc0_2);

        BorrowersLists.add(list, BorderLayout.NORTH);

        JPanel tablepane = new JPanel(new BorderLayout());
        tablepane.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{/*{null, null, null, null, null, null}*/}, new String[]{
            "Registration",
            "Name",
            "Year",
            "Semester",
            "Accession No",
            "ISBN No",
            "Date",
            "Time",}
        ));

        JScrollPane scroll1 = new JScrollPane();
        scroll1.setViewportView(table);
        tablepane.add(scroll1);
        BorrowersLists.add(tablepane, BorderLayout.CENTER);
        tab.addTab("Borrower's Lists", BorrowersLists);

        JPanel ReturnBook = new JPanel(new BorderLayout(10, 10));
        ReturnBook.setBackground(Color.DARK_GRAY);
        ReturnBook.setBorder(new LineBorder(Color.DARK_GRAY, 10));

        ReturnBook.setBackground(Color.DARK_GRAY);
        JLabel ISBNNo = new JLabel("Registration No : ");
        ISBNNo.setForeground(Color.LIGHT_GRAY);
        JLabel AccessionNo = new JLabel("Accession No :     ");
        AccessionNo.setForeground(Color.LIGHT_GRAY);

        typeReg1 = new JTextField(16);
        typeReg1.setHorizontalAlignment(JTextField.CENTER);
        typeReg1.setBackground(Color.WHITE);
        typeReg1.setBorder(new LineBorder(Color.WHITE, 6));
        typeReg1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                Dbdisplay_Books_Borrowed();
            }

            public void keyTyped(KeyEvent e) {

            }
        });

        typeReg2 = new JTextField(16);
        typeReg2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                retur.setEnabled(false);
            }

            public void keyReleased(KeyEvent e) {
                DBenable_Return_button();
                //Dbupdate_Copies();

            }

        });
        typeReg2.setHorizontalAlignment(JTextField.CENTER);
        typeReg2.setBackground(Color.WHITE);
        typeReg2.setBorder(new LineBorder(Color.WHITE, 6));

        retur = new JButton("Return");
        retur.setEnabled(false);
        retur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dbreturn_Borrowed_Books();
                Dbupdate_Available_Copies("add");

            }

        });

        JPanel Details = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Details.setBackground(Color.DARK_GRAY);
        table1 = new JTable();
        table1.setModel(new DefaultTableModel(new Object[][]{/*{null, null, null, null, null, null}*/}, new String[]{ //"Accession No",
        //"Date",
        //"Time",
        }
        ));

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table1);
        Details.add(scroll);
        ReturnBook.add(Details, BorderLayout.CENTER);

        JPanel Details2 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.insets = new Insets(3, 3, 3, 3);

        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.weightx = 0.01;
        gbc0_1.weighty = 0.01;

        Details2.setBorder(new LineBorder(Color.GRAY, 10));
        Details2.setBackground(Color.DARK_GRAY);
        Details2.setForeground(Color.LIGHT_GRAY);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        Details2.add(ISBNNo, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        Details2.add(typeReg1, gbc0);

        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        Details2.add(AccessionNo, gbc0);

        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 0;
        gbc0.gridy = 3;
        Details2.add(typeReg2, gbc0);

        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 0;
        gbc0.gridy = 4;
        Details2.add(retur, gbc0);

        ReturnBook.add(Details2, BorderLayout.WEST);
        tab.addTab("Return books", ReturnBook);

        centerpane.add(tab);
        centerpane.setBackground(Color.GRAY);
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

    public void Dbupdate_Table() {

        Vector<String> header = new Vector<String>();
        header.add("Registration");
        header.add("Name");
        header.add("Year");
        header.add("Semester");
        header.add("Accession No");
        header.add("ISBN No");
        header.add("Date");
        header.add("Time");
        table.setModel(new DefaultTableModel(getListOfBorowersBooks(), header));
    }

    public void Dbupdate_Info() {
        try {
            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select * from studentdetails where RegNo = ?");
            pre.setString(1, typeReg.getText().toString());
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {

                nametext.setText(rs.getString("Student Name"));
                semestertext.addItem(rs.getString("Year"));
                yeartext.addItem(rs.getString("Semester"));

            }
            if (con != null) {
                con.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(BorrowBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Dbborrow_Book() {
        String regno = typeReg.getText();
        String name = nametext.getText();
        String year = yeartext.getItemAt(0).toString();
        String semester = semestertext.getSelectedItem().toString();
        String accession = Accessiontext.getText();

        try {

            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery("select * from borowersdb");

            //if (rs.next()) {
            rs.moveToInsertRow();
            rs.updateString("Registration", regno);
            rs.updateString("Name", name);
            rs.updateString("Year", year);
            rs.updateString("Semester", semester);
            rs.updateString("AccessionNo", accession);
            rs.updateString("ISBNNo", getISBNno());
            rs.updateString("Date", getDate());
            rs.updateString("Time", getTime());
            rs.insertRow();
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            //}
            Dbupdate_Available_Copies("sub");
        } catch (Exception e) {
            Logger.getLogger(BorrowBooks.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void Dbreturn_Borrowed_Books() {
        String text1 = typeReg1.getText();
        String text = typeReg2.getText();
        try {
            con = DbConnection();
            st = con.createStatement();
            st.executeUpdate("delete from borowersdb where AccessionNo = '" + text + "' and Registration = '" + text1 + "'");
            JOptionPane.showMessageDialog(null, "Book Return Successfully!");
            st.close();
            con.close();
            Dbdisplay_Books_Borrowed();
        } catch (Exception ex) {
            Logger.getLogger(BorrowBooks.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Dbdisplay_Books_Borrowed() {

        Vector<String> header = new Vector<String>();
        header.add("Accession No");
        header.add("Date");
        header.add("Time");
        table1.setModel(new DefaultTableModel(Dbdisplay_Book_Borrowed(), header));

    }

    public String getISBNno() {
        String ISBNNo = null;
        try {
            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select ISBNNo from bookdetails where AccessionNo = ?");
            pre.setString(1, Accessiontext.getText().toString());
            final ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ISBNNo = rs.getString("ISBNNo");
            }

        } catch (Exception ex) {
            Logger.getLogger(BorrowBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ISBNNo;
    }

    public String getBookTitle() {
        String Booktitle = null;
        try {
            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select BookTitle from bookdetails where AccessionNo = ?");
            pre.setString(1, Accessiontext.getText().toString());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Booktitle = rs.getString("BookTitle");
            }

        } catch (Exception ex) {
            Logger.getLogger(BorrowBooks.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Booktitle;
    }

    public String getDate() {

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        String date = "" + day + "/" + month + "/" + year + "";
        return date;

    }

    public String getTime() {
        Date date = new Date();
        String d = date.toString();
        String pm;
        Calendar cal = new GregorianCalendar();
        int hour = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int day = cal.get(Calendar.AM_PM);
        if (day == 1) {
            pm = "PM";
        } else {
            pm = "AM";
        }

        String y = d.substring(0, 3);

        String Time = "" + y + " at " + hour + ":" + min + ":" + sec + " " + pm + "";
        return Time;

    }

    public ImageIcon resizeImage1(ImageIcon Path) {
        Image image1 = Path.getImage();
        Image newImage = image1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowBooks();
            }
        });

    }
    public void Dbupdate_Available_Copies(String text) {
        String reg = Accessiontext.getText();
        String access = typeReg2.getText();
        int copies = 0;
        LinkedList<String> list = new LinkedList<String>();
        try {
            Connection con0 = DbConnection();
            Statement st0 = con0.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs0 = st0.executeQuery("select * from availablecopy where AccessionNo= '" + reg + "'");
            while (rs0.next()) {
                copies = rs0.getInt("AvailableCopy");
                list.add(rs0.getString("ISBNNo"));
            }
            switch (text) {
                case "sub":
                    if (rs0.next() || rs0.last()) {
                        if (copies >= 2) {
                            rs0.updateInt("AvailableCopy", rs0.getInt("AvailableCopy") - 1);
                            rs0.updateRow();
                        } else {
                            rs0.deleteRow();
                        }
                    }
                    break;
                case "add":
                    if (rs0.next() || rs0.last()) {

                        //}
                        if (copies >= 1 && list.contains(getISBNno())) {
                            rs0.updateInt("AvailableCopy", rs0.getInt("AvailableCopy") + 1);
                            rs0.updateRow();
                        } else {
                            rs0.moveToInsertRow();
                            rs0.updateString("AccessionNo", access);
                            rs0.updateString("ISBNNo", getISBNno());
                            rs0.updateString("BookTitle", getBookTitle());
                            rs0.updateInt("AvailableCopy", rs0.getInt("AvailableCopy") + 1);
                            rs0.insertRow();
                        }

                    } else {
                        if (rs0.next() || !(rs0.next())) {
                            if (copies >= 1 && list.contains(getISBNno())) {
                                rs0.updateInt("AvailableCopy", rs0.getInt("AvailableCopy") + 1);
                                rs0.updateRow();
                            } else {
                                rs0.moveToInsertRow();
                                rs0.updateString("AccessionNo", access);
                                rs0.updateString("ISBNNo", getISBNno());
                                rs0.updateString("BookTitle", getBookTitle());
                                rs0.updateInt("AvailableCopy", rs0.getInt("AvailableCopy") + 1);
                                rs0.insertRow();
                            }

                        }
                    }
                    break;

            }
            rs0.close();
            st0.close();
            con0.close();
        } catch (Exception e) {
            Logger.getLogger(StudentInformation.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void DBenable_button() {
        String Reg = Accessiontext.getText();
        String aces = typeReg.getText();

        try {
            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from bookdetails where AccessionNo = '" + Reg + "'");
            if (!aces.isEmpty() && rs.next()) {
                Ac.setEnabled(true);
            } else if (aces.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Registration Number Cant be Empty !!!");
            } else if (nametext.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Registration Number is not correct !!!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    public void DBenable_Return_button() {
        String Reg = typeReg2.getText();

        try {
            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from bookdetails where AccessionNo = '" + Reg + "'");
            while (rs.next()) {
                retur.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
}
