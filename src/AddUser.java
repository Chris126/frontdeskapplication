
import com.mysql.jdbc.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddUser extends javax.swing.JFrame {

    Connection connection;

    public AddUser() {
        initComponents();
        lbl_userString.setText("WELCOME, " + User.username.toUpperCase());
        //Try and connect to mysql database using relevant credentials
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/frontdeskapplication", "chris", "password");
        } catch (SQLException ex) {
            System.out.println("Could not connect");
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrp_Gender = new javax.swing.ButtonGroup();
        lbl_window_header = new javax.swing.JLabel();
        lbl_firstname = new javax.swing.JLabel();
        javax.swing.JLabel lbl_lastname = new javax.swing.JLabel();
        lbl_telephone = new javax.swing.JLabel();
        lbl_dob = new javax.swing.JLabel();
        lbl_Gender = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        txt_fname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        txt_telephone = new javax.swing.JTextField();
        txt_dob = new javax.swing.JTextField();
        lbl_userString = new javax.swing.JLabel();
        radioBtn_Male = new javax.swing.JRadioButton();
        radioBtn_Female = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_window_header.setText("ADD NEW USER");

        lbl_firstname.setText("First Name");

        lbl_lastname.setText("Last Name");

        lbl_telephone.setText("Telephone");
        lbl_telephone.setToolTipText("");

        lbl_dob.setText("Date Of Birth");

        lbl_Gender.setText("Gender");
        lbl_Gender.setToolTipText("");

        btn_clear.setText("CLEAR");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_save.setText("SAVE USER");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        txt_fname.setToolTipText("Enter your first name");

        txt_lname.setToolTipText("Enter your last name");

        txt_telephone.setToolTipText("Enter your telephone number");

        txt_dob.setToolTipText("Enter your date of birth in YYY/MM/DD");

        lbl_userString.setText("WELCOME, USER");

        btnGrp_Gender.add(radioBtn_Male);
        radioBtn_Male.setText("Male");
        radioBtn_Male.setToolTipText("");
        radioBtn_Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_MaleActionPerformed(evt);
            }
        });

        btnGrp_Gender.add(radioBtn_Female);
        radioBtn_Female.setText("Female");
        radioBtn_Female.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_dob)
                            .addComponent(lbl_Gender))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_lname, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(txt_telephone, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(txt_dob, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(txt_fname))
                                .addGap(34, 34, 34)
                                .addComponent(lbl_userString))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioBtn_Male)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioBtn_Female))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_clear)
                        .addGap(18, 18, 18)
                        .addComponent(btn_save))
                    .addComponent(lbl_window_header)
                    .addComponent(lbl_firstname)
                    .addComponent(lbl_lastname)
                    .addComponent(lbl_telephone))
                .addGap(27, 44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_window_header)
                    .addComponent(lbl_userString))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_firstname)
                    .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_lastname)
                    .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_telephone)
                    .addComponent(txt_telephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_dob)
                    .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Gender)
                    .addComponent(radioBtn_Male)
                    .addComponent(radioBtn_Female))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_clear))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioBtn_MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_MaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtn_MaleActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        //Get data from text fields
        String fname = txt_fname.getText();
        String lname = txt_lname.getText();
        String telephone = txt_telephone.getText();
        String dob = txt_dob.getText();
        String gender = "";

        //get gender from radio button group
        if (radioBtn_Female.isSelected()) {
            gender = radioBtn_Female.getText();
        } else if (radioBtn_Male.isSelected()) {
            gender = radioBtn_Male.getText();
        } else {
            JOptionPane.showMessageDialog(this, "Select a gender");
            return;
        }

        //Check for empty or invalid inputs
        if (StringUtils.isNullOrEmpty(fname)) {
            JOptionPane.showMessageDialog(this, "Enter a value for first name");
            return;
        } else if (StringUtils.isNullOrEmpty(lname)) {
            JOptionPane.showMessageDialog(this, "Enter a value for last name");
            return;
        } else if (StringUtils.isNullOrEmpty(telephone)) {
            JOptionPane.showMessageDialog(this, "Enter a value for telephone");
            return;
        } else if (telephone.length() != 10) {
            JOptionPane.showMessageDialog(this, "Enter a valid 10 digit telephone number");
            return;
        } else if (StringUtils.isNullOrEmpty(dob)) {
            JOptionPane.showMessageDialog(this, "Enter a value for date of birth");
            return;
        }

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        //check if the dob is valid 
        try {
            format.parse(dob);
            //if the dob and all other fields above check out, proceed to insert the user data into the app's database
            Statement statement = connection.createStatement();
            String sql = "insert into normalusers (firstName, lastName, telephone, dob, gender) values (?,?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1, fname);
            prep.setString(2, lname);
            prep.setString(3, telephone);
            prep.setString(4, dob);
            prep.setString(5, gender);
            prep.execute();
            JOptionPane.showMessageDialog(this, "User saved successfully");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid date of birth in the correct format");
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        //clear all fields
        txt_fname.setText("");
        txt_lname.setText("");
        txt_telephone.setText("");
        txt_dob.setText("");
        btnGrp_Gender.clearSelection();
    }//GEN-LAST:event_btn_clearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGrp_Gender;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel lbl_Gender;
    private javax.swing.JLabel lbl_dob;
    private javax.swing.JLabel lbl_firstname;
    private javax.swing.JLabel lbl_telephone;
    private javax.swing.JLabel lbl_userString;
    private javax.swing.JLabel lbl_window_header;
    private javax.swing.JRadioButton radioBtn_Female;
    private javax.swing.JRadioButton radioBtn_Male;
    private javax.swing.JTextField txt_dob;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_telephone;
    // End of variables declaration//GEN-END:variables
}
