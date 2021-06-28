/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Color;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bigjo
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }
    
    //Prevent rewriting the same code twice by putting them all in a class
    public class AppControls{
        
        public void clearForm(){
            txtFName.setText("");
            txtLName.setText("");
            lstNationality.clearSelection();
            cmbSex.setSelectedIndex(0);
            btnGrpHappy.clearSelection();
            chbSecured.setSelected(false);
            txtFName.setEnabled(true);
            txtLName.setEnabled(true);
        }
        
        public String[] getFormData(){
       
            //Columns can be reordered, so to prevent wrong inserts,
            //this function will track the index of the columns
            DefaultTableModel dtm = (DefaultTableModel) dataTable.getModel();
            int colsCount = dtm.getColumnCount();
            Map<String, Integer> cols = getTableColumns(dataTable);
            
            //Get Happy State
            String happy = "null";
            for(Enumeration<AbstractButton> buttons = btnGrpHappy.getElements(); buttons.hasMoreElements();){
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    happy = button.getText();
                }
            }
            //Get Secured checbox
            String isSecured = (chbSecured.isSelected() ? "Yes":"No"); 

            //Assign values to array, keeping in mind the order of columns
            String[] dataArray = new String[colsCount];
            dataArray[cols.get("First Name")] = txtFName.getText();
            dataArray[cols.get("Last Name")] = txtLName.getText();
            dataArray[cols.get("Nationality")] = (lstNationality.getSelectedValue() != null ? lstNationality.getSelectedValue(): "null");
            dataArray[cols.get("Sex")] = cmbSex.getSelectedItem().toString();
            dataArray[cols.get("Happy?")] = happy;
            dataArray[cols.get("Secured?")] = isSecured;
            
            return dataArray;
        }
        
        public String[] getFormDataFiller(){
       
            //Columns can be reordered, so to prevent wrong inserts,
            //this function will track the index of the columns
            DefaultTableModel dtm = (DefaultTableModel) dataTable.getModel();
            int colsCount = dtm.getColumnCount();
            Map<String, Integer> cols = getTableColumns(dataTable);
            
            //Get Happy State
            String happy = "null";
            //Get Secured checbox
            String isSecured = (chbSecured.isSelected() ? "Yes":"No"); 

            //Assign values to array, keeping in mind the order of columns
            String[] dataArray = new String[colsCount];
            dataArray[cols.get("First Name")] = "Spam";
            dataArray[cols.get("Last Name")] = "Spam";
            dataArray[cols.get("Nationality")] = (lstNationality.getSelectedValue() != null ? lstNationality.getSelectedValue(): "null");
            dataArray[cols.get("Sex")] = cmbSex.getSelectedItem().toString();
            dataArray[cols.get("Happy?")] = happy;
            dataArray[cols.get("Secured?")] = isSecured;
            
            return dataArray;
        }
        
        public Object[] getRowData(int rowNumber){
            
            DefaultTableModel tbl = (DefaultTableModel) dataTable.getModel();
            
            int columnCount = tbl.getColumnCount();
            Object[] rowData = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                rowData[i] = tbl.getValueAt(rowNumber, i);
            }
            
            return rowData;
        }
        
        public boolean isNameEmpty(){
            return txtFName.getText().equals("") || txtLName.getText().equals("");
        }
        
        public Map<String, Integer> getTableColumns(JTable tbl){
            Map<String, Integer> colMap = new HashMap<String, Integer>();
            
            DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
            for (int i = 0; i < dtm.getColumnCount(); i++) {
                colMap.put(dtm.getColumnName(i), i);
            }
            
            return colMap;
        }
        
    }
    public AppControls appcontrol = new AppControls();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpHappy = new javax.swing.ButtonGroup();
        outerWrapper = new javax.swing.JPanel();
        formWrapper = new javax.swing.JPanel();
        borderCenter = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblFName = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblLName = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblNationality = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstNationality = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        lblSex = new javax.swing.JLabel();
        cmbSex = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        lblHappy = new javax.swing.JLabel();
        radHappyYes = new javax.swing.JRadioButton();
        radHappyNo = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        chbSecured = new javax.swing.JCheckBox();
        btnDisplay = new javax.swing.JButton();
        pnlControlTable = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();
        textAreaPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        miFile = new javax.swing.JMenu();
        miFileNew = new javax.swing.JMenuItem();
        miFileOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miFileClose = new javax.swing.JMenuItem();
        miFileSave = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miFileAppExit = new javax.swing.JMenuItem();
        miEdit = new javax.swing.JMenu();
        miEditCustomOutput = new javax.swing.JMenu();
        miECOPrintHappy = new javax.swing.JMenuItem();
        miECOPrintTemplate = new javax.swing.JMenu();
        miECOPTNameOnly = new javax.swing.JMenuItem();
        miECOPTAll = new javax.swing.JMenuItem();
        miECOPTCreateTrash = new javax.swing.JMenuItem();
        miEditFormToggle = new javax.swing.JMenu();
        miEFTCheckbox = new javax.swing.JCheckBoxMenuItem();
        miEFTClearOutput = new javax.swing.JMenuItem();
        miEditOutputControl = new javax.swing.JMenu();
        miEOCWhite = new javax.swing.JMenuItem();
        miEOCGreen = new javax.swing.JMenuItem();
        miEOCGreyBlack = new javax.swing.JMenuItem();
        miAbout = new javax.swing.JMenu();
        miAboutShowDialog = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee Info With Menus");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        outerWrapper.setLayout(new javax.swing.BoxLayout(outerWrapper, javax.swing.BoxLayout.LINE_AXIS));

        formWrapper.setBorder(javax.swing.BorderFactory.createTitledBorder("Form"));
        formWrapper.setLayout(new java.awt.BorderLayout());

        borderCenter.setLayout(new javax.swing.BoxLayout(borderCenter, javax.swing.BoxLayout.Y_AXIS));

        lblFName.setText("First Name");
        jPanel2.add(lblFName);

        txtFName.setMinimumSize(new java.awt.Dimension(200, 24));
        txtFName.setPreferredSize(new java.awt.Dimension(170, 24));
        jPanel2.add(txtFName);

        borderCenter.add(jPanel2);

        lblLName.setText("Last Name");
        jPanel3.add(lblLName);

        txtLName.setPreferredSize(new java.awt.Dimension(170, 24));
        jPanel3.add(txtLName);

        borderCenter.add(jPanel3);

        lblNationality.setText("Nationality");
        jPanel4.add(lblNationality);

        lstNationality.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Filipino", "Japanese", "American", "British", "Korean", "Brazilian", "Vietnamese" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstNationality.setToolTipText("");
        lstNationality.setAlignmentX(1.0F);
        lstNationality.setPreferredSize(new java.awt.Dimension(170, 90));
        jScrollPane2.setViewportView(lstNationality);

        jPanel4.add(jScrollPane2);

        borderCenter.add(jPanel4);

        lblSex.setText("Sex");
        jPanel5.add(lblSex);

        cmbSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Prefer not to say" }));
        cmbSex.setPreferredSize(new java.awt.Dimension(170, 26));
        jPanel5.add(cmbSex);

        borderCenter.add(jPanel5);

        lblHappy.setText("Are you Happy?");
        jPanel6.add(lblHappy);

        btnGrpHappy.add(radHappyYes);
        radHappyYes.setText("Yes");
        jPanel6.add(radHappyYes);

        btnGrpHappy.add(radHappyNo);
        radHappyNo.setText("No");
        jPanel6.add(radHappyNo);

        borderCenter.add(jPanel6);

        chbSecured.setText("Secured");
        chbSecured.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chbSecuredMouseClicked(evt);
            }
        });
        jPanel7.add(chbSecured);

        btnDisplay.setText("Display");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });
        jPanel7.add(btnDisplay);

        borderCenter.add(jPanel7);

        pnlControlTable.setBorder(javax.swing.BorderFactory.createTitledBorder("Table Controls"));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlControlTable.add(btnUpdate);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlControlTable.add(btnDelete);

        btnCancelEdit.setText("Cancel");
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });
        pnlControlTable.add(btnCancelEdit);

        borderCenter.add(pnlControlTable);

        formWrapper.add(borderCenter, java.awt.BorderLayout.CENTER);

        outerWrapper.add(formWrapper);

        textAreaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Output Area"));
        textAreaPanel.setLayout(new javax.swing.BoxLayout(textAreaPanel, javax.swing.BoxLayout.LINE_AXIS));

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "First Name", "Last Name", "Nationality", "Sex", "Happy?", "Secured?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(dataTable);

        textAreaPanel.add(jScrollPane3);

        outerWrapper.add(textAreaPanel);

        miFile.setMnemonic('F');
        miFile.setText("File");

        miFileNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        miFileNew.setText("New");
        miFileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileNewActionPerformed(evt);
            }
        });
        miFile.add(miFileNew);

        miFileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        miFileOpen.setText("Open");
        miFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileOpenActionPerformed(evt);
            }
        });
        miFile.add(miFileOpen);
        miFile.add(jSeparator1);

        miFileClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        miFileClose.setText("Close");
        miFileClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileCloseActionPerformed(evt);
            }
        });
        miFile.add(miFileClose);

        miFileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miFileSave.setText("Save");
        miFileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileSaveActionPerformed(evt);
            }
        });
        miFile.add(miFileSave);
        miFile.add(jSeparator2);

        miFileAppExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK));
        miFileAppExit.setText("Exit");
        miFileAppExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFileAppExitActionPerformed(evt);
            }
        });
        miFile.add(miFileAppExit);

        jMenuBar1.add(miFile);

        miEdit.setMnemonic('E');
        miEdit.setText("Edit");

        miEditCustomOutput.setText("Insert To Table");

        miECOPrintHappy.setText("I'm Happy (Disabled)");
        miECOPrintHappy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miECOPrintHappyActionPerformed(evt);
            }
        });
        miEditCustomOutput.add(miECOPrintHappy);

        miECOPrintTemplate.setText("Form Data");

        miECOPTNameOnly.setText("Print Full Name Only (Disabled)");
        miECOPTNameOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miECOPTNameOnlyActionPerformed(evt);
            }
        });
        miECOPrintTemplate.add(miECOPTNameOnly);

        miECOPTAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_MASK));
        miECOPTAll.setText("Print All Form Data (Disabled)");
        miECOPTAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miECOPTAllActionPerformed(evt);
            }
        });
        miECOPrintTemplate.add(miECOPTAll);

        miECOPTCreateTrash.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miECOPTCreateTrash.setText("Generate Spam Data");
        miECOPTCreateTrash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miECOPTCreateTrashActionPerformed(evt);
            }
        });
        miECOPrintTemplate.add(miECOPTCreateTrash);

        miEditCustomOutput.add(miECOPrintTemplate);

        miEdit.add(miEditCustomOutput);

        miEditFormToggle.setText("Form");

        miEFTCheckbox.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        miEFTCheckbox.setSelected(true);
        miEFTCheckbox.setText("Show Form");
        miEFTCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEFTCheckboxActionPerformed(evt);
            }
        });
        miEditFormToggle.add(miEFTCheckbox);

        miEFTClearOutput.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        miEFTClearOutput.setText("Wipe Table Data");
        miEFTClearOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEFTClearOutputActionPerformed(evt);
            }
        });
        miEditFormToggle.add(miEFTClearOutput);

        miEdit.add(miEditFormToggle);

        miEditOutputControl.setText("TextArea Color");

        miEOCWhite.setText("White");
        miEOCWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEOCWhiteActionPerformed(evt);
            }
        });
        miEditOutputControl.add(miEOCWhite);

        miEOCGreen.setText("Dark Green");
        miEOCGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEOCGreenActionPerformed(evt);
            }
        });
        miEditOutputControl.add(miEOCGreen);

        miEOCGreyBlack.setText("Grey Black");
        miEOCGreyBlack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEOCGreyBlackActionPerformed(evt);
            }
        });
        miEditOutputControl.add(miEOCGreyBlack);

        miEdit.add(miEditOutputControl);

        jMenuBar1.add(miEdit);

        miAbout.setMnemonic('A');
        miAbout.setText("About");
        miAbout.setToolTipText("");

        miAboutShowDialog.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        miAboutShowDialog.setText("About");
        miAboutShowDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAboutShowDialogActionPerformed(evt);
            }
        });
        miAbout.add(miAboutShowDialog);

        jMenuBar1.add(miAbout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outerWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outerWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chbSecuredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chbSecuredMouseClicked
        txtFName.setEnabled(!chbSecured.isSelected());
        txtLName.setEnabled(!chbSecured.isSelected());
    }//GEN-LAST:event_chbSecuredMouseClicked

    private void miFileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileNewActionPerformed
        JOptionPane.showMessageDialog(
                this,
                "You have selected '" + miFileNew.getText() + "' action from File menu",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_miFileNewActionPerformed

    private void miFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileOpenActionPerformed
        JOptionPane.showMessageDialog(
                this,
                "You have selected '" + miFileOpen.getText() + "' action from File menu",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_miFileOpenActionPerformed

    private void miFileCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileCloseActionPerformed
        JOptionPane.showMessageDialog(
                this,
                "You have selected '" + miFileClose.getText() + "' action from File menu",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_miFileCloseActionPerformed

    private void miFileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileSaveActionPerformed
        JOptionPane.showMessageDialog(
                this,
                "You have selected '" + miFileSave.getText() + "' action from File menu",
                "Message",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_miFileSaveActionPerformed

    private void miFileAppExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFileAppExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_miFileAppExitActionPerformed

    private void miECOPrintHappyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miECOPrintHappyActionPerformed
        System.out.println("System says 'I very happi'");
    }//GEN-LAST:event_miECOPrintHappyActionPerformed

    private void miECOPTNameOnlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miECOPTNameOnlyActionPerformed
        //Fix this
    }//GEN-LAST:event_miECOPTNameOnlyActionPerformed

    private void miECOPTAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miECOPTAllActionPerformed
        //Fix this
    }//GEN-LAST:event_miECOPTAllActionPerformed

    private void miEFTCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEFTCheckboxActionPerformed
        formWrapper.setVisible(miEFTCheckbox.isSelected());
    }//GEN-LAST:event_miEFTCheckboxActionPerformed

    private void miEFTClearOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEFTClearOutputActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) dataTable.getModel();
        
        //Delete backwards because rowNumber will shift down and break the loop if you start from 0
        for (int i = dtm.getRowCount()-1; i>= 0; i--) {
            dtm.removeRow(i);
        }
          
    }//GEN-LAST:event_miEFTClearOutputActionPerformed

    private void miEOCGreyBlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEOCGreyBlackActionPerformed
        dataTable.setBackground(new Color(69,73,74));
        dataTable.setForeground(new Color(187,187,187));
    }//GEN-LAST:event_miEOCGreyBlackActionPerformed

    private void miEOCGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEOCGreenActionPerformed
        dataTable.setBackground(new Color(25, 63, 27));
        dataTable.setForeground(new Color(187,187,187));
    }//GEN-LAST:event_miEOCGreenActionPerformed

    private void miEOCWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEOCWhiteActionPerformed
        dataTable.setBackground(new Color(205, 205, 205));
        dataTable.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_miEOCWhiteActionPerformed

    private void miAboutShowDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAboutShowDialogActionPerformed
        
        String aboutText = "This is a version of EmployeeInfoWithMenus that uses the JTable"
                + "\nMenu functions are mostly disabled..."
                + "\nStill uses FlatLAF Look and Feel, pretty neat."
                + "\n\nCreated by Baz Ian Gil De Guzman (12-CPROG-A)" 
                + "\nFinished ~7:10pm, June 3 2021";
        
        JOptionPane.showMessageDialog(
                this,
                aboutText,
                "About Program",
                JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_miAboutShowDialogActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        DefaultTableModel tbl = (DefaultTableModel) dataTable.getModel();
        
        //Add only if the fields have value
        if(!appcontrol.isNameEmpty()){
            tbl.addRow(appcontrol.getFormData());
        }
        
        //Clear Form after insert, also reset the text fields
        appcontrol.clearForm();
    }//GEN-LAST:event_btnDisplayActionPerformed

    private void dataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataTableMouseClicked

        int row = dataTable.getSelectedRow();
        Object[] rowData = appcontrol.getRowData(row);
        Map<String, Integer> cols = appcontrol.getTableColumns(dataTable);
        
        //Debugging
        System.out.println("Selected Row Index: " + row);
        System.out.println("Row Data Sample");
            System.out.println("\tFirst name: " + rowData[cols.get("First Name")].toString());
            System.out.println("\tLast name: " + rowData[cols.get("Last Name")].toString());
        
        //Pass the row data back to form
        txtFName.setText(rowData[cols.get("First Name")].toString());
        txtLName.setText(rowData[cols.get("Last Name")].toString());
        lstNationality.setSelectedValue(rowData[cols.get("Nationality")], true);
        cmbSex.setSelectedItem(rowData[cols.get("Sex")]);
        
        for(Enumeration<AbstractButton> buttons = btnGrpHappy.getElements(); buttons.hasMoreElements();){
            AbstractButton button = buttons.nextElement();
            if (button.getActionCommand().equals(rowData[cols.get("Happy?")])) {
                button.setSelected(true);
            }
        }
        chbSecured.setSelected((rowData[cols.get("Secured?")].toString().equals("Yes")));
        
        //Show controls, hide the insert
        pnlControlTable.setVisible(true);
        btnDisplay.setVisible(false);
    }//GEN-LAST:event_dataTableMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        DefaultTableModel tbl = (DefaultTableModel) dataTable.getModel();
        
        int row = dataTable.getSelectedRow();
        String[] formData = appcontrol.getFormData();
        
        for (int i = 0; i < formData.length; i++) {
            tbl.setValueAt(formData[i], row, i);
        }
        
        //Remove selection in table, disable table controls, reenable insert
        dataTable.clearSelection();
        pnlControlTable.setVisible(false);
        btnDisplay.setVisible(true);
        appcontrol.clearForm();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //Hide table controls on load
        pnlControlTable.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Do you really want to delete this item?");
        
        System.out.println("Confirm Delete Option Selected: " + choice);
        
        int row = dataTable.getSelectedRow();
        DefaultTableModel tbl = (DefaultTableModel) dataTable.getModel();
        switch(choice){
            case 0:
                tbl.removeRow(row);
                //Choose preferred confirmation behavior
                //JOptionPane.showMessageDialog(this, "Row has been deleted...");
                System.out.println("Row "+row+" deleted...");
                break;
            default:
                //JOptionPane.showMessageDialog(this, "Delete Cancelled...");
                System.out.println("Row "+row+" delete cancelled...");
                break;
        }
        
        pnlControlTable.setVisible(false);
        btnDisplay.setVisible(true);
        dataTable.clearSelection();
        appcontrol.clearForm();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
        
        btnDisplay.setVisible(true);
        pnlControlTable.setVisible(false);
        dataTable.clearSelection();
        
        appcontrol.clearForm();
        
    }//GEN-LAST:event_btnCancelEditActionPerformed

    private void miECOPTCreateTrashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miECOPTCreateTrashActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) dataTable.getModel();
        
        dtm.addRow(appcontrol.getFormDataFiller());
    }//GEN-LAST:event_miECOPTCreateTrashActionPerformed

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
                javax.swing.UIManager.setLookAndFeel( new FlatDarculaLaf() );
            } catch( Exception ex ) {
                System.err.println( "Failed to initialize LaF" );
            }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borderCenter;
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplay;
    private javax.swing.ButtonGroup btnGrpHappy;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chbSecured;
    private javax.swing.JComboBox<String> cmbSex;
    private javax.swing.JTable dataTable;
    private javax.swing.JPanel formWrapper;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblHappy;
    private javax.swing.JLabel lblLName;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblSex;
    private javax.swing.JList<String> lstNationality;
    private javax.swing.JMenu miAbout;
    private javax.swing.JMenuItem miAboutShowDialog;
    private javax.swing.JMenuItem miECOPTAll;
    private javax.swing.JMenuItem miECOPTCreateTrash;
    private javax.swing.JMenuItem miECOPTNameOnly;
    private javax.swing.JMenuItem miECOPrintHappy;
    private javax.swing.JMenu miECOPrintTemplate;
    private javax.swing.JCheckBoxMenuItem miEFTCheckbox;
    private javax.swing.JMenuItem miEFTClearOutput;
    private javax.swing.JMenuItem miEOCGreen;
    private javax.swing.JMenuItem miEOCGreyBlack;
    private javax.swing.JMenuItem miEOCWhite;
    private javax.swing.JMenu miEdit;
    private javax.swing.JMenu miEditCustomOutput;
    private javax.swing.JMenu miEditFormToggle;
    private javax.swing.JMenu miEditOutputControl;
    private javax.swing.JMenu miFile;
    private javax.swing.JMenuItem miFileAppExit;
    private javax.swing.JMenuItem miFileClose;
    private javax.swing.JMenuItem miFileNew;
    private javax.swing.JMenuItem miFileOpen;
    private javax.swing.JMenuItem miFileSave;
    private javax.swing.JPanel outerWrapper;
    private javax.swing.JPanel pnlControlTable;
    private javax.swing.JRadioButton radHappyNo;
    private javax.swing.JRadioButton radHappyYes;
    private javax.swing.JPanel textAreaPanel;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    // End of variables declaration//GEN-END:variables
}
