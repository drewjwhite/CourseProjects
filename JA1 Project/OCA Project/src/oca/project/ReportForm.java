
package oca.project;

import java.util.ArrayList;



/**
 *
 * Form that allows running various reports 
 */
public class ReportForm extends javax.swing.JFrame {
        
    
    private ArrayList<Person> reportFormList;
    private MainForm mainForm;
    /**
     * Creates new form ReportForm
     * @param payrollReportItemList
     */
    public ReportForm(ArrayList<PayrollReportItem> payrollReportItemList) {
        initComponents();

        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        msgMessage = new javax.swing.JOptionPane();
        btnPaymentForPeriod = new javax.swing.JButton();
        btnBonusReport = new javax.swing.JButton();
        btnPaymentHistoryForPerson = new javax.swing.JButton();
        btnFortnighlyPayments = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMonthlyPayments = new javax.swing.JButton();
        cboName = new javax.swing.JComboBox();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtFirstDate = new javax.swing.JTextField();
        txtSecondDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReport = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPaymentForPeriod.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnPaymentForPeriod.setText("All payments for a period");
        btnPaymentForPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentForPeriodActionPerformed(evt);
            }
        });

        btnBonusReport.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnBonusReport.setText("Bonuses report");
        btnBonusReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBonusReportActionPerformed(evt);
            }
        });

        btnPaymentHistoryForPerson.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnPaymentHistoryForPerson.setText("Payment history by person");
        btnPaymentHistoryForPerson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentHistoryForPersonActionPerformed(evt);
            }
        });

        btnFortnighlyPayments.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnFortnighlyPayments.setText("List Fortnightly Payments");
        btnFortnighlyPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFortnighlyPaymentsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("Payroll Reports");

        btnMonthlyPayments.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnMonthlyPayments.setText("List Monthly Payments");
        btnMonthlyPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonthlyPaymentsActionPerformed(evt);
            }
        });

        cboName.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("First Date:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel3.setText("Second Date:");

        txtFirstDate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtSecondDate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtReport.setColumns(20);
        txtReport.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtReport.setRows(5);
        jScrollPane1.setViewportView(txtReport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnPaymentForPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBonusReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPaymentHistoryForPerson, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFortnighlyPayments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMonthlyPayments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSecondDate)
                                        .addComponent(txtFirstDate)))
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jSeparator1))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtFirstDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSecondDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPaymentForPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBonusReport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(cboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPaymentHistoryForPerson, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFortnighlyPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMonthlyPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 91, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    //event handler for the Back button that closes the current form and displays the main form 
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
//        this.setVisible(false);
//        OCAProject.openStartForm();
    }//GEN-LAST:event_btnBackActionPerformed

    //event handler for the button that displays all payments made within a period between two dates
    private void btnPaymentForPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentForPeriodActionPerformed
       
    }//GEN-LAST:event_btnPaymentForPeriodActionPerformed


    
    //event handler for the button that displays 
    //information about all the bonuses assigned to subordinates
    private void btnBonusReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBonusReportActionPerformed
       
    }//GEN-LAST:event_btnBonusReportActionPerformed

    //event handler for the button that displays all payments for the employee selected in the cboName
    private void btnPaymentHistoryForPersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentHistoryForPersonActionPerformed
      
    }//GEN-LAST:event_btnPaymentHistoryForPersonActionPerformed

    
    //event handler for the button displaying all fortnightly payments made
    private void btnFortnighlyPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFortnighlyPaymentsActionPerformed
       
    }//GEN-LAST:event_btnFortnighlyPaymentsActionPerformed

    
    //event handler for the button displaying all monthly payments made
    private void btnMonthlyPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonthlyPaymentsActionPerformed
        
    }//GEN-LAST:event_btnMonthlyPaymentsActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ReportForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ReportForm().setVisible(true);
//            }
//        });
//    }
    
    //populates cboName with all the perople working in the company

         

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBonusReport;
    private javax.swing.JButton btnFortnighlyPayments;
    private javax.swing.JButton btnMonthlyPayments;
    private javax.swing.JButton btnPaymentForPeriod;
    private javax.swing.JButton btnPaymentHistoryForPerson;
    private javax.swing.JComboBox cboName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JOptionPane msgMessage;
    private javax.swing.JTextField txtFirstDate;
    private javax.swing.JTextArea txtReport;
    private javax.swing.JTextField txtSecondDate;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the assignBonusFormList
     */
    public ArrayList<Person> getReportFormList() {
        return reportFormList;
    }

    /**
     * @param assignBonusFormList the assignBonusFormList to set
     */
    public void setreportFormList(ArrayList<Person> reportFormList) {
        this.reportFormList = reportFormList;
    }

    /**
     * @return the mainForm
     */
    public MainForm getMainForm() {
        return mainForm;
    }

    /**
     * @param mainForm the mainForm to set
     */
    public void setMainForm(MainForm mainForm) {
        this.mainForm = mainForm;
    }


}
