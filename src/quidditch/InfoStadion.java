/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quidditch;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author Elater
 */
public class InfoStadion extends javax.swing.JFrame {

    Integer idStadionu;
    /**
     * Creates new form Zawodnicy
     */
    public InfoStadion(String id) throws SQLException {
        super("Informacje o stadionie");
        idStadionu=Integer.parseInt(id);
        initComponents();
        fillData();
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    

//    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//        if (JOptionPane.showConfirmDialog(frame, 
//            "Are you sure you want to close this window?", "Close Window?", 
//            JOptionPane.YES_NO_OPTION,
//            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
//            System.exit(0);
//        }
        //windowEvent.
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        stadionTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        stadionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Howdy", "Ho", "Obrońca", "10.12.1993", "M"}
            },
            new String [] {
                "Numer", "Imię", "Nazwisko", "Pozycja", "Data urodzenia", "Płeć"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        stadionTable.setEnabled(false);
        jScrollPane1.setViewportView(stadionTable);
        if (stadionTable.getColumnModel().getColumnCount() > 0) {
            stadionTable.getColumnModel().getColumn(0).setResizable(false);
            stadionTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            stadionTable.getColumnModel().getColumn(5).setResizable(false);
            stadionTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void fillData() throws SQLException {
                
        
                //Wysrodkuj
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                this.setLocation((dim.width-this.getSize().width)/2, (dim.height-this.getSize().height)/2); 
        
                setResizable(false);
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Nazwa");
		defaultTableModel.addColumn("Adres");
		defaultTableModel.addColumn("Pojemność");
		defaultTableModel.addColumn("Parking");
                
                Stadion s = new Stadion();
                ArrayList<Stadion> listaStadionow = s.getLista();
                for(Stadion st: listaStadionow)
                {
                    if(st.getId_stadionu()==idStadionu)
                        defaultTableModel.addRow(new Object[] {st.getNazwa(),st.getAdres(),st.getPojemnosc().toString(),st.getParking()});
                        
                }
                
		//defaultTableModel.addRow(new Object[] {"HAHA","LOL","XD","LOLL"});
                //JTable rankTable;
                stadionTable.setModel(defaultTableModel);
                stadionTable.getColumnModel().getColumn(3).setPreferredWidth(15);
                stadionTable.getColumnModel().getColumn(3).setMinWidth(10);
                //stadionTable.setPreferredSize(200,100);
            }
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
            java.util.logging.Logger.getLogger(InfoStadion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoStadion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoStadion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoStadion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InfoStadion("").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InfoStadion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable stadionTable;
    // End of variables declaration//GEN-END:variables
}
