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
public class Stadion {
    private Integer id_stadionu;
    private String nazwa;
    private String adres;
    private Integer pojemnosc;
    private Boolean parking;
    private static ArrayList<Stadion> listaStadion; 
    
    public Stadion() {
    }

    public Stadion(Integer id_stadionu, String nazwa, String adres, Integer pojemnosc, Boolean parking) {
        this.id_stadionu = (id_stadionu == null) ? null : id_stadionu;
        this.nazwa = (nazwa == null) ? null : nazwa;
        this.adres = (adres == null) ? null : adres;
        this.pojemnosc = (pojemnosc == null) ? null : pojemnosc;
        this.parking = (parking == null) ? null : parking;
    }

    public static ArrayList<Stadion> getLista() throws SQLException {
        listaStadion = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from stadion;");  
        while(rs.next())
            listaStadion.add(new Stadion(rs.getInt("id_stadionu"),rs.getString("nazwa"),rs.getString("adres"),rs.getInt("pojemnosc"),rs.getBoolean("parking")));
        return listaStadion;
    }

    public void addQuery() throws SQLException {
        String query = "insert into stadion ( id_stadionu, nazwa, adres, pojemnosc, parking) values (" 
                + id_stadionu + ",\""
                + nazwa + "\",\""
                + adres + "\","
                + pojemnosc + ","
                + parking
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from stadion where id = ?";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }

       
    
    
        
    
    
}
