package Librarypackage;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class StudentInformation extends LibraryMgt implements ActionListener {

    JFrame frame;
    JPanel GrayDashboard, toppane, centerpane, southpane, southpane1;
    public JTextField StdNameText, contactNotext, StdNoText, typeReg, editStdNoText, editStdNameText, edityeartext, editcontactNotext;
    public JComboBox yeartext, semestertext, editsemestertext;
    public JLabel RegNoText, StNameText, yrtext, semtext, contNotext, contNo1;

    Connection con;
    Statement st;
    ResultSet rs;

    public StudentInformation() {
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
        logo3.setToolTipText("Menu");
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
        logo4.setToolTipText("Help");
        JLabel logo5 = new JLabel(Close_icon);
        logo5.setToolTipText("Close");

        icons.add(logo3);
        icons.add(logo4);
        icons.add(logo5);
        toppane.add(icons, BorderLayout.EAST);
        GrayDashboard.add(toppane, BorderLayout.NORTH);

        centerpane = new JPanel(new BorderLayout());
        //centerpane.setBackground(Color.DARK_GRAY);
        JTabbedPane tab = new JTabbedPane();

        JPanel InfoTab = new JPanel(new GridBagLayout());
        InfoTab.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc0 = new GridBagConstraints();

        gbc0.insets = new Insets(3, 2, 2, 2);
        JLabel StdNo = new JLabel("Student's Registration No : ");
        StdNo.setForeground(Color.LIGHT_GRAY);
        JLabel StdName = new JLabel("Student's Name : ");
        StdName.setForeground(Color.LIGHT_GRAY);
        JLabel year = new JLabel("Year : ");
        year.setForeground(Color.LIGHT_GRAY);
        JLabel semester = new JLabel("Semester : ");
        semester.setForeground(Color.LIGHT_GRAY);
        JLabel contactNo = new JLabel("Conatact No : ");
        contactNo.setForeground(Color.LIGHT_GRAY);
        StdNoText = new JTextField(15);
        StdNoText.setBackground(Color.LIGHT_GRAY);
        StdNoText.setHorizontalAlignment(JTextField.CENTER);
        StdNoText.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        StdNameText = new JTextField(15);
        StdNameText.setBackground(Color.LIGHT_GRAY);
        StdNameText.setHorizontalAlignment(JTextField.CENTER);
        StdNameText.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        yeartext = new JComboBox();
        yeartext.setBackground(Color.LIGHT_GRAY);
        yeartext.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        //yeartext.addItem("");
        yeartext.addItem("2016");
        yeartext.addItem("2015");
        yeartext.addItem("2014");
        yeartext.addItem("2013");
        yeartext.addItem("2012");
        semestertext = new JComboBox();
        //semestertext.addItem("");
        semestertext.addItem("1ST Semester");
        semestertext.addItem("2ND Semester");
        semestertext.setBackground(Color.LIGHT_GRAY);
        semestertext.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        contactNotext = new JTextField(15);
        contactNotext.setHorizontalAlignment(JTextField.CENTER);
        contactNotext.setBackground(Color.LIGHT_GRAY);
        contactNotext.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        JButton submit = new JButton("Submit:");
        submit.addActionListener(this);

        gbc0.fill = GridBagConstraints.BASELINE_LEADING;
        gbc0.gridx = 0;
        gbc0.gridy = 0;
        InfoTab.add(StdNo, gbc0);
        gbc0.fill = GridBagConstraints.BASELINE_LEADING;
        gbc0.gridx = 0;
        gbc0.gridy = 1;
        InfoTab.add(StdName, gbc0);
        gbc0.fill = GridBagConstraints.BASELINE_LEADING;
        gbc0.gridx = 0;
        gbc0.gridy = 2;
        InfoTab.add(year, gbc0);
        gbc0.fill = GridBagConstraints.BASELINE_LEADING;
        gbc0.gridx = 0;
        gbc0.gridy = 3;
        InfoTab.add(semester, gbc0);
        gbc0.fill = GridBagConstraints.BASELINE_LEADING;
        gbc0.gridx = 0;
        gbc0.gridy = 4;
        InfoTab.add(contactNo, gbc0);
        gbc0.fill = GridBagConstraints.BASELINE_LEADING;
        gbc0.gridx = 0;
        gbc0.gridy = 5;
        InfoTab.add(submit, gbc0);
        gbc0.fill = GridBagConstraints.BASELINE_LEADING;
        gbc0.gridx = 1;
        gbc0.gridy = 0;
        InfoTab.add(StdNoText, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 1;
        InfoTab.add(StdNameText, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 2;
        InfoTab.add(yeartext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 3;
        InfoTab.add(semestertext, gbc0);
        gbc0.fill = GridBagConstraints.HORIZONTAL;
        gbc0.gridx = 1;
        gbc0.gridy = 4;
        InfoTab.add(contactNotext, gbc0);
        tab.addTab("Add new Student/member", Add_Tab_icon, InfoTab);

        JPanel StDetails = new JPanel(new BorderLayout(5, 5));
        StDetails.setBackground(Color.GRAY);
        GridBagConstraints gbc0_1 = new GridBagConstraints();
        gbc0_1.insets = new Insets(3, 3, 3, 3);
        JLabel RegNo = new JLabel("Registration No : ");
        RegNo.setForeground(Color.LIGHT_GRAY);
        JLabel RegNo1 = new JLabel("Registration No :     ");
        JLabel StName = new JLabel("Student's Name : ");
        StName.setForeground(Color.LIGHT_GRAY);
        JLabel yr = new JLabel("Year : ");
        yr.setForeground(Color.LIGHT_GRAY);
        JLabel sem = new JLabel("Semester : ");
        sem.setForeground(Color.LIGHT_GRAY);
        JLabel contNo = new JLabel("Conatact No : ");
        contNo.setForeground(Color.LIGHT_GRAY);
        RegNoText = new JLabel();
        RegNoText.setForeground(Color.LIGHT_GRAY);
        StNameText = new JLabel();
        StNameText.setForeground(Color.YELLOW);
        yrtext = new JLabel();
        yrtext.setForeground(Color.LIGHT_GRAY);
        semtext = new JLabel();
        semtext.setForeground(Color.LIGHT_GRAY);
        contNotext = new JLabel();
        contNotext.setForeground(Color.LIGHT_GRAY);
        typeReg = new JTextField(16);
        typeReg.setHorizontalAlignment(JTextField.CENTER);
        typeReg.setBackground(Color.LIGHT_GRAY);
        typeReg.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));
        typeReg.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                DBshow_Student_Details();
            }
        });

        JPanel Details0 = new JPanel(new FlowLayout());
        Details0.setBackground(Color.GRAY);
        Details0.add(RegNo1);
        Details0.add(typeReg);
        StDetails.add(Details0, BorderLayout.NORTH);

        JPanel Details = new JPanel(new GridBagLayout());
        Details.setBackground(Color.DARK_GRAY);
        Details.setBorder(new LineBorder(Color.DARK_GRAY, 5));
        Details.setForeground(Color.LIGHT_GRAY);

        gbc0_1.gridx = 0;
        gbc0_1.gridy = 0;
        Details.add(RegNo, gbc0_1);
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 1;
        Details.add(StName, gbc0_1);
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 2;
        Details.add(yr, gbc0_1);
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 3;
        Details.add(sem, gbc0_1);
        gbc0_1.gridx = 0;
        gbc0_1.gridy = 4;
        Details.add(contNo, gbc0_1);

        gbc0_1.gridx = 1;
        gbc0_1.gridy = 0;
        Details.add(RegNoText, gbc0_1);
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
        StDetails.add(Details, BorderLayout.CENTER);

        southpane = new JPanel();
        contNo1 = new JLabel("     Inactive    ");
        contNo1.setForeground(Color.red);
        contNo1.setVisible(false);
        contNo1.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        southpane.add(contNo1);

        southpane.setBackground(Color.GRAY);
        StDetails.add(southpane, BorderLayout.SOUTH);

        southpane = new JPanel();
        southpane.setBackground(Color.GRAY);
        StDetails.add(southpane, BorderLayout.EAST);

        southpane = new JPanel();
        southpane.setBackground(Color.GRAY);
        StDetails.add(southpane, BorderLayout.WEST);
        tab.addTab("Students Details", resizeImage2(Info_Tab_icon), StDetails);

        JPanel EditInfo = new JPanel(new GridBagLayout());
        EditInfo.setBackground(Color.DARK_GRAY);
        GridBagConstraints gbc0_2 = new GridBagConstraints();

        gbc0_2.insets = new Insets(3, 3, 3, 3);
        JLabel editStdNo = new JLabel("Enter Student's Registration No : ");
        editStdNo.setForeground(Color.CYAN);
        JLabel editStdName = new JLabel("Student's Name : ");
        editStdName.setForeground(Color.LIGHT_GRAY);
        JLabel edityear = new JLabel("Year : ");
        edityear.setForeground(Color.LIGHT_GRAY);
        JLabel editsemester = new JLabel("Semester : ");
        editsemester.setForeground(Color.LIGHT_GRAY);
        JLabel editcontactNo = new JLabel("Conatact No : ");
        editcontactNo.setForeground(Color.LIGHT_GRAY);
        editStdNoText = new JTextField(16);
        editStdNoText.setHorizontalAlignment(JTextField.CENTER);
        editStdNoText.setBackground(Color.LIGHT_GRAY);
        editStdNoText.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
        editStdNoText.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                DBedit_Student_Details();

            }

            @Override
            public void keyPressed(KeyEvent e) {
                editStdNameText.setText(null);
                edityeartext.setText(null);
                editcontactNotext.setText(null);
                editsemestertext.removeAllItems();
            }
        });

        //editStdNoText.addMouseListener(new MouseAdapter() {
        // public void mouseEntered(MouseEvent e) {
        //editStdNameText.setText(null);
        //edityeartext.setText(null);
        //editcontactNotext.setText(null);
        ///editsemestertext.addItem(null);
        //}
        //});
        editStdNameText = new JTextField(16);
        editStdNameText.setHorizontalAlignment(JTextField.CENTER);
        editStdNameText.setBackground(Color.LIGHT_GRAY);

        editStdNameText.setBorder(
                new LineBorder(Color.LIGHT_GRAY, 3));

        edityeartext = new JTextField(14);
        edityeartext.setHorizontalAlignment(JTextField.CENTER);
        edityeartext.setBackground(Color.LIGHT_GRAY);

        edityeartext.setBorder(
                new LineBorder(Color.LIGHT_GRAY, 3));

        editsemestertext = new JComboBox();

        editsemestertext.setBackground(Color.LIGHT_GRAY);

        editsemestertext.setBorder(
                new LineBorder(Color.LIGHT_GRAY, 3));

        editcontactNotext = new JTextField(15);
        editcontactNotext.setHorizontalAlignment(JTextField.CENTER);
        editcontactNotext.setBackground(Color.LIGHT_GRAY);

        editcontactNotext.setBorder(
                new LineBorder(Color.LIGHT_GRAY, 3));
        JButton editsubmit = new JButton("Update");
        editsubmit.addActionListener(this);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 0;

        EditInfo.add(editStdNo, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 1;

        EditInfo.add(editStdName, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 2;

        EditInfo.add(edityear, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 3;

        EditInfo.add(editsemester, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 4;
        //gbc0_2.gridwidth = 3;
        EditInfo.add(editcontactNo, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 0;
        gbc0_2.gridy = 5;

        EditInfo.add(editsubmit, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 1;
        gbc0_2.gridy = 0;

        EditInfo.add(editStdNoText, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 1;
        gbc0_2.gridy = 1;

        EditInfo.add(editStdNameText, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 1;
        gbc0_2.gridy = 2;
        gbc0_2.gridwidth = 10;
        gbc0_2.ipadx = 5;

        EditInfo.add(edityeartext, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 1;
        gbc0_2.gridy = 3;

        EditInfo.add(editsemestertext, gbc0_2);
        gbc0_2.fill = GridBagConstraints.HORIZONTAL;
        gbc0_2.gridx = 1;
        gbc0_2.gridy = 4;

        EditInfo.add(editcontactNotext, gbc0_2);

        tab.addTab(
                "Edit Students / member", resizeImage2(StudentsInfo_icon), EditInfo);

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

    public void DBRegister_Student() {
        String name = StdNameText.getText();
        String contact = contactNotext.getText();
        String reg = StdNoText.getText();
        String year = yeartext.getSelectedItem().toString();
        String semester = semestertext.getSelectedItem().toString();
        String DbReg = null;

        try {
            con = DbConnection();

            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("select * from studentdetails");

            while (rs.next()) {
                DbReg = rs.getString("RegNo");
            }
            if (reg.equals(DbReg)) {
                JOptionPane.showMessageDialog(null, "User Already Existed");
            } else {

                rs.moveToInsertRow();
                rs.updateString("RegNo", reg);
                rs.updateString("Student Name", name);
                rs.updateString("Year", year);
                rs.updateString("Semester", semester);
                rs.updateString("Contact No", contact);
                rs.insertRow();

                JOptionPane.showMessageDialog(null, "New User Created successfully!");
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DBshow_Student_Details() {
        String Reg = typeReg.getText();
        try {
            con = DbConnection();

            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("select * from studentdetails where RegNo ='" + Reg + "'");
            while (rs.next()) {
                RegNoText.setText(rs.getString("RegNo"));
                StNameText.setText(rs.getString("Student Name"));
                yrtext.setText(rs.getString("Year").trim());
                semtext.setText(rs.getString("Semester"));
                contNotext.setText(rs.getString("Contact No"));
                contNo1.setVisible(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DBedit_Student_Details() {

//editStdNameText, edityeartext, editcontactNotext,editsemestertext
        String Reg = editStdNoText.getText();
        String s = null;
        try {
            con = DbConnection();

            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("select * from studentdetails where RegNo ='" + Reg + "'");
            while (rs.next()) {
                editStdNameText.setText(rs.getString("Student Name"));
                edityeartext.setText(rs.getString("Year").trim());
                s = rs.getString("Semester");
                if (s.equals("1ST Semester")) {
                    editsemestertext.addItem("1ST Semester");
                    editsemestertext.addItem("2ND Semester");
                } else {
                    editsemestertext.addItem("2ND Semester");
                    editsemestertext.addItem("1ST Semester");

                }
                editcontactNotext.setText(rs.getString("Contact No"));

            }

        } catch (Exception ex) {
            Logger.getLogger(StudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void DBupdate_Edited_Student_Details() {
        //editStdNameText, edityeartext, editcontactNotext,editsemestertext

        String name = editStdNameText.getText();
        String contact = editcontactNotext.getText();
        String reg = editStdNoText.getText();
        String year = edityeartext.getText();
        String semester = editsemestertext.getSelectedItem().toString();
        //String DbReg = null;

        try {
            con = DbConnection();

            st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("select * from studentdetails");
            if (rs.next()) {
                rs.updateString("RegNo", reg);
                rs.updateString("Student Name", name);
                rs.updateString("Year", year);
                rs.updateString("Semester", semester);
                rs.updateString("Contact No", contact);
                rs.updateRow();
                JOptionPane.showMessageDialog(null, "User Updated successfully!");
                // }
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentInformation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StudentInformation();
//            }
//        });
//
//    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Submit:":
                DBRegister_Student();
                break;
            case "Update":
                DBupdate_Edited_Student_Details();
                break;
        }
    }
}
