package oca.project;

import java.awt.Color;
import java.awt.color.ColorSpace;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.border.*;



/**
 *
 * Form that allows to display personal details and pay salaried and contractor employees
 */
public class PersonalDataForm extends javax.swing.JFrame {
    
    private ArrayList<Person> personalDataFormList = new ArrayList<>();
    private MainForm mainForm;
    
    int xPoint = 30;
    int yPoint = 25;
    int gap = 125;

    //setting up date format

    //creating new list to hold the report items


      

    /**
     * Creates new form DataEntryForm
     * @param payrollReportItemList
     */
    public PersonalDataForm(ArrayList<PayrollReportItem> payrollReportItemList) {
        initComponents();
        formatLayout();
        
        
        

    }
    
    public void populateCboName(){
        for (Person person : this.getPersonalDataFormList()){
            cboName.addItem(person.toString());
        }
    }
    
    public void formatLayout() {
                
        this.setSize(750, 700);
        //set the background colour of the form and two panels to lt blue
        getContentPane().setBackground(new java.awt.Color(153,204,255));
        panContractor.setBackground(new java.awt.Color(153,204,255));
        panSalariedPerson.setBackground(new java.awt.Color(153,204,255));
        panContractor.setVisible(false); //set cantractor panel to hidden
        //Set size and location of labels and visible Salaried Position panel
        lblHeading.setLocation(xPoint-5, yPoint);
        lblName.setLocation(xPoint, yPoint + 75);
        lblDOB.setLocation(xPoint, yPoint + 115);
        lblStartDate.setLocation(xPoint, yPoint+ 155);
        lblContract.setLocation(xPoint, yPoint + 195);
        lblTimePeriod.setLocation(xPoint, yPoint + 275);
        panSalariedPerson.setLocation(xPoint - 5, yPoint + 315);
        panSalariedPerson.setSize(400, 200);
        panSalariedPerson.setBorder(BorderFactory.createEtchedBorder(1));
        lblSalaried.setLocation(5, 5);
        lblBaseSalary1.setLocation(5, 35);
        //Align content with their labels
        cboName.setLocation(xPoint + gap, yPoint + 75);
        txtDOB.setLocation(xPoint + gap, yPoint + 115);
        txtStartDate.setLocation(xPoint + gap, yPoint + 155);
        scrContractor.setLocation(xPoint + gap, yPoint + 195);
        cboTimePeriod.setLocation(xPoint + gap, yPoint + 275);
        txtBaseSalary.setLocation(gap + 5, 35);
        
        
        
    }
    
