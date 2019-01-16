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
public class Druzyna {
    private Integer id_druzyny;
    private Integer id_stadionu;
    private String nazwa;
    private String narodowosc;
    private Integer stadion_id_stadionu;
    private static ArrayList<Druzyna> listaDruzyna; 
    
    public Druzyna() {
    }
    
    public Druzyna(Integer id_druzyny, Integer id_stadionu, String nazwa, String narodowosc, Integer stadion_id_stadionu) {
        this.id_druzyny = (id_druzyny == null) ? null : id_druzyny;
        this.id_stadionu = (id_stadionu == null) ? null : id_stadionu;
        this.nazwa = (nazwa == null) ? null : nazwa;
        this.narodowosc = (narodowosc == null) ? null : narodowosc;
        this.stadion_id_stadionu = (stadion_id_stadionu == null) ? null : stadion_id_stadionu;
    }

    public static ArrayList<Druzyna> getLista() throws SQLException {
        listaDruzyna = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from druzyna;");  
        while(rs.next())
            listaDruzyna.add(new Druzyna(rs.getInt("id_druzyny"),rs.getInt("id_stadionu"),rs.getString("nazwa"),rs.getString("narodowosc"),rs.getInt("stadion_id_stadionu")));
        return listaDruzyna;
    }

    public void addQuery() throws SQLException {
        String query = "insert into druzyna ( id_pracownika, imie, nazwisko, funkcja, zarobki, stadion_id_stadionu) values (" 
                + id_druzyny + ","
                + id_stadionu + ",\""
                + nazwa + "\",\""
                + narodowosc + "\","
                + stadion_id_stadionu + ","
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from druzyna where id = ?";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
    
}
