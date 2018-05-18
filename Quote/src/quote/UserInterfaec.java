/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quote;

/**
 *
 * @author Coles Laptop
 Sample code for visability 
 * import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class togglepanel {

    public static void main(String[] args) {

        final JFrame frame = new JFrame();
        final JPanel panel1 = new JPanel();
        final JPanel panel2 = new JPanel();
        JButton button1 = new JButton("previous frame!");
        JButton button2 = new JButton("next frame");

        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.add(panel1);
        frame.add(panel2);

        panel1.add(button2);
        panel1.setVisible(true);

        panel2.add(button1);
        panel2.setVisible(false);

        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                panel1.setVisible(true);
                panel2.setVisible(false);

            }
        });


        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                panel1.setVisible(false);
                panel2.setVisible(true);
            }
        });
    }
}
 
 
 
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

        SearchButton = new javax.swing.JRadioButton();
        AddButton = new javax.swing.JRadioButton();
        RemoveButton = new javax.swing.JRadioButton();
        AuthoButton = new javax.swing.JRadioButton();
        QuoteButton = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        OutScreen = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        SearchWord = new javax.swing.JEditorPane();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Add");

        RemoveButton.setText("Remove");

        AuthoButton.setText("Author");
        AuthoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthoButtonActionPerformed(evt);
            }
        });

        QuoteButton.setText("Quote");

        OutScreen.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                OutScreenPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(OutScreen);

        jScrollPane2.setViewportView(SearchWord);

        jToggleButton1.setText("Search");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchButton)
                            .addComponent(RemoveButton)
                            .addComponent(AddButton))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(QuoteButton)
                                    .addComponent(AuthoButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jToggleButton1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchButton)
                            .addComponent(AuthoButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddButton)
                            .addComponent(QuoteButton))
                        .addGap(18, 18, 18)
                        .addComponent(RemoveButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButton1))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AuthoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuthoButtonActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
OutScreen.setText("new string");
//OutScreen.is)
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
       
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void OutScreenPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_OutScreenPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_OutScreenPropertyChange

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
    private javax.swing.JRadioButton AddButton;
    private javax.swing.JRadioButton AuthoButton;
    private javax.swing.JTextPane OutScreen;
    private javax.swing.JRadioButton QuoteButton;
    private javax.swing.JRadioButton RemoveButton;
    private javax.swing.JRadioButton SearchButton;
    private javax.swing.JEditorPane SearchWord;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
