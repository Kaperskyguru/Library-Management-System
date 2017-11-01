package Librarypackage;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.view.JasperViewer;

public class GenerateReport extends LibraryMgt {

    JFrame frame;
    JTable table;
    JPanel GrayDashboard, toppane, centerpane, southpane, southpane1;

    public GenerateReport() {
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
        //centerpane.setBackground(Color.DARK_GRAY);
        JTabbedPane tab = new JTabbedPane();

        JPanel AddNewBook = new JPanel(new GridBagLayout());
        AddNewBook.setBackground(Color.GRAY);
        AddNewBook.setBorder(new LineBorder(Color.DARK_GRAY, 10));

        GridBagConstraints gbc0 = new GridBagConstraints();
        gbc0.insets = new Insets(20, 10, 3, 3);
        gbc0.gridwidth = 3;
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.fill = GridBagConstraints.VERTICAL;

        JLabel ISBNNo = new JLabel("ISBNNo : ");
        ISBNNo.setForeground(Color.WHITE);

        JLabel Year = new JLabel("Year : ");
        Year.setForeground(Color.WHITE);

        final JLabel GenerateReport1 = new JLabel("Generate Selected Student's Information : ");
        GenerateReport1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        GenerateReport1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        // GenerateReport.setHorizontalAlignment(Alignment.CENTER);
        GenerateReport1.setForeground(Color.WHITE);

        GenerateReport1.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                GenerateReport1.setBorder(new LineBorder(Color.CYAN, 1));

            }

            public void mouseClicked(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
                GenerateReport1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
            }

        });

        final JLabel YearReport = new JLabel("Generate report on All Student's Information : ");
        YearReport.setForeground(Color.WHITE);
        YearReport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        YearReport.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));

        YearReport.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                YearReport.setBorder(new LineBorder(Color.CYAN, 1));

            }

            public void mouseClicked(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
                YearReport.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
            }

        });

        JComboBox ISBNNoText = new JComboBox();
        ISBNNoText.addItem("1st Semester");
        ISBNNoText.addItem("2nd Semester");
        //AccessionNoText.setBackground(Color.WHITE);
        ISBNNoText.setBorder(new LineBorder(Color.WHITE, 1));

        JComboBox YearText = new JComboBox();
        for (int i = 2016; i >= 2010; i--) {
            YearText.addItem(i);
        }
        // ISBNNoText.setBackground(Color.LIGHT_GRAY);
        YearText.setBorder(new LineBorder(Color.WHITE, 1));

        gbc0.fill = GridBagConstraints.BOTH;
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        AddNewBook.add(ISBNNo, gbc0);

        gbc0.fill = GridBagConstraints.BOTH;
        gbc0.gridx = 5;
        gbc0.gridy = 0;
        gbc0.ipadx = 1;
        //gbc0.gridwidth = 2;
        AddNewBook.add(ISBNNoText, gbc0);

        gbc0.fill = GridBagConstraints.BOTH;
        gbc0.gridx = 8;
        gbc0.gridy = 0;
        AddNewBook.add(Year, gbc0);

        gbc0.fill = GridBagConstraints.CENTER;
        gbc0.gridx = 9;
        gbc0.gridy = 0;
        //gbc0.ipadx = 1;
        gbc0.gridwidth = 0;
        AddNewBook.add(YearText, gbc0);

        //gbc0.fill = GridBagConstraints.BOTH;
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        gbc0.ipady = 2;
        gbc0.gridwidth = 9;
        AddNewBook.add(GenerateReport1, gbc0);

        gbc0.fill = GridBagConstraints.BOTH;
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        gbc0.ipady = 2;
        AddNewBook.add(YearReport, gbc0);

        tab.addTab("Students Information", AddNewBook);

