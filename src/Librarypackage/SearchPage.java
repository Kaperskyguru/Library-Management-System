package Librarypackage;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class SearchPage extends LibraryMgt {

    JFrame frame;
    JPanel GrayDashboard, toppane, centerpane, southpane, southpane1;
    JTable table;
    JTextField typeReg;
    JLabel ISBNNoText, BookTitletext, AuthorNametext, AvailableCopiestext, RegNoText, StNameText, yrtext, semtext, contNotext, columNotext;
    JComboBox AvailableANotext;

    // public TableRowSorter<TableModel> sorter;
    public SearchPage() {
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

        });

        JLabel logo4 = new JLabel(Help_icon);
        JLabel logo5 = new JLabel(Close_icon);

        icons.add(logo3);
        icons.add(logo4);
        icons.add(logo5);
        toppane.add(icons, BorderLayout.EAST);
        GrayDashboard.add(toppane, BorderLayout.NORTH);

        centerpane = new JPanel(new BorderLayout());
        //centerpane.setBackground(Color.DARK_GRAY);
        JTabbedPane tab = new JTabbedPane();

        JPanel SearchAccession = new JPanel(new BorderLayout());
        SearchAccession.setBackground(Color.GRAY);
        JLabel RegNo = new JLabel("ISBN No : ");
        RegNo.setForeground(Color.LIGHT_GRAY);
        JLabel RegNo1 = new JLabel("Accession No :     ");
        JLabel StName = new JLabel("Book Title : ");
        StName.setForeground(Color.LIGHT_GRAY);
        JLabel yr = new JLabel("Author Name : ");
        yr.setForeground(Color.LIGHT_GRAY);
        JLabel sem = new JLabel("Bookself No : ");
        sem.setForeground(Color.LIGHT_GRAY);
        JLabel contNo = new JLabel("Row No : ");
        contNo.setForeground(Color.LIGHT_GRAY);

        JLabel columNo = new JLabel("Column No : ");
        columNo.setForeground(Color.LIGHT_GRAY);

        RegNoText = new JLabel();
        RegNoText.setForeground(Color.LIGHT_GRAY);
        StNameText = new JLabel();
        StNameText.setForeground(Color.LIGHT_GRAY);
        yrtext = new JLabel();
        yrtext.setForeground(Color.LIGHT_GRAY);
        semtext = new JLabel();
        semtext.setForeground(Color.LIGHT_GRAY);
        contNotext = new JLabel();
        contNotext.setForeground(Color.LIGHT_GRAY);

        columNotext = new JLabel();
        columNotext.setForeground(Color.LIGHT_GRAY);

        typeReg = new JTextField(16);
        typeReg.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                Dbsearch_By_AccessionNo();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }
        });

        typeReg.setHorizontalAlignment(JTextField.CENTER);
        typeReg.setBackground(Color.WHITE);
        typeReg.setBorder(new LineBorder(Color.WHITE, 6));

        JPanel Details0 = new JPanel(new FlowLayout());
        Details0.setBackground(Color.GRAY);
        Details0.add(RegNo1);
        Details0.add(typeReg);
        SearchAccession.add(Details0, BorderLayout.NORTH);

        JPanel Details = new JPanel(new GridBagLayout());
        GridBagConstraints gbc0_1 = new GridBagConstraints();
        gbc0_1.insets = new Insets(3, 3, 3, 3);
        gbc0_1.fill = GridBagConstraints.HORIZONTAL;
        gbc0_1.weightx = 0.01;
        //gbc0_1.weighty = 0.01;
        // gbc0_1.ipadx = 1;
        // gbc0_1.gridheight = 1;

        Details.setBorder(new LineBorder(Color.GRAY, 10));
        Details.setBackground(Color.DARK_GRAY);
        Details.setForeground(Color.LIGHT_GRAY);
        gbc0_1.fill = GridBagConstraints.HORIZONTAL;
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 0;
        Details.add(RegNo, gbc0_1);
        gbc0_1.fill = GridBagConstraints.HORIZONTAL;
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 1;
        Details.add(StName, gbc0_1);
        gbc0_1.fill = GridBagConstraints.HORIZONTAL;
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 2;
        Details.add(yr, gbc0_1);
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 3;
        Details.add(sem, gbc0_1);
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 4;
        Details.add(contNo, gbc0_1);
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 5;
        Details.add(columNo, gbc0_1);

        gbc0_1.fill = GridBagConstraints.HORIZONTAL;
        gbc0_1.gridx = 1;
        gbc0_1.gridy = 0;
        Details.add(RegNoText, gbc0_1);
        gbc0_1.fill = GridBagConstraints.HORIZONTAL;
        gbc0_1.gridx = 1;
        gbc0_1.gridy = 1;
        Details.add(StNameText, gbc0_1);
        gbc0_1.gridx = 1;
        gbc0_1.gridy = 2;
        gbc0_1.gridwidth = 10;
        gbc0_1.ipadx = 5;
        Details.add(yrtext, gbc0_1);
        gbc0_1.gridx = 1;
        gbc0_1.gridy = 3;
        Details.add(semtext, gbc0_1);
        gbc0_1.gridx = 1;
        gbc0_1.gridy = 4;
        Details.add(contNotext, gbc0_1);

        gbc0_1.gridx = 1;
        gbc0_1.gridy = 5;
        Details.add(columNotext, gbc0_1);
        SearchAccession.add(Details, BorderLayout.CENTER);

        southpane = new JPanel();
        southpane.setBackground(Color.GRAY);
        SearchAccession.add(southpane, BorderLayout.SOUTH);

        tab.addTab("Search By Accession / Call Number", SearchAccession);

        JPanel SeachByISBNNumber = new JPanel(new BorderLayout());
        SeachByISBNNumber.setBackground(Color.DARK_GRAY);

        SeachByISBNNumber.setBackground(Color.GRAY);
        JLabel ISBNNo = new JLabel("ISBN No : ");
        ISBNNo.setForeground(Color.LIGHT_GRAY);
        JLabel AccessionNo = new JLabel("ISBN No :     ");
        JLabel BookTitle = new JLabel("Book Title : ");
        BookTitle.setForeground(Color.LIGHT_GRAY);
        JLabel AuthorName = new JLabel("Author Name : ");
        AuthorName.setForeground(Color.LIGHT_GRAY);
        JLabel AvailableCopies = new JLabel("Total Available Copies : ");
        AvailableCopies.setForeground(Color.LIGHT_GRAY);
        JLabel AvailableANo = new JLabel("Available Accession Numbers : ");
        AvailableANo.setForeground(Color.LIGHT_GRAY);

        ISBNNoText = new JLabel();
        ISBNNoText.setForeground(Color.LIGHT_GRAY);
        BookTitletext = new JLabel();
        BookTitletext.setForeground(Color.LIGHT_GRAY);
        AuthorNametext = new JLabel();
        AuthorNametext.setForeground(Color.LIGHT_GRAY);
        AvailableCopiestext = new JLabel();
        AvailableCopiestext.setForeground(Color.LIGHT_GRAY);

        AvailableANotext = new JComboBox();
        AvailableANotext.setVisible(false);
        AvailableANotext.setForeground(Color.LIGHT_GRAY);

        typeReg1 = new JTextField(16);
        typeReg1.setHorizontalAlignment(JTextField.CENTER);
        typeReg1.setBackground(Color.WHITE);
        typeReg1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                //Dbearch_Method();
                Dbsearch_By_ISBNNo();

            }

            @Override
            public void keyPressed(KeyEvent e) {
                AvailableANotext.removeAllItems();

            }
        });
        typeReg1.setBorder(new LineBorder(Color.WHITE, 6));

        JPanel Details1 = new JPanel(new FlowLayout());
        Details1.setBackground(Color.GRAY);
        Details1.add(AccessionNo);
        Details1.add(typeReg1);
        SeachByISBNNumber.add(Details1, BorderLayout.NORTH);

        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.insets = new Insets(3, 3, 3, 3);

        JPanel Details2 = new JPanel(new GridBagLayout());
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.weightx = 0.01;
        //gbc0_1.weighty = 0.01;
        // gbc0_1.ipadx = 1;
        // gbc0_1.gridheight = 1;

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
        Details2.add(BookTitle, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        Details2.add(AuthorName, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 3;
        Details2.add(AvailableCopies, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 4;
        Details2.add(AvailableANo, gbc0);

        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 0;
        Details2.add(ISBNNoText, gbc0);

        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 1;
        Details2.add(BookTitletext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 2;
        gbc0.gridwidth = 10;
        gbc0.ipadx = 5;
        Details2.add(AuthorNametext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 3;
        Details2.add(AvailableCopiestext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 4;
        Details2.add(AvailableANotext, gbc0);

        SeachByISBNNumber.add(Details2, BorderLayout.CENTER);
        tab.addTab("Seach By ISBN Number", SeachByISBNNumber);

        JPanel SearchByName = new JPanel(new BorderLayout(10, 10));
        SearchByName.setBorder(new LineBorder(Color.GRAY, 10));
        SearchByName.setBackground(Color.GRAY);
        GridBagConstraints gbc0_2 = new GridBagConstraints();
        gbc0_2.insets = new Insets(3, 3, 3, 3);
        JPanel list = new JPanel(new GridBagLayout());
        list.setBackground(Color.GRAY);
        booknametext = new JTextField(50);
        booknametext.setHorizontalAlignment(JTextField.CENTER);
        booknametext.setBackground(Color.WHITE);
        booknametext.setBorder(new LineBorder(Color.WHITE, 6));

        booknametext.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                Dbupdate_Table();

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }
        });

        JLabel bookname = new JLabel("Book Name");
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 0;
        list.add(bookname, gbc0_2);

        gbc0_2.gridx = 2;
        gbc0_2.gridy = 0;
        list.add(booknametext, gbc0_2);

        SearchByName.add(list, BorderLayout.NORTH);

        JPanel tablepane = new JPanel(new BorderLayout());
        tablepane.setBorder(new LineBorder(Color.DARK_GRAY, 10));
        table = new JTable();
        
        // sorter = new TableRowSorter<TableModel>(table.getModel());
        JScrollPane scroll = new JScrollPane();
        // table.setRowSorter(sorter);
        scroll.setViewportView(table);
        tablepane.add(scroll);
        SearchByName.add(tablepane, BorderLayout.CENTER);
        tab.addTab("Search By Name", SearchByName);

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

    public void Dbsearch_By_Book_Title() {
        String text = booknametext.getText();
        if (text.trim().length() == 0) {
//            sorter.setRowFilter(null);
        } else {
            //sorter.setRowFilter(RowFilter.regexFilter(text));
        }
    }

    public void Dbupdate_Table() {
        data = getListOfBooks();
        Vector<String> header = new Vector<String>();

        header.add("Accession");
        header.add("Central Accession");
        header.add("ISBN No");
        header.add("Book Title");
        header.add("Author Name");
        header.add("Edition");
        header.add("Bookshelf");
        header.add("Row");
        header.add("Column");
        table.setModel(new DefaultTableModel(data, header));

    }


    public ImageIcon resizeImage1(ImageIcon Path) {
        Image image1 = Path.getImage();
        Image newImage = image1.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
    }

    public void Dbsearch_By_ISBNNo() {
        try {

            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select * from bookdetails where ISBNNo = ?");
            pre.setString(1, typeReg1.getText());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ISBNNoText.setText(rs.getString("ISBNNo"));
                BookTitletext.setText(rs.getString("BookTitle"));
                AuthorNametext.setText(rs.getString("Author Name"));
                AvailableCopiestext.setText("" + Dbavailable_copy_No());
                AvailableANotext.addItem(rs.getString("AccessionNo"));
                AvailableANotext.setVisible(true);

            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private int Dbavailable_copy_No() {
        int copies = 1;
        try {
            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select * from availablecopy where ISBNNo = ?");
            pre.setString(1, typeReg1.getText());
            ResultSet rs = pre.executeQuery();
            if(rs.next()) {
                copies = rs.getInt("AvailableCopy");
            }
        } catch (Exception ex) {
            Logger.getLogger(SearchPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return copies;
    }



    public void Dbsearch_By_AccessionNo() {
        try {

            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select * from bookdetails where AccessionNo = ?");
            pre.setString(1, typeReg.getText());
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                RegNoText.setText(rs.getString("ISBNNo"));
                StNameText.setText(rs.getString("BookTitle"));
                yrtext.setText(rs.getString("Author Name"));
                semtext.setText(rs.getString("Book Self No"));;
                contNotext.setText(rs.getString("Row No"));
                columNotext.setText(rs.getString("Column No"));

            }

            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SearchPage();
//            }
//        });
//
//    }
    private Vector<Vector<String>> data;
}
