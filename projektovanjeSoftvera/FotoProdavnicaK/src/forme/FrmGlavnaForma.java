/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Radnik;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Korisnik
 */
public class FrmGlavnaForma extends javax.swing.JFrame {

    static Radnik radnik;
    /**
     * Creates new form FrmGlavnaForma
     */
   

    public FrmGlavnaForma(Radnik radnik) {
        initComponents();
        this.radnik = radnik;
    }

    private FrmGlavnaForma() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuItemObradaProizvoda = new javax.swing.JMenuItem();
        MenuItemObradaRacuna = new javax.swing.JMenuItem();
        MenuItemDobavljac = new javax.swing.JMenuItem();
        Brojac = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Operacija");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        MenuItemObradaProizvoda.setText("Rad sa proizvodima");
        MenuItemObradaProizvoda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemObradaProizvodaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemObradaProizvoda);

        MenuItemObradaRacuna.setText("Rad sa racunom");
        MenuItemObradaRacuna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemObradaRacunaActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemObradaRacuna);

        MenuItemDobavljac.setText("Rad sa dobavljacem");
        MenuItemDobavljac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemDobavljacActionPerformed(evt);
            }
        });
        jMenu1.add(MenuItemDobavljac);

        Brojac.setText("Brojac");
        Brojac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrojacActionPerformed(evt);
            }
        });
        jMenu1.add(Brojac);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuItemObradaRacunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemObradaRacunaActionPerformed
        FrmObradaRacuna forma = new FrmObradaRacuna();
        forma.setVisible(true);
    }//GEN-LAST:event_MenuItemObradaRacunaActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
       
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void MenuItemObradaProizvodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemObradaProizvodaActionPerformed
        JDialog dijalog = new JDialog(this, "Ubacivanje proizvoda", false);
        PanelProizvod panel = new PanelProizvod();
        dijalog.add(panel);
        dijalog.pack();
        dijalog.setVisible(true);
    }//GEN-LAST:event_MenuItemObradaProizvodaActionPerformed

    private void MenuItemDobavljacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemDobavljacActionPerformed
        JDialog dijalog = new JDialog();
        PanelDobavljac panel = new PanelDobavljac();
        dijalog.add(panel);
        dijalog.pack();
        dijalog.setVisible(true);
    }//GEN-LAST:event_MenuItemDobavljacActionPerformed

    private void BrojacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrojacActionPerformed
       FrmBrojac forma = new FrmBrojac();
       forma.setVisible(true);
    }//GEN-LAST:event_BrojacActionPerformed

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
            java.util.logging.Logger.getLogger(FrmGlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGlavnaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmGlavnaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Brojac;
    private javax.swing.JMenuItem MenuItemDobavljac;
    private javax.swing.JMenuItem MenuItemObradaProizvoda;
    private javax.swing.JMenuItem MenuItemObradaRacuna;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
