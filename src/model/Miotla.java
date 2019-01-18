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
public class Miotla {
    private Integer id_miotly;
    private String model;
    private Float predkosc;
    private String tworzywo;
    private Float masa;
    private String kolor;
    private Integer zawodnik_id_zawodnika;
    private static ArrayList<Miotla> listaMiotla; 

    public Miotla() {
    }
    
    public Miotla(Integer id_miotly, String model, Float predkosc, String tworzywo, Float masa, String kolor, Integer zawodnik_id_zawodnika) {
        this.id_miotly = (id_miotly == null) ? null : id_miotly;
        this.model = (model == null) ? null : model;
        this.predkosc = (predkosc == null) ? null : predkosc;
        this.tworzywo = (tworzywo == null) ? null : tworzywo;
        this.masa = (masa == null) ? null : masa;
        this.kolor = (kolor == null) ? null : kolor;
        this.zawodnik_id_zawodnika = (zawodnik_id_zawodnika == null) ? null : zawodnik_id_zawodnika;
    }

    public static ArrayList<Miotla> getLista() throws SQLException {
        listaMiotla = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from miotla;");  
        while(rs.next())
            listaMiotla.add(new Miotla(rs.getInt("id_miotly"),rs.getString("model"),rs.getFloat("predkosc"),rs.getString("tworzywo"),rs.getFloat("masa"),rs.getString("kolor"),rs.getInt("zawodnik_id_zawodnika")));
        return listaMiotla;
    }

    public void addQuery() throws SQLException {
        String query = "insert into miotla ( model, predkosc, tworzywo, masa, kolor, zawodnik_id_zawodnika) values (\""
                + model + "\","
                + predkosc + ",\""
                + tworzywo + "\","
                + masa + ",\""
                + kolor + "\","
                + zawodnik_id_zawodnika
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from miotla where id_miotly = ?;";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
}
