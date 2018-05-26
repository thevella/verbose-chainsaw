/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Coles Laptop
 */
public class UserInterfaec extends javax.swing.JFrame {

    /**
     * Creates new form UserInterfaec
     */
    public UserInterfaec() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        PopUp = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Auth_Search = new javax.swing.JMenuItem();
        QuotePopOut = new javax.swing.JPopupMenu();
        Remove = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SearchTerm = new javax.swing.JTextArea();
        Quote_Search = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        Author_Search = new javax.swing.JRadioButton();
        Tags_Search = new javax.swing.JRadioButton();
        SearchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        AuthorDisplay = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Output1 = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Output2 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        SearchTerm1 = new javax.swing.JTextArea();
        Author_Add = new javax.swing.JRadioButton();
        Quote_Add = new javax.swing.JRadioButton();
        AddButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jRadioButton1.setText("jRadioButton1");

        jMenuItem1.setText("Remove Author");
        PopUp.add(jMenuItem1);

        Auth_Search.setText("Search By Author");
        Auth_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Auth_SearchActionPerformed(evt);
            }
        });
        PopUp.add(Auth_Search);

        Remove.setText("Remove Quote");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });
        QuotePopOut.add(Remove);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(744, 465));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        SearchTerm.setColumns(1);
        SearchTerm.setLineWrap(true);
        SearchTerm.setRows(5);
        SearchTerm.setWrapStyleWord(true);
        jScrollPane1.setViewportView(SearchTerm);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 350;
        gridBagConstraints.ipady = 90;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 47, 0, 0);
        jPanel2.add(jScrollPane1, gridBagConstraints);

        Quote_Search.setBackground(new java.awt.Color(255, 255, 255));
        Quote_Search.setText("Quote");
        Quote_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quote_SearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 89, 0, 66);
        jPanel2.add(Quote_Search, gridBagConstraints);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 155;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 412, 0, 66);
        jPanel2.add(jSeparator1, gridBagConstraints);

        Author_Search.setBackground(new java.awt.Color(255, 255, 255));
        Author_Search.setText("Author");
        Author_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Author_SearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 89, 0, 66);
        jPanel2.add(Author_Search, gridBagConstraints);

        Tags_Search.setBackground(new java.awt.Color(255, 255, 255));
        Tags_Search.setText("Tags");
        Tags_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tags_SearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 89, 0, 66);
        jPanel2.add(Tags_Search, gridBagConstraints);

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 83, 68, 66);
        jPanel2.add(SearchButton, gridBagConstraints);

        AuthorDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AuthorDisplay.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = new String[1];
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        AuthorDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AuthorDisplayMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(AuthorDisplay);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 72;
        gridBagConstraints.ipady = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jPanel2.add(jScrollPane2, gridBagConstraints);

        Output1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = {""};
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Output1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Output1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Output1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Output1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 512;
        gridBagConstraints.ipady = 132;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(11, 33, 0, 66);
        jPanel2.add(jScrollPane3, gridBagConstraints);

        jTabbedPane1.addTab("Search", jPanel2);

        Output2.setEditable(false);
        Output2.setColumns(20);
        Output2.setRows(5);
        Output2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane6.setViewportView(Output2);

        SearchTerm1.setColumns(20);
        SearchTerm1.setLineWrap(true);
        SearchTerm1.setRows(5);
        SearchTerm1.setWrapStyleWord(true);
        jScrollPane7.setViewportView(SearchTerm1);

        Author_Add.setBackground(new java.awt.Color(255, 255, 255));
        Author_Add.setText("Author");
        Author_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Author_AddActionPerformed(evt);
            }
        });

        Quote_Add.setBackground(new java.awt.Color(255, 255, 255));
        Quote_Add.setText("Quote");
        Quote_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quote_AddActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(172, 172, 172)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AddButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(89, 89, 89)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Author_Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Quote_Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addContainerGap(117, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(206, 206, 206)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22)
                            .addComponent(AddButton))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Author_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Quote_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(68, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Add", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setSize(new java.awt.Dimension(760, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Auth_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Auth_SearchActionPerformed
       String to=AuthorDisplay.getSelectedValue();
        SearchTerm.setText(to);
    }//GEN-LAST:event_Auth_SearchActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
      
        Quote aa = new Quote();
        
    String to=Output1.getSelectedValue().replaceAll("<html>", "");
   String te=to.replaceAll("<br/>", "");
   String ta= te.substring(0,te.indexOf("--"));
    System.out.println(ta);
       try {
            aa.removeQuote(ta,3);
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaec.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_RemoveActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        Quote aa = new Quote();

        int todec = 1;
        if (Author_Add.isSelected()) {
            todec = 1;
        } else if (Quote_Add.isSelected()) {
            todec = 2;
        }

        Connection connec = aa.getDBConnection();

        Statement stmt = null;

        String Term = SearchTerm1.getText();

        ResultSet resultSet = null;
        String test = "";
        try {
            stmt = connec.createStatement();
            resultSet = aa.searchRough(2, Term, 2, connec, stmt);
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaec.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (resultSet.next()) {
                test = resultSet.getString(1);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserInterfaec.class.getName()).log(Level.SEVERE, null, ex);
        }

        String ob = Output2.getText();
        Output2.setText(test + ob);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void Quote_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quote_AddActionPerformed
        Author_Add.setSelected(false);
    }//GEN-LAST:event_Quote_AddActionPerformed

    private void Author_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Author_AddActionPerformed
        Quote_Add.setSelected(false);
    }//GEN-LAST:event_Author_AddActionPerformed

    private void Output1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Output1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt) && !Output1.isSelectionEmpty()) {   // if right mouse button clicked
            QuotePopOut.show(evt.getComponent(), evt.getX(), evt.getY());
            System.out.println("sdsd");
        }
    }//GEN-LAST:event_Output1MouseClicked

    private void AuthorDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AuthorDisplayMouseClicked
        if (SwingUtilities.isRightMouseButton(evt) && !AuthorDisplay.isSelectionEmpty()) {   // if right mouse button clicked
            PopUp.show(this, evt.getX(), evt.getY());
            System.out.println("sdsd");
        }
    }//GEN-LAST:event_AuthorDisplayMouseClicked

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        Quote aa = new Quote();

        int todec = 1;
        if (Author_Search.isSelected() && !Tags_Search.isSelected()) {
            AuthorDisplay.setVisible(true);

            todec = 1;
            String Term = SearchTerm.getText();

            ResultSet resultSet = null;
            String test = "";
            Connection connec = aa.getDBConnection();

            Statement stmt = null;

            try {
                stmt = connec.createStatement();
                resultSet = aa.searchRough(2, Term, 2, connec, stmt);

            } catch (SQLException ex) {
                Logger.getLogger(UserInterfaec.class.getName()).log(Level.SEVERE, null, ex);
            } //finally {
                //connec.close();
                //}
            ArrayList<String> ToList = new ArrayList<String>();
            ArrayList<String> QuoteList = new ArrayList<String>();

            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        test += resultSet.getString(3) + "\n";
                        test += "-- " + resultSet.getString(2) + "\n" + "\n";
                        QuoteList.add(("<html>" + resultSet.getString(3) + "<br/>" + "-- " + resultSet.getString(2) + "<br/>" + "<br/>" + "<html>").replaceAll("\n", "<br/>"));

                        ToList.add(resultSet.getString(2));

                        String[] Quote = QuoteList.toArray(new String[QuoteList.size()]);
                        String[] out1 = ToList.toArray(new String[ToList.size()]);

                        Set<String> out = new LinkedHashSet<String>(Arrays.asList(out1));

                        Output1.setListData(Quote);
                        AuthorDisplay.setListData(out.toArray(new String[out.size()]));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UserInterfaec.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                //Output1.setListData("You Entered Ilegal SQL TEXT.Please Try Again");

            }
        } else if (Quote_Search.isSelected() && !Tags_Search.isSelected()) {
            AuthorDisplay.setVisible(false);
            todec = 2;
            String Term = SearchTerm.getText();

            ResultSet resultSet = null;
            String test = "";
            Connection connec = aa.getDBConnection();

            Statement stmt = null;

            try {
                stmt = connec.createStatement();
                resultSet = aa.searchRough(3, Term, 3, connec, stmt);

            } catch (SQLException ex) {
                Logger.getLogger(UserInterfaec.class.getName()).log(Level.SEVERE, null, ex);
            } //finally {
                //connec.close();
                //}
            ArrayList<String> QuoteOut = new ArrayList<String>();

            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        test += resultSet.getString(3) + "\n";
                        test += "-- " + resultSet.getString(2) + "\n\n";
                        QuoteOut.add(("<html>" + resultSet.getString(3) + "<br/>" + "-- " + resultSet.getString(2) + "<br/>" + "<br/>" + "<html>").replaceAll("\n", "<br/>"));
                        String[] quote1 = QuoteOut.toArray(new String[QuoteOut.size()]);
                        Output1.setListData(quote1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UserInterfaec.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                //Output1.setText("You Entered Ilegal SQL TEXT.Please try Again");
            }

        } else if (Quote_Search.isSelected() && Tags_Search.isSelected()) {

        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void Tags_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tags_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tags_SearchActionPerformed

    private void Author_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Author_SearchActionPerformed

        Quote_Search.setSelected(false);

        //Search_Author.setOpaque(true);
    }//GEN-LAST:event_Author_SearchActionPerformed

    private void Quote_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quote_SearchActionPerformed
        Author_Search.setSelected(false);
    }//GEN-LAST:event_Quote_SearchActionPerformed
    

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
            java.util.logging.Logger.getLogger(UserInterfaec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterfaec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterfaec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterfaec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterfaec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JMenuItem Auth_Search;
    private javax.swing.JList<String> AuthorDisplay;
    private javax.swing.JRadioButton Author_Add;
    private javax.swing.JRadioButton Author_Search;
    private javax.swing.JList<String> Output1;
    private javax.swing.JTextArea Output2;
    private javax.swing.JPopupMenu PopUp;
    private javax.swing.JPopupMenu QuotePopOut;
    private javax.swing.JRadioButton Quote_Add;
    private javax.swing.JRadioButton Quote_Search;
    private javax.swing.JMenuItem Remove;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextArea SearchTerm;
    private javax.swing.JTextArea SearchTerm1;
    private javax.swing.JRadioButton Tags_Search;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