//-----------------------------------------------------------------------------------------------------------------------------
        JPanel ListOfBooks = new JPanel(new GridBagLayout());
        ListOfBooks.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc0_1 = new GridBagConstraints();
        gbc0_1.insets = new Insets(10, 10, 10, 10);
        gbc0_1.gridwidth = 1;
        gbc0_1.fill = GridBagConstraints.HORIZONTAL;
        gbc0_1.fill = GridBagConstraints.VERTICAL;

        JLabel ISBNno = new JLabel("ISBN No : ");
        ISBNno.setForeground(Color.WHITE);

        JLabel Bookself = new JLabel("BookSelf No : ");
        Bookself.setForeground(Color.WHITE);

        final JLabel Generatereport = new JLabel("Generate report on books using Selected ISBN No: ");
        Generatereport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Generatereport.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        // GenerateReport.setHorizontalAlignment(Alignment.CENTER);
        Generatereport.setForeground(Color.WHITE);

        Generatereport.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                Generatereport.setBorder(new LineBorder(Color.CYAN, 1));

            }

            public void mouseClicked(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
                Generatereport.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
            }

        });

        final JLabel BookselfReport = new JLabel("Generate report on books using Selected BookSelf No : ");
        BookselfReport.setForeground(Color.WHITE);
        BookselfReport.setCursor(new Cursor(Cursor.HAND_CURSOR));
        BookselfReport.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));

        BookselfReport.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                BookselfReport.setBorder(new LineBorder(Color.CYAN, 1));

            }

            public void mouseClicked(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
                BookselfReport.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
            }

        });

        final JLabel GenerateBooks = new JLabel("Click here to generate information about books: ");
        GenerateBooks.setCursor(new Cursor(Cursor.HAND_CURSOR));
        GenerateBooks.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        // GenerateReport.setHorizontalAlignment(Alignment.CENTER);
        GenerateBooks.setForeground(Color.WHITE);

        GenerateBooks.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                GenerateBooks.setBorder(new LineBorder(Color.CYAN, 1));

            }

            public void mouseClicked(MouseEvent e) {
             //   report();

            }

            public void mouseExited(MouseEvent e) {
                GenerateBooks.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
            }

        });

        JTextField ISBNnoText = new JTextField(10);
        //AccessionNoText.setBackground(Color.WHITE);
        ISBNnoText.setBorder(new LineBorder(Color.WHITE, 1));

        JTextField bookselfText = new JTextField(10);

        // ISBNNoText.setBackground(Color.LIGHT_GRAY);
        bookselfText.setBorder(new LineBorder(Color.WHITE, 1));

        //gbc0.fill = GridBagConstraints.BOTH;
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 0;
        ListOfBooks.add(ISBNno, gbc0_1);

        gbc0_1.fill = GridBagConstraints.BOTH;
        gbc0_1.gridx = 1;
        gbc0_1.gridy = 0;
        //gbc0.ipadx = 1;
        //gbc0.gridwidth = 2;
        ListOfBooks.add(ISBNnoText, gbc0_1);

        gbc0_1.fill = GridBagConstraints.BOTH;
        gbc0_1.gridx = 2;
        gbc0_1.gridy = 0;
        ListOfBooks.add(Generatereport, gbc0_1);

        //gbc0.fill = GridBagConstraints.CENTER;
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 2;
        //gbc0.ipadx = 1;
        //gbc0.gridwidth = 0;
        ListOfBooks.add(Bookself, gbc0_1);

        //gbc0.fill = GridBagConstraints.BOTH;
        gbc0_1.gridx = 1;
        gbc0_1.gridy = 2;
        //gbc0.ipady = 2;
        //gbc0.gridwidth = 9;
        ListOfBooks.add(bookselfText, gbc0_1);

        gbc0_1.fill = GridBagConstraints.BOTH;
        gbc0_1.gridx = 2;
        gbc0_1.gridy = 2;
        // gbc0.ipady = 2;
        ListOfBooks.add(BookselfReport, gbc0_1);

        gbc0_1.fill = GridBagConstraints.BOTH;
        gbc0_1.gridx = 1;
        gbc0_1.gridy = 5;
        gbc0.ipady = 1;
        gbc0.gridwidth = 9;
        ListOfBooks.add(GenerateBooks, gbc0_1);

        tab.addTab("Books Information", ListOfBooks);

        //-------------------------------------------------------------------------------------------------------------------
        JPanel EditBooks = new JPanel(new BorderLayout());

        EditBooks.setBackground(Color.DARK_GRAY);

        gbc0.insets = new Insets(5, 5, 5, 5);
        EditBooks.setBorder(new LineBorder(Color.DARK_GRAY, 10));

        JLabel Datefrom = new JLabel("Date from :    ");
        Datefrom.setForeground(Color.WHITE);

        JLabel to = new JLabel("    to    ");
        to.setForeground(Color.WHITE);

        final JLabel editRowNo = new JLabel("Click here to Generate report on Transaction History between selected date : ");
        editRowNo.setForeground(Color.WHITE);
        editRowNo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        editRowNo.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                editRowNo.setBorder(new LineBorder(Color.CYAN, 1));

            }

            public void mouseClicked(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
                editRowNo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
            }

        });

        final JLabel editColumnNo = new JLabel("Click here to Generate report on all the Transaction History : ");
        editColumnNo.setForeground(Color.WHITE);
        editColumnNo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        editColumnNo.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                editColumnNo.setBorder(new LineBorder(Color.CYAN, 1));

            }

            public void mouseClicked(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {
                editColumnNo.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
            }

        });

        JComboBox day = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            day.addItem(i);
        }
        //editGenerateReporttext.setBackground(Color.LIGHT_GRAY);
        day.setBorder(new LineBorder(Color.WHITE, 1));

