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
    private String nazwa;
    private String narodowosc;
    private Integer stadion_id_stadionu;
    private static ArrayList<Druzyna> listaDruzyna; 
    
    public Druzyna() {
    }

    public Integer getId_druzyny() {
        return id_druzyny;
    }

    public void setId_druzyny(Integer id_druzyny) {
        this.id_druzyny = id_druzyny;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }

    public Integer getStadion_id_stadionu() {
        return stadion_id_stadionu;
    }

    public void setStadion_id_stadionu(Integer stadion_id_stadionu) {
        this.stadion_id_stadionu = stadion_id_stadionu;
    }

    public static ArrayList<Druzyna> getListaDruzyna() {
        return listaDruzyna;
    }

    public static void setListaDruzyna(ArrayList<Druzyna> listaDruzyna) {
        Druzyna.listaDruzyna = listaDruzyna;
    }
    
    public Druzyna(Integer id_druzyny, String nazwa, String narodowosc, Integer stadion_id_stadionu) {
        this.id_druzyny = (id_druzyny == null) ? null : id_druzyny;
        this.nazwa = (nazwa == null) ? null : nazwa;
        this.narodowosc = (narodowosc == null) ? null : narodowosc;
        this.stadion_id_stadionu = (stadion_id_stadionu == null) ? null : stadion_id_stadionu;
    }

    public static ArrayList<Druzyna> getLista() throws SQLException {
        listaDruzyna = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from druzyna;");  
        while(rs.next())
            listaDruzyna.add(new Druzyna(rs.getInt("id_druzyny"),rs.getString("nazwa"),rs.getString("narodowosc"),rs.getInt("stadion_id_stadionu")));
        return listaDruzyna;
    }

    public void addQuery() throws SQLException {
        System.out.println(nazwa);
        System.out.println(narodowosc);
        System.out.println(stadion_id_stadionu.toString());
        String query = "insert into druzyna ( nazwa, narodowosc, stadion_id_stadionu) values (\""
                + nazwa + "\",\""
                + narodowosc + "\","
                + stadion_id_stadionu
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from druzyna where id_druzyny = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
    
}
