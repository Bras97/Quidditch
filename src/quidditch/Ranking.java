/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quidditch;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
public class Ranking extends javax.swing.JFrame {
    
    Boolean pozycjaZaznaczona=false;
    Integer idZespolu;
    Integer idStadionu;
    /**
     * Creates new form Ranking
     */
    public Ranking() throws SQLException {
        initComponents();
        fillData();
        setVisible(true);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        jDodajButton = new java.awt.Button();
        jModyfikujButton = new java.awt.Button();
        jUsunButton = new java.awt.Button();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 30), new java.awt.Dimension(0, 30), new java.awt.Dimension(32767, 30));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jButtonZawodnicy = new javax.swing.JButton();
        jButtonStadiony = new javax.swing.JButton();
        jButtonPracownicy = new javax.swing.JButton();
        jObraz = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();

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
        jLabel1.setText("Nazwa:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Narodowość:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Stadion:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Punktacja:");

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jDodajButton.setActionCommand("Dodaj");
        jDodajButton.setLabel("Dodaj");
        jDodajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDodajButtonActionPerformed(evt);
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

        jUsunButton.setLabel("Usuń");
        jUsunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsunButtonActionPerformed(evt);
            }
        });

        jButtonZawodnicy.setText("Zawodnicy");
        jButtonZawodnicy.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonZawodnicy.setName(""); // NOI18N
        jButtonZawodnicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZawodnicyActionPerformed(evt);
            }
        });

        jButtonStadiony.setText("Stadiony");
        jButtonStadiony.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonStadiony.setName(""); // NOI18N
        jButtonStadiony.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStadionyActionPerformed(evt);
            }
        });

        jButtonPracownicy.setText("Pracownicy");
        jButtonPracownicy.setMargin(new java.awt.Insets(2, 5, 2, 5));
        jButtonPracownicy.setName(""); // NOI18N
        jButtonPracownicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPracownicyActionPerformed(evt);
            }
        });

        jMenu1.setText("Ranking");
        jMenu1.setBorderPainted(true);
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.add(jMenu1);

        jMenu7.setText("Zawodnicy");
        jMenuBar1.add(jMenu7);

        jMenu2.setText("Stadiony");
        jMenuBar1.add(jMenu2);

        jMenu6.setText("Miotly");
        jMenuBar1.add(jMenu6);

        jMenu5.setText("Pracownicy");
        jMenuBar1.add(jMenu5);

        jMenu9.setText("Sędziowie");
        jMenuBar1.add(jMenu9);

        jMenu10.setText("Znicze");
        jMenuBar1.add(jMenu10);

        jMenu8.setText("Kary");
        jMenuBar1.add(jMenu8);

        jMenu11.setText("Rozegrane");
        jMenuBar1.add(jMenu11);

        jMenu12.setText("Zaplanowane");
        jMenuBar1.add(jMenu12);

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
                                    .addComponent(jDodajButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 196, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jModyfikujButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jUsunButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 173, Short.MAX_VALUE)
                            .addComponent(jTextField4))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonZawodnicy, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonStadiony, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPracownicy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jUsunButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDodajButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jModyfikujButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addComponent(jObraz, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filler3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonZawodnicy, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonStadiony, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPracownicy, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        //jTextField3.setText(rankTable.getValueAt(currentRow, 2).toString());
        jTextField4.setText(rankTable.getValueAt(currentRow, 3).toString());
        //idZespolu= dr.getId_druzyny();
        pozycjaZaznaczona=true;
        
        
        idStadionu  =  Integer.parseInt(rankTable.getModel().getValueAt(currentRow, 5).toString());
        
        
        jComboBox.removeAllItems();
        
        String stadion = rankTable.getValueAt(currentRow, 2).toString();
        jComboBox.addItem(stadion); 
        
        Stadion s = new Stadion();
        try {
            ArrayList<Stadion> listaStadionow = s.getLista();
            
            Collections.sort(listaStadionow, new Comparator<Stadion>() {
                public int compare(Stadion o1, Stadion o2) {
                    return o1.getNazwa().compareTo(o2.getNazwa());
                    }
                });
            
            for(Stadion st: listaStadionow)
            {
                if(idStadionu!=st.getId_stadionu())
                   jComboBox.addItem(st.getNazwa());
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rankTableMouseClicked

    private void jDodajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDodajButtonActionPerformed
        Druzyna druzyna = new Druzyna();
        ArrayList<Druzyna> listaDruzyn = new ArrayList<>();
        druzyna.setNazwa(jTextField1.getText());
        
        try {
            listaDruzyn = druzyna.getLista();
        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(Druzyna dr: listaDruzyn)
        {
            if(dr.getNazwa().equals(jTextField1.getText()))
            {
                JOptionPane.showMessageDialog(new Frame(), "Drużyna z taką nazwą już istnieje!", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        druzyna.setNarodowosc(jTextField2.getText());

        String nazwaStadionu =(String)jComboBox.getSelectedItem();

        Stadion s = new Stadion();
        ArrayList<Stadion> listaStadionow = new ArrayList<>();

        try {
            listaStadionow = s.getLista();

        for(Stadion st: listaStadionow)
        {
            if (nazwaStadionu.equals(st.getNazwa()))
            {
                druzyna.setStadion_id_stadionu(st.getId_stadionu());
                break;
            }
        }

            System.out.println("Zrobiłem przypadkiem inserta :(");
        druzyna.addQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel model = (DefaultTableModel)rankTable.getModel();
        
        //DefaultTableModel model = (DefaultTableModel) rankTable.getModel();
        model.fireTableDataChanged();
        rankTable.repaint();

        
    }//GEN-LAST:event_jDodajButtonActionPerformed

    private void jModyfikujButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModyfikujButtonActionPerformed
            
            if(!pozycjaZaznaczona)
            {
                JOptionPane.showMessageDialog(new Frame(), "Proszę wybrać drużynę z tabeli, którą chcesz zaktualizować.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int currentRow = rankTable.getSelectedRow();    
            Druzyna druzyna = new Druzyna();
            String nazwaStadionu =(String)jComboBox.getSelectedItem();
            
            System.out.println(nazwaStadionu + idStadionu);
            try {
                if(!nazwaStadionu.equals(rankTable.getModel().getValueAt(currentRow, 2)))
                {
                    Stadion s = new Stadion();
                    ArrayList<Stadion> listaStadionow = new ArrayList<>();
                    listaStadionow = s.getLista();

                    for(Stadion st: listaStadionow)
                    {
                        if (nazwaStadionu.equals(st.getNazwa()))
                        {
                            idStadionu=st.getId_stadionu();
                            break;
                        }
                    }                    
                }
                System.out.println("Zaktualizowano");
                System.out.println(rankTable.getModel().getValueAt(currentRow, 4).toString());
                druzyna.updateQuery(Integer.parseInt(rankTable.getModel().getValueAt(currentRow, 4).toString()), jTextField1.getText(), jTextField2.getText(), idStadionu);
                
            } catch (SQLException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
            }
 
            DefaultTableModel model = (DefaultTableModel) rankTable.getModel();
            model.fireTableDataChanged();
            rankTable.repaint();
            pozycjaZaznaczona=false;
    }//GEN-LAST:event_jModyfikujButtonActionPerformed

    private void jButtonZawodnicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZawodnicyActionPerformed
                               
        if(pozycjaZaznaczona)
        {
            int currentRow = rankTable.getSelectedRow();
            try {
                Sklad sklad = new Sklad(rankTable.getModel().getValueAt(currentRow, 4).toString());
            } catch (SQLException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Nie można utworzyć klasy Skład\n");
            }            
        }
        else
            JOptionPane.showMessageDialog(new Frame(), "Wybierz z listy drużynę, której chcesz podejrzeć skład.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonZawodnicyActionPerformed

    private void jButtonStadionyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStadionyActionPerformed
        
        if(pozycjaZaznaczona)
        {
            int currentRow = rankTable.getSelectedRow();
            try {
                InfoStadion infoStadion = new InfoStadion(rankTable.getModel().getValueAt(currentRow, 5).toString());
            } catch (SQLException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Nie można utworzyć klasy Stadion\n");
            }            
        }
        else
            JOptionPane.showMessageDialog(new Frame(), "Wybierz z listy drużynę, której chcesz zobaczyć stadion.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonStadionyActionPerformed

    private void jButtonPracownicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPracownicyActionPerformed
        
        if(pozycjaZaznaczona)
        {
            int currentRow = rankTable.getSelectedRow();
            try {
                InfoPracownicy infoPracownicy = new InfoPracownicy(rankTable.getModel().getValueAt(currentRow, 4).toString());
            } catch (SQLException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Nie można utworzyć klasy infoPracownicy\n");
            }            
        }
        else
            JOptionPane.showMessageDialog(new Frame(), "Wybierz z listy drużynę, której chcesz zobaczyć pracowników.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonPracownicyActionPerformed

    private void jUsunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsunButtonActionPerformed
        
        if(!pozycjaZaznaczona)
        {
            JOptionPane.showMessageDialog(new Frame(), "Proszę wybrać drużynę z tabeli, którą chcesz usunąć.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int currentRow = rankTable.getSelectedRow();
        if (JOptionPane.showConfirmDialog(null, 
            "Czy na pewno chcesz nieodwracalnie usunąć zaznaczoną drużynę?", "Usunąć?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            Druzyna d = new Druzyna();
            int czyUsunieto=-1;
            try {
                czyUsunieto = d.delQuery(Integer.parseInt(rankTable.getModel().getValueAt(currentRow, 5).toString()));
            } catch (SQLException ex) {
                Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
            }
            switch(czyUsunieto)
            {
                case -3: JOptionPane.showMessageDialog(new Frame(), "Nie można usunąć drużyny, ponieważ istnieje rozgrywka w której brała udział.", "Usuń najpierw powiązane rozgrywki", JOptionPane.INFORMATION_MESSAGE);
                         break;
                case -2: JOptionPane.showMessageDialog(new Frame(), "Nie można usunąć drużyny, ponieważ istnieją zawodnicy powiązani z tą drużyną.", "Usuń najpierw powiązanych zawodników", JOptionPane.INFORMATION_MESSAGE);
                         break;
                case 1:  JOptionPane.showMessageDialog(new Frame(), "Pomyślnie usunięto drużynę.", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                         break;
                default: JOptionPane.showMessageDialog(new Frame(), "Coś poszło nie tak.", "BŁĄD", JOptionPane.INFORMATION_MESSAGE);
                         break;
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) rankTable.getModel();
        model.fireTableDataChanged();
        rankTable.repaint();
    }//GEN-LAST:event_jUsunButtonActionPerformed

  
    public void fillData() throws SQLException {
                
//                URL iconURL = getClass().getResource("/src/img/znicz.png");
//                // iconURL is null when not found
//                ImageIcon icon = new ImageIcon(iconURL);
//                jObraz.setIconImage(icon.getImage());


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
                    jObraz.setIcon(new ImageIcon(getClass().getResource("/img/puchar.png")));
                }catch(Exception e){ System.out.println("Nie znaleziono zdjęcia\n");} 
                setResizable(false);
                
                //uzupelnij comboBox
                Stadion s = new Stadion();
                ArrayList<Stadion> listaStadionow = s.getLista();
                
//                Collections.sort(listaStadionow, new Comparator<Stadion>() {
//                    public int compare(Stadion o1, Stadion o2) {
//                        return o1.getNazwa().compareTo(o2.getNazwa());
//                        }
//                    });
            
                jComboBox.removeAllItems();
                for(Stadion st: listaStadionow)
                {
                    if(idStadionu!=st.getId_stadionu())
                        jComboBox.addItem(st.getNazwa());
                }
                //jComboBox.
                
                //jObraz.setIcon((Icon) Toolkit.getDefaultToolkit().getImage("src/img/znicz.jpg"));
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Nazwa");
		defaultTableModel.addColumn("Narodowość");
		defaultTableModel.addColumn("Stadion");
		defaultTableModel.addColumn("Punkty");
		defaultTableModel.addColumn("Id_druzyny");
		defaultTableModel.addColumn("Id_stadionu");
                
                Druzyna d = new Druzyna();
                ArrayList<Druzyna> listaDruzyn = d.getLista();
                
                for(Druzyna dr: listaDruzyn)
                {
                    String stadion=null;
                    for(Stadion st: listaStadionow)
                    {
                        if(dr.getStadion_id_stadionu()==st.getId_stadionu())
                            stadion=st.getNazwa().toString();
                    }
                    defaultTableModel.addRow(new Object[] {dr.getNazwa(),dr.getNarodowosc(),stadion, "0", dr.getId_druzyny().toString(), dr.getStadion_id_stadionu().toString()});
                }
                
                rankTable.setModel(defaultTableModel);
                rankTable.getColumnModel().getColumn(3).setPreferredWidth(15);
 
                
                rankTable.removeColumn(rankTable.getColumnModel().getColumn(5));
                rankTable.removeColumn(rankTable.getColumnModel().getColumn(4));
                
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
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        
        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new Ranking().setVisible(true);
                    
                    //Ranking.rankTable.add("J","K","L","O");
                } catch (SQLException ex) {
                    Logger.getLogger(Ranking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButtonPracownicy;
    private javax.swing.JButton jButtonStadiony;
    private javax.swing.JButton jButtonZawodnicy;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JComboBox<String> jComboBox;
    private java.awt.Button jDodajButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private java.awt.Button jModyfikujButton;
    private javax.swing.JLabel jObraz;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private java.awt.Button jUsunButton;
    private javax.swing.JTable rankTable;
    // End of variables declaration//GEN-END:variables
}
