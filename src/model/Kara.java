/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class Kara {
    private Integer id_kary;
    private String typ_kary;
    private Integer okres_wykluczenia;
    private Integer zawodnik_id_zawodnika;
    private static ArrayList<Kara> listaKara; 

    public Kara() {
    }
    
    public Kara(Integer id_kary, String typ_kary, Integer okres_wykluczenia, Integer zawodnik_id_zawodnika) {
        this.id_kary = (id_kary == null) ? null : id_kary;
        this.typ_kary = (typ_kary == null) ? null : typ_kary;
        this.okres_wykluczenia = (okres_wykluczenia == null) ? null : okres_wykluczenia;
        this.zawodnik_id_zawodnika = (zawodnik_id_zawodnika == null) ? null : zawodnik_id_zawodnika;
    }

    public static ArrayList<Kara> getLista() throws SQLException {
        listaKara = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from kara;");  
        while(rs.next())
            listaKara.add(new Kara(rs.getInt("id_kary"),rs.getString("typ_kary"),rs.getInt("okres_wykluczenia"),rs.getInt("zawodnik_id_zawodnika")));
        return listaKara;
    }

    public void addQuery() throws SQLException {
        String query = "insert into kara ( typ_kary, okres_wykluczenia,zawodnik_id_zawodnika) values (\""
                + typ_kary + "\","
                + okres_wykluczenia +","
                + zawodnik_id_zawodnika
                + ");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void updateQuery(Integer id, String typ_kary, Integer okres_wykluczenia, Integer zawodnik_id_zawodnika) throws SQLException{
        PreparedStatement ps = Quidditch.con.prepareStatement("UPDATE kara SET typ_kary = ?, okres_wykluczenia = ?, zawodnik_id_zawodnika = ? WHERE id_kary = ?;");
        ps.setString(1,typ_kary);
        ps.setInt(2,okres_wykluczenia);
        ps.setInt(3,zawodnik_id_zawodnika);
        ps.setInt(4,id);
        ps.execute();
    }
    
    public int delQuery(Integer id) throws SQLException {
        String query = "delete from kara where id_kary = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
        return 1;
    }

    public Integer getId_kary() {
        return id_kary;
    }

    public void setId_kary(Integer id_kary) {
        this.id_kary = id_kary;
    }

    public String getTyp_kary() {
        return typ_kary;
    }

    public void setTyp_kary(String typ_kary) {
        this.typ_kary = typ_kary;
    }

    public Integer getOkres_wykluczenia() {
        return okres_wykluczenia;
    }

    public void setOkres_wykluczenia(Integer okres_wykluczenia) {
        this.okres_wykluczenia = okres_wykluczenia;
    }

    public Integer getZawodnik_id_zawodnika() {
        return zawodnik_id_zawodnika;
    }

    public void setZawodnik_id_zawodnika(Integer zawodnik_id_zawodnika) {
        this.zawodnik_id_zawodnika = zawodnik_id_zawodnika;
    }

    public static ArrayList<Kara> getListaKara() {
        return listaKara;
    }

    public static void setListaKara(ArrayList<Kara> listaKara) {
        Kara.listaKara = listaKara;
    }
    
    
    
}
