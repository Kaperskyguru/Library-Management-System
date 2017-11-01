package Librarypackage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class BookCollection extends LibraryMgt {

    JFrame frame = new JFrame();

    JTable table;
    JPanel Dashboard, GrayDashboard, toppane, centerpane, southpane, southpane1;
    public JTextField AccessionNoText, ColumnNotext, RowNotext, BookshelfNotext, ISBNNoText, CLAccessiontext, BookTitletext, AuthorNametext, EditionText;
    public JTextField editRowNotext, editColumnNotext, editBookshelfNotext, editEditionText, editAccessionNoText, editISBNNoText, editCLAccessiontext, editBookTitletext, editAuthorNametext;
    Vector<Vector<String>> data;

    public BookCollection() {
        Init();
    }

    public void Init() {

        frame.setSize(900, 600);
        frame.setTitle("Personal LibApp");
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
            //    frame.setVisible(false);
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
        //centerpane.setBackground(Color.DARK_GRAY);
        JTabbedPane tab = new JTabbedPane();

        JPanel AddNewBook = new JPanel(new GridBagLayout());
        AddNewBook.setBackground(Color.GRAY);
        AddNewBook.setBorder(new LineBorder(Color.DARK_GRAY, 10));

        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.insets = new Insets(3, 3, 3, 3);

        JLabel AccessionNo = new JLabel("Accession No : ");
        AccessionNo.setForeground(Color.WHITE);

        JLabel ISBNNo = new JLabel("ISBN No : ");
        ISBNNo.setForeground(Color.WHITE);

        JLabel CLAccession = new JLabel("CL Accession : ");
        CLAccession.setForeground(Color.WHITE);

        JLabel BookTitle = new JLabel("Book Title : ");
        BookTitle.setForeground(Color.WHITE);

        JLabel AuthorName = new JLabel("Author Name : ");
        AuthorName.setForeground(Color.WHITE);

        JLabel Edition = new JLabel("Edition : ");
        Edition.setForeground(Color.WHITE);

        JLabel BookshelfNo = new JLabel("Bookshelf No : ");
        BookshelfNo.setForeground(Color.WHITE);

        JLabel RowNo = new JLabel("Row No : ");
        RowNo.setForeground(Color.WHITE);

        JLabel ColumnNo = new JLabel("Column No : ");
        ColumnNo.setForeground(Color.WHITE);

        AccessionNoText = new JTextField(10);
        AccessionNoText.setHorizontalAlignment(JTextField.CENTER);
        //AccessionNoText.setBackground(Color.WHITE);
        AccessionNoText.setBorder(new LineBorder(Color.WHITE, 1));

        ISBNNoText = new JTextField(10);
        ISBNNoText.setHorizontalAlignment(JTextField.CENTER);
        // ISBNNoText.setBackground(Color.LIGHT_GRAY);
        ISBNNoText.setBorder(new LineBorder(Color.WHITE, 1));

        ISBNNoText.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                BookTitletext.setEnabled(true);
                BookTitletext.setBackground(Color.WHITE);
                BookTitletext.setEditable(true);
                BookTitletext.setText(null);
                BookTitletext.setBorder(new LineBorder(Color.WHITE, 1));
                AuthorNametext.setEnabled(true);
                AuthorNametext.setBackground(Color.WHITE);
                AuthorNametext.setBorder(new LineBorder(Color.WHITE, 1));
                AuthorNametext.setText(null);
                AuthorNametext.setEditable(true);

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //AuthorNametext.setEditable(false);

            }

            @Override
            public void keyReleased(KeyEvent e) {
                DBshow_Book_Details();
                //Dbupdate_Copies();

            }

        });

        CLAccessiontext = new JTextField(10);
        CLAccessiontext.setHorizontalAlignment(JTextField.CENTER);
        //CLAccessiontext.setBackground(Color.LIGHT_GRAY);
        CLAccessiontext.setBorder(new LineBorder(Color.WHITE, 1));

        BookTitletext = new JTextField(15);
        BookTitletext.setHorizontalAlignment(JTextField.CENTER);
        BookTitletext.setEnabled(false);
        BookTitletext.setBackground(Color.LIGHT_GRAY);
        BookTitletext.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));

        AuthorNametext = new JTextField(15);
        AuthorNametext.setHorizontalAlignment(JTextField.CENTER);
        AuthorNametext.setEnabled(false);
        AuthorNametext.setBackground(Color.LIGHT_GRAY);
        AuthorNametext.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));

        EditionText = new JTextField(15);
        EditionText.setHorizontalAlignment(JTextField.CENTER);
        //EditionText.setBackground(Color.LIGHT_GRAY);
        EditionText.setBorder(new LineBorder(Color.WHITE, 1));

        BookshelfNotext = new JTextField(10);
        BookshelfNotext.setHorizontalAlignment(JTextField.CENTER);
        // BookshelfNotext.setBackground(Color.LIGHT_GRAY);
        BookshelfNotext.setBorder(new LineBorder(Color.WHITE, 1));

        RowNotext = new JTextField(10);
        RowNotext.setHorizontalAlignment(JTextField.CENTER);
        //RowNotext.setBackground(Color.LIGHT_GRAY);
        RowNotext.setBorder(new LineBorder(Color.WHITE, 1));

        ColumnNotext = new JTextField(10);
        ColumnNotext.setHorizontalAlignment(JTextField.CENTER);
        //ColumnNotext.setBackground(Color.LIGHT_GRAY);
        ColumnNotext.setBorder(new LineBorder(Color.WHITE, 1));

        JButton Submit = new JButton("Submit");
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                DBadd_Book_Details();
                // Dbupdate_Copies();
            }

        });

        gbc0.gridx = 0;
        gbc0.gridy = 0;
        AddNewBook.add(AccessionNo, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        AddNewBook.add(ISBNNo, gbc0);
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        AddNewBook.add(CLAccession, gbc0);

        gbc0.gridx = 1;
        gbc0.gridy = 0;
        AddNewBook.add(AccessionNoText, gbc0);
        gbc0.gridx = 1;
        gbc0.gridy = 1;
        AddNewBook.add(ISBNNoText, gbc0);
        gbc0.gridx = 1;
        gbc0.gridy = 2;
        //bc0.gridwidth = 10;
        //gbc0.ipadx = 5;
        AddNewBook.add(CLAccessiontext, gbc0);

        gbc0.gridx = 2;
        gbc0.gridy = 0;
        AddNewBook.add(BookTitle, gbc0);
        gbc0.gridx = 2;
        gbc0.gridy = 1;
        AddNewBook.add(AuthorName, gbc0);
        gbc0.gridx = 2;
        gbc0.gridy = 2;
        AddNewBook.add(Edition, gbc0);

        gbc0.gridx = 3;
        gbc0.gridy = 0;
        AddNewBook.add(BookTitletext, gbc0);

        gbc0.gridx = 3;
        gbc0.gridy = 1;
        AddNewBook.add(AuthorNametext, gbc0);
        gbc0.gridx = 3;
        gbc0.gridy = 2;
        AddNewBook.add(EditionText, gbc0);

        gbc0.gridx = 3;
        gbc0.gridy = 5;
        AddNewBook.add(Submit, gbc0);

        gbc0.gridx = 4;
        gbc0.gridy = 0;
        AddNewBook.add(BookshelfNo, gbc0);
        gbc0.gridx = 4;
        gbc0.gridy = 1;
        AddNewBook.add(RowNo, gbc0);
        gbc0.gridx = 4;
        gbc0.gridy = 2;
        AddNewBook.add(ColumnNo, gbc0);

        gbc0.gridx = 5;
        gbc0.gridy = 0;
        AddNewBook.add(BookshelfNotext, gbc0);
        gbc0.gridx = 5;
        gbc0.gridy = 1;
        AddNewBook.add(RowNotext, gbc0);
        gbc0.gridx = 5;
        gbc0.gridy = 2;
        AddNewBook.add(ColumnNotext, gbc0);

        tab.addTab("Add New Book", resizeImage2(BCol_icon), AddNewBook);

        JPanel ListOfBooks = new JPanel(new BorderLayout(10, 10));
        ListOfBooks.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc0_2 = new GridBagConstraints();
        gbc0_2.insets = new Insets(3, 3, 3, 3);
        JPanel list = new JPanel(new GridBagLayout());
        list.setBackground(Color.DARK_GRAY);
        JButton listofbook = new JButton("List of Books ");
        listofbook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dbupdate_Table();
            }

        });

        listofbook.setForeground(Color.WHITE);
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 0;
        list.add(listofbook, gbc0_2);
        ListOfBooks.add(list, BorderLayout.NORTH);

        JPanel tablepane = new JPanel(new BorderLayout());
        tablepane.setBackground(Color.DARK_GRAY);
        tablepane.setBorder(new LineBorder(Color.DARK_GRAY, 10));

        table = new JTable();
        JScrollPane scroll = new JScrollPane();
        table.setEnabled(false);
        scroll.setViewportView(table);
        tablepane.add(scroll, BorderLayout.CENTER);
        ListOfBooks.add(tablepane, BorderLayout.CENTER);
        tab.addTab("List Of Books", resizeImage2(BCol_icon), ListOfBooks);

        JPanel EditBooks = new JPanel(new BorderLayout());

        EditBooks.setBackground(Color.DARK_GRAY);

        gbc0.insets = new Insets(3, 3, 3, 3);
        EditBooks.setBorder(new LineBorder(Color.DARK_GRAY, 10));

        JLabel editAccessionNo = new JLabel("Accession No  :    ");
        editAccessionNo.setForeground(Color.WHITE);

        JLabel editISBNNo = new JLabel("ISBN No : ");
        editISBNNo.setForeground(Color.WHITE);

        JLabel editCLAccession = new JLabel("CL Accession : ");
        editCLAccession.setForeground(Color.WHITE);

        JLabel editBookTitle = new JLabel("Book Title : ");
        editBookTitle.setForeground(Color.WHITE);

        JLabel editAuthorName = new JLabel("Author Name : ");
        editAuthorName.setForeground(Color.WHITE);

        JLabel editEdition = new JLabel("Edition : ");
        editEdition.setForeground(Color.WHITE);

        JLabel editBookshelfNo = new JLabel("Bookshelf No : ");
        editBookshelfNo.setForeground(Color.WHITE);

        JLabel editRowNo = new JLabel("Row No : ");
        editRowNo.setForeground(Color.WHITE);

        JLabel editColumnNo = new JLabel("Column No : ");
        editColumnNo.setForeground(Color.WHITE);

        editAccessionNoText = new JTextField(13);
        editAccessionNoText.setHorizontalAlignment(JTextField.CENTER);
        editAccessionNoText.setBackground(Color.LIGHT_GRAY);
        editAccessionNoText.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        editAccessionNoText.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                Dbdisplay_For_Edit();
            }

        });

        editISBNNoText = new JTextField(10);
        editISBNNoText.setHorizontalAlignment(JTextField.CENTER);
        //editISBNNoText.setBackground(Color.LIGHT_GRAY);
        editISBNNoText.setBorder(new LineBorder(Color.WHITE, 1));

        editCLAccessiontext = new JTextField(10);
        editCLAccessiontext.setHorizontalAlignment(JTextField.CENTER);
        //editCLAccessiontext.setBackground(Color.LIGHT_GRAY);
        editCLAccessiontext.setBorder(new LineBorder(Color.WHITE, 1));

        editBookTitletext = new JTextField(12);
        editBookTitletext.setHorizontalAlignment(JTextField.CENTER);
        //editBookTitletext.setBackground(Color.LIGHT_GRAY);
        editBookTitletext.setBorder(new LineBorder(Color.WHITE, 1));

        editAuthorNametext = new JTextField(12);
        editAuthorNametext.setHorizontalAlignment(JTextField.CENTER);
        //editAuthorNametext.setBackground(Color.LIGHT_GRAY);
        editAuthorNametext.setBorder(new LineBorder(Color.WHITE, 1));

        editEditionText = new JTextField(12);
        editEditionText.setHorizontalAlignment(JTextField.CENTER);
        //editEditionText.setBackground(Color.LIGHT_GRAY);
        editEditionText.setBorder(new LineBorder(Color.WHITE, 1));

        editBookshelfNotext = new JTextField(10);
        editBookshelfNotext.setHorizontalAlignment(JTextField.CENTER);
        //editBookshelfNotext.setBackground(Color.LIGHT_GRAY);
        editBookshelfNotext.setBorder(new LineBorder(Color.WHITE, 1));

        editRowNotext = new JTextField(10);
        editRowNotext.setHorizontalAlignment(JTextField.CENTER);
        // editRowNotext.setBackground(Color.LIGHT_GRAY);
        editRowNotext.setBorder(new LineBorder(Color.WHITE, 1));

        editColumnNotext = new JTextField(10);
        editColumnNotext.setHorizontalAlignment(JTextField.CENTER);
        //editColumnNotext.setBackground(Color.LIGHT_GRAY);
        editColumnNotext.setBorder(new LineBorder(Color.WHITE, 1));
        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dbupdate_Edited_Books();

            }

        });

        JButton remove = new JButton("Remove");
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dbdelete_Book();
            }

        });

        JPanel edits0 = new JPanel();
        edits0.setBackground(Color.GRAY);
        edits0.add(editAccessionNo);
        edits0.add(editAccessionNoText);
        edits0.add(remove);
        EditBooks.add(edits0, BorderLayout.NORTH);

        JPanel edits = new JPanel(new GridBagLayout());
        edits.setBackground(Color.GRAY);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        edits.add(editISBNNo, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        edits.add(editCLAccession, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;

        gbc0.gridx = 1;
        gbc0.gridy = 0;
        edits.add(editISBNNoText, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 1;
        edits.add(editCLAccessiontext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 2;
        gbc0.gridy = 0;
        edits.add(editBookTitle, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 2;
        gbc0.gridy = 1;
        edits.add(editAuthorName, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 2;
        gbc0.gridy = 2;
        edits.add(editEdition, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 3;
        gbc0.gridy = 0;
        edits.add(editBookTitletext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 3;
        gbc0.gridy = 1;
        edits.add(editAuthorNametext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 3;
        gbc0.gridy = 2;
        edits.add(editEditionText, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 3;
        gbc0.gridy = 3;
        edits.add(update, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 4;
        gbc0.gridy = 0;
        edits.add(editBookshelfNo, gbc0);
        gbc0.gridx = 4;
        gbc0.gridy = 1;
        edits.add(editRowNo, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 4;
        gbc0.gridy = 2;
        edits.add(editColumnNo, gbc0);

        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 5;
        gbc0.gridy = 0;
        edits.add(editBookshelfNotext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 5;
        gbc0.gridy = 1;
        edits.add(editRowNotext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 5;
        gbc0.gridy = 2;
        edits.add(editColumnNotext, gbc0);
        EditBooks.add(edits, BorderLayout.CENTER);

        tab.addTab("Edit Books Information", resizeImage2(BCol_icon), EditBooks);

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

    public void DBshow_Book_Details() {
        String Reg = ISBNNoText.getText();
        String DbReg = null;
        String DbReg1 = null;
        try {
            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from bookdetails where ISBNNo = '" + Reg + "'");
            while (rs.next()) {
                DbReg = rs.getString("BookTitle");
                DbReg1 = rs.getString("Author Name");
                if (DbReg.length() != 0 || DbReg1.length() != 0) {
                    BookTitletext.setEditable(false);
                    BookTitletext.setText(rs.getString("BookTitle"));
                    AuthorNametext.setText(rs.getString("Author Name"));
                    BookTitletext.setEnabled(true);
                    BookTitletext.setBackground(Color.GREEN);
                    AuthorNametext.setEnabled(true);
                    AuthorNametext.setBackground(Color.GREEN);
                    AuthorNametext.setBorder(new LineBorder(Color.GREEN, 1));
                    BookTitletext.setBorder(new LineBorder(Color.GREEN, 1));
                } else {
                    BookTitletext.setText(rs.getString("BookTitle"));
                    AuthorNametext.setText(rs.getString("Author Name"));
                    BookTitletext.setEnabled(true);
                    BookTitletext.setBackground(Color.GREEN);
                    AuthorNametext.setEnabled(true);
                    AuthorNametext.setBackground(Color.GREEN);
                    AuthorNametext.setBorder(new LineBorder(Color.GREEN, 1));
                    BookTitletext.setBorder(new LineBorder(Color.GREEN, 1));

                }
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentInformation.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DBadd_Book_Details() {
        //AccessionNoText,ColumnNotext,RowNotext,BookshelfNotext,ISBNNoText,CLAccessiontext,BookTitletext,AuthorNametext,EditionText;

        String name = AccessionNoText.getText();
        String contact = CLAccessiontext.getText();
        String reg = ISBNNoText.getText();
        String year = BookTitletext.getText();
        String semester = AuthorNametext.getText();
        String rowno = RowNotext.getText();
        String ColumnNo = ColumnNotext.getText();
        String bookselfno = BookshelfNotext.getText();
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();
        LinkedList<String> list3 = new LinkedList<String>();
        String DbAccessionNo = null;
        String DbISBNNo = null;
        int i = 0;
        try {
            con = DbConnection();

            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("select * from bookdetails");//
            while (rs.next()) {
                DbAccessionNo = rs.getString("AccessionNo");
                DbISBNNo = rs.getString("ISBNNo");
                list1.add(rs.getString("Book Self No"));
                list2.add(rs.getString("Row No"));
                list3.add(rs.getString("Column No"));

            }
            //if (Integer.parseInt(name) == Integer.parseInt(DbAccessionNo)) {
            if (name.equals(DbAccessionNo)) {
                JOptionPane.showMessageDialog(null, "Use Other Accession No !");
            } else if (name.isEmpty() || contact.isEmpty() || reg.isEmpty() || year.isEmpty() || semester.isEmpty() || rowno.isEmpty() || ColumnNo.isEmpty() || bookselfno.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fields Can Not be Empty !");
            } else if (list1.contains(bookselfno) && list2.contains(rowno) && list3.contains(ColumnNo)) {
                JOptionPane.showMessageDialog(null, "A Book Is Already Found In Book Self No, Row No, Column No");
            } else {
                
                rs.moveToInsertRow();
                rs.updateString("AccessionNo", name);
                rs.updateString("ISBNNo", reg);
                rs.updateString("CL Accession", contact);
                rs.updateString("BookTitle", year);
                rs.updateString("Author Name", semester);
                rs.updateString("Edition", name);
                rs.updateString("Book Self No", bookselfno);
                rs.updateString("Row No", rowno);
                rs.updateString("Column No", ColumnNo);
                rs.insertRow();
                Dbupdate_Copies();

                JOptionPane.showMessageDialog(null, "Book Added successfully !");

            }
        } catch (Exception ex) {
            Logger.getLogger(StudentInformation.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Dbupdate_Copies() {
        String reg = ISBNNoText.getText();
        String accession = AccessionNoText.getText();
        String booktitle = BookTitletext.getText();
        LinkedList<String> lst = new LinkedList<String>();
        try {

            Connection con1 = DbConnection();
            Statement st1 = con1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs1 = st1.executeQuery("select * from availablecopy");
            while (rs1.next()) {
                lst.add(rs1.getString("ISBNNo"));
            }

            rs1.close();
            st1.close();
            con1.close();

            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from availablecopy");
            if (rs.next()) {

                if (lst.contains(reg)) {
                    rs.updateString("AccessionNo", accession);
                    rs.updateString("ISBNNo", reg);
                    rs.updateString("BookTitle", booktitle);
                    rs.updateInt("AvailableCopy", rs.getInt("AvailableCopy") + 1);
                    rs.updateRow();
                    System.out.println("Running first if");
                } else {

                    rs.moveToInsertRow();
                    rs.updateString("AccessionNo", accession);
                    rs.updateString("ISBNNo", reg);
                    rs.updateString("BookTitle", booktitle);
                    rs.updateInt("AvailableCopy", rs.getInt("AvailableCopy") + 1);
                    rs.insertRow();
                    System.out.println("Running first if else");

                }
            } else {

                if (lst.contains(reg)) {
                    if (!rs.next()) {
                        rs.moveToInsertRow();
                        rs.updateString("AccessionNo", accession);
                        rs.updateString("ISBNNo", reg);
                        rs.updateString("BookTitle", booktitle);
                        rs.updateInt("AvailableCopy", rs.getInt("AvailableCopy") + 1);
                        rs.insertRow();
                    } else {
                        //rs.updateString("AccessionNo", accession);
                        rs.updateString("ISBNNo", reg);
                        rs.updateString("BookTitle", booktitle);
                        rs.updateInt("AvailableCopy", rs.getInt("AvailableCopy") + 1);
                        rs.updateRow();
                    }
                } else {

                    rs.moveToInsertRow();
                    rs.updateString("AccessionNo", accession);
                    rs.updateString("ISBNNo", reg);
                    rs.updateString("BookTitle", booktitle);
                    rs.updateInt("AvailableCopy", rs.getInt("AvailableCopy") + 1);
                    rs.insertRow();

                }

            }
        } catch (Exception e) {
            Logger.getLogger(StudentInformation.class
                    .getName()).log(Level.SEVERE, null, e);
        }
    }

    public void Dbupdate_Table() {

        Vector<String> header = new Vector<String>();

        header.add("Accession");
        header.add("ISBN No");
        header.add("Central Accession");
        header.add("Book Title");
        header.add("Author Name");
        header.add("Edition");
        header.add("Bookshelf");
        header.add("Row");
        header.add("Column");
        table.setModel(new DefaultTableModel(getAllListOfBooks(), header));

    }

    public void Dbdisplay_For_Edit() {
        //public JTextField editRowNotext, editColumnNotext, editBookshelfNotext, editEditionText, editAccessionNoText, editISBNNoText, editCLAccessiontext, editBookTitletext, editAuthorNametext;
        String Reg = editAccessionNoText.getText();

        try {
            con = DbConnection();

            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("select * from bookdetails where AccessionNo ='" + Reg + "'");
            while (rs.next()) {
                editISBNNoText.setText(rs.getString("ISBNNo"));
                editCLAccessiontext.setText(rs.getString("CL Accession"));
                editBookTitletext.setText(rs.getString("BookTitle"));
                editAuthorNametext.setText(rs.getString("Author Name"));
                editEditionText.setText(rs.getString("Edition"));
                editBookshelfNotext.setText(rs.getString("Book Self No"));
                editColumnNotext.setText(rs.getString("Row No"));
                editRowNotext.setText(rs.getString("Column No"));

            }

        } catch (Exception ex) {
            Logger.getLogger(StudentInformation.class
                    .getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void Dbdelete_Book() {

        try {
            String text1 = editAccessionNoText.getText();

            con = DbConnection();
            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String stt = "delete from bookdetails where AccessionNo = '" + text1 + "'";
            st.executeUpdate(stt);
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully!");
            con.close();
            st.close();
            editRowNotext.setText(null);
            editColumnNotext.setText(null);
            editBookshelfNotext.setText(null);
            editEditionText.setText(null);
            editAccessionNoText.setText(null);
            editISBNNoText.setText(null);
            editCLAccessiontext.setText(null);
            editBookTitletext.setText(null);
            editAuthorNametext.setText(null);

        } catch (Exception ex) {
            Logger.getLogger(BookCollection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Dbupdate_Edited_Books() {
        String rowno = editRowNotext.getText();
        String colno = editColumnNotext.getText();
        String bookself = editBookshelfNotext.getText();
        String edition = editEditionText.getText();
        //String accession = editAccessionNoText.getText();
        String ISBNno = editISBNNoText.getText();
        String ClAccession = editCLAccessiontext.getText();
        String booktitle = editBookTitletext.getText();
        String authorname = editAuthorNametext.getText();

        try {
            con = DbConnection();

            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("select * from bookdetails");
            if (rs.next()) {
                rs.updateString("ISBNNo", ISBNno);
                rs.updateString("CL Accession", ClAccession);
                rs.updateString("BookTitle", booktitle);
                rs.updateString("Author Name", authorname);
                rs.updateString("Edition", edition);
                rs.updateString("Book Self No", bookself);
                rs.updateString("Row No", rowno);
                rs.updateString("Column No", colno);
                rs.updateRow();
                JOptionPane.showMessageDialog(null, "User Updated successfully!");
                // }

            }
        } catch (Exception ex) {
            Logger.getLogger(StudentInformation.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ImageIcon resizeImage(ImageIcon Path) {
        Image image1 = Path.getImage();
        Image newImage = image1.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
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
//                new BookCollection();
//            }
//        });
//
//    }

}