//        JTextField editYearReport text = new JTextField(12);
        //editYearReport text.setBackground(Color.LIGHT_GRAY);
        // editYearReport text.setBorder(new LineBorder(Color.WHITE, 1));
        JComboBox month = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            month.addItem(i);
        }
        //editAuthorNametext.setBackground(Color.LIGHT_GRAY);
        month.setBorder(new LineBorder(Color.WHITE, 1));

        JComboBox year = new JComboBox();
        for (int i = 2016; i >= 2010; i--) {
            year.addItem(i);
        }
        //editEditionText.setBackground(Color.LIGHT_GRAY);
        year.setBorder(new LineBorder(Color.WHITE, 1));

        JComboBox day1 = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            day1.addItem(i);
        }
        //editBookshelfNotext.setBackground(Color.LIGHT_GRAY);
        day1.setBorder(new LineBorder(Color.WHITE, 1));

        JComboBox month1 = new JComboBox();
        for (int i = 1; i <= 12; i++) {
            month1.addItem(i);
        }
        // editRowNotext.setBackground(Color.LIGHT_GRAY);
        month1.setBorder(new LineBorder(Color.WHITE, 1));

        JComboBox year1 = new JComboBox();
        for (int i = 2016; i >= 2010; i--) {
            year1.addItem(i);
        }
        //editColumnNotext.setBackground(Color.LIGHT_GRAY);
        year1.setBorder(new LineBorder(Color.WHITE, 1));

        JPanel edits = new JPanel(new GridBagLayout());
        GridBagConstraints gbc00 = new GridBagConstraints();
        gbc00.insets = new Insets(20, 20, 3, 3);
        gbc00.gridwidth = 1;
        gbc00.fill = GridBagConstraints.HORIZONTAL;
        gbc00.fill = GridBagConstraints.VERTICAL;

        edits.setBackground(Color.GRAY);

        gbc00.gridx = 5;
        gbc00.gridy = 0;
        edits.add(Datefrom, gbc00);
        gbc00.gridx = 6;
        gbc00.gridy = 0;
        edits.add(day, gbc00);
        gbc00.gridx = 7;
        gbc00.gridy = 0;
        edits.add(month, gbc00);
        gbc00.gridx = 8;
        gbc00.gridy = 0;
        edits.add(year, gbc00);
        gbc00.gridx = 9;
        gbc00.gridy = 0;
        edits.add(to, gbc00);
        gbc00.gridx = 10;
        gbc00.gridy = 0;
        edits.add(day1, gbc00);
        gbc00.gridx = 11;
        gbc00.gridy = 0;
        edits.add(month1, gbc00);
        gbc00.gridx = 12;
        gbc00.gridy = 0;
        edits.add(year1, gbc00);

        gbc00.gridx = 4;
        gbc00.gridy = 1;
        gbc00.gridwidth = 9;
        //gbc00.gridheight = 9;
        edits.add(editRowNo, gbc00);
        gbc00.gridx = 4;
        gbc00.gridy = 2;
        gbc00.gridheight = 9;
        edits.add(editColumnNo, gbc00);

        EditBooks.add(edits, BorderLayout.CENTER);

        tab.addTab("Edit Books Information", EditBooks);

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
        JLabel l = new JLabel("ND 1 Second ISBNNo - 2015; Matrix No.: 2014/NDM/20076/CS; AbiaPoly.");

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

    public ImageIcon resizeImage(ImageIcon Path) {
        Image image1 = Path.getImage();
        Image newImage = image1.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
    }

    public ImageIcon resizeImage2(ImageIcon Path) {
        Image image1 = Path.getImage();
        Image newImage = image1.getScaledInstance(60, 50, Image.SCALE_SMOOTH);
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
//                new GenerateReport();
//            }
//        });
//
//    }
//    public void report() {
//        String ReportPath = "C:\\Users\\Kapersky\\Documents\\NetBeansProjects\\Library Management System\\src\\Librarypackage\\report1.jrxml";
//        try {
//            JasperReport report = JasperCompileManager.compileReport(ReportPath);
//            JasperPrint jp = JasperFillManager.fillReport(report, null, con);
//            JasperViewer.viewReport(jp);
//        } catch (JRException e) {
//            JOptionPane.showMessageDialog(null, e);
//
//        }
//    }
}
