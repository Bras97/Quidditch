/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quidditch.Quidditch;

/**
 *
 * @author Marcin
 */
public class Rozgrywka {
    private Integer id_rozgrywki;
    private String punkty_druzyna1;
    private String punkty_druzyna2;
    private Date data;
    private Integer druzyna_id_druzyny;
    private Integer druzyna_id_druzyny1;
    private Integer znicz_id_znicza;
    private Integer sedzia_id_sedzi;
    private static ArrayList<Rozgrywka> listaRozgrywka; 

    public Rozgrywka() {
    }
    
    public Rozgrywka(Integer id_rozgrywki, String punkty_druzyna1, String punkty_druzyna2, Date data, Integer druzyna_id_druzyny, Integer druzyna_id_druzyny1, Integer znicz_id_znicza, Integer sedzia_id_sedzi) {
        this.id_rozgrywki = (id_rozgrywki == null) ? null : id_rozgrywki;
        this.punkty_druzyna1 = (punkty_druzyna1 == null) ? null : punkty_druzyna1;
        this.punkty_druzyna2 = (punkty_druzyna2 == null) ? null : punkty_druzyna2;
        this.data = (data == null) ? null : data;
        this.druzyna_id_druzyny = (druzyna_id_druzyny == null) ? null : druzyna_id_druzyny;
        this.druzyna_id_druzyny1 = (druzyna_id_druzyny1 == null) ? null : druzyna_id_druzyny1;
        this.znicz_id_znicza = (znicz_id_znicza == null) ? null : znicz_id_znicza;
        this.sedzia_id_sedzi = (sedzia_id_sedzi == null) ? null : sedzia_id_sedzi;
    }

    public static ArrayList<Rozgrywka> getLista() throws SQLException {
        listaRozgrywka = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from rozgrywka;");  
        while(rs.next())
            listaRozgrywka.add(new Rozgrywka(rs.getInt("id_rozgrywki"),rs.getString("punkty_druzyna1"),rs.getString("punkty_druzyna2"),rs.getDate("data"),rs.getInt("druzyna_id_druzyny1"),rs.getInt("druzyna_id_druzyny2"),rs.getInt("znicz_id_znicza"),rs.getInt("sedzia_id_sedzi")));
        return listaRozgrywka;
    }

    public void addQuery() throws SQLException {
        String query = "insert into rozgrywka ( punkty_druzyna1, punkty_druzyna2, data, druzyna_id_druzyny1, druzyna_id_druzyny2, znicz_id_znicza, sedzia_id_sedzi) values ("
                + punkty_druzyna1 + ","
                + punkty_druzyna2 + ","
                + data + ","
                + druzyna_id_druzyny + ","
                + druzyna_id_druzyny1 + ","
                + znicz_id_znicza + ","
                + sedzia_id_sedzi
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    
    
    public void updateQuery(Integer id, Integer punkty_druzyna1, Integer punkty_druzyna2, Date data, Integer druzyna_id_druzyny, Integer druzyna_id_druzyny1, Integer znicz_id_znicza, Integer sedzia_id_sedzi) throws SQLException{
        PreparedStatement ps = Quidditch.con.prepareStatement("UPDATE rozgrywka SET punkty_druzyna1 = ?, punkty_druzyna2 = ?, data = ?, druzyna_id_druzyny1 = ?, druzyna_id_druzyny2 = ?, znicz_id_znicza = ?, sedzia_id_sedzi = ? WHERE id_rozgrywki = ?;");
        ps.setInt(1,punkty_druzyna1);
        ps.setInt(2,punkty_druzyna2);
        ps.setDate(3,data);
        ps.setInt(4,druzyna_id_druzyny);
        ps.setInt(5,druzyna_id_druzyny1);
        ps.setInt(6,znicz_id_znicza);
        ps.setInt(7,sedzia_id_sedzi);
        ps.setInt(8,id);
        ps.executeUpdate();
    }
    
    public int delQuery(Integer id) throws SQLException {
        String query = "delete from rozgrywka where id_rozgrywki = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
        return 1;
    }

    public Integer getId_rozgrywki() {
        return id_rozgrywki;
    }

    public void setId_rozgrywki(Integer id_rozgrywki) {
        this.id_rozgrywki = id_rozgrywki;
    }

    public String getPunkty_druzyna1() {
        return punkty_druzyna1;
    }

    public void setPunkty_druzyna1(String punkty_druzyna1) {
        this.punkty_druzyna1 = punkty_druzyna1;
    }

    public String getPunkty_druzyna2() {
        return punkty_druzyna2;
    }

    public void setPunkty_druzyna2(String punkty_druzyna2) {
        this.punkty_druzyna2 = punkty_druzyna2;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getDruzyna_id_druzyny() {
        return druzyna_id_druzyny;
    }

    public void setDruzyna_id_druzyny(Integer druzyna_id_druzyny) {
        this.druzyna_id_druzyny = druzyna_id_druzyny;
    }

    public Integer getDruzyna_id_druzyny1() {
        return druzyna_id_druzyny1;
    }

    public void setDruzyna_id_druzyny1(Integer druzyna_id_druzyny1) {
        this.druzyna_id_druzyny1 = druzyna_id_druzyny1;
    }

    public Integer getZnicz_id_znicza() {
        return znicz_id_znicza;
    }

    public void setZnicz_id_znicza(Integer znicz_id_znicza) {
        this.znicz_id_znicza = znicz_id_znicza;
    }

    public Integer getSedzia_id_sedzi() {
        return sedzia_id_sedzi;
    }

    public void setSedzia_id_sedzi(Integer sedzia_id_sedzi) {
        this.sedzia_id_sedzi = sedzia_id_sedzi;
    }

    public static ArrayList<Rozgrywka> getListaRozgrywka() {
        return listaRozgrywka;
    }

    public static void setListaRozgrywka(ArrayList<Rozgrywka> listaRozgrywka) {
        Rozgrywka.listaRozgrywka = listaRozgrywka;
    }
    
    
}
