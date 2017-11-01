package Librarypackage;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import javax.swing.UnsupportedLookAndFeelException;

public class LibraryMgt {

    static Connection con;
    static Statement st;
    static ResultSet rs;
    static PreparedStatement pre1;
    static JTextField booknametext, typeReg1, loginUsernameText;
    public static JPanel Dashboard;

    public ImageIcon Logo_icon = new ImageIcon(getClass().getResource("Icons/Abia Poly.png"));
    public ImageIcon StudentsInfo_icon = new ImageIcon(getClass().getResource("Icons/st.png"));
    public ImageIcon StudentsInfoHover_icon = new ImageIcon(getClass().getResource("Icons/stHover.png"));
    public ImageIcon BCol_icon = new ImageIcon(getClass().getResource("Icons/cb.png"));
    public ImageIcon BColHover_icon = new ImageIcon(getClass().getResource("Icons/cbHover.png"));
    public ImageIcon search_icon = new ImageIcon(getClass().getResource("Icons/search.png"));
    public ImageIcon searchHover_icon = new ImageIcon(getClass().getResource("Icons/searchHover.png"));
    public ImageIcon BorrowBook_icon = new ImageIcon(getClass().getResource("Icons/bb.png"));
    public ImageIcon BorrowBookHover_icon = new ImageIcon(getClass().getResource("Icons/bbHover.png"));
    public ImageIcon ChangePass_icon = new ImageIcon(getClass().getResource("Icons/cp.png"));
    public ImageIcon ChangePassHover_icon = new ImageIcon(getClass().getResource("Icons/cpHover.png"));
    public ImageIcon BackUpDb_icon = new ImageIcon(getClass().getResource("Icons/bd.png"));
    public ImageIcon BackUpDbHover_icon = new ImageIcon(getClass().getResource("Icons/bdHover.png"));
    public ImageIcon Greport_icon = new ImageIcon(getClass().getResource("Icons/gr.png"));
    public ImageIcon GreportHover_icon = new ImageIcon(getClass().getResource("Icons/grHover.png"));
    public ImageIcon Close_icon = new ImageIcon(getClass().getResource("Icons/closeIcon.png"));
    public ImageIcon Help_icon = new ImageIcon(getClass().getResource("Icons/helpIcon.png"));
    public ImageIcon Home_icon = new ImageIcon(getClass().getResource("Icons/HomeIcon.png"));
    public ImageIcon Add_Tab_icon = new ImageIcon(getClass().getResource("Icons/addIcon.png"));
    public ImageIcon Info_Tab_icon = new ImageIcon(getClass().getResource("Icons/listIcon.png"));

    public LibraryMgt() {

    }

    public Connection DbConnection() throws Exception {

        // Loading the Class Path;
        // Class.forName("org.sqlite.JDBC");
        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Class.forName("com.mysql.jdbc.Driver");

        // Creating  a new connection
        // String myDB = "jdbc:sqlite:C:\\Users\\kapersky\\Documents\\NetBeansProjects\\Library Management System\\src\\librarydb.db";
        String myDB = "jdbc:mysql://localhost:3306/librarydb";
        con = DriverManager.getConnection(myDB, "root", "");
        return con;

    }

    public Vector Dbdisplay_Book_Borrowed() {
        Vector<Vector<String>> vect = new Vector<Vector<String>>();
        String regno = typeReg1.getText();
        //typeReg2

        try {
            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select * from borowersdb where Registration = ?");

            pre.setString(1, regno);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                Vector<String> employee = new Vector<String>();
                employee.add(rs.getString("AccessionNo"));
                employee.add(rs.getString("Date"));
                employee.add(rs.getString("Time"));
                vect.add(employee);

            }

        } catch (Exception e) {

        }
        return vect;
    }

    public Vector getListOfBooks() {
        Vector<Vector<String>> vect = new Vector<Vector<String>>();
        try {
            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select * from bookdetails where BookTitle = ?");
            pre.setString(1, booknametext.getText().toString());
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Vector<String> employee = new Vector<String>();
                // employee.add(rs.getString(1));
                employee.add(rs.getString("AccessionNo"));
                employee.add(rs.getString("ISBNNo"));
                employee.add(rs.getString("CL Accession"));
                employee.add(rs.getString("BookTitle"));
                employee.add(rs.getString("Author Name"));
                employee.add(rs.getString("Edition"));
                employee.add(rs.getString("Book Self No"));
                employee.add(rs.getString("Row No"));
                employee.add(rs.getString("Column No"));
                vect.add(employee);
            }
            if (con != null) {
                con.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(LibraryMgt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vect;
    }

    public Vector getListOfBorowersBooks() {
        Vector<Vector<String>> vect = new Vector<Vector<String>>();
        try {
            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select * from borowersdb");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Vector<String> employee = new Vector<String>();
                employee.add(rs.getString("Registration"));
                employee.add(rs.getString("Name"));
                employee.add(rs.getString("Year"));
                employee.add(rs.getString("Semester"));
                employee.add(rs.getString("AccessionNo"));
                employee.add(rs.getString("ISBNNo"));
                employee.add(rs.getString("Date"));
                employee.add(rs.getString("Time"));
                vect.add(employee);
            }
            if (con != null) {
                con.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(LibraryMgt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vect;
    }

    public Vector getAllListOfBooks() {
        Vector<Vector<String>> vect = new Vector<Vector<String>>();
        try {
            con = DbConnection();
            PreparedStatement pre = con.prepareStatement("select * from bookdetails");
            // pre.setString(1, booknametext.getText().toString());
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Vector<String> employee = new Vector<String>();
                // employee.add(rs.getString(1));
                employee.add(rs.getString("AccessionNo"));
                employee.add(rs.getString("ISBNNo"));
                employee.add(rs.getString("CL Accession"));
                employee.add(rs.getString("BookTitle"));
                employee.add(rs.getString("Author Name"));
                employee.add(rs.getString("Edition"));
                employee.add(rs.getString("Book Self No"));
                employee.add(rs.getString("Row No"));
                employee.add(rs.getString("Column No"));
                vect.add(employee);
            }
            if (con != null) {
                con.close();
            }

        } catch (Exception ex) {
            Logger.getLogger(LibraryMgt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vect;
    }

    public ImageIcon resizeImage(ImageIcon Path) {
        Image image1 = Path.getImage();
        Image newImage = image1.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
    }

    public ImageIcon resizeImage2(ImageIcon Path) {
        Image image1 = Path.getImage();
        Image newImage = image1.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newImage);
        return icon;
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LibraryMgt.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LibraryMgt m = new LibraryMgt();
                    st = m.DbConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
                    rs = st.executeQuery("select * from admindetails");
                           
                    new Login();
                } catch (Exception ex) {
                    Logger.getLogger(LibraryMgt.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

}