    //method that allows to display personal details based on the selection made in the cboName
    public void getPersonalData( ) {
         String selectedEmployee = String.valueOf(cboName.getSelectedItem());
         
         for (Person person : personalDataFormList){
             if (person.toString().equals(selectedEmployee)){
                 if (person instanceof SalariedSubordinate){
                     SalariedSubordinate staffMember = (SalariedSubordinate)person;
                     txtDOB.setText(String.valueOf(staffMember.getDoB()));
                     txtStartDate.setVisible(true);
                     txtStartDate.setText(String.valueOf(staffMember.getStartDate()));
                     lstContractor.setSelectedIndex(1);
                     cboTimePeriod.setVisible(true);
                     if (staffMember.getTimePeriod() == TimePeriod.FORTNIGHTLY){
                        cboTimePeriod.setSelectedIndex(1);
                     }
                     else {
                        cboTimePeriod.setSelectedIndex(2);
                     }
                     panContractor.setVisible(false);
                     panSalariedPerson.setVisible(true);
                     txtBaseSalary.setText(String.valueOf(staffMember.getBaseSalary()));
                 }
                 else if (person instanceof CEO){
                     CEO ceo = (CEO)person;
                     txtDOB.setText(String.valueOf(ceo.getDoB()));
                     txtStartDate.setVisible(true);
                     txtStartDate.setText(String.valueOf(ceo.getStartDate()));
                     lstContractor.setSelectedIndex(1);
                     cboTimePeriod.setVisible(true);
                     if (ceo.getTimePeriod() == TimePeriod.FORTNIGHTLY){
                        cboTimePeriod.setSelectedIndex(1);
                     }
                     else {
                        cboTimePeriod.setSelectedIndex(2);
                     }
                     panContractor.setVisible(false);
                     panSalariedPerson.setVisible(true);
                     txtBaseSalary.setText(String.valueOf(ceo.getBaseSalary()));
                 }
                 else if (person instanceof ContractSubordinate){
                     ContractSubordinate contractor = (ContractSubordinate)person;
                     txtStartDate.setVisible(false);
                     txtDOB.setText(String.valueOf(contractor.getDoB()));
                     lstContractor.setSelectedIndex(0);
                     cboTimePeriod.setVisible(false);
                     panSalariedPerson.setVisible(false);
                     panContractor.setVisible(true);
                     panContractor.setLocation(xPoint - 5, yPoint + 315);
                     panContractor.setSize(400, 200);
                     panContractor.setBorder(BorderFactory.createEtchedBorder(1));
                     txtHourlyRate.setText("$" + String.valueOf(contractor.getHourlyRate()) + "0");
                 }
                 
                 
                 
             }
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

        msgMessage = new javax.swing.JOptionPane();
        lblName = new javax.swing.JLabel();
        cboName = new javax.swing.JComboBox();
        lblDOB = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        lblStartDate = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        lblContract = new javax.swing.JLabel();
        scrContractor = new javax.swing.JScrollPane();
        lstContractor = new javax.swing.JList();
        panSalariedPerson = new javax.swing.JPanel();
        txtBaseSalary = new javax.swing.JTextField();
        lblSalaried = new javax.swing.JLabel();
        lblBaseSalary1 = new javax.swing.JLabel();
        cboTimePeriod = new javax.swing.JComboBox();
        lblTimePeriod = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblHeading = new javax.swing.JLabel();
        panContractor = new javax.swing.JPanel();
        lblContractWorker = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtStartOfPayPeriod = new javax.swing.JTextField();
        txtHoursOfWork = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtHourlyRate = new javax.swing.JTextField();
        btnAddContract = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 600));
        getContentPane().setLayout(null);

        lblName.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        lblName.setText("Name:");
        getContentPane().add(lblName);
        lblName.setBounds(32, 117, 102, 20);

