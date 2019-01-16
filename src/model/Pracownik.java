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
public class Pracownik {
    private Integer id_pracownika;
    private String imie;
    private String nazwisko;
    private String funkcja;
    private Float zarobki;
    private static ArrayList<Pracownik> listaPracownik; 
    
    public Pracownik() {
    }
    
    public Pracownik(Integer id_pracownika, String imie, String nazwisko, String funkcja, Float zarobki) {
        this.id_pracownika = (id_pracownika == null) ? null : id_pracownika;
        this.imie = (imie == null) ? null : imie;
        this.nazwisko = (nazwisko == null) ? null : nazwisko;
        this.funkcja = (funkcja == null) ? null : funkcja;
        this.zarobki = (zarobki == null) ? null : zarobki;
    }

    public static ArrayList<Pracownik> getLista() throws SQLException {
        listaPracownik = new ArrayList<>();
        Statement stmt= Quidditch.con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from pracownik;");  
        while(rs.next())
            listaPracownik.add(new Pracownik(rs.getInt("id_pracownika"),rs.getString("imie"),rs.getString("nazwisko"),rs.getString("funkcja"),rs.getFloat("zarobki")));
        return listaPracownik;
    }

    public void addQuery() throws SQLException {
        String query = "insert into pracownik ( id_pracownika, imie, nazwisko, funkcja, zarobki) values (" 
                + id_pracownika + ",\""
                + imie + "\",\""
                + nazwisko + "\",\""
                + funkcja + "\","
                + zarobki
                +");";
        Statement stmt= Quidditch.con.createStatement(); 
        stmt.executeUpdate(query);
    }
    
    public void delQuery(Integer id) throws SQLException {
        String query = "delete from pracownik where id = ?";
        PreparedStatement preparedStmt = Quidditch.con.prepareStatement(query);
        preparedStmt.setInt(1, id); //TO DO
        preparedStmt.execute();
    }
    
}
