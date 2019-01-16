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
public class Znicz {
    private Integer id_znicza;
    private String nazwa;
    private Float masa;
    private Float predkosc;
    private String producent;
    private static ArrayList<Znicz> listaZnicz; 

    public Znicz() {
    }
    
    public Znicz(Integer id_znicza, String nazwa, Float masa, Float predkosc, String producent) {
        this.id_znicza = (id_znicza == null) ? null : id_znicza;
        this.nazwa = (nazwa == null) ? null : nazwa;
        this.masa = (masa == null) ? null : masa;
        this.predkosc = (predkosc == null) ? null : predkosc;
        this.producent = (producent == null) ? null : producent;
    }

    public static ArrayList<Znicz> getLista() throws SQLException {
        listaZnicz = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from znicz;");  
        while(rs.next())
            listaZnicz.add(new Znicz(rs.getInt("id_znicza"),rs.getString("nazwa"),rs.getFloat("masa"),rs.getFloat("predkosc"),rs.getString("producent")));
        return listaZnicz;
    }

    public void addQuery() throws SQLException {
        String query = "insert into znicz ( id_znicza, nazwa, masa, predkosc, producent) values (" 
                + id_znicza + ",\""
                + nazwa + "\","
                + masa + ","
                + predkosc + ",\""
                + producent
                +"\");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from znicz where id = ?";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
    
}
