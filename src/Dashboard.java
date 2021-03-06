
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Dashboard extends javax.swing.JFrame {

    Connection connection;
    static Dashboard instance;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        lbl_userString.setText("WELCOME, " + User.username.toUpperCase());
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/frontdeskapplication", "chris", "password");
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        populateTable();
//        createChart();
        instance = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_window_heading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        btn_add_user = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        lbl_userString = new javax.swing.JLabel();
        btn_Chart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_window_heading.setText("FRONT DESK APPLICATION DASHBOARD");
        lbl_window_heading.setToolTipText("");

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Telephone", "Date of Birth", "Age"
            }
        ));
        jScrollPane1.setViewportView(userTable);

        btn_add_user.setText("ADD USER");
        btn_add_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_userActionPerformed(evt);
            }
        });

        btn_logout.setText("LOG OUT");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        lbl_userString.setText("WELCOME USER");

        btn_Chart.setText("SHOW PIE CHART");
        btn_Chart.setToolTipText("");
        btn_Chart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_window_heading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_userString))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_add_user)
                                .addGap(18, 18, 18)
                                .addComponent(btn_logout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Chart)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_window_heading)
                    .addComponent(lbl_userString))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add_user)
                    .addComponent(btn_logout)
                    .addComponent(btn_Chart))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_add_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_userActionPerformed
        // TODO add your handling code here:
        AddUser adduser = new AddUser();
        adduser.setVisible(true);
        adduser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btn_add_userActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        this.dispose();
        LoginPage login = new LoginPage();
        login.setVisible(true);

    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_ChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChartActionPerformed
        createChart();
    }//GEN-LAST:event_btn_ChartActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    public void populateTable() {
        try {

            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("select * from normalusers");
            DefaultTableModel model = (DefaultTableModel) userTable.getModel();
            model.setRowCount(0);
            while (results.next()) {
                System.out.println("id : " + results.getString(1));
                System.out.println("fname : " + results.getString(2));
                System.out.println("lname : " + results.getString(3));
                System.out.println("lname : " + results.getString(4));
                System.out.println("lname : " + results.getString(5));
                System.out.println("lname : " + results.getString(6));

                LocalDate now = LocalDate.now();
                LocalDate dob = LocalDate.parse(results.getString(5), DateTimeFormatter.ISO_LOCAL_DATE);
                long numYears = ChronoUnit.YEARS.between(dob, now);
                System.out.println("diff : " + numYears);

                model.addRow(new Object[]{results.getString(2) + " " + results.getString(3), results.getString(6), results.getString(4), results.getString(5), numYears});
            }

            System.out.println("Try block success");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createChart() {
//        Sql code for fetching the male and female counts from the database
        String femaleSqlCount = "SELECT count(userId) as GenderCount, gender FROM `normalusers` where gender like \"female\"";
        String maleSqlCount = "SELECT count(userId) as GenderCount, gender FROM `normalusers` where gender like \"male\"";
//        Initialize the countss to zero
        int femaleCount = 0;
        int maleCount = 0;

//        Execute the queries created above in order to get the actual data
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(femaleSqlCount);
            while (results.next()) {
                System.out.println("res 1 : " + results.getString(1));
                femaleCount = Integer.parseInt(results.getString(1));
            }
            Statement statement2 = connection.createStatement();
            ResultSet results2 = statement.executeQuery(maleSqlCount);
            while (results2.next()) {
                System.out.println("res 2 : " + results2.getString(1));
                maleCount = Integer.parseInt(results2.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Male count : " + maleCount + "Female Count : " + femaleCount);

//        create pie chart with gender counts using jfreechart library
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Male", new Integer(maleCount));
        dataset.setValue("Female", new Integer(femaleCount));
        JFreeChart chart = ChartFactory.createPieChart(
                "Chart Showing Gender Distribution", // chart title 
                dataset, // data    
                true, // include legend   
                true,
                false);
//        PiePlot P = (PiePlot) chart.getPlot();
        ChartFrame frame = new ChartFrame("Pie chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Chart;
    private javax.swing.JButton btn_add_user;
    private javax.swing.JButton btn_logout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_userString;
    private javax.swing.JLabel lbl_window_heading;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
