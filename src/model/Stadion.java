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
    private String parking;
    private static ArrayList<Stadion> listaStadion; 
    
    public Stadion() {
    }

    public Integer getId_stadionu() {
        return id_stadionu;
    }

    public void setId_stadionu(Integer id_stadionu) {
        this.id_stadionu = id_stadionu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Integer getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(Integer pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public static ArrayList<Stadion> getListaStadion() {
        return listaStadion;
    }

    public static void setListaStadion(ArrayList<Stadion> listaStadion) {
        Stadion.listaStadion = listaStadion;
    }

    public Stadion(Integer id_stadionu, String nazwa, String adres, Integer pojemnosc, String parking) {
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
            listaStadion.add(new Stadion(rs.getInt("id_stadionu"),rs.getString("nazwa"),rs.getString("adres"),rs.getInt("pojemnosc"),rs.getString("parking")));
                     
        return listaStadion;
    }

    public void addQuery() throws SQLException {
        String query = "insert into stadion ( nazwa, adres, pojemnosc, parking) values (\""
                + nazwa + "\",\""
                + adres + "\","
                + pojemnosc + ","
                + parking
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public int delQuery(Integer id) throws SQLException {
        Druzyna x = new Druzyna();
        ArrayList<Druzyna> lista = x.getLista();
        for(Druzyna y: lista)
        {
            if(y.getStadion_id_stadionu() == id)
                return -1;
        }
        String query = "delete from stadion where id_stadionu = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
        return 1;
    }

       
    
    
        
    
    
}