        cboName.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboNameItemStateChanged(evt);
            }
        });
        getContentPane().add(cboName);
        cboName.setBounds(138, 117, 305, 19);

        lblDOB.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        lblDOB.setText("Date of Birth:");
        lblDOB.setPreferredSize(new java.awt.Dimension(81, 20));
        getContentPane().add(lblDOB);
        lblDOB.setBounds(30, 153, 102, 20);

        txtDOB.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtDOB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtDOB.setEnabled(false);
        getContentPane().add(txtDOB);
        txtDOB.setBounds(140, 160, 209, 19);

        lblStartDate.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        lblStartDate.setText("Start Date:");
        getContentPane().add(lblStartDate);
        lblStartDate.setBounds(32, 190, 102, 20);

        txtStartDate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtStartDate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtStartDate.setEnabled(false);
        getContentPane().add(txtStartDate);
        txtStartDate.setBounds(138, 191, 209, 19);

        lblContract.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        lblContract.setText("Contractor:");
        getContentPane().add(lblContract);
        lblContract.setBounds(32, 226, 102, 20);

        lstContractor.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lstContractor.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Yes", "No" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstContractor.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstContractor.setEnabled(false);
        lstContractor.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstContractorValueChanged(evt);
            }
        });
        scrContractor.setViewportView(lstContractor);

        getContentPane().add(scrContractor);
        scrContractor.setBounds(138, 228, 100, 44);

        panSalariedPerson.setLayout(null);

        txtBaseSalary.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtBaseSalary.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtBaseSalary.setEnabled(false);
        panSalariedPerson.add(txtBaseSalary);
        txtBaseSalary.setBounds(110, 40, 170, 19);

        lblSalaried.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        lblSalaried.setText("Salaried Worker");
        panSalariedPerson.add(lblSalaried);
        lblSalaried.setBounds(0, 0, 106, 20);

        lblBaseSalary1.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        lblBaseSalary1.setText("Base Salary: ");
        panSalariedPerson.add(lblBaseSalary1);
        lblBaseSalary1.setBounds(0, 34, 100, 20);

        getContentPane().add(panSalariedPerson);
        panSalariedPerson.setBounds(40, 330, 287, 150);

        cboTimePeriod.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cboTimePeriod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WEEKLY", "FORTNIGHTLY", "MONTHLY" }));
        getContentPane().add(cboTimePeriod);
        cboTimePeriod.setBounds(138, 292, 210, 19);

        lblTimePeriod.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        lblTimePeriod.setText("Time Period:");
        getContentPane().add(lblTimePeriod);
        lblTimePeriod.setBounds(32, 289, 102, 20);

        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(350, 560, 74, 47);

        lblHeading.setBackground(new java.awt.Color(204, 255, 204));
        lblHeading.setFont(new java.awt.Font("Nyala", 1, 48)); // NOI18N
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText(" Personal Information");
        lblHeading.setOpaque(true);
        getContentPane().add(lblHeading);
        lblHeading.setBounds(36, 28, 630, 51);

        panContractor.setPreferredSize(new java.awt.Dimension(327, 202));

        lblContractWorker.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        lblContractWorker.setText("Contractor Worker");

        jLabel2.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        jLabel2.setText("Start date of pay period");

        jLabel4.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        jLabel4.setText("Hours of Work:");

        txtStartOfPayPeriod.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        txtHoursOfWork.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Nyala", 0, 18)); // NOI18N
        jLabel7.setText("Hourly rate: ");

        txtHourlyRate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtHourlyRate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtHourlyRate.setEnabled(false);

        btnAddContract.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAddContract.setText("Add");
        btnAddContract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddContractActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panContractorLayout = new javax.swing.GroupLayout(panContractor);
        panContractor.setLayout(panContractorLayout);
        panContractorLayout.setHorizontalGroup(
            panContractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panContractorLayout.createSequentialGroup()
                .addComponent(lblContractWorker)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panContractorLayout.createSequentialGroup()
                .addGroup(panContractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(panContractorLayout.createSequentialGroup()
                        .addGroup(panContractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(panContractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStartOfPayPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoursOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAddContract))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panContractorLayout.setVerticalGroup(
            panContractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panContractorLayout.createSequentialGroup()
                .addComponent(lblContractWorker)
                .addGap(18, 18, 18)
                .addGroup(panContractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panContractorLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddContract)
                        .addGap(27, 27, 27))
                    .addGroup(panContractorLayout.createSequentialGroup()
                        .addComponent(txtStartOfPayPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panContractorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoursOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addComponent(txtHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(panContractor);
        panContractor.setBounds(460, 270, 360, 202);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //When user selects the name, the personal data is updated
    private void cboNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboNameItemStateChanged
        getPersonalData();
    }//GEN-LAST:event_cboNameItemStateChanged

    //displays only contractor or salaried worker information based on the selection made in the contractor list
    private void lstContractorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstContractorValueChanged

    }//GEN-LAST:event_lstContractorValueChanged

    //event handler that allow to assign salary to contractor
    private void btnAddContractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddContractActionPerformed
       try {
           
       }
       catch (Exception e){
           
       }
    }//GEN-LAST:event_btnAddContractActionPerformed
    //event handler for the Back button that closes the current form and displays the main form 
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        setMainForm(mainForm);
        getMainForm().setVisible(true);
        
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    
    //creates the model to populate cboName with the list of people working in the company

    
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
//            java.util.logging.Logger.getLogger(PersonalDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PersonalDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PersonalDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PersonalDataForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PersonalDataForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddContract;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox cboName;
    private javax.swing.JComboBox cboTimePeriod;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblBaseSalary1;
    private javax.swing.JLabel lblContract;
    private javax.swing.JLabel lblContractWorker;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSalaried;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblTimePeriod;
    private javax.swing.JList lstContractor;
    private javax.swing.JOptionPane msgMessage;
    private javax.swing.JPanel panContractor;
    private javax.swing.JPanel panSalariedPerson;
    private javax.swing.JScrollPane scrContractor;
    private javax.swing.JTextField txtBaseSalary;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtHourlyRate;
    private javax.swing.JTextField txtHoursOfWork;
    private javax.swing.JTextField txtStartDate;
    private javax.swing.JTextField txtStartOfPayPeriod;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the assignBonusFormList
     */
    public ArrayList<Person> getPersonalDataFormList() {
        return personalDataFormList;
    }

    /**
     * @param assignBonusFormList the assignBonusFormList to set
     */
    public void setPersonalDataFormList(ArrayList<Person> personalDataFormList) {
        this.personalDataFormList = personalDataFormList;
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
        this.mainForm = new MainForm(personalDataFormList);
    }


}
