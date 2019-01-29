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
        String query = "insert into znicz ( nazwa, masa, predkosc, producent) values (\""
                + nazwa + "\","
                + masa + ","
                + predkosc + ",\""
                + producent
                +"\");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void updateQuery(Integer id, String nazwa, Float masa, Float predkosc, String producent) throws SQLException{
        PreparedStatement ps = Quidditch.con.prepareStatement("UPDATE znicz SET nazwa = ?, masa = ?, predkosc = ?, producent = ? WHERE id_znicza = ?;");
        ps.setString(1,nazwa);
        ps.setFloat(2,masa);
        ps.setFloat(3,predkosc);
        ps.setString(4,producent);
        ps.setInt(5,id);
        ps.executeUpdate();
    }
    
    public int delQuery(Integer id) throws SQLException {
        Rozgrywka x = new Rozgrywka();
        ArrayList<Rozgrywka> lista = x.getLista();
        for(Rozgrywka y: lista)
        {
            if(y.getZnicz_id_znicza() == id)
                return -1;
        }
        String query = "delete from znicz where id_znicza = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
        return 1;
    }

    public Integer getId_znicza() {
        return id_znicza;
    }

    public void setId_znicza(Integer id_znicza) {
        this.id_znicza = id_znicza;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getMasa() {
        return masa;
    }

    public void setMasa(Float masa) {
        this.masa = masa;
    }

    public Float getPredkosc() {
        return predkosc;
    }

    public void setPredkosc(Float predkosc) {
        this.predkosc = predkosc;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public static ArrayList<Znicz> getListaZnicz() {
        return listaZnicz;
    }

    public static void setListaZnicz(ArrayList<Znicz> listaZnicz) {
        Znicz.listaZnicz = listaZnicz;
    }
    
}
