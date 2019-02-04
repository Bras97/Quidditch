/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quidditch;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.*;

/**
 *
 * @author Elater
 */
public class Sedziowie extends javax.swing.JFrame {
    
    Boolean pozycjaZaznaczona=false;
    Integer idZespolu;
    Integer idStadionu;
    Boolean wyszukiwanie=false;
    /**
     * Creates new form Ranking
     */
    public Sedziowie() throws SQLException {
        initComponents();
        fillData();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int odp = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zamknąć aplikację?", "Zamknąć?", JOptionPane.YES_NO_OPTION);
                if (odp ==JOptionPane.YES_OPTION)
                    System.exit(0);
            }
            
});
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        rankTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        jDodajButton = new java.awt.Button();
        jUsunButton = new java.awt.Button();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jObraz = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jWyszukajButton1 = new javax.swing.JToggleButton();
        jModyfikujButton = new java.awt.Button();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jRanking = new javax.swing.JMenu();
        jZawodnicy = new javax.swing.JMenu();
        jStadiony = new javax.swing.JMenu();
        jMiotly = new javax.swing.JMenu();
        jPracownicy = new javax.swing.JMenu();
        jSedziowie = new javax.swing.JMenu();
        jZnicze = new javax.swing.JMenu();
        jKary = new javax.swing.JMenu();
        jRozegrane = new javax.swing.JMenu();
        jZaplanowane = new javax.swing.JMenu();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quidditch rank");

        rankTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Szubinianka", "Polska", "Szubinland", "66"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nazwa", "Narodowość", "Stadion", "Punkty"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        rankTable.setName("tabelaRanking"); // NOI18N
        rankTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rankTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rankTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Imię:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nazwisko:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("D. urodzenia:");

        jDodajButton.setActionCommand("Dodaj");
        jDodajButton.setLabel("Dodaj");
        jDodajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDodajButtonActionPerformed(evt);
            }
        });

        jUsunButton.setLabel("Usuń");
        jUsunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsunButtonActionPerformed(evt);
            }
        });

        jWyszukajButton1.setText("Wyszukaj");
        jWyszukajButton1.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jWyszukajButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWyszukajButton1ActionPerformed(evt);
            }
        });

        jModyfikujButton.setLabel("Modyfikuj");
        jModyfikujButton.setName(""); // NOI18N
        jModyfikujButton.setPreferredSize(new java.awt.Dimension(50, 24));
        jModyfikujButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModyfikujButtonActionPerformed(evt);
            }
        });

        jRanking.setText("Ranking");
        jRanking.setBorderPainted(true);
        jRanking.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jRanking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRankingMouseClicked(evt);
            }
        });
        jMenuBar1.add(jRanking);

        jZawodnicy.setText("Zawodnicy");
        jZawodnicy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jZawodnicyMouseClicked(evt);
            }
        });
        jMenuBar1.add(jZawodnicy);

        jStadiony.setText("Stadiony");
        jStadiony.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jStadionyMouseClicked(evt);
            }
        });
        jMenuBar1.add(jStadiony);

        jMiotly.setText("Miotly");
        jMiotly.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMiotlyMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMiotly);

        jPracownicy.setText("Pracownicy");
        jPracownicy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPracownicyMouseClicked(evt);
            }
        });
        jMenuBar1.add(jPracownicy);

        jSedziowie.setText("Sędziowie");
        jSedziowie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSedziowieMouseClicked(evt);
            }
        });
        jMenuBar1.add(jSedziowie);

        jZnicze.setText("Znicze");
        jZnicze.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jZniczeMouseClicked(evt);
            }
        });
        jMenuBar1.add(jZnicze);

        jKary.setText("Kary");
        jKary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jKaryMouseClicked(evt);
            }
        });
        jMenuBar1.add(jKary);

        jRozegrane.setText("Rozegrane");
        jRozegrane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRozegraneMouseClicked(evt);
            }
        });
        jMenuBar1.add(jRozegrane);

        jZaplanowane.setText("Zaplanowane");
        jZaplanowane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jZaplanowaneMouseClicked(evt);
            }
        });
        jMenuBar1.add(jZaplanowane);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jObraz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDodajButton, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(196, 196, 196)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jModyfikujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jUsunButton, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField4))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jWyszukajButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jUsunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDodajButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jModyfikujButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addComponent(jObraz, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jWyszukajButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    
    private void rankTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rankTableMouseClicked
        int currentRow = rankTable.getSelectedRow();
        jTextField1.setText(rankTable.getValueAt(currentRow, 0).toString());
        jTextField2.setText(rankTable.getValueAt(currentRow, 1).toString());
        jTextField4.setText(rankTable.getValueAt(currentRow, 2).toString());
        pozycjaZaznaczona=true;      
        
    }//GEN-LAST:event_rankTableMouseClicked

    private void jDodajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDodajButtonActionPerformed
        if (!czyNazwaPusta())
        {
            Sedzia sedzia = new Sedzia();
            ArrayList<Sedzia> listaSedziow = new ArrayList<>();
            sedzia.setImie(jTextField1.getText());
            sedzia.setNazwisko(jTextField2.getText());
           
            DateFormat format = new SimpleDateFormat("yyyy, MMMMM, dd", Locale.ENGLISH);
            java.sql.Date sqlDate = null;
            String tmpS = Quidditch.conv(jTextField4.getText());
            try {
                java.util.Date date = (java.util.Date) format.parse(tmpS);
                sqlDate = new java.sql.Date(date.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(Zawodnicy.class.getName()).log(Level.SEVERE, null, ex);
            }
            sedzia.setData_urodzenia(sqlDate);
            
            try {

            sedzia.addQuery();

            } catch (SQLException ex) {
                Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                wypelnijTabele();
            } catch (SQLException ex) {
                Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_jDodajButtonActionPerformed

    private void jModyfikujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModyfikujButtonActionPerformed
            
            if(!pozycjaZaznaczona)
            {
                JOptionPane.showMessageDialog(new Frame(), "Proszę wybrać sędziego z tabeli, którego chcesz zaktualizować.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int currentRow = rankTable.getSelectedRow();    
            Sedzia sedzia = new Sedzia();
            
            DateFormat format = new SimpleDateFormat("yyyy, MMMMM, dd", Locale.ENGLISH);
            java.sql.Date sqlDate = null;
            String tmpS = Quidditch.conv(jTextField4.getText());
            try {
                java.util.Date date = (java.util.Date) format.parse(tmpS);
                sqlDate = new java.sql.Date(date.getTime());
            } catch (ParseException ex) {
                Logger.getLogger(Zawodnicy.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                
                sedzia.updateQuery(Integer.parseInt(rankTable.getModel().getValueAt(currentRow, 3).toString()), jTextField1.getText(), jTextField2.getText(), sqlDate);
                
            } catch (SQLException ex) {
                Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
            }
 
//            DefaultTableModel model = (DefaultTableModel) rankTable.getModel();
//            model.fireTableDataChanged();
//            rankTable.repaint();
            pozycjaZaznaczona=false;
            
            try {
                wypelnijTabele();
            } catch (SQLException ex) {
                Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jModyfikujButtonActionPerformed

    private void jUsunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsunButtonActionPerformed
        
        try {
            if(!pozycjaZaznaczona)
            {
                JOptionPane.showMessageDialog(new Frame(), "Proszę wybrać sędziego z tabeli, którego chcesz usunąć.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int currentRow = rankTable.getSelectedRow();
            if (JOptionPane.showConfirmDialog(null,
                    "Czy na pewno chcesz nieodwracalnie usunąć zaznaczonego sędziego?", "Usunąć?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                Sedzia d = new Sedzia();
                int czyUsunieto=-1;
                
                    czyUsunieto = d.delQuery(Integer.parseInt(rankTable.getModel().getValueAt(currentRow, 3).toString()));
                    
                switch(czyUsunieto)
                {
                    case -2: JOptionPane.showMessageDialog(new Frame(), "Nie można usunąć sędziego, ponieważ istnieje rozgrywka w której brał udział.", "Usuń najpierw powiązane rozgrywki", JOptionPane.INFORMATION_MESSAGE);
                    break;
                    case 1:  JOptionPane.showMessageDialog(new Frame(), "Pomyślnie usunięto sędziego.", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                    break;
                    default: JOptionPane.showMessageDialog(new Frame(), "Coś poszło nie tak.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
            pozycjaZaznaczona=false;
//        DefaultTableModel model = (DefaultTableModel) rankTable.getModel();
//        model.fireTableDataChanged();
//        rankTable.repaint();
            wypelnijTabele();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jUsunButtonActionPerformed

    private void jWyszukajButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWyszukajButton1ActionPerformed
        try {
            wyszukiwanie=true;
            wypelnijTabele();
            
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jWyszukajButton1ActionPerformed

    private void jZawodnicyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jZawodnicyMouseClicked
        try {
            Zawodnicy t = new Zawodnicy();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jZawodnicyMouseClicked

    private void jStadionyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jStadionyMouseClicked
        try {
            Stadiony t = new Stadiony();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
      
    }//GEN-LAST:event_jStadionyMouseClicked

    private void jMiotlyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMiotlyMouseClicked
        try {
            Miotly t = new Miotly();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jMiotlyMouseClicked

    private void jPracownicyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPracownicyMouseClicked
        try {
            Pracownicy t = new Pracownicy();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jPracownicyMouseClicked

    private void jSedziowieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSedziowieMouseClicked
        
    }//GEN-LAST:event_jSedziowieMouseClicked

    private void jZniczeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jZniczeMouseClicked
        try {
            Znicze t = new Znicze();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jZniczeMouseClicked

    private void jKaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jKaryMouseClicked
        try {
            Kary t = new Kary();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jKaryMouseClicked

    private void jRozegraneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRozegraneMouseClicked
        try {
            Rozegrane t = new Rozegrane();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jRozegraneMouseClicked

    private void jZaplanowaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jZaplanowaneMouseClicked
        try {
            Zaplanowane t = new Zaplanowane();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jZaplanowaneMouseClicked

    private void jRankingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRankingMouseClicked
        try {
            Ranking t = new Ranking();
        } catch (SQLException ex) {
            Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jRankingMouseClicked

    public Boolean czyNazwaPusta()
    {
        if(jTextField2.getText().equals(""))
        {
            JOptionPane.showMessageDialog(new Frame(), "Nazwisko nie może być puste!", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;  
    }
    
    public void wypelnijTabele() throws SQLException
    {
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Imię");
        defaultTableModel.addColumn("Nazwisko");
        defaultTableModel.addColumn("Data urodzenia");
        defaultTableModel.addColumn("Id_sedziego");

        Sedzia d = new Sedzia();
        ArrayList<Sedzia> listaSedziow = new ArrayList<>();
        if(!wyszukiwanie)
            listaSedziow = d.getLista();
        else
            listaSedziow = d.wyszukaj(jTextField3.getText());

         Collections.sort(listaSedziow, new Comparator<Sedzia>() {
            public int compare(Sedzia o1, Sedzia o2) {
                return o1.getNazwisko().compareTo(o2.getNazwisko());
                }
            });

         
        for(Sedzia dr: Sedzia.getLista())
        {
            defaultTableModel.addRow(new Object[] {dr.getImie(),dr.getNazwisko(),dr.getDataString(),dr.getId_sedzi()});
        }

        rankTable.setModel(defaultTableModel);
        rankTable.getColumnModel().getColumn(3).setPreferredWidth(15);

        
        rankTable.removeColumn(rankTable.getColumnModel().getColumn(3));
                
    }
    
    
    public void fillData() throws SQLException {

                //Wysrodkuj
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                this.setLocation((dim.width-this.getSize().width)/2, (dim.height-this.getSize().height)/2); 
        
                jTextField1.setColumns(10);
                jTextField2.setColumns(10);
                jTextField4.setColumns(10);
                try{
//                    ImageIcon img = new ImageIcon(getClass().getResource("/img/pracownicy.png"));
//                    Image image = img.getImage(); // transform it 
//                    Image newimg = image.getScaledInstance(271, 190,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//                    img = new ImageIcon(newimg);
//                    jObraz.setIcon(img);
                    jObraz.setIcon(new ImageIcon(getClass().getResource("/img/sedzia.png")));
                }catch(Exception e){ System.out.println("Nie znaleziono zdjęcia\n");} 
                setResizable(false);
                
                //uzupelnij comboBox
                
                //jComboBox.
                wypelnijTabele();
                //jObraz.setIcon((Icon) Toolkit.getDefaultToolkit().getImage("src/img/znicz.jpg"));
		
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
                        //in.wyswietl();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sedziowie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sedziowie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sedziowie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sedziowie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
        //</editor-fold>        
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new Sedziowie().setVisible(true);
                    
                    //Ranking.rankTable.add("J","K","L","O");
                } catch (SQLException ex) {
                    Logger.getLogger(Sedziowie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
 
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private java.awt.Button jDodajButton;
    private javax.swing.JMenu jKary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMiotly;
    private java.awt.Button jModyfikujButton;
    private javax.swing.JLabel jObraz;
    private javax.swing.JMenu jPracownicy;
    private javax.swing.JMenu jRanking;
    private javax.swing.JMenu jRozegrane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jSedziowie;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenu jStadiony;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private java.awt.Button jUsunButton;
    private javax.swing.JToggleButton jWyszukajButton1;
    private javax.swing.JMenu jZaplanowane;
    private javax.swing.JMenu jZawodnicy;
    private javax.swing.JMenu jZnicze;
    private javax.swing.JTable rankTable;
    // End of variables declaration//GEN-END:variables
}
