
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginPage extends javax.swing.JFrame {

    Connection connection;

    public LoginPage() {
        //Initialize components
        initComponents();
        //Try and connect to mysql database using relevant credentials
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/frontdeskapplication", "chris", "password");
        } catch (SQLException ex) {
            System.out.println("Could not connect");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_Username = new javax.swing.JLabel();
        label_Password = new javax.swing.JLabel();
        txt_Username = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        btn_Login = new javax.swing.JButton();
        label_Header = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_Username.setText("Username");
        label_Username.setToolTipText("");

        label_Password.setText("Password");

        txt_Username.setToolTipText("Enter your username");

        txt_Password.setToolTipText("Enter your password");
        txt_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PasswordActionPerformed(evt);
            }
        });

        btn_Login.setText("LOGIN");
        btn_Login.setToolTipText("");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        label_Header.setText("FRONT DESK APPLICATION LOGIN FORM");
        label_Header.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_Username, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_Password, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Login)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txt_Username)
                            .addComponent(txt_Password)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(102, Short.MAX_VALUE)
                        .addComponent(label_Header)))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(label_Header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_Username))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Password)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(btn_Login)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PasswordActionPerformed

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        //Get username and password from text fields in UI form
        String username = txt_Username.getText();
        String password = txt_Password.getText();
        int userId = checkLogin(username, password);
        //Check if the provided credentials match those stored in the database
        if (userId > 0) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            if (User.isLoggedIn()) {
                User.username = username;
                User.userId = userId;
            } else {
                User.getInstance(username, userId);
            }
            
            this.dispose(); //Remove current window
            Dashboard dashboard = new Dashboard(); //redirect to dashboard window
            dashboard.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Login failed");
        }
    }//GEN-LAST:event_btn_LoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    public int checkLogin(String username, String password) {
        //Initialize variables to store data retrieved from database
        String dbUsername = "";
        String dbPassword = "";
        int userId = 0;
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from adminusers");

            while (results.next()) {
                System.out.println("id : " + results.getString(1));
                System.out.println("username : " + results.getString(2));
                System.out.println("password : " + results.getString(3));
                dbUsername = results.getString(2);
                dbPassword = results.getString(3);
                userId = Integer.parseInt(results.getString(1));
            }

            System.out.println("Db connection closed");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        if (dbUsername.equals(username) && dbPassword.equals(password)) {
            return userId;
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JLabel label_Header;
    private javax.swing.JLabel label_Password;
    private javax.swing.JLabel label_Username;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}
